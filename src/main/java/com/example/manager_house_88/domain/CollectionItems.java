package com.example.manager_house_88.domain;

import com.example.manager_house_88.bos.Bostype;
import com.example.manager_house_88.bos.Entry;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity(name = "t_collectionItems")
@Bostype("A08")
public class CollectionItems extends Entry{

    @ManyToOne(fetch = FetchType.LAZY)
    private Commodity commodity;

    @ManyToOne(fetch = FetchType.LAZY)
    @Access(AccessType.PROPERTY)
    @JsonBackReference
    public User getParent() {
        return (User)super.getInnerParent();
    }

}
