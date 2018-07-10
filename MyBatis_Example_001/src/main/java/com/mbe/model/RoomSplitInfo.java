package com.mbe.model;

import java.util.Date;

public class RoomSplitInfo {
    private String id;

    private String splitdate;

    private String type;

    private String createby;

    private Date createon;

    private String modifyby;

    private Date modifyon;

    private String owner;

    private String status;
    private String reason;

    private String oldroomids;

    private String newroomids;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getOldroomids() {
        return oldroomids;
    }

    public void setOldroomids(String oldroomids) {
        this.oldroomids = oldroomids == null ? null : oldroomids.trim();
    }

    public String getNewroomids() {
        return newroomids;
    }

    public void setNewroomids(String newroomids) {
        this.newroomids = newroomids == null ? null : newroomids.trim();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSplitdate() {
        return splitdate;
    }

    public void setSplitdate(String splitdate) {
        this.splitdate = splitdate == null ? null : splitdate.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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