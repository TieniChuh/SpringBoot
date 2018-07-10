package com.mbe.services.impl;

import com.BaseClass.util.ApiResult;
import com.BaseClass.util.LogicalException;
 import com.mbe.mapper.ApartmentInsInfoMapper;
import com.mbe.model.ApartmentInsInfo;
import com.mbe.services.ApartmentInsInfoService;
import com.mbe.vo.ApartmentInsInfoVo;
import com.mbe.vo.HouseinfoVo;
import com.mbe.vo.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Author:Administrator
 * Description: Auto_Templeate
 * Date:  2018/6/22.
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ApartmentInsInfoServiceImpl implements ApartmentInsInfoService{

    private static Logger log = LoggerFactory.getLogger(ApartmentInsInfoServiceImpl.class);

    @Autowired
    private ApartmentInsInfoMapper apartmentInsInfoMapper;

    /**
     * @param apartmentInsInfoVo
     * @throws LogicalException
     */
    @Override
    public void insert(ApartmentInsInfoVo apartmentInsInfoVo) throws LogicalException {
        ApartmentInsInfo apartmentInsInfo=new ApartmentInsInfo();
        try {
            BeanUtils.copyProperties(apartmentInsInfoVo, apartmentInsInfo);

            apartmentInsInfoMapper.insert(apartmentInsInfo);
        }catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException(e.getMessage());
        }
     }

    /**
     *
     * @param apartmentInsInfoVo
     * @return
     * @throws LogicalException
     */
    @Override
    public ApiResult queryByInsNoOrAddress(ApartmentInsInfoVo apartmentInsInfoVo) throws LogicalException {
        try{
            Map<String, Object> requestMap = apartmentInsInfoVo.toSearchMap();

            requestMap.put("insuranceno", apartmentInsInfoVo.getInsuranceno());
            //分页参数加入
            requestMap.putAll(apartmentInsInfoVo.toSearchMap());

            int count = apartmentInsInfoMapper.countByInsNoOrAddress(requestMap);
            List<ApartmentInsInfoVo> infoList = apartmentInsInfoMapper.selectByInsNoOrAddress(requestMap);
            if(infoList.size()>0)
            log.info("##########################"+infoList.get(0).getInsuredname());
            Page<ApartmentInsInfoVo> page = new Page<>(apartmentInsInfoVo.getCurrentPage(), count, apartmentInsInfoVo.getPageSize());
            page.setList(infoList);
            ApiResult returnVo = new ApiResult();
            returnVo.setData(page);
            return ApiResult.success(returnVo);
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException("查询操作异常！");
        }

    }

    /**
     *
     * @param apartmentInsInfoVo
     * @throws LogicalException
     */
    @Override
    public void update(ApartmentInsInfoVo apartmentInsInfoVo) throws LogicalException {
        ApartmentInsInfo apartmentInsInfo=new ApartmentInsInfo();
        try {
            BeanUtils.copyProperties(apartmentInsInfoVo, apartmentInsInfo);
            apartmentInsInfoMapper.updateByPrimaryKeySelective(apartmentInsInfo);
         }catch (Exception e) {
            log.warn(e.getMessage());
            throw new LogicalException(e.getMessage());
        }
    }

    /**
     *
     * @param apartmentInsInfoVo
     * @throws LogicalException
     */
    @Override
    public void delete(ApartmentInsInfoVo apartmentInsInfoVo) throws LogicalException {
        //	Status	数据状态 （0：可用，1：逻辑删除）
        apartmentInsInfoVo.setStatus("1");
        update(apartmentInsInfoVo);
    }
}