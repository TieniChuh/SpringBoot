package com.mbe.mapper;

import com.BaseClass.util.MyMapper;
import com.mbe.model.Housefilepath;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HousefilepathMapper extends MyMapper<Housefilepath> {

    /**
     * 查询一条房源信息中的所有附件图片
     *
     * @param houseId String
     * @return List
     */
    List<Housefilepath> selectByHouseInfoId(@Param("houseId") String houseId);

    /**
     * 设置记录状态0-可用，1-删除
     *
     * @param housefilepathid String
     */
    void updateStatus(@Param("housefilepathid") String housefilepathid);
}