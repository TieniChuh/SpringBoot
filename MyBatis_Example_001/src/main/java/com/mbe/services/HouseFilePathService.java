package com.mbe.services;

import com.BaseClass.util.ApiResult;
import com.BaseClass.util.LogicalException;
import com.mbe.model.Housefilepath;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/6/26.
 */
public interface HouseFilePathService {

    /**
     * 查询房源信息的所有图片
     *
     * @param housefilepath Housefilepath
     * @return ApiResult
     * @throws LogicalException
     */
    ApiResult selectAllByHouseId(Housefilepath housefilepath) throws LogicalException;

    /**
     * 新增一张房源信息的图片
     *
     * @param housefilepath Housefilepath
     * @param request HttpServletRequest
     * @return ApiResult
     * @throws LogicalException
     */
    ApiResult insertHouseFilePath(Housefilepath housefilepath, HttpServletRequest request)throws LogicalException;

    /**
     * 修改一张房源信息的图片
     *
     * @param housefilepath Housefilepath
     * @param request HttpServletRequest
     * @return ApiResult
     * @throws LogicalException
     */
    ApiResult updateHouseFilePath(Housefilepath housefilepath, HttpServletRequest request)throws LogicalException;

    /**
     * 删除一张房源信息的图片
     *
     * @param housefilepath Housefilepath
     * @return ApiResult
     * @throws LogicalException
     */
    ApiResult deleteHouseFilePath(Housefilepath housefilepath)throws LogicalException;
}
