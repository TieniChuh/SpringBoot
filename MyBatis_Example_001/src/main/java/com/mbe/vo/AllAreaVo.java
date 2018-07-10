package com.mbe.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import com.BaseClass.model.BaseModel;
import com.mbe.model.Floorinfo;
import com.mbe.paasmodel.Floor;

public class AllAreaVo extends BaseModel<AllAreaVo>{
	/**
     * ID
     */
    @Id
    @Column(name = "AREAID")
    private String areaid;

    /**
     * 
     * 区域名
     */
    @Column(name = "AREANAME")
    private String areaname;
    
    /**
     * 楼宇名称英文简称
     */
    private String englishshortname;

    /**
     * LOGO
     */
    @Column(name = "AREALOGO")
    private String arealogo;

    /**
     * 省
     */
    @Column(name = "PROVINCE")
    private String province;

    /**
     * 市
     */
    @Column(name = "CITY")
    private String city;

    /**
     * 区
     */
    @Column(name = "DOWNTOWN")
    private String downtown;

    /**
     * 描述
     */
    @Column(name = "COMMENT")
    private String comment;

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
     * 状态
     */
    @Column(name = "STATUS")
    private String status;

    @Column(name = "TENANTID")
    private String tenantid;
    
    /**
     * 运营面积
     */
	private String roomarea;
    /**
     * 建筑面积
     */
	private Double buildingarea;
	 /**
     * 可租赁面积
     */
	private Double rentablearea;
	
	  /**
     * 楼宇数量
     */
	private Integer buildingCount;
	 /**
     * 已经出租赁面积
     */
	private Double rentOutArea;
    
	 /**
     * 空置面积
     */
	private Double unusedArea;
	/**
	 * 合同份数
	 */
	private Integer contractCount;

    /**
     * 房源数量
     */
    private Integer houseCount;
	
    public String getRoomarea() {
		return roomarea;
	}

	public void setRoomarea(String roomarea) {
		this.roomarea = roomarea;
	}

	/**
     * 获取ID
     *
     * @return AREAID - ID
     */
    public String getAreaid() {
        return areaid;
    }

    /**
     * 设置ID
     *
     * @param areaid ID
     */
    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }

    /**
     * 获取区域名
     *
     * @return AREANAME - 区域名
     */
    public String getAreaname() {
        return areaname;
    }

    /**
     * 设置区域名
     *
     * @param areaname 区域名
     */
    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    /**
     * 获取LOGO
     *
     * @return AREALOGO - LOGO
     */
    public String getArealogo() {
        return arealogo;
    }

    /**
     * 设置LOGO
     *
     * @param arealogo LOGO
     */
    public void setArealogo(String arealogo) {
        this.arealogo = arealogo;
    }

    /**
     * 获取省
     *
     * @return PROVINCE - 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省
     *
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取市
     *
     * @return CITY - 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置市
     *
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取区
     *
     * @return DOWNTOWN - 区
     */
    public String getDowntown() {
        return downtown;
    }

    /**
     * 设置区
     *
     * @param downtown 区
     */
    public void setDowntown(String downtown) {
        this.downtown = downtown;
    }

    /**
     * 获取描述
     *
     * @return COMMENT - 描述
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置描述
     *
     * @param comment 描述
     */
    public void setComment(String comment) {
        this.comment = comment;
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
     * 获取状态
     *
     * @return STATUS - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return TENANTID
     */
    public String getTenantid() {
        return tenantid;
    }

    /**
     * @param tenantid
     */
    public void setTenantid(String tenantid) {
        this.tenantid = tenantid;
    }

	public Double getBuildingarea() {
		return buildingarea;
	}

	public void setBuildingarea(Double buildingarea) {
		this.buildingarea = buildingarea;
	}

	public Integer getBuildingCount() {
		return buildingCount;
	}

	public void setBuildingCount(Integer buildingCount) {
		this.buildingCount = buildingCount;
	}

	public String getEnglishshortname() {
		return englishshortname;
	}

	public void setEnglishshortname(String englishshortname) {
		this.englishshortname = englishshortname;
	}

	public Double getRentablearea() {
		return rentablearea;
	}

	public void setRentablearea(Double rentablearea) {
		this.rentablearea = rentablearea;
	}

	public Double getRentOutArea() {
		return rentOutArea;
	}

	public void setRentOutArea(Double rentOutArea) {
		this.rentOutArea = rentOutArea;
	}

	public Double getUnusedArea() {
		return unusedArea;
	}

	public void setUnusedArea(Double unusedArea) {
		this.unusedArea = unusedArea;
	}

	public Integer getContractCount() {
		return contractCount;
	}

	public void setContractCount(Integer contractCount) {
		this.contractCount = contractCount;
	}

    public Integer getHouseCount() {
        return houseCount;
    }

    public void setHouseCount(Integer houseCount) {
        this.houseCount = houseCount;
    }
}
