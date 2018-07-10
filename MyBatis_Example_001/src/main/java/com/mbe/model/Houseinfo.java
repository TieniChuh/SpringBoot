package com.mbe.model;

import com.BaseClass.model.BaseModel;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 房源MODEL
 */
public class Houseinfo extends BaseModel<Houseinfo> {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 房源ID
     */
    @Id
    @Column(name = "HOUSEID")
    private String houseid;

    /**
     * 标题
     */
    @Column(name = "TITLE")
    private String title;

    /**
     * 楼宇
     */
    @Column(name = "BUILDINGNO")
    private String buildingno;

    /**
     * 房屋类型
     */
    @Column(name = "HOUSETYPE")
    private String housetype;

    /**
     * 所属软件园
     */
    @Column(name = "AREAID")
    private String areaid;

    /**
     * 房源信息状态
     */
    @Column(name = "INFOSTATUS")
    private String infostatus;

    /**
     * 竣工时间
     */
    @Column(name = "COMPLETIONTIME")
    private Date completiontime;

    /**
     * 产权性质年限
     */
    @Column(name = "PROPERTYYEARS")
    private String propertyyears;

    /**
     * 得房率
     */
    @Column(name = "ROOMRATE")
    private Double roomrate;

    /**
     * 租售状态
     */
    @Column(name = "HOUSESTATUS")
    private String housestatus;

    /**
     * 租价
     */
    @Column(name = "RENTAL")
    private Double rental;

    /**
     * 租价单位
     */
    @Column(name = "RENTALUNIT")
    private String rentalunit;

    /**
     * 物业费
     */
    @Column(name = "PROPERTYFEE")
    private Double propertyfee;

    /**
     * 物业费单位
     */
    @Column(name = "PROPERTYFEEUNIT")
    private String propertyfeeunit;

    /**
     * 售价
     */
    @Column(name = "PRICE")
    private Double price;

    /**
     * 售价单位
     */
    @Column(name = "PRICEUNIT")
    private String priceunit;

    /**
     * 建筑面积
     */
    @Column(name = "BUILDUPAREA")
    private Double builduparea;

    /**
     * 待租面积
     */
    @Column(name = "RENTEDAREA")
    private Double rentedarea;

    /**
     * 可分割面积
     */
    @Column(name = "DIVIDEDAREA")
    private String dividedarea;

    /**
     * 层数
     */
    @Column(name = "FLOORCOUNT")
    private Integer floorcount;

    /**
     * 层高
     */
    @Column(name = "FLOORHEIGHT")
    private Double floorheight;

    /**
     * 车位
     */
    @Column(name = "PARKINGCOUNT")
    private Integer parkingcount;

    /**
     * 电梯数（吨位）
     */
    @Column(name = "ELEVATORTONNAGE")
    private Double elevatortonnage;

    /**
     * 开发公司
     */
    @Column(name = "DEVCOMPANY")
    private String devcompany;

    /**
     * 运营公司
     */
    @Column(name = "OPECOMPANY")
    private String opecompany;

    /**
     * 联系人
     */
    @Column(name = "CONTACT")
    private String contact;

    /**
     * 电话
     */
    @Column(name = "TELEPHONE")
    private String telephone;

    /**
     * 邮箱
     */
    @Column(name = "EMAIL")
    private String email;

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
     * 县
     */
    @Column(name = "DOWNTOWN")
    private String downtown;

    /**
     * 地址
     */
    @Column(name = "ADDRESS")
    private String address;

    /**
     * 周边配套
     */
    @Column(name = "SUPPORTING")
    private String supporting;

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
     * 项目简介
     */
    @Column(name = "INTRODUCTION")
    private String introduction;

    /**
     * 房源图集
     */
    @Column(name = "ATTACHEDINFO")
    private String attachedinfo;

    /**
     * 紧急电气系统
     */
    @Column(name = "ELECTRICALSYSTEM")
    private String electricalsystem;

