package com.mbe.vo;

import java.util.Date;
/**
 * Author:Administrator
 * Description: Auto_Templeate
 * Date:  2018/6/22.
 */
public class DeviceManagementInfoVo extends BaseSearchVo<DeviceManagementInfoVo>{
    private String id;

    private String deviceno;

    private String devicename;

    private String devicetypeid;

    private String model;

    private String brand;

    private String devicemaintantypeid;

    private String devicestatusid;

    private String location;

    private String serialnumber;

    private String ownercompanyid;

    private String handlerid;

    private String supplier;

    private String supplierphone;

    private String remark;

    private String createby;

    private Date createon;

    private String modifyby;

    private Date modifyon;

    private String owner;

    private String status;

    private String attachedinfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDeviceno() {
        return deviceno;
    }

    public void setDeviceno(String deviceno) {
        this.deviceno = deviceno == null ? null : deviceno.trim();
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename == null ? null : devicename.trim();
    }

    public String getDevicetypeid() {
        return devicetypeid;
    }

    public void setDevicetypeid(String devicetypeid) {
        this.devicetypeid = devicetypeid == null ? null : devicetypeid.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getDevicemaintantypeid() {
        return devicemaintantypeid;
    }

    public void setDevicemaintantypeid(String devicemaintantypeid) {
        this.devicemaintantypeid = devicemaintantypeid == null ? null : devicemaintantypeid.trim();
    }

    public String getDevicestatusid() {
        return devicestatusid;
    }

    public void setDevicestatusid(String devicestatusid) {
        this.devicestatusid = devicestatusid == null ? null : devicestatusid.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber == null ? null : serialnumber.trim();
    }

    public String getOwnercompanyid() {
        return ownercompanyid;
    }

    public void setOwnercompanyid(String ownercompanyid) {
        this.ownercompanyid = ownercompanyid == null ? null : ownercompanyid.trim();
    }

    public String getHandlerid() {
        return handlerid;
    }

    public void setHandlerid(String handlerid) {
        this.handlerid = handlerid == null ? null : handlerid.trim();
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public String getSupplierphone() {
        return supplierphone;
    }

    public void setSupplierphone(String supplierphone) {
        this.supplierphone = supplierphone == null ? null : supplierphone.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public String getAttachedinfo() {
        return attachedinfo;
    }

    public void setAttachedinfo(String attachedinfo) {
        this.attachedinfo = attachedinfo == null ? null : attachedinfo.trim();
    }
}