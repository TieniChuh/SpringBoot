package com.mbe.model;

import com.BaseClass.model.BaseModel;

import java.util.Date;
import javax.persistence.*;

/**
 * 房源附件MODEL
 */
public class Housefilepath  extends BaseModel<Housefilepath> {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @Id
    @Column(name = "HOUSEFILEPATHID")
    private String housefilepathid;

    /**
     * 房源ID
     */
    @Column(name = "HOUSEID")
    private String houseid;

    /**
     * 文件URL
     */
    @Column(name = "FILEURL")
    private String fileurl;

    /**
     * 文件名
     */
    @Column(name = "FILENAME")
    private String filename;

    /**
     * 创建人
     */
    @Column(name = "CREATEBY")
    private String createby;

    /**
     * 创建时间
     */
    @Column(name = "CREATEON")
    private Date createon;

    /**
     * 更新人
     */
    @Column(name = "MODIFYBY")
    private String modifyby;

    /**
     * 更新时间
     */
    @Column(name = "MODIFYON")
    private Date modifyon;

    /**
     * 负责人
     */
    @Column(name = "OWNER")
    private String owner;

    /**
     * 数据状态 （0：可用，1：逻辑删除）
     */
    @Column(name = "STATUS")
    private String status;

    /**
     * 获取ID
     *
     * @return HOUSEFILEPATHID - ID
     */
    public String getHousefilepathid() {
        return housefilepathid;
    }

    /**
     * 设置ID
     *
     * @param housefilepathid ID
     */
    public void setHousefilepathid(String housefilepathid) {
        this.housefilepathid = housefilepathid;
    }

    /**
     * 获取房源ID
     *
     * @return HOUSEID - 房源ID
     */
    public String getHouseid() {
        return houseid;
    }

    /**
     * 设置房源ID
     *
     * @param houseid 房源ID
     */
    public void setHouseid(String houseid) {
        this.houseid = houseid;
    }

    /**
     * 获取文件URL
     *
     * @return FILEURL - 文件URL
     */
    public String getFileurl() {
        return fileurl;
    }

    /**
     * 设置文件URL
     *
     * @param fileurl 文件URL
     */
    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    /**
     * 获取创建人
     *
     * @return CREATEBY - 创建人
     */
    public String getCreateby() {
        return createby;
    }

    /**
     * 设置创建人
     *
     * @param createby 创建人
     */
    public void setCreateby(String createby) {
        this.createby = createby;
    }

    /**
     * 获取创建时间
     *
     * @return CREATEON - 创建时间
     */
    public Date getCreateon() {
        return createon;
    }

    /**
     * 设置创建时间
     *
     * @param createon 创建时间
     */
    public void setCreateon(Date createon) {
        this.createon = createon;
    }

    /**
     * 获取更新人
     *
     * @return MODIFYBY - 更新人
     */
    public String getModifyby() {
        return modifyby;
    }

    /**
     * 设置更新人
     *
     * @param modifyby 更新人
     */
    public void setModifyby(String modifyby) {
        this.modifyby = modifyby;
    }

    /**
     * 获取更新时间
     *
     * @return MODIFYON - 更新时间
     */
    public Date getModifyon() {
        return modifyon;
    }

    /**
     * 设置更新时间
     *
     * @param modifyon 更新时间
     */
    public void setModifyon(Date modifyon) {
        this.modifyon = modifyon;
    }

    /**
     * 获取负责人
     *
     * @return OWNER - 负责人
     */
    public String getOwner() {
        return owner;
    }

    /**
     * 设置负责人
     *
     * @param owner 负责人
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * 获取数据状态 （0：可用，1：逻辑删除）
     *
     * @return OWNER - 数据状态 （0：可用，1：逻辑删除）
     */
    public String getStatus() {
        return status;
    }


    /**
     * 设置数据状态 （0：可用，1：逻辑删除）
     *
     * @param status 数据状态 （0：可用，1：逻辑删除）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取文件名
     *
     * @return OWNER - 文件名
     */
    public String getFilename() {
        return filename;
    }


    /**
     * 设置文件名
     *
     * @param filename 文件名
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }
}