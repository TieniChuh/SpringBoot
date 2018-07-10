package com.mbe.services;

import com.BaseClass.util.ApiResult;
import com.BaseClass.util.LogicalException;
import com.mbe.vo.HouseinfoVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2018/6/21.
 */
public interface HouseInfoService {

    /**
     * 查询房源信息列表-后端
     *
     * @param houseinfoVo HouseinfoVo
     * @return ApiResult
     * @throws LogicalException
     */
    ApiResult selectByAreaAndTitle(HouseinfoVo houseinfoVo) throws LogicalException;

    /**
     * 根据ID查找房源
     *
     * @param houseinfoVo HouseinfoVo
     * @return ApiResult
     * @throws LogicalException
     */
    ApiResult selectById(HouseinfoVo houseinfoVo) throws LogicalException;

    /**
     * 保存房源信息
     *
     * @param houseinfoVo HouseinfoVo
     * @param request HttpServletRequest
     * @return ApiResult
     * @throws LogicalException
     */
    ApiResult insert(HouseinfoVo houseinfoVo, HttpServletRequest request) throws LogicalException;

    /**
     * 更新房源信息-基本信息
     *
     * @param houseinfoVo houseinfoVo
     * @param request HttpServletRequest
     * @return ApiResult
     * @throws LogicalException
     */
    ApiResult updatePartBasic(HouseinfoVo houseinfoVo,  HttpServletRequest request) throws LogicalException;

    /**
     * 更新房源信息-区位交通
     *
     * @param houseinfoVo houseinfoVo
     * @param request HttpServletRequest
     * @return ApiResult
     * @throws LogicalException
     */
    ApiResult updatePartTraffic(HouseinfoVo houseinfoVo,HttpServletRequest request) throws LogicalException;

    /**
     *更新房源信息-周边配套
     *
     * @param houseinfoVo houseinfoVo
     * @param request HttpServletRequest
     * @throws LogicalException
     */
    ApiResult updatePartSupporting(HouseinfoVo houseinfoVo,HttpServletRequest request) throws LogicalException;

    /**
     *更新房源信息-其他信息
     *
     * @param houseinfoVo houseinfoVo
     * @param request HttpServletRequest
     * @return ApiResult
     * @throws LogicalException
     */
    ApiResult updatePartOthers(HouseinfoVo houseinfoVo,HttpServletRequest request) throws LogicalException;


    /**
     * 修改房源发布状态
     *
     * @param houseinfoVo HouseinfoVo
     * @return ApiResult
     * @throws LogicalException
     */
    ApiResult modifyHouseInfoStatus(HouseinfoVo houseinfoVo,HttpServletRequest request) throws LogicalException;

    /**
     * 删除房源
     *
     * @param houseinfoVo HouseinfoVo
     * @return ApiResult
     * @throws LogicalException
     */
    ApiResult deleteHouseInfo(HouseinfoVo houseinfoVo,HttpServletRequest request) throws LogicalException;

    /**
     * 查询所有园区-后端
     *
     * @return ApiResult
     * @throws LogicalException
     */
    ApiResult selectAllArea() throws LogicalException;

    /**
     * 查询房源信息列表-前端
     *
     * @param houseinfoVo houseinfoVo
     * @return ApiResult
     * @throws LogicalException
     */
    ApiResult selectByCondition(HouseinfoVo houseinfoVo) throws LogicalException;
}
