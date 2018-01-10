package com.example.manager_house_88.domain;

import com.example.manager_house_88.bos.BaseEntity;
import com.example.manager_house_88.bos.Bostype;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/*答复*/

@Getter
@Setter
@Bostype("A06")
@Entity(name = "t_reply")
public class Reply extends BaseEntity {
}
