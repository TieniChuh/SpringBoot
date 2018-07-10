package com.mbe.services.impl;

import com.BaseClass.util.*;
import com.mbe.mapper.AreainfoMapper;
import com.mbe.mapper.HousefilepathMapper;
import com.mbe.mapper.HouseinfoMapper;
import com.mbe.model.Areainfo;
import com.mbe.model.Housefilepath;
import com.mbe.model.Houseinfo;
import com.mbe.paasmodel.Area;
import com.mbe.services.HouseInfoService;
import com.mbe.util.Constants;
import com.mbe.vo.AllAreaVo;
import com.mbe.vo.HouseinfoVo;
import com.mbe.vo.Page;
import net.sf.json.JSONArray;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Administrator on 2018/6/21.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class HouseInfoServiceImpl implements HouseInfoService {

    private static Logger log = LoggerFactory.getLogger(HouseInfoServiceImpl.class);

    @Autowired
    private HouseinfoMapper houseinfoMapper;

    @Autowired
    private AreainfoMapper areainfoMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ApiResult selectByAreaAndTitle(HouseinfoVo houseinfoVo) throws LogicalException {
        try{
            if (houseinfoVo == null || StringUtils.isBlank(houseinfoVo.getAreaid())) {
                return ApiResult.fail("参数对象无效！");
            }
            Map<String, Object> requestMap = houseinfoVo.toSearchMap();
            requestMap.put("areaId", houseinfoVo.getAreaid());
            requestMap.put("title",houseinfoVo.getTitle());

            int count = houseinfoMapper.countByAreaAndTitle(requestMap);
            List<Houseinfo> infoList = houseinfoMapper.selectByAreaAndTitle(requestMap);
            Page<Houseinfo> page = new Page<>(houseinfoVo.getCurrentPage(), count, houseinfoVo.getPageSize());
            page.setList(infoList);
            return ApiResult.success(page);
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException("查询操作异常！");
        }
    }

    @Override
    public ApiResult selectById(HouseinfoVo houseinfoVo) throws LogicalException {
        try{
            if (houseinfoVo == null || StringUtils.isBlank(houseinfoVo.getHouseid())) {
                return ApiResult.fail("参数对象无效！");
            }
            Houseinfo houseinfo = houseinfoMapper.selectByPrimaryKey(houseinfoVo.getHouseid());
            //确认房源有效
            if(houseinfo != null && AuthConstants.DEL_FLAG_NORMAL.equals(houseinfo.getStatus())){
                return ApiResult.success(houseinfo);
            } else {
                return ApiResult.fail("房源已删除！");
            }
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException("查询操作异常！");
        }
    }

    @Override
    public ApiResult insert(HouseinfoVo houseinfoVo, HttpServletRequest request) throws LogicalException {
        try{
            //控制必填信息
            if (houseinfoVo == null) {
                return ApiResult.fail("参数对象无效！");
            } else if (StringUtils.isBlank(houseinfoVo.getTitle())) {
                return ApiResult.fail("房源标题为空！");
            }else if (StringUtils.isBlank(houseinfoVo.getBuildingno())) {
                return ApiResult.fail("房源楼宇信息为空！");
            }else if (StringUtils.isBlank(houseinfoVo.getHousetype())) {
                return ApiResult.fail("房源类型为空！");
            }else if (StringUtils.isBlank(houseinfoVo.getHousestatus())) {
                return ApiResult.fail("房源租售状态为空！");
            } else if(houseinfoVo.getHousestatus().equals("001")){
                //租
                if (houseinfoVo.getRental()==null) {
                     return ApiResult.fail("房源租价为空！");
                }
                if(StringUtils.isBlank(houseinfoVo.getRentalunit())){
                    return ApiResult.fail("房源租价单位为空！");
                }
            } else if(houseinfoVo.getHousestatus().equals("002")){
                //售
                if (houseinfoVo.getPrice()==null) {
                    return ApiResult.fail("房源售价为空！");
                }
                if(StringUtils.isBlank(houseinfoVo.getPriceunit())){
                    return ApiResult.fail("房源售价单位为空！");
                }
            } else if(houseinfoVo.getHousestatus().equals("003")){
                //租售
                if (houseinfoVo.getRental()==null) {
                    return ApiResult.fail("房源租价为空！");
                }
                if(StringUtils.isBlank(houseinfoVo.getRentalunit())){
                    return ApiResult.fail("房源租价单位为空！");
                }
                if (houseinfoVo.getPrice()==null) {
                    return ApiResult.fail("房源售价为空！");
                }
                if(StringUtils.isBlank(houseinfoVo.getPriceunit())){
                    return ApiResult.fail("房源售价单位为空！");
                }
            } else  if (houseinfoVo.getPropertyfee()==null) {
                return ApiResult.fail("房源物业费为空！");
            }else if(StringUtils.isBlank(houseinfoVo.getPropertyfeeunit())){
                return ApiResult.fail("房源物业费单位为空！");
            }else if (houseinfoVo.getBuilduparea() == null){
                return ApiResult.fail("房源建筑面积为空！");
            }else if (houseinfoVo.getRentedarea()== null){
                return ApiResult.fail("房源待租面积为空！");
            }else if (StringUtils.isBlank(houseinfoVo.getDividedarea())){
                return ApiResult.fail("房源可分割面积为空！");
            }else if (StringUtils.isBlank(houseinfoVo.getContact())){
                return ApiResult.fail("房源联系人为空！");
            }else if (StringUtils.isBlank(houseinfoVo.getProvince())) {
                return ApiResult.fail("省为空");
            }else if (StringUtils.isBlank(houseinfoVo.getCity())) {
                return ApiResult.fail("市为空");
            }else if (StringUtils.isBlank(houseinfoVo.getDowntown())) {
                return ApiResult.fail("区为空");
            }

            Houseinfo houseInfo = new Houseinfo();
            houseInfo.setHouseid(UUID.randomUUID().toString());
            houseInfo.setInfostatus(Constants.HOUSE_INFO_NEW);
            houseInfo.setStatus(AuthConstants.DEL_FLAG_NORMAL);

            String userId = RequestUtils.CurrentUserId(request);
            houseInfo.setCreateby(userId);
            houseInfo.setModifyby(userId);
            houseInfo.setOwner(userId);
            Date now = new Date();
            houseInfo.setCreateon(now);
            houseInfo.setModifyon(now);

            houseInfo.setTitle(houseinfoVo.getTitle());
            houseInfo.setBuildingno(houseinfoVo.getBuildingno());
            houseInfo.setHousetype(houseinfoVo.getHousetype());
            houseInfo.setCompletiontime(houseinfoVo.getCompletiontime());
            houseInfo.setPropertyyears(houseinfoVo.getPropertyyears());
            houseInfo.setRoomrate(houseinfoVo.getRoomrate());
            houseInfo.setHousestatus(houseinfoVo.getHousestatus());
            houseInfo.setRental(houseinfoVo.getRental());
            houseInfo.setRentalunit(houseinfoVo.getRentalunit());
            houseInfo.setPropertyfee(houseinfoVo.getPropertyfee());
            houseInfo.setPropertyfeeunit(houseinfoVo.getPropertyfeeunit());
            houseInfo.setPrice(houseinfoVo.getPrice());
            houseInfo.setPriceunit(houseinfoVo.getPriceunit());
            houseInfo.setBuilduparea(houseinfoVo.getBuilduparea());
            houseInfo.setRentedarea(houseinfoVo.getRentedarea());
            houseInfo.setDividedarea(houseinfoVo.getDividedarea());
            houseInfo.setFloorcount(houseinfoVo.getFloorcount());
            houseInfo.setFloorheight(houseinfoVo.getFloorheight());
            houseInfo.setParkingcount(houseinfoVo.getParkingcount());
            houseInfo.setElevatortonnage(houseinfoVo.getElevatortonnage());
            houseInfo.setAttachedinfo(houseinfoVo.getAttachedinfo());
            houseInfo.setIntroduction(houseinfoVo.getIntroduction());
            houseInfo.setDevcompany(houseinfoVo.getDevcompany());
            houseInfo.setOpecompany(houseinfoVo.getOpecompany());
            houseInfo.setContact(houseinfoVo.getContact());
            houseInfo.setTelephone(houseinfoVo.getTelephone());
            houseInfo.setEmail(houseinfoVo.getEmail());

            houseInfo.setProvince(houseinfoVo.getProvince());
            houseInfo.setCity(houseinfoVo.getCity());
            houseInfo.setDowntown(houseinfoVo.getDowntown());
            houseInfo.setAddress(houseinfoVo.getAddress());

            houseInfo.setSupporting(houseinfoVo.getSupporting());

            houseInfo.setAirconditionsystem(houseinfoVo.getAirconditionsystem());
            houseInfo.setCommunicationsystem(houseinfoVo.getCommunicationsystem());
            houseInfo.setSecuritysystem(houseinfoVo.getSecuritysystem());
            houseInfo.setElectricalsystem(houseinfoVo.getElectricalsystem());
            houseInfo.setFireextinguishersystem(houseinfoVo.getFireextinguishersystem());

            this.houseinfoMapper.insert(houseInfo);
            return ApiResult.success();
        }catch(Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException("新增操作异常！");
        }
    }

    @Override
    public ApiResult updatePartBasic(HouseinfoVo houseinfoVo,  HttpServletRequest request) throws LogicalException {
        try{
            //控制必填信息
            if (houseinfoVo == null || StringUtils.isBlank(houseinfoVo.getHouseid())) {
                return ApiResult.fail("参数对象无效！");
            }else if (StringUtils.isBlank(houseinfoVo.getTitle())) {
                return ApiResult.fail("房源标题为空！");
            }else if (StringUtils.isBlank(houseinfoVo.getBuildingno())) {
                return ApiResult.fail("房源楼宇信息为空！");
            }else if (StringUtils.isBlank(houseinfoVo.getHousetype())) {
                return ApiResult.fail("房源类型为空！");
            }else if (StringUtils.isBlank(houseinfoVo.getHousestatus())) {
                return ApiResult.fail("房源租售状态为空！");
            } else if(houseinfoVo.getHousestatus().equals("001")){
                //租
                if (houseinfoVo.getRental()==null) {
                    return ApiResult.fail("房源租价为空！");
                }
                if(StringUtils.isBlank(houseinfoVo.getRentalunit())){
                    return ApiResult.fail("房源租价单位为空！");
                }
            } else if(houseinfoVo.getHousestatus().equals("002")){
                //售
                if (houseinfoVo.getPrice()==null) {
                    return ApiResult.fail("房源售价为空！");
                }
                if(StringUtils.isBlank(houseinfoVo.getPriceunit())){
                    return ApiResult.fail("房源售价单位为空！");
                }
            } else if(houseinfoVo.getHousestatus().equals("003")){
                //租售
                if (houseinfoVo.getRental()==null) {
                    return ApiResult.fail("房源租价为空！");
                }
                if(StringUtils.isBlank(houseinfoVo.getRentalunit())){
                    return ApiResult.fail("房源租价单位为空！");
                }
                if (houseinfoVo.getPrice()==null) {
                    return ApiResult.fail("房源售价为空！");
                }
                if(StringUtils.isBlank(houseinfoVo.getPriceunit())){
                    return ApiResult.fail("房源售价单位为空！");
                }
            }else if (houseinfoVo.getPropertyfee()==null) {
                return ApiResult.fail("房源物业费为空！");
            }else if(StringUtils.isBlank(houseinfoVo.getPropertyfeeunit())){
                return ApiResult.fail("房源物业费单位为空！");
            }else if (houseinfoVo.getBuilduparea() == null){
                return ApiResult.fail("房源建筑面积为空！");
            }else if (houseinfoVo.getRentedarea()== null){
                return ApiResult.fail("房源待租面积为空！");
            }else if (StringUtils.isBlank(houseinfoVo.getDividedarea())){
                return ApiResult.fail("房源可分割面积为空！");
            }else if (StringUtils.isBlank(houseinfoVo.getContact())){
                return ApiResult.fail("房源联系人为空！");
            }

            Houseinfo houseinfo = houseinfoMapper.selectByPrimaryKey(houseinfoVo.getHouseid());
            if(houseinfo != null && AuthConstants.DEL_FLAG_NORMAL.equals(houseinfo.getStatus())) {
                String userId = RequestUtils.CurrentUserId(request);
                houseinfo.setModifyby(userId);
                houseinfo.setModifyon(new Date());

                houseinfo.setTitle(houseinfoVo.getTitle());
                houseinfo.setBuildingno(houseinfoVo.getBuildingno());
                houseinfo.setHousetype(houseinfoVo.getHousetype());
                houseinfo.setCompletiontime(houseinfoVo.getCompletiontime());
                houseinfo.setPropertyyears(houseinfoVo.getPropertyyears());
                houseinfo.setRoomrate(houseinfoVo.getRoomrate());
                houseinfo.setHousestatus(houseinfoVo.getHousestatus());
                houseinfo.setRental(houseinfoVo.getRental());
                houseinfo.setRentalunit(houseinfoVo.getRentalunit());
                houseinfo.setPropertyfee(houseinfoVo.getPropertyfee());
                houseinfo.setPropertyfeeunit(houseinfoVo.getPropertyfeeunit());
                houseinfo.setPrice(houseinfoVo.getPrice());
                houseinfo.setPriceunit(houseinfoVo.getPriceunit());
                houseinfo.setBuilduparea(houseinfoVo.getBuilduparea());
                houseinfo.setRentedarea(houseinfoVo.getRentedarea());
                houseinfo.setDividedarea(houseinfoVo.getDividedarea());
                houseinfo.setFloorcount(houseinfoVo.getFloorcount());
                houseinfo.setFloorheight(houseinfoVo.getFloorheight());
                houseinfo.setParkingcount(houseinfoVo.getParkingcount());
                houseinfo.setElevatortonnage(houseinfoVo.getElevatortonnage());
                houseinfo.setAttachedinfo(houseinfoVo.getAttachedinfo());
                houseinfo.setIntroduction(houseinfoVo.getIntroduction());
                houseinfo.setDevcompany(houseinfoVo.getDevcompany());
                houseinfo.setOpecompany(houseinfoVo.getOpecompany());
                houseinfo.setContact(houseinfoVo.getContact());
                houseinfo.setTelephone(houseinfoVo.getTelephone());
                houseinfo.setEmail(houseinfoVo.getEmail());

                houseinfoMapper.updateByPrimaryKey(houseinfo);
                return ApiResult.success(houseinfo);
            } else {
                return ApiResult.fail("房源已删除！");
            }
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException("修改操作异常！");
        }
    }

    @Override
    public ApiResult updatePartTraffic(HouseinfoVo houseinfoVo, HttpServletRequest request) throws LogicalException {
        try{
            if (houseinfoVo == null || StringUtils.isBlank(houseinfoVo.getHouseid())) {
                return ApiResult.fail("参数对象无效！");
            }else if (StringUtils.isBlank(houseinfoVo.getProvince())) {
                return ApiResult.fail("省为空");
            }else if (StringUtils.isBlank(houseinfoVo.getCity())) {
                return ApiResult.fail("市为空");
            }else if (StringUtils.isBlank(houseinfoVo.getDowntown())) {
                return ApiResult.fail("区为空");
            }

            Houseinfo houseinfo = houseinfoMapper.selectByPrimaryKey(houseinfoVo.getHouseid());
            if(houseinfo != null && AuthConstants.DEL_FLAG_NORMAL.equals(houseinfo.getStatus())) {
                String userId = RequestUtils.CurrentUserId(request);
                houseinfo.setModifyby(userId);
                houseinfo.setModifyon(new Date());

                houseinfo.setProvince(houseinfoVo.getProvince());
                houseinfo.setCity(houseinfoVo.getCity());
                houseinfo.setDowntown(houseinfoVo.getDowntown());
                houseinfo.setAddress(houseinfoVo.getAddress());

                houseinfoMapper.updateByPrimaryKey(houseinfo);
                return ApiResult.success(houseinfo);
            } else {
                return ApiResult.fail("房源已删除！");
            }
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException("修改操作异常！");
        }
    }

    @Override
    public ApiResult updatePartSupporting(HouseinfoVo houseinfoVo, HttpServletRequest request) throws LogicalException {
        try{
            if (houseinfoVo == null || StringUtils.isBlank(houseinfoVo.getHouseid())) {
                return ApiResult.fail("参数对象无效！");
            }
            Houseinfo houseinfo = houseinfoMapper.selectByPrimaryKey(houseinfoVo.getHouseid());
            if(houseinfo != null && AuthConstants.DEL_FLAG_NORMAL.equals(houseinfo.getStatus())) {
                String userId = RequestUtils.CurrentUserId(request);
                houseinfo.setModifyby(userId);
                houseinfo.setModifyon(new Date());

                houseinfo.setSupporting(houseinfoVo.getSupporting());
                houseinfoMapper.updateByPrimaryKey(houseinfo);
                return ApiResult.success(houseinfo);
            } else {
                return ApiResult.fail("房源已删除！");
            }
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException("修改操作异常！");
        }
    }

    @Override
    public ApiResult updatePartOthers(HouseinfoVo houseinfoVo, HttpServletRequest request) throws LogicalException {
        try{
            if (houseinfoVo == null || StringUtils.isBlank(houseinfoVo.getHouseid())) {
                return ApiResult.fail("参数对象无效！");
            }
            //确认房源有效
            Houseinfo houseinfo = houseinfoMapper.selectByPrimaryKey(houseinfoVo.getHouseid());
            if(houseinfo != null && AuthConstants.DEL_FLAG_NORMAL.equals(houseinfo.getStatus())) {
                String userId = RequestUtils.CurrentUserId(request);
                houseinfo.setModifyby(userId);
                houseinfo.setModifyon(new Date());

                houseinfo.setAirconditionsystem(houseinfoVo.getAirconditionsystem());
                houseinfo.setCommunicationsystem(houseinfoVo.getCommunicationsystem());
                houseinfo.setSecuritysystem(houseinfoVo.getSecuritysystem());
                houseinfo.setElectricalsystem(houseinfoVo.getElectricalsystem());
                houseinfo.setFireextinguishersystem(houseinfoVo.getFireextinguishersystem());
                houseinfoMapper.updateByPrimaryKey(houseinfo);
                return ApiResult.success(houseinfo);
            } else {
                return ApiResult.fail("房源已删除！");
            }
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException("修改操作异常！");
        }
    }

    @Override
    public ApiResult modifyHouseInfoStatus(HouseinfoVo houseinfoVo, HttpServletRequest request) throws LogicalException {
        try{
            if (houseinfoVo == null || StringUtils.isBlank(houseinfoVo.getHouseid())) {
                return ApiResult.fail("参数对象无效！");
            }
            //确认房源有效
            Houseinfo houseinfo = houseinfoMapper.selectByPrimaryKey(houseinfoVo.getHouseid());
            if(houseinfo != null && AuthConstants.DEL_FLAG_NORMAL.equals(houseinfo.getStatus())) {
                houseinfoMapper.updateInfoStatus(houseinfoVo.getInfostatus(), houseinfoVo.getHouseid());
            } else {
                return ApiResult.fail("房源已删除！");
            }
            return ApiResult.success();
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException("修改操作异常！");
        }
    }

    @Override
    public ApiResult deleteHouseInfo(HouseinfoVo houseinfoVo, HttpServletRequest request) throws LogicalException {
        try{
            if (houseinfoVo == null || StringUtils.isBlank(houseinfoVo.getHouseid())) {
                return ApiResult.fail("参数对象无效！");
            }
            Houseinfo houseinfo = houseinfoMapper.selectByPrimaryKey(houseinfoVo.getHouseid());
            //确认房源有效
            if(houseinfo != null && AuthConstants.DEL_FLAG_NORMAL.equals(houseinfo.getStatus())){
                if(!Constants.HOUSE_INFO_ISSUED.equals(houseinfo.getInfostatus())) {
                    houseinfoMapper.updateStatus(houseinfoVo.getHouseid());
                    return ApiResult.success();
                } else {
                    return ApiResult.fail("该房源已发布，不能被删除！");
                }
            } else {
                return ApiResult.fail("房源已删除！");
            }
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException("修改操作异常！");
        }
    }

    @Override
    public ApiResult selectAllArea() throws LogicalException {
        try{
            List<AllAreaVo> listReturn = new ArrayList<>();
            List<Areainfo> listFound = areainfoMapper.selectAll();
            List<Area> areaList = new  ArrayList<Area>();
            for(Areainfo areaInfo : listFound) {
                if(AuthConstants.DEL_FLAG_NORMAL.equals(areaInfo.getStatus())) {
                    Area area = new Area();
                    area.setAreaid(areaInfo.getAreaid());
                    areaList.add(area);
                }
            }
            //调用paas层接口
            HttpHeaders headers = new HttpHeaders();
            MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
            headers.setContentType(type);
            headers.add("Accept", MediaType.APPLICATION_JSON.toString());
            JSONArray jsonObj = JSONArray.fromObject(areaList);
            HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);
            ApiResult getresult= this.restTemplate.postForObject("http://BasicResources/area/selectAreaList", formEntity, ApiResult.class);
            List<Area> resultList = new ArrayList<>();
            if(getresult.getCode() == 0) {
                JSONArray jsonArray = JSONArray.fromObject(getresult.getData());
                resultList = (List<Area>) JSONArray.toCollection(jsonArray, Area.class);
            }

            for(Areainfo areaInfo : listFound) {
                if(AuthConstants.DEL_FLAG_NORMAL.equals(areaInfo.getStatus())){
                    AllAreaVo areaVo = new AllAreaVo();
                    BeanUtils.copyProperties(areaInfo, areaVo);
                    areaVo.setHouseCount(houseinfoMapper.countHouses(areaInfo.getAreaid()));
                    //设置areaLogo
                    if(CollectionUtils.isNotEmpty(resultList)) {
                        for (Area area : resultList) {
                            if(area.getAreaid().equals(areaInfo.getAreaid())) {
                                areaVo.setArealogo(area.getArealogo());
                            }
                        }
                    }
                    listReturn.add(areaVo);
                }
            }
            return ApiResult.success(listReturn);
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException("查询操作异常！");
        }
    }

    @Override
    public ApiResult selectByCondition(HouseinfoVo houseinfoVo) throws LogicalException {
        try{
            if (houseinfoVo == null) {
                return ApiResult.fail("参数对象无效！");
            }
            Map<String, Object> requestMap = houseinfoVo.toSearchMap();
            requestMap.put("houseStatus", houseinfoVo.getHousestatus());
            requestMap.put("houseType",houseinfoVo.getHousetype());
            requestMap.put("city", houseinfoVo.getCity());
            requestMap.put("downTown",houseinfoVo.getDowntown());
            requestMap.put("areaLowLimit", houseinfoVo.getAreaLowLimit());
            requestMap.put("areaTopLimit", houseinfoVo.getAreaTopLimit());
            requestMap.put("rentalLowLimit", houseinfoVo.getRentalLowLimit());
            requestMap.put("rentalTopLimit", houseinfoVo.getRentalTopLimit());
            requestMap.put("priceLowLimit",houseinfoVo.getPriceLowLimit());
            requestMap.put("priceTopLimit",houseinfoVo.getPriceTopLimit());
            int count = houseinfoMapper.countByCondition(requestMap);
            List<Houseinfo> infoList = houseinfoMapper.selectByCondition(requestMap);
            Page<Houseinfo> page = new Page<>(houseinfoVo.getCurrentPage(), count, houseinfoVo.getPageSize());
            page.setList(infoList);
            return ApiResult.success(page);
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException("查询操作异常！");
        }
    }
}
