package com.mbe.vo;

import com.BaseClass.model.BaseModel;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Administrator on 2018/6/21.
 */
public class HouseinfoVo extends BaseSearchVo<HouseinfoVo> {

    //
    private static final long serialVersionUID = 1L;

    //房源ID
    @Id
    private String houseid;

    //标题
    private String title;

    //楼宇
    private String buildingno;

    //房屋类型
    private String housetype;

    //所属软件园
    private String areaid;

    //房源信息状态
    private String infostatus;

    //竣工时间
    private Date completiontime;

    //产权性质年限
    private String propertyyears;

    //得房率
    private Double roomrate;

    //租售状态
    private String housestatus;

    //租价
    private Double rental;

    //租价单位
    private String rentalunit;

    //物业费
    private Double propertyfee;

    //物业费单位
    private String propertyfeeunit;

    //售价
    private Double price;

    //售价单位
    private String priceunit;

    //建筑面积
    private Double builduparea;

    //待租面积
    private Double rentedarea;

    //可分割面积
    private String dividedarea;

    //层数
    private Integer floorcount;

    //层高
    private Double floorheight;

    //车位
    private Integer parkingcount;

    //电梯数（吨位）
    private Double elevatortonnage;

    //项目简介
    private String introduction;

   //房源图集
    private String attachedinfo;

    //开发公司
    private String devcompany;

    //运营公司
    private String opecompany;

    //联系人
    private String contact;

    //电话
    private String telephone;

    //邮箱
    private String email;

    //省
    private String province;

    //市
    private String city;

    //县
    private String downtown;

    //地址
    private String address;

    //周边配套
    private String supporting;

    //紧急电气系统
    private String electricalsystem;

    //安保系统
    private String securitysystem;

    //空调系统
    private String airconditionsystem;

    //通讯系统
    private String communicationsystem;

    //消防系统
    private String fireextinguishersystem;

    //面积下限
    private Double areaLowLimit;

    //面积上限
    private Double areaTopLimit;

    //租价下限
    private Double rentalLowLimit;

    //租价上限
    private Double rentalTopLimit;

    //售价下限
    private Double priceLowLimit;

    //售价上限
    private Double priceTopLimit;

    //行政区域
    private String administrativeareas;

    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBuildingno() {
        return buildingno;
    }

    public void setBuildingno(String buildingno) {
        this.buildingno = buildingno;
    }

    public String getHousetype() {
        return housetype;
    }

    public void setHousetype(String housetype) {
        this.housetype = housetype;
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }

    public String getInfostatus() {
        return infostatus;
    }

    public void setInfostatus(String infostatus) {
        this.infostatus = infostatus;
    }

    public Date getCompletiontime() {
        return completiontime;
    }

    public void setCompletiontime(Date completiontime) {
        this.completiontime = completiontime;
    }

    public String getPropertyyears() {
        return propertyyears;
    }

    public void setPropertyyears(String propertyyears) {
        this.propertyyears = propertyyears;
    }

    public Double getRoomrate() {
        return roomrate;
    }

    public void setRoomrate(Double roomrate) {
        this.roomrate = roomrate;
    }

    public String getHousestatus() {
        return housestatus;
    }

    public void setHousestatus(String housestatus) {
        this.housestatus = housestatus;
    }

    public Double getRental() {
        return rental;
    }

    public void setRental(Double rental) {
        this.rental = rental;
    }

    public String getRentalunit() {
        return rentalunit;
    }

    public void setRentalunit(String rentalunit) {
        this.rentalunit = rentalunit;
    }

    public Double getPropertyfee() {
        return propertyfee;
    }

    public void setPropertyfee(Double propertyfee) {
        this.propertyfee = propertyfee;
    }

    public String getPropertyfeeunit() {
        return propertyfeeunit;
    }

    public void setPropertyfeeunit(String propertyfeeunit) {
        this.propertyfeeunit = propertyfeeunit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPriceunit() {
        return priceunit;
    }

    public void setPriceunit(String priceunit) {
        this.priceunit = priceunit;
    }

    public Double getBuilduparea() {
        return builduparea;
    }

    public void setBuilduparea(Double builduparea) {
        this.builduparea = builduparea;
    }

    public Double getRentedarea() {
        return rentedarea;
    }

    public void setRentedarea(Double rentedarea) {
        this.rentedarea = rentedarea;
    }

    public String getDividedarea() {
        return dividedarea;
    }

    public void setDividedarea(String dividedarea) {
        this.dividedarea = dividedarea;
    }

    public Integer getFloorcount() {
        return floorcount;
    }

    public void setFloorcount(Integer floorcount) {
        this.floorcount = floorcount;
    }

    public Double getFloorheight() {
        return floorheight;
    }

    public void setFloorheight(Double floorheight) {
        this.floorheight = floorheight;
    }

    public Integer getParkingcount() {
        return parkingcount;
    }

    public void setParkingcount(Integer parkingcount) {
        this.parkingcount = parkingcount;
    }

    public Double getElevatortonnage() {
        return elevatortonnage;
    }

    public void setElevatortonnage(Double elevatortonnage) {
        this.elevatortonnage = elevatortonnage;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getDevcompany() {
        return devcompany;
    }

    public void setDevcompany(String devcompany) {
        this.devcompany = devcompany;
    }

    public String getOpecompany() {
        return opecompany;
    }

    public void setOpecompany(String opecompany) {
        this.opecompany = opecompany;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDowntown() {
        return downtown;
    }

    public void setDowntown(String downtown) {
        this.downtown = downtown;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSupporting() {
        return supporting;
    }

    public void setSupporting(String supporting) {
        this.supporting = supporting;
    }

    public String getElectricalsystem() {
        return electricalsystem;
    }

    public void setElectricalsystem(String electricalsystem) {
        this.electricalsystem = electricalsystem;
    }

    public String getSecuritysystem() {
        return securitysystem;
    }

    public void setSecuritysystem(String securitysystem) {
        this.securitysystem = securitysystem;
    }

    public String getAirconditionsystem() {
        return airconditionsystem;
    }

    public void setAirconditionsystem(String airconditionsystem) {
        this.airconditionsystem = airconditionsystem;
    }

    public String getCommunicationsystem() {
        return communicationsystem;
    }

    public void setCommunicationsystem(String communicationsystem) {
        this.communicationsystem = communicationsystem;
    }

    public String getFireextinguishersystem() {
        return fireextinguishersystem;
    }

    public void setFireextinguishersystem(String fireextinguishersystem) {
        this.fireextinguishersystem = fireextinguishersystem;
    }

    public Double getPriceTopLimit() {
        return priceTopLimit;
    }

    public void setPriceTopLimit(Double priceTopLimit) {
        this.priceTopLimit = priceTopLimit;
    }

    public Double getAreaLowLimit() {
        return areaLowLimit;
    }

    public void setAreaLowLimit(Double areaLowLimit) {
        this.areaLowLimit = areaLowLimit;
    }

    public Double getAreaTopLimit() {
        return areaTopLimit;
    }

    public void setAreaTopLimit(Double areaTopLimit) {
        this.areaTopLimit = areaTopLimit;
    }

    public Double getRentalLowLimit() {
        return rentalLowLimit;
    }

    public void setRentalLowLimit(Double rentalLowLimit) {
        this.rentalLowLimit = rentalLowLimit;
    }

    public Double getRentalTopLimit() {
        return rentalTopLimit;
    }

    public void setRentalTopLimit(Double rentalTopLimit) {
        this.rentalTopLimit = rentalTopLimit;
    }

    public Double getPriceLowLimit() {
        return priceLowLimit;
    }

    public void setPriceLowLimit(Double priceLowLimit) {
        this.priceLowLimit = priceLowLimit;
    }

    public String getAdministrativeareas() {
        return administrativeareas;
    }

    public void setAdministrativeareas(String administrativeareas) {
        this.administrativeareas = administrativeareas;
    }

    public String getAttachedinfo() {
        return attachedinfo;
    }

    public void setAttachedinfo(String attachedinfo) {
        this.attachedinfo = attachedinfo;
    }
}