    /**
     * 安保系统
     */
    @Column(name = "SECURITYSYSTEM")
    private String securitysystem;

    /**
     * 空调系统
     */
    @Column(name = "AIRCONDITIONSYSTEM")
    private String airconditionsystem;

    /**
     * 通讯系统
     */
    @Column(name = "COMMUNICATIONSYSTEM")
    private String communicationsystem;

    /**
     * 消防系统
     */
    @Column(name = "FIREEXTINGUISHERSYSTEM")
    private String fireextinguishersystem;

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
     * 获取标题
     *
     * @return TITLE - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取楼宇
     *
     * @return BUILDINGNO - 楼宇
     */
    public String getBuildingno() {
        return buildingno;
    }

    /**
     * 设置楼宇
     *
     * @param buildingno 楼宇
     */
    public void setBuildingno(String buildingno) {
        this.buildingno = buildingno;
    }

    /**
     * 获取房屋类型
     *
     * @return HOUSETYPE - 房屋类型
     */
    public String getHousetype() {
        return housetype;
    }

    /**
     * 设置房屋类型
     *
     * @param housetype 房屋类型
     */
    public void setHousetype(String housetype) {
        this.housetype = housetype;
    }

    /**
     * 获取所属软件园
     *
     * @return AREAID - 所属软件园
     */
    public String getAreaid() {
        return areaid;
    }

