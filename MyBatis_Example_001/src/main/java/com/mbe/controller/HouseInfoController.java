package com.mbe.controller;

import com.BaseClass.util.ApiResult;
import com.BaseClass.util.LogicalException;
import com.BaseClass.util.RequestUtils;
import com.mbe.services.HouseInfoService;
import com.mbe.services.PaymentService;
import com.mbe.util.Constants;
import com.mbe.vo.HouseinfoVo;
import com.mbe.vo.ParkcontractVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/6/21.
 */
@RestController
@RequestMapping("houseInfo")
public class HouseInfoController {

    @Autowired
    private HouseInfoService houseInfoService;

    /**
     * 查询房源信息列表-后端
     * @param houseinfoVo HouseinfoVo
     * @param request HttpServletRequest
     * @return ApiResult
     */
    @RequestMapping(value = "/selectByAreaAndTitle", method = { RequestMethod.POST })
    public ApiResult selectByAreaAndTitle(@RequestBody HouseinfoVo houseinfoVo, HttpServletRequest request) {
        try {
            return houseInfoService.selectByAreaAndTitle(houseinfoVo);
        } catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }

    /**
     * 插入一条新的房源信息-后端
     * @param houseinfoVo HouseinfoVo
     * @param request HttpServletRequest
     * @return ApiResult
     */
    @RequestMapping(value = "/insert", method = { RequestMethod.POST })
    public ApiResult insert(@RequestBody HouseinfoVo houseinfoVo, HttpServletRequest request) {
        try {
            return houseInfoService.insert(houseinfoVo, request);
        } catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }

    /**
     * 修改房源-基本信息-后端
     * @param houseinfoVo HouseinfoVo
     * @param request HttpServletRequest
     * @return ApiResult
     */
    @RequestMapping(value = "/updatePartBasic", method = { RequestMethod.POST })
    public ApiResult updatePartBasic(@RequestBody HouseinfoVo houseinfoVo, HttpServletRequest request) {
        try {
            return houseInfoService.updatePartBasic(houseinfoVo, request);
        } catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }

    /**
     * 修改房源-区位交通-后端
     * @param houseinfoVo HouseinfoVo
     * @param request HttpServletRequest
     * @return ApiResult
     */
    @RequestMapping(value = "/updatePartTraffic", method = { RequestMethod.POST })
    public ApiResult updatePartTraffic(@RequestBody HouseinfoVo houseinfoVo, HttpServletRequest request) {
        try {
            return houseInfoService.updatePartOthers(houseinfoVo, request);
        } catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }

    /**
     * 修改房源-周边配套-后端
     * @param houseinfoVo HouseinfoVo
     * @param request HttpServletRequest
     * @return ApiResult
     */
    @RequestMapping(value = "/updatePartSupporting", method = { RequestMethod.POST })
    public ApiResult updatePartSupporting(@RequestBody HouseinfoVo houseinfoVo, HttpServletRequest request) {
        try {
            return houseInfoService.updatePartSupporting(houseinfoVo, request);
        } catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }

    /**
     * 修改房源-其他信息-后端
     * @param houseinfoVo HouseinfoVo
     * @param request HttpServletRequest
     * @return ApiResult
     */
    @RequestMapping(value = "/updatePartOthers", method = { RequestMethod.POST })
    public ApiResult updatePartOthers(@RequestBody HouseinfoVo houseinfoVo, HttpServletRequest request) {
        try {
            return houseInfoService.updatePartOthers(houseinfoVo, request);
        } catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }

    /**
     * 发布房源-后端
     * @param houseinfoVo HouseinfoVo
     * @param request HttpServletRequest
     * @return ApiResult
     */
    @RequestMapping(value = "/issueInfo", method = { RequestMethod.POST })
    public ApiResult issueInfo(@RequestBody HouseinfoVo houseinfoVo, HttpServletRequest request) {
        try {
            houseinfoVo.setInfostatus(Constants.HOUSE_INFO_ISSUED);
            return houseInfoService.modifyHouseInfoStatus(houseinfoVo, request);
        } catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }

    /**
     * 撤销已发布房源-后端
     * @param houseinfoVo HouseinfoVo
     * @param request HttpServletRequest
     * @return ApiResult
     */
    @RequestMapping(value = "/cancelInfo", method = { RequestMethod.POST })
    public ApiResult cancelInfo(@RequestBody HouseinfoVo houseinfoVo, HttpServletRequest request) {
        try {
            houseinfoVo.setInfostatus(Constants.HOUSE_INFO_CANCELLED);
            return houseInfoService.modifyHouseInfoStatus(houseinfoVo, request);
        } catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }

    /**
     * 删除房源-后端
     * @param houseinfoVo HouseinfoVo
     * @param request HttpServletRequest
     * @return ApiResult
     */
    @RequestMapping(value = "/deleteInfo", method = { RequestMethod.POST })
    public ApiResult deleteInfo(@RequestBody HouseinfoVo houseinfoVo, HttpServletRequest request) {
        try {
            return houseInfoService.deleteHouseInfo(houseinfoVo, request);
        } catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }


    /**
     * 查询所有园区信息-后端
     * @param request HttpServletRequest
     * @return ApiResult
     */
    @RequestMapping(value = "/selectAllArea", method = { RequestMethod.POST })
    public ApiResult selectAllArea(HttpServletRequest request) {
        try {
            return houseInfoService.selectAllArea();
        } catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }

    /**
     * 查询房源信息列表-前端
     * @param houseinfoVo HouseinfoVo
     * @param request HttpServletRequest
     * @return ApiResult
     */
    @RequestMapping(value = "/selectByCondition", method = { RequestMethod.POST })
    public ApiResult selectByCondition(@RequestBody HouseinfoVo houseinfoVo, HttpServletRequest request) {
        try {
            return houseInfoService.selectByCondition(houseinfoVo);
        } catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }
}
