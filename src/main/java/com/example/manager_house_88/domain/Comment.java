package com.example.manager_house_88.domain;

import com.example.manager_house_88.bos.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@Entity(name = "t_Comment")
public class Comment extends BaseEntity {
}
