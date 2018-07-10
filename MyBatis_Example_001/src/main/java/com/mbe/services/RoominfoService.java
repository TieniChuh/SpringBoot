package com.mbe.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import com.BaseClass.util.LogicalException;
import com.mbe.vo.RoomSplitInfoVo;
import com.mbe.paasvo.BasetreeinstanceVo;
import com.mbe.vo.RoominfoVo;
import org.springframework.web.bind.annotation.RequestBody;

public interface RoominfoService {
	
	List<RoominfoVo> selectAll(RoominfoVo roominfovo) throws LogicalException;
	
	RoominfoVo selectById(String roomid) throws LogicalException;
	
	void insert(RoominfoVo roominfovo, HttpServletRequest request) throws LogicalException;
	
	void update(RoominfoVo roominfovo, HttpServletRequest request) throws LogicalException;
	
	void delete(RoominfoVo roominfovo, HttpServletRequest request) throws LogicalException;
	
	ArrayList<Object> importRoom(List<List<Object>> list, String userId, String tenantId, String floorId, HttpServletRequest request) throws LogicalException;

	//按照需求类型，统计房间面积
	ArrayList<BasetreeinstanceVo> sumAreaByCondition(BasetreeinstanceVo bVo) throws LogicalException;
	
	//设置房间可用/停用
	void usableRoom ( List<RoominfoVo> roominfoVoList, String usable) throws LogicalException;

	List<RoominfoVo> selectAllTrustRoom(RoominfoVo roominfovo) throws LogicalException;

	void roomSplit(RoomSplitInfoVo roomsplitinfoVo)throws LogicalException;;

}
