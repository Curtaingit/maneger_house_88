package com.example.manager_house_88.repository;

import com.example.manager_house_88.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule,String> {

/*    List<Schedule> findByOpenid(String openid);*/

    List<Schedule> findByUserId(String userId);

    List<Schedule> findByCommodityId(String commodityId);

    Schedule findByUserIdAndCommodityId(String userId,String commodityId);
}
