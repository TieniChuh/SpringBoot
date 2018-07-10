package com.mbe.mapper;

import com.BaseClass.util.MyMapper;
import com.mbe.model.Airconditionfeeclause;
import com.mbe.model.ApartmentInsInfo;
import com.mbe.vo.ApartmentInsInfoVo;

import java.util.List;
import java.util.Map;

/**
 * Author:Administrator
 * Description: Auto_Templeate
 * Date:  2018/6/22.
 */
public interface ApartmentInsInfoMapper {
    /**
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @param record
     * @return
     */
    int insert(ApartmentInsInfo record);

    /**
     *
     * @param record
     * @return
     */
    int insertSelective(ApartmentInsInfo record);

    /**
     *
     * @param id
     * @return
     */
    ApartmentInsInfo selectByPrimaryKey(String id);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ApartmentInsInfo record);


    int updateByPrimaryKey(ApartmentInsInfo record);

    /**
     *
     * @param map
     * @return
     */
    int countByInsNoOrAddress(Map<String, Object> map);

    /**
     *
     * @param map
     * @return
     */
    List<ApartmentInsInfoVo> selectByInsNoOrAddress(Map<String, Object> map);


}