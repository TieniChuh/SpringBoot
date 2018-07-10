package com.mbe.model;

import java.util.Date;
/**
 * Author:Administrator
 * Description: Auto_Templeate
 * Date:  2018/6/22.
 */
public class MaintenanceStandards {
    private String id;

    private String equtypeid;

    private String maintencycleid;

    private String maintentypeid;

    private String maintenexeid;

    private String remark;

    private String createrid;

    private Date createdate;

    private String createby;

    private Date createon;

    private String modifyby;

    private Date modifyon;

    private String owner;

    private String status;
    private String maintenanceperiod;

    private String attachedinfo;

    public String getMaintenanceperiod() {
        return maintenanceperiod;
    }

    public void setMaintenanceperiod(String maintenanceperiod) {
        this.maintenanceperiod = maintenanceperiod == null ? null : maintenanceperiod.trim();
    }

    public String getAttachedinfo() {
        return attachedinfo;
    }

    public void setAttachedinfo(String attachedinfo) {
        this.attachedinfo = attachedinfo == null ? null : attachedinfo.trim();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEqutypeid() {
        return equtypeid;
    }

    public void setEqutypeid(String equtypeid) {
        this.equtypeid = equtypeid == null ? null : equtypeid.trim();
    }

    public String getMaintencycleid() {
        return maintencycleid;
    }

    public void setMaintencycleid(String maintencycleid) {
        this.maintencycleid = maintencycleid == null ? null : maintencycleid.trim();
    }

    public String getMaintentypeid() {
        return maintentypeid;
    }

    public void setMaintentypeid(String maintentypeid) {
        this.maintentypeid = maintentypeid == null ? null : maintentypeid.trim();
    }

    public String getMaintenexeid() {
        return maintenexeid;
    }

    public void setMaintenexeid(String maintenexeid) {
        this.maintenexeid = maintenexeid == null ? null : maintenexeid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreaterid() {
        return createrid;
    }

    public void setCreaterid(String createrid) {
        this.createrid = createrid == null ? null : createrid.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }

    public Date getCreateon() {
        return createon;
    }

    public void setCreateon(Date createon) {
        this.createon = createon;
    }

    public String getModifyby() {
        return modifyby;
    }

    public void setModifyby(String modifyby) {
        this.modifyby = modifyby == null ? null : modifyby.trim();
    }

    public Date getModifyon() {
        return modifyon;
    }

    public void setModifyon(Date modifyon) {
        this.modifyon = modifyon;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}