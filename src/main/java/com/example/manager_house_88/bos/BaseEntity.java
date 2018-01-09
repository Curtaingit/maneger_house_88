package com.example.manager_house_88.bos;

// Generated file. Do not edit.
// Generated by org.xdoclet.plugin.timbos.ActionScript3Plugin from com.tim.bos.BaseEntity

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Access(AccessType.FIELD)
public class BaseEntity extends CoreObject implements IEntity {

//    @Column(name="number",unique=true,nullable=false,length=40)
//    private String number;

    @CreatedBy
    @Column(name="createactorid",length=25)
    private String createactorid;

    @LastModifiedBy
    @Column(name="updateactorid",length=25)
    private String updateactorid;




    @LastModifiedDate
    private long updatetime;

    @CreatedDate
    private long createtime;

   /* @Column(name="objectstatus",length=25)
    @Enumerated(EnumType.STRING)
    private EntityStatus objectstatus;

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public EntityStatus getObjectstatus() {
        return objectstatus;
    }
    public void setObjectstatus(EntityStatus objectstatus) {
        this.objectstatus = objectstatus;
    }
*/

    public String getCreateactorid() {
        return createactorid;
    }
   /* public void setCreateactorid(String createactorid) {
        this.createactorid = createactorid;
    }
*/
    public String getUpdateactorid() {
        return updateactorid;
    }
    public long getUpdatetime() {
        return updatetime;
    }


    /*   public void setUpdatetime(long updatetime) {
           this.updatetime = updatetime;
       }*/
    public long getCreatetime() {
        return createtime;
    }
/*
    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }
*/

/*

    @PrePersist
    public void prePersist(){
        this.updatetime=DatetimeUtils.getCurrentTime().getTime();
        this.createtime=this.updatetime;
        if(!StringUtils.hasText(number)){
            this.number=""+DatetimeUtils.getCurrentTime().getTime();
        }
    }

    @PreUpdate
    private void preUpdate(){
        this.updatetime=DatetimeUtils.getCurrentTime().getTime();
        if(!StringUtils.hasText(number)){
            this.number=""+DatetimeUtils.getCurrentTime().getTime();
        }
    }
*/


}
