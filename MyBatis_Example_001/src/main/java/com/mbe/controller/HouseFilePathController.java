package com.mbe.controller;


import javax.servlet.http.HttpServletRequest;

import com.mbe.model.Housefilepath;
import com.mbe.services.HouseFilePathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.BaseClass.util.ApiResult;
import com.BaseClass.util.LogicalException;


@RestController
@RequestMapping("/houseFilePath")
public class HouseFilePathController {

    @Autowired
    private HouseFilePathService houseFilePathService;

    /**
     * 查询某一房源下所有房源图片
     * @param housefilepath Housefilepath
     * @param request HttpServletRequest
     * @return ApiResult
     * @throws LogicalException
     */
    @RequestMapping(value = "/selectAll", method = { RequestMethod.POST })
    public ApiResult selectAllByHouseId(@RequestBody Housefilepath housefilepath, HttpServletRequest request) throws LogicalException {
        try {
            return houseFilePathService.selectAllByHouseId(housefilepath);
        } catch (LogicalException e) {

            return ApiResult.fail(e.getMessage());
        } catch (Exception e) {

            return ApiResult.fail("操作失败！");
        }
    }

    /**
     * 新增一条房源图片
     *
     * @param housefilepath Housefilepath
     * @param request HttpServletRequest
     * @return ApiResult
     * @throws LogicalException
     */
    @RequestMapping(value = "/insert", method = { RequestMethod.POST })
    public ApiResult insertFilePath(@RequestBody Housefilepath housefilepath, HttpServletRequest request) throws LogicalException {
        try {
            houseFilePathService.insertHouseFilePath(housefilepath, request);
            return ApiResult.success();
        }catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        }   catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }

    /**
     * 修改一条房源图片
     *
     * @param housefilepath Housefilepath
     * @param request HttpServletRequest
     * @return ApiResult
     * @throws LogicalException
     */
    @RequestMapping(value = "/update", method = { RequestMethod.POST })
    public ApiResult updateFilePath(@RequestBody Housefilepath housefilepath, HttpServletRequest request) throws LogicalException {
        try {
            houseFilePathService.updateHouseFilePath(housefilepath, request);
            return ApiResult.success();
        }catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        }   catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }

    /**
     * 删除一条房源图片
     *
     * @param housefilepath Housefilepath
     * @param request HttpServletRequest
     * @return ApiResult
     * @throws LogicalException
     */
    @RequestMapping(value = "/delete", method = { RequestMethod.POST })
    public ApiResult deleteFilePath(@RequestBody Housefilepath housefilepath, HttpServletRequest request) throws LogicalException {
        try {
            houseFilePathService.deleteHouseFilePath(housefilepath);
            return ApiResult.success();
        }catch (LogicalException e) {
            return ApiResult.fail(e.getMessage());
        }   catch (Exception e) {
            return ApiResult.fail("操作失败！");
        }
    }

}
