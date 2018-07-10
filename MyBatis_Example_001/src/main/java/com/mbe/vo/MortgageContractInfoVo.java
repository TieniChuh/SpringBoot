package com.mbe.vo;

import java.util.Date;
import java.util.List;

/**
 * Author:Administrator
 * Description: Auto_Templeate
 * Date:  2018/6/22.
 */
public class MortgageContractInfoVo extends BaseSearchVo<MortgageContractInfoVo>  {
    private String id;

    private String morcontractno;

    private Double debtamount;

    private String debtor;

    private String mortgagee;

    private Date constartdate;

    private Date conenddate;

    private String attachedinfo;

    private String contractstatus;

    private String createby;

    private Date createon;

    private String modifyby;

    private Date modifyon;

    private String owner;

    private String status;
    private List<PawnDetailVo>  oldPawnDetailList;

    private List<PawnDetailVo> pawnDetailList;

    public String getContractstatus() {
        return contractstatus;
    }

    public void setContractstatus(String contractstatus) {
        this.contractstatus = contractstatus;
    }

    public List<PawnDetailVo> getPawnDetailList() {
        return pawnDetailList;
    }

    public void setPawnDetailList(List<PawnDetailVo> pawnDetailList) {
        this.pawnDetailList = pawnDetailList;
    }

    public List<PawnDetailVo> getOldPawnDetailList() {
        return oldPawnDetailList;
    }

    public void setOldPawnDetailList(List<PawnDetailVo> oldPawnDetailList) {
        this.oldPawnDetailList = oldPawnDetailList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMorcontractno() {
        return morcontractno;
    }

    public void setMorcontractno(String morcontractno) {
        this.morcontractno = morcontractno == null ? null : morcontractno.trim();
    }

    public Double getDebtamount() {
        return debtamount;
    }

    public void setDebtamount(Double debtamount) {
        this.debtamount = debtamount;
    }

    public String getDebtor() {
        return debtor;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor == null ? null : debtor.trim();
    }

    public String getMortgagee() {
        return mortgagee;
    }

    public void setMortgagee(String mortgagee) {
        this.mortgagee = mortgagee == null ? null : mortgagee.trim();
    }

    public Date getConstartdate() {
        return constartdate;
    }

    public void setConstartdate(Date constartdate) {
        this.constartdate = constartdate;
    }

    public Date getConenddate() {
        return conenddate;
    }

    public void setConenddate(Date conenddate) {
        this.conenddate = conenddate;
    }

    public String getAttachedinfo() {
        return attachedinfo;
    }

    public void setAttachedinfo(String attachedinfo) {
        this.attachedinfo = attachedinfo == null ? null : attachedinfo.trim();
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