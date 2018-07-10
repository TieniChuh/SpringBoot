package com.mbe.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author:Administrator
 * Description: Auto_Templeate
 * Date:  2018/6/22.
 */
public class DeviceTypeSettingInfo {
    private String id;

    private String divicename;

    private String fatherid;

    private Integer devicelevel;

    private String createby;

    private Date createon;

    private String modifyby;

    private Date modifyon;

    private String owner;

    private String status;
    public List<DeviceTypeSettingInfo> childList = new ArrayList<DeviceTypeSettingInfo>();

    public List<DeviceTypeSettingInfo> getChildList() {
        return childList;
    }

    public void setChildList(List<DeviceTypeSettingInfo> childList) {
        this.childList = childList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDivicename() {
        return divicename;
    }

    public void setDivicename(String divicename) {
        this.divicename = divicename == null ? null : divicename.trim();
    }

    public String getFatherid() {
        return fatherid;
    }

    public void setFatherid(String fatherid) {
        this.fatherid = fatherid == null ? null : fatherid.trim();
    }

    public Integer getDevicelevel() {
        return devicelevel;
    }

    public void setDevicelevel(Integer devicelevel) {
        this.devicelevel = devicelevel;
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