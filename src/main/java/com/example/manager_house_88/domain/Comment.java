package com.example.manager_house_88.domain;

import com.example.manager_house_88.bos.BaseEntity;
import com.example.manager_house_88.bos.Bostype;
import com.example.manager_house_88.enums.CommentEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.criteria.CriteriaBuilder;

/*评论*/

@Setter
@Getter
@Bostype("A03")
@Entity(name = "t_comment")
public class Comment extends BaseEntity {

    /*评论内容*/
    private String content;

    /*审核状态*/
    private int auditStatus = CommentEnum.WAITAUDITSTATUS.getCode();

    /*点赞数*/
    private int liked;

    /*用户id*/
    private String userId;

    /*评论归属 经纪人 or 标的物 */
    private String ascriptionId;

    /*头像 logo*/
    private String headImg;

    /*姓名*/
    private String name;

    /*星级*/
    private String level;

    /*评论的状态  精选  or  普通*/
    private int commentStatus = CommentEnum.GENERAL.getCode();

}
