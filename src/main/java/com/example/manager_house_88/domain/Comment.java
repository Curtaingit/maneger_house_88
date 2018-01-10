package com.example.manager_house_88.domain;

import com.example.manager_house_88.bos.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/*评论*/

@Setter
@Getter
@Entity(name = "t_comment")
public class Comment extends BaseEntity {

}
