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
    private int status;

    /*点赞数*/
    private int liked;

    /*评论属于 经纪人 or 用户*/
    private int type;

    /*评论归属*/
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