    /**
     * 设置所属软件园
     *
     * @param areaid 所属软件园
     */
    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }

    /**
     * 获取房源信息状态
     *
     * @return INFOSTATUS - 房源信息状态
     */
    public String getInfostatus() {
        return infostatus;
    }

    /**
     * 设置房源信息状态
     *
     * @param infostatus 房源信息状态
     */
    public void setInfostatus(String infostatus) {
        this.infostatus = infostatus;
    }

    /**
     * 获取竣工时间
     *
     * @return COMPLETIONTIME - 竣工时间
     */
    public Date getCompletiontime() {
        return completiontime;
    }

    /**
     * 设置竣工时间
     *
     * @param completiontime 竣工时间
     */
    public void setCompletiontime(Date completiontime) {
        this.completiontime = completiontime;
    }

    /**
     * 获取产权性质年限
     *
     * @return PROPERTYYEARS - 产权性质年限
     */
    public String getPropertyyears() {
        return propertyyears;
    }

    /**
     * 设置产权性质年限
     *
     * @param propertyyears 产权性质年限
     */
    public void setPropertyyears(String propertyyears) {
        this.propertyyears = propertyyears;
    }

    /**
     * 获取得房率
     *
     * @return ROOMRATE - 得房率
     */
    public Double getRoomrate() {
        return roomrate;
    }

    /**
     * 设置得房率
     *
     * @param roomrate 得房率
     */
    public void setRoomrate(Double roomrate) {
        this.roomrate = roomrate;
    }

    /**
     * 获取租售状态
     *
     * @return HOUSESTATUS - 租售状态
     */
    public String getHousestatus() {
        return housestatus;
    }

    /**
     * 设置租售状态
     *
     * @param housestatus 租售状态
     */
    public void setHousestatus(String housestatus) {
        this.housestatus = housestatus;
    }

    /**
     * 获取租价
     *
     * @return RENTAL - 租价
     */
    public Double getRental() {
        return rental;
    }

    /**
     * 设置租价
     *
     * @param rental 租价
     */
    public void setRental(Double rental) {
        this.rental = rental;
    }

    /**
     * 获取租价单位
     *
     * @return RENTALUNIT - 租价单位
     */
    public String getRentalunit() {
        return rentalunit;
    }

    /**
     * 设置租价单位
     *
     * @param rentalunit 租价单位
     */
    public void setRentalunit(String rentalunit) {
        this.rentalunit = rentalunit;
    }

    /**
     * 获取物业费
     *
     * @return PROPERTYFEE - 物业费
     */
    public Double getPropertyfee() {
        return propertyfee;
    }

    /**
     * 设置物业费
     *
     * @param propertyfee 物业费
     */
    public void setPropertyfee(Double propertyfee) {
        this.propertyfee = propertyfee;
    }

    /**
     * 获取物业费单位
     *
     * @return PROPERTYFEEUNIT - 物业费单位
     */
    public String getPropertyfeeunit() {
        return propertyfeeunit;
    }

    /**
     * 设置物业费单位
     *
     * @param propertyfeeunit 物业费单位
     */
    public void setPropertyfeeunit(String propertyfeeunit) {
        this.propertyfeeunit = propertyfeeunit;
    }

    /**
     * 获取售价
     *
     * @return PRICE - 售价
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置售价
     *
     * @param price 售价
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取售价单位
     *
     * @return PRICEUNIT - 售价单位
     */
    public String getPriceunit() {
        return priceunit;
    }

    /**
     * 设置售价单位
     *
     * @param priceunit 售价单位
     */
    public void setPriceunit(String priceunit) {
        this.priceunit = priceunit;
    }

    /**
     * 获取建筑面积
     *
     * @return BUILDUPAREA - 建筑面积
     */
    public Double getBuilduparea() {
        return builduparea;
    }

    /**
     * 设置建筑面积
     *
     * @param builduparea 建筑面积
     */
    public void setBuilduparea(Double builduparea) {
        this.builduparea = builduparea;
    }

    /**
     * 获取待租面积
     *
     * @return RENTEDAREA - 待租面积
     */
    public Double getRentedarea() {
        return rentedarea;
    }

    /**
     * 设置待租面积
     *
     * @param rentedarea 待租面积
     */
    public void setRentedarea(Double rentedarea) {
        this.rentedarea = rentedarea;
    }

    /**
     * 获取可分割面积
     *
     * @return DIVIDEDAREA - 可分割面积
     */
    public String getDividedarea() {
        return dividedarea;
    }

    /**
     * 设置可分割面积
     *
     * @param dividedarea 可分割面积
     */
    public void setDividedarea(String dividedarea) {
        this.dividedarea = dividedarea;
    }

    /**
     * 获取层数
     *
     * @return FLOORCOUNT - 层数
     */
    public Integer getFloorcount() {
        return floorcount;
    }

    /**
     * 设置层数
     *
     * @param floorcount 层数
     */
    public void setFloorcount(Integer floorcount) {
        this.floorcount = floorcount;
    }

    /**
     * 获取层高
     *
     * @return FLOORHEIGHT - 层高
     */
    public Double getFloorheight() {
        return floorheight;
    }

    /**
     * 设置层高
     *
     * @param floorheight 层高
     */
    public void setFloorheight(Double floorheight) {
        this.floorheight = floorheight;
    }

    /**
     * 获取车位
     *
     * @return PARKINGCOUNT - 车位
     */
    public Integer getParkingcount() {
        return parkingcount;
    }

    /**
     * 设置车位
     *
     * @param parkingcount 车位
     */
    public void setParkingcount(Integer parkingcount) {
        this.parkingcount = parkingcount;
    }

    /**
     * 获取电梯数（吨位）
     *
     * @return ELEVATORTONNAGE - 电梯数（吨位）
     */
    public Double getElevatortonnage() {
        return elevatortonnage;
    }

    /**
     * 设置电梯数（吨位）
     *
     * @param elevatortonnage 电梯数（吨位）
     */
    public void setElevatortonnage(Double elevatortonnage) {
        this.elevatortonnage = elevatortonnage;
    }

    /**
     * 获取开发公司
     *
     * @return DEVCOMPANY - 开发公司
     */
    public String getDevcompany() {
        return devcompany;
    }

    /**
     * 设置开发公司
     *
     * @param devcompany 开发公司
     */
    public void setDevcompany(String devcompany) {
        this.devcompany = devcompany;
    }

    /**
     * 获取运营公司
     *
     * @return OPECOMPANY - 运营公司
     */
    public String getOpecompany() {
        return opecompany;
    }

    /**
     * 设置运营公司
     *
     * @param opecompany 运营公司
     */
    public void setOpecompany(String opecompany) {
        this.opecompany = opecompany;
    }

    /**
     * 获取联系人
     *
     * @return CONTACT - 联系人
     */
    public String getContact() {
        return contact;
    }

    /**
     * 设置联系人
     *
     * @param contact 联系人
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * 获取电话
     *
     * @return TELEPHONE - 电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置电话
     *
     * @param telephone 电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获取邮箱
     *
     * @return EMAIL - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
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
     * 获取县
     *
     * @return DOWNTOWN - 县
     */
    public String getDowntown() {
        return downtown;
    }

    /**
     * 设置县
     *
     * @param downtown 县
     */
    public void setDowntown(String downtown) {
        this.downtown = downtown;
    }

    /**
     * 获取地址
     *
     * @return ADDRESS - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取周边配套
     *
     * @return SUPPORTING - 周边配套
     */
    public String getSupporting() {
        return supporting;
    }

    /**
     * 设置周边配套
     *
     * @param supporting 周边配套
     */
    public void setSupporting(String supporting) {
        this.supporting = supporting;
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
     * 获取项目简介
     *
     * @return INTRODUCTION - 项目简介
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 设置项目简介
     *
     * @param introduction 项目简介
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * 获取紧急电气系统
     *
     * @return ELECTRICALSYSTEM - 紧急电气系统
     */
    public String getElectricalsystem() {
        return electricalsystem;
    }

    /**
     * 设置紧急电气系统
     *
     * @param electricalsystem 紧急电气系统
     */
    public void setElectricalsystem(String electricalsystem) {
        this.electricalsystem = electricalsystem;
    }

    /**
     * 获取安保系统
     *
     * @return SECURITYSYSTEM - 安保系统
     */
    public String getSecuritysystem() {
        return securitysystem;
    }

    /**
     * 设置安保系统
     *
     * @param securitysystem 安保系统
     */
    public void setSecuritysystem(String securitysystem) {
        this.securitysystem = securitysystem;
    }

    /**
     * 获取空调系统
     *
     * @return AIRCONDITIONSYSTEM - 空调系统
     */
    public String getAirconditionsystem() {
        return airconditionsystem;
    }

    /**
     * 设置空调系统
     *
     * @param airconditionsystem 空调系统
     */
    public void setAirconditionsystem(String airconditionsystem) {
        this.airconditionsystem = airconditionsystem;
    }

    /**
     * 获取通讯系统
     *
     * @return COMMUNICATIONSYSTEM - 通讯系统
     */
    public String getCommunicationsystem() {
        return communicationsystem;
    }

    /**
     * 设置通讯系统
     *
     * @param communicationsystem 通讯系统
     */
    public void setCommunicationsystem(String communicationsystem) {
        this.communicationsystem = communicationsystem;
    }

    /**
     * 获取消防系统
     *
     * @return FIREEXTINGUISHERSYSTEM - 消防系统
     */
    public String getFireextinguishersystem() {
        return fireextinguishersystem;
    }

    /**
     * 设置消防系统

     *
     * @param fireextinguishersystem 消防系统
     */
    public void setFireextinguishersystem(String fireextinguishersystem) {
        this.fireextinguishersystem = fireextinguishersystem;
    }

    /**
     * 获取数据状态 （0：可用，1：逻辑删除）
     *
     * @return STATUS - 获取数据状态 （0：可用，1：逻辑删除）
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


    public String getAttachedinfo() {
        return attachedinfo;
    }

    public void setAttachedinfo(String attachedinfo) {
        this.attachedinfo = attachedinfo;
    }
}