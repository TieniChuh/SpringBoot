package com.mbe.mapper;

import com.BaseClass.util.LogicalException;
import com.BaseClass.util.MyMapper;
import com.mbe.model.Filepath;
import com.mbe.model.Houseinfo;
import com.mbe.vo.HouseinfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HouseinfoMapper extends MyMapper<Houseinfo> {

    /**
     * 计算房源信息列表查询总记录数
     *
     * @param map Map
     * @return Long
     */
    int countByAreaAndTitle(Map<String, Object> map);

    /**
     * 查询房源信息列表
     *
     * @param map Map
     * @return List
     */
    List<Houseinfo> selectByAreaAndTitle(Map<String, Object> map);

    /**
     * 修改房源发布的状态
     *
     * @param infoStatus String
     * @param houseId String
     * @return Integer
     */
    Integer updateInfoStatus(@Param("infoStatus") String infoStatus, @Param("houseId") String houseId);

    /**
     * 修改房源记录的状态-逻辑删除
     *
     * @param houseId String
     * @return Integer
     */
    Integer updateStatus(String houseId);

    /**
     * 计算房源信息列表查询总记录数-前端
     *
     * @param map Map
     * @return int
     */
    int countByCondition(Map<String,Object> map);

    /**
     * 查询房源信息列表-前端
     *
     * @param map Map
     * @return List
     */
    List<Houseinfo> selectByCondition(Map<String,Object> map);

    /**
     * 统计同一园区内的房源数量
     *
     * @param areaId String
     * @return Integer
     */
    Integer countHouses(@Param("areaId") String areaId);


}