package com.mbe.vo;

import java.util.Date;
/**
 * Author:Administrator
 * Description: Auto_Templeate
 * Date:  2018/6/22.
 */
public class PawnDetailVo  extends BaseSearchVo<PawnDetailVo>{
    private String pid;

    private String pawnname;

    private String pawnaddress;

    private String pawnaddressid;

    private Integer amount;

    private Double value;

    private String voucherno;

    private String regoffice;

    private String morconinfoid;

    private String createby;

    private Date createon;

    private String modifyby;

    private Date modifyon;

    private String owner;

    private String status;

    public String getPawnaddressid() {
        return pawnaddressid;
    }

    public void setPawnaddressid(String pawnaddressid) {
        this.pawnaddressid = pawnaddressid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPawnname() {
        return pawnname;
    }

    public void setPawnname(String pawnname) {
        this.pawnname = pawnname == null ? null : pawnname.trim();
    }

    public String getPawnaddress() {
        return pawnaddress;
    }

    public void setPawnaddress(String pawnaddress) {
        this.pawnaddress = pawnaddress == null ? null : pawnaddress.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getVoucherno() {
        return voucherno;
    }

    public void setVoucherno(String voucherno) {
        this.voucherno = voucherno == null ? null : voucherno.trim();
    }

    public String getRegoffice() {
        return regoffice;
    }

    public void setRegoffice(String regoffice) {
        this.regoffice = regoffice == null ? null : regoffice.trim();
    }

    public String getMorconinfoid() {
        return morconinfoid;
    }

    public void setMorconinfoid(String morconinfoid) {
        this.morconinfoid = morconinfoid == null ? null : morconinfoid.trim();
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