package com.mbe.mapper;

import com.mbe.model.RoomSplitInfo;

public interface RoomSplitInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(RoomSplitInfo record);

    int insertSelective(RoomSplitInfo record);

    RoomSplitInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoomSplitInfo record);

    int updateByPrimaryKey(RoomSplitInfo record);
}