package com.mbe.services.impl;

/**
 * Created by Administrator on 2018/6/26.
 */

import com.BaseClass.util.*;
import com.mbe.mapper.BuildinginfoMapper;
import com.mbe.mapper.HousefilepathMapper;
import com.mbe.model.Housefilepath;
import com.mbe.model.Houseinfo;
import com.mbe.services.HouseFilePathService;
import com.mbe.util.Constants;
import com.mbe.vo.HouseinfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/6/21.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class HouseFilePathServiceImpl implements HouseFilePathService {

    private static Logger log = LoggerFactory.getLogger(HouseFilePathServiceImpl.class);

    @Autowired
    private HousefilepathMapper housefilepathMapper;

    @Override
    public ApiResult selectAllByHouseId(Housefilepath housefilepath) throws LogicalException {
        try{
            if (housefilepath == null || StringUtils.isBlank(housefilepath.getHouseid())) {
                return ApiResult.fail("参数对象无效！");
            }
            List<Housefilepath> filePathList = housefilepathMapper.selectByHouseInfoId(housefilepath.getHouseid());
            return ApiResult.success(filePathList);
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException("查询操作异常！");
        }
    }

    @Override
    public ApiResult insertHouseFilePath(Housefilepath housefilepath, HttpServletRequest request) throws LogicalException {
        try {
            if (housefilepath == null) {
                return ApiResult.fail("参数对象无效！");
            }
            if(StringUtils.isBlank(housefilepath.getHouseid())){
                return ApiResult.fail("房源对象为空！");
            }
            if(StringUtils.isBlank(housefilepath.getFileurl())){
                return ApiResult.fail("文件路径为空！");
            }
            housefilepath.setHousefilepathid(UUID.randomUUID().toString());
            housefilepath.setStatus(AuthConstants.DEL_FLAG_NORMAL);
            String userId = RequestUtils.CurrentUserId(request);
            housefilepath.setCreateby(userId);
            housefilepath.setModifyby(userId);
            housefilepath.setOwner(userId);
            Date now = new Date();
            housefilepath.setCreateon(now);
            housefilepath.setModifyon(now);
            housefilepathMapper.insert(housefilepath);
            return ApiResult.success(housefilepath);
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException("新建操作异常！");
        }
    }

    @Override
    public ApiResult updateHouseFilePath(Housefilepath housefilepath, HttpServletRequest request) throws LogicalException {
        try {
            if (housefilepath == null || StringUtils.isBlank(housefilepath.getHousefilepathid())) {
                return ApiResult.fail("参数对象无效！");
            }
            if(StringUtils.isBlank(housefilepath.getHouseid())){
                return ApiResult.fail("房源对象为空！");
            }
            if(StringUtils.isBlank(housefilepath.getFileurl())){
                return ApiResult.fail("文件路径为空！");
            }
            Housefilepath housefilepathOld = housefilepathMapper.selectByPrimaryKey(housefilepath.getHousefilepathid());
            if(housefilepathOld != null && AuthConstants.DEL_FLAG_NORMAL.equals(housefilepathOld.getStatus())) {
                String userId = RequestUtils.CurrentUserId(request);
                housefilepathOld.setModifyby(userId);
                housefilepathOld.setOwner(userId);
                Date now = new Date();
                housefilepathOld.setModifyon(now);
                housefilepathOld.setHouseid(housefilepath.getHouseid());
                housefilepathOld.setFilename(housefilepath.getFilename());
                housefilepathOld.setFileurl(housefilepath.getFileurl());
                housefilepathMapper.updateByPrimaryKey(housefilepathOld);
                return ApiResult.success(housefilepathOld);
            } else {
                return ApiResult.fail("图片位置已删除！");
            }
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException("新建操作异常！");
        }
    }

    @Override
    public ApiResult deleteHouseFilePath(Housefilepath housefilepath) throws LogicalException {
        try {
            if (housefilepath == null || StringUtils.isBlank(housefilepath.getHousefilepathid())) {
                return ApiResult.fail("参数对象无效！");
            }
            Housefilepath housefilepathOld = housefilepathMapper.selectByPrimaryKey(housefilepath.getHousefilepathid());
            if(housefilepathOld != null && AuthConstants.DEL_FLAG_NORMAL.equals(housefilepathOld.getStatus())) {
                housefilepathMapper.updateStatus(housefilepath.getHousefilepathid());
                return ApiResult.success();
            } else {
                return ApiResult.fail("图片位置已删除！");
            }
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException("新建操作异常！");
        }
    }
}
