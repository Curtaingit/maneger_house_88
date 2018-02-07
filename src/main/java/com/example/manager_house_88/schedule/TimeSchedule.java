package com.example.manager_house_88.schedule;

import com.example.manager_house_88.authwechat.SpringUtil;
import com.example.manager_house_88.domain.Comment;
import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.domain.Schedule;
import com.example.manager_house_88.enums.CommentEnum;
import com.example.manager_house_88.enums.CommodityStatusEnum;
import com.example.manager_house_88.service.CommentService;
import com.example.manager_house_88.service.CommodityService;
import com.example.manager_house_88.service.ScheduleService;
import com.example.manager_house_88.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Slf4j
public class TimeSchedule {


    /*定时任务  每天23时59分59秒执行*/
    @Scheduled(cron = "58 59 23 * * ?")
    public void updateCommodityStatus() {
        CommodityService commodityService = (CommodityService) SpringUtil.getBean("commodityService");
        ScheduleService scheduleService = (ScheduleService) SpringUtil.getBean("scheduleService");
        UserService userService = (UserService) SpringUtil.getBean("userService");

        List<Commodity> commodityList = commodityService.findAll(new Sort("createtime"));

        /*修改房屋的状态  挂牌中 -> 竞标中*/
        for (Commodity commodity : commodityList) {
            Boolean isCount = commodity.getPurchaser() <= scheduleService.getCompleteBidding(commodity.getId());
            Boolean isTime = commodity.getAuctionTime() != null && commodity.getAuctionTime() - 3000 < System.currentTimeMillis();
            if (isCount && isTime) {
                commodity.setStatus(CommodityStatusEnum.BIDDING.getCode());
                commodityService.save(commodity);
                List<Schedule> scheduleList = scheduleService.findByCommodityId(commodity.getId());
                for (Schedule schedule : scheduleList) {
                    userService.addMsg(schedule.getUserId(), commodity.getDescription() + "已开标");
                }
                log.info(commodity.getDescription() + "已开标");
            }

        }
    }

    /*定时任务  每天4时00分00秒执行*/
    @Scheduled(cron = "00 00 04 * * ?")
    public void updateCommentLiked() {
        CommentService commentService = (CommentService) SpringUtil.getBean("commentService");
        RedisTemplate redisTemplate = (RedisTemplate) SpringUtil.getBean("redisTemplate");
        List<Comment> commentList = commentService.findByAuditStatus(CommentEnum.AGREE_AUDIT_STATUS.getCode());

        /*通过点赞数  redis -> 数据库*/
        for(Comment comment : commentList){
            String likedKey = comment.getId() + "liked";
            String liked = (String) redisTemplate.opsForValue().get(likedKey);
            comment.setLiked(Integer.valueOf(liked));
            commentService.save(comment);
        }

    }
}
