package com.mbe.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;


import com.mbe.mapper.RoomSplitInfoMapper;
import com.mbe.model.*;
import com.mbe.vo.RoomSplitInfoVo;
import com.mbe.util.RequestUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import com.BaseClass.util.ApiResult;
import com.BaseClass.util.AuthConstants;
import com.BaseClass.util.LogicalException;
import com.BaseClass.util.RequestUtils;
import com.mbe.mapper.RoominfoMapper;
import com.mbe.mapper.FloorinfoMapper;
import com.mbe.paasmodel.Basetreeinstance;
import com.mbe.paasmodel.Dictionaries;
import com.mbe.paasmodel.Floor;
import com.mbe.paasmodel.Room;
import com.mbe.paasvo.BasetreeinstanceVo;
import com.mbe.services.RoominfoService;
import com.mbe.vo.FloorVo;
import com.mbe.vo.RoomAreaSumVo;
import com.mbe.vo.RoominfoVo;
import com.mysql.jdbc.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.DefaultDefaultValueProcessor;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoominfoServiceImpl implements RoominfoService {

	private static Logger log = LoggerFactory.getLogger(RoominfoServiceImpl.class);
	// 更新状态
	public static final String TYPE_UPDATE = "0";
	// 删除状态
	public static final String TYPE_DELETE = "1";
	@Autowired
	private RoominfoMapper roominfoMapper;
	@Autowired
	private FloorinfoMapper floorinfoMapper;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private RoomSplitInfoMapper roomSplitInfoMapper;
	@Override
	public List<RoominfoVo> selectAll(RoominfoVo roominfovo) throws LogicalException {
		try {
			// 查询联系人相关信息
			List<RoominfoVo> roominfovoList = roominfoMapper.selectRoomInfo(roominfovo);
			// 声明基础库房间id list
			List<String> roomids = new ArrayList<String>();
			// 写入基础人员id
			for (int i = 0; i < roominfovoList.size(); i++) {
				roomids.add(roominfovoList.get(i).getRoomid());
			}
			// 根据基础人员id查询相关信息
			for (int i = 0; i < roominfovoList.size(); i++) {
				// get请求
				ApiResult result = this.restTemplate.getForObject(
						"http://BasicResources/room/selectRoomById?roomId=" + roominfovoList.get(i).getRoomid(),
						ApiResult.class);

				if (result.getCode() == 0) {
					// pass层返回数据
					JSONObject jsonobject = JSONObject.fromObject(result.getData());
					Room room = (Room) JSONObject.toBean(jsonobject, Room.class);
					BeanUtils.copyProperties(room, roominfovoList.get(i));
				}
			}

			return roominfovoList;
		} catch (Exception e) {
			log.warn(e.getMessage());
			throw new LogicalException("查询操作异常！");
		}
	}

	/**
	 * 根据id查询房间
	 *
	 */
	@Override
	public RoominfoVo selectById(String roomid) throws LogicalException {
		try {
			RoominfoVo roominfovo = new RoominfoVo();

			Roominfo roominfo = roominfoMapper.selectByPrimaryKey(roomid);
			BeanUtils.copyProperties(roominfo, roominfovo);
			// get请求
			ApiResult result = this.restTemplate
					.getForObject("http://" + RequestUtil.BASICRESOURCES + "/room/selectRoomById?roomId=" + roomid, ApiResult.class);

			if (result.getCode() == 0) {
				// pass层返回数据
				JSONObject jsonobject = JSONObject.fromObject(result.getData());
				Room room = (Room) JSONObject.toBean(jsonobject, Room.class);
				BeanUtils.copyProperties(room, roominfovo);
			}

			return roominfovo;
		} catch (Exception e) {
			log.warn(e.getMessage());
			throw new LogicalException("查询操作异常！");
		}
	}

	/**
	 * 添加房间
	 *
	 */
	@Override
	public void insert(RoominfoVo roominfovo, HttpServletRequest request) throws LogicalException {
		try {

			roominfovo.setCreateon(new Date());
			roominfovo.setModifyon(new Date());
			//paas层数据 Room
			Room room = new Room();
			room.setStatus(AuthConstants.DEL_FLAG_NORMAL);
			BeanUtils.copyProperties(roominfovo, room);
			// 调用paas层添加房间接口
			HttpHeaders headers = new HttpHeaders();
			MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
			headers.setContentType(type);
			headers.add("Accept", MediaType.APPLICATION_JSON.toString());
			Enumeration<String> headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String key = (String) headerNames.nextElement();
				String value = request.getHeader(key);
				headers.add(key, value);
			}
			JsonConfig jsonConfig = new JsonConfig();
			DefaultDefaultValueProcessor processor = new DefaultDefaultValueProcessor() {
				public Object getDefaultValue(Class type) {
					return null;
				}
			};
			jsonConfig.registerDefaultValueProcessor(String.class, processor);
			JSONObject jsonObj = JSONObject.fromObject(room, jsonConfig);
			Long createon = roominfovo.getCreateon().getTime();
			jsonObj = jsonObj.element("createon", createon.toString());
			Long modifyon = roominfovo.getModifyon().getTime();
			jsonObj = jsonObj.element("modifyon", modifyon.toString());
			HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);

			ApiResult result = this.restTemplate.postForObject("http://BasicResources/room/addRoom/", formEntity,
					ApiResult.class);

			if (result.getCode() == 0) {
				// pass层返回id
				String roomid = result.getMessage();

				Roominfo roominfo = new Roominfo();
				BeanUtils.copyProperties(roominfovo, roominfo);
				// 插入房间数据
				roominfo.setRoomid(roomid);
				//房间状态为0
				roominfo.setStatus(AuthConstants.DEL_FLAG_NORMAL);
				//房间可用/停用状态为0
				roominfo.setUsable(AuthConstants.DEL_FLAG_NORMAL);
				//房间在租状态
				roominfo.setRoomstatus(AuthConstants.DEL_FLAG_NORMAL);

				roominfoMapper.insertSelective(roominfo);

				// 更新楼层 floor 的可租赁面积
				roominfoMapper.updateRentableareaAndBuildingarea(roominfovo.getFloorid());
				// 更新楼宇 building 的可租赁面积
				Floorinfo floorinfo = new  Floorinfo();
				floorinfo.setBuildingid(roominfovo.getBuildingid());
				floorinfoMapper.updateRentableareaAndBuildingarea(floorinfo);

//				// 更新楼层 floor 的可租赁面积
//				String areastatisticstype = roominfoMapper.superAreastatisticstype(roominfovo.getFloorid());
//				if ("1".equals(areastatisticstype)) {
//
//					roominfoMapper.updateRentablearea(roominfovo.getFloorid());
//
//					// 更新楼宇 building 的可租赁面积
//					String areastatisticstype2 = floorinfoMapper.superAreastatisticstype(roominfovo.getBuildingid());
//					if ("1".equals(areastatisticstype2)) {
//						floorinfoMapper.updateRentablearea(roominfovo.getBuildingid());
//					}
//				}

			} else {
				throw new LogicalException(result.getMessage());
			}
		} catch (Exception e) {
			log.warn(e.getMessage());
			throw new LogicalException(e.getMessage());
		}
	}

	/**
	 * 修改房间信息
	 *
	 */
	@Override
	public void update(RoominfoVo roominfovo, HttpServletRequest request) throws LogicalException {
		try {
			ApiResult returnVo = new ApiResult();
			roominfovo.setModifyon(new Date());

			// 调用pass层接口保存数据
			ApiResult result = this.updateRoominfo(roominfovo, request);
			if (result.getCode() == -1) {
				log.info("接口调用失败：" + result.getMessage());
				throw new LogicalException(result.getMessage());
			}

			Roominfo roominfo = new Roominfo();
			BeanUtils.copyProperties(roominfovo, roominfo);
			// roominfo更新saas数据
			this.updateRoominfo(roominfo, TYPE_UPDATE);

		} catch (Exception e) {
			log.warn(e.getMessage());
			throw new LogicalException(e.getMessage());
		}
	}

	/**
	 * 删除房间信息
	 *
	 */
	@Override
	public void delete(RoominfoVo roominfovo, HttpServletRequest request) throws LogicalException {
		try {

			ApiResult returnVo = new ApiResult();
			roominfovo.setStatus(AuthConstants.DEL_FLAG_DELETE);
			roominfovo.setModifyon(new Date());

			// 调用pass层接口保存数据
			ApiResult result = this.updateRoominfo(roominfovo, request);

			if (result.getCode() == -1) {
				log.info("接口调用失败：" + result.getMessage());
				returnVo.setCustomerMessage(result.getMessage());
			}

			Roominfo roominfo = new Roominfo();
			BeanUtils.copyProperties(roominfovo, roominfo);

			// roominfo更新saas数据
			this.updateRoominfo(roominfo, TYPE_DELETE);

		} catch (Exception e) {
			log.warn(e.getMessage());
			throw new LogicalException("删除操作异常！");
		}
	}

	/**
	 * roominfo更新saas数据
	 *
	 * @param roominfo
	 */
	private void updateRoominfo(Roominfo roominfo, String type) {
		// ====
		// 更新时执行
		if (type.equals(TYPE_UPDATE)) {

		}
		// 删除时执行
		if (type.equals(TYPE_DELETE)) {
			String roomid = roominfo.getRoomid();
			roominfo = new Roominfo();
			roominfo.setRoomid(roomid);
			roominfo = roominfoMapper.selectOne(roominfo);
			//房间删除状态
			roominfo.setStatus(AuthConstants.DEL_FLAG_DELETE);
			//房间可用/停用状态为0
			roominfo.setUsable(AuthConstants.DEL_FLAG_DELETE);
		}
		// 更新roominfo
		roominfoMapper.updateByPrimaryKeySelective(roominfo);

		// 更新floorinfo可租赁面积
		roominfoMapper.updateRentableareaAndBuildingarea(roominfo.getFloorid());
		// 更新buildinginfo可租赁面积
		Floorinfo floorinfo = new  Floorinfo();
		floorinfo.setBuildingid(roominfo.getBuildingid());
		floorinfoMapper.updateRentableareaAndBuildingarea(floorinfo);

		// 更新floorinfo可租赁面积
//		String areastatisticstype = roominfoMapper.superAreastatisticstype(roominfo.getFloorid());
//		if ("1".equals(areastatisticstype)) {
//			roominfoMapper.updateRentablearea(roominfo.getFloorid());
		// 更新buildinginfo可租赁面积
//			String areastatisticstype2 = floorinfoMapper.superAreastatisticstype(roominfo.getBuildingid());
//			if ("1".equals(areastatisticstype2)) {
//				floorinfoMapper.updateRentablearea(roominfo.getBuildingid());
//			}
//		}

	}

	// 调用pass层条件查询楼层信息
	private ApiResult updateRoominfo(RoominfoVo roominfovo, HttpServletRequest request) {
		Room room = new Room();
		BeanUtils.copyProperties(roominfovo, room);
		room.setRoomid(roominfovo.getRoomid());
		// room.setModifyon(new Date());
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			headers.add(key, value);
		}

		JsonConfig jsonConfig = new JsonConfig();
		DefaultDefaultValueProcessor processor = new DefaultDefaultValueProcessor() {
			public Object getDefaultValue(Class type) {
				return null;
			}
		};
		jsonConfig.registerDefaultValueProcessor(String.class, processor);

		JSONObject jsonObj = JSONObject.fromObject(room, jsonConfig);
		if (room.getModifyon() != null) {
			Long modifyon = room.getModifyon().getTime();
			jsonObj = jsonObj.element("modifyon", modifyon.toString());
		}
		if (room.getCreateon() != null) {
			Long createon = room.getCreateon().getTime();
			jsonObj = jsonObj.element("createon", createon.toString());
		}

		HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);

		ApiResult result = this.restTemplate.postForObject("http://BasicResources/room/updUseraccount/", formEntity,
				ApiResult.class);

		// ApiResult result = this.restTemplate.postForObject("http://127.0.0.1:9093/room/updUseraccount/",
		// formEntity,  ApiResult.class);

		return result;
	}

	/**
	 * 调用pass层条件查询楼层信息
	 */
	private Floor getfloorInfo(FloorVo floorvo, HttpServletRequest request) throws LogicalException {
		Floor floor = null;
		try {
			// 调用paas层接口
			HttpHeaders headers = new HttpHeaders();
			MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
			headers.setContentType(type);
			headers.add("Accept", MediaType.APPLICATION_JSON.toString());

			Enumeration<String> headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String key = (String) headerNames.nextElement();
				String passPalue = request.getHeader(key);
				headers.add(key, passPalue);
			}
			JSONObject jsonObj = JSONObject.fromObject(floorvo.getBasicfloor());
			HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);
			ApiResult getresult = this.restTemplate.postForObject("http://BasicResources/floor/selectFloorByCondition",
					formEntity, ApiResult.class);

			if (getresult.getCode() == 0) {
				JSONArray jsonArray = JSONArray.fromObject(getresult.getData());
				List<Floor> floorList = (List<Floor>) JSONArray.toCollection(jsonArray, Floor.class);
				floor = floorList.get(0);
			}

		} catch (Exception e) {
			log.warn(e.getMessage());
			// throw new LogicalException("查询操作异常！");
		}
		return floor;
	}

	/**
	 * 调用pass层条件查询业务字典
	 */
	private List<Dictionaries> getAllDictById(String code, HttpServletRequest request) throws LogicalException {
		List<Dictionaries> dictionaries = new ArrayList<Dictionaries>();
		try {
			String tenantid = RequestUtils.CurrentTenantId(request);
			// 调用paas层接口
			ApiResult getresult = this.restTemplate.getForObject(
					"http://Organization/dictionary/getAllDict?code=" + code + "&tenantid=" + tenantid,
					ApiResult.class);

			if (getresult.getCode() == 0) {
				JSONArray jsonArray = JSONArray.fromObject(getresult.getData());
				dictionaries = (List<Dictionaries>) JSONArray.toCollection(jsonArray, Dictionaries.class);
			}

		} catch (Exception e) {
			log.warn(e.getMessage());
			// throw new LogicalException("查询操作异常！");
		}
		return dictionaries;
	}

	/**
	 * 批量导入房间信息
	 *
	 */
	@Override
	public ArrayList<Object> importRoom(List<List<Object>> list, String userId, String tenantId, String buildingId,
										HttpServletRequest request) throws LogicalException {
		ArrayList<Object> succedList = new ArrayList<Object>();
		int succeedCount = 0;
		int failedCount = 0;
		List<Dictionaries> dicOrientation = this.getAllDictById("orientation", request);
		List<Dictionaries> dicPriceunit = this.getAllDictById("price", request);
		int k = 1;
		for (int i = 1; i < list.size(); i++) {
			try {
				List<Object> value = list.get(k);

				k++;
				if (value != null && !value.isEmpty()) {
					// 条件查询楼层信息
					Floor floor = new Floor();
					floor.setBuildingid(buildingId);
					floor.setFloorname(value.get(0).toString());
					FloorVo floorVo = new FloorVo();
					floorVo.setBasicfloor(floor);
					floor = this.getfloorInfo(floorVo, request);

					if (floor == null) {
						log.warn("查询操作异常！");
						failedCount++;
						continue;
					}

					RoominfoVo room = new RoominfoVo();
					room.setRoomid(UUID.randomUUID().toString());
					room.setCreateby(userId);
					room.setOwner(userId);
					room.setModifyby(userId);
					room.setStatus(AuthConstants.DEL_FLAG_NORMAL);
					if (StringUtils.isNullOrEmpty(floor.getFloorid())) {
						failedCount++;
						log.warn("楼层ID为空");
						// throw new LogicalException("楼层ID为空");
						failedCount++;
						continue;
					}
					room.setFloorid(floor.getFloorid());
					room.setBuildingid(buildingId);
					if (value.size() > 1) {
						room.setRoomno(format(value.get(1).toString()));
					}
					if (value.size() > 2) {
						room.setRoomrentarea(Double.valueOf(value.get(2).toString()));
						room.setRoomarea(Float.valueOf(value.get(2).toString()));
					}
					if (value.size() > 3) {
						// 朝向
						for (Dictionaries item : dicOrientation) {
							if (format(item.getName()).equals(format(value.get(3).toString()))) {
								room.setOrientation(format(item.getCode()));
								break;
							}
						}
					}
					if (value.size() > 4) {
						// 采光
						if (format(value.get(4).toString()).equals("是")) {
							room.setLighting("0");
						} else if (format(value.get(4).toString()).equals("否")) {
							room.setLighting("1");
						}
					}
					if (value.size() > 5) {
						// 单价
						room.setRoomprice(Double.valueOf(value.get(5).toString()));
					}
					if (value.size() > 6) {
						// 单价单位
						for (Dictionaries item : dicPriceunit) {
							if (format(item.getName()).equals(format(value.get(6).toString()))) {
								room.setRoompriceunit(format(item.getCode()));
								break;
							}
						}
					}
					// 返回房间信息
					ImportRoom room2info = new ImportRoom();
					room2info.setFloorName(format(value.get(0).toString()));
					room2info.setRoomno(format(value.get(1).toString()));
					room2info.setRoomrentarea(Double.valueOf(value.get(2).toString()));
					room2info.setOrientation(format(value.get(3).toString()));
					room2info.setLighting(format(value.get(4).toString()));
					room2info.setPropertyprice(Double.valueOf(value.get(5).toString()));
					room2info.setRoompriceunit(format(value.get(6).toString()));
					// 查询房间是否存在
					Roominfo condition = new Roominfo();
					condition.setRoomno(value.get(1).toString());
					condition.setFloorid(floor.getFloorid());
					condition.setBuildingid(buildingId);
					List<Roominfo> roominfoCount = roominfoMapper.select(condition);
					int count = roominfoCount.size();
					if (count > 0) {
						room.setRoomid(roominfoCount.get(0).getRoomid());
						//调用更新方法
						this.update(room, request);
						succeedCount++;
						log.warn("第" + (i + 1) + "行房间编号已存在");
						// throw new LogicalException("第"+ (i+1) +"行房间编号已存在");
						succedList.add(room2info);
						continue;
					}
					//调用插入方法
					this.insert(room, request);
					succedList.add(room2info);
					succeedCount++;
				}

			} catch (Exception e) {
				log.warn(e.getMessage());
				failedCount++;
				// throw new LogicalException("导入房间信息失败！");
			}
		}
		return succedList;
	}

	/**
	 * 去除空格和小数点
	 *
	 */
	private String format(String parameter) {
		String param = parameter.trim();
		Pattern pattern = Pattern.compile("-?[0-9]+.?[0-9]+");
		if (!StringUtils.isNullOrEmpty(param)) {
			Matcher isNum = pattern.matcher(param);
			if (isNum.matches() && param.indexOf(".") != -1) {
				param = param.substring(0, param.indexOf("."));
			}
		}
		return param;
	}

	/**
	 * 按照需求类型，统计房间面积 1,建筑类型：buildingtype 2,土地性质：landnature 3,经营类型：housingtype
	 */
	@Override
	public ArrayList<BasetreeinstanceVo> sumAreaByCondition(BasetreeinstanceVo sourceVo) throws LogicalException {

		try {
			// paas层和saas层字段对不上
			sourceVo.setCode(this.transform(sourceVo.getCode()));

			// VO添加保存Double：面积
			ArrayList<BasetreeinstanceVo> resultVOList = new ArrayList<>();
			// 查询paas层数据库roominfo统计面积
			if (sourceVo.getCodeList().size() > 0) {

				for (Basetreeinstance bt : sourceVo.getCodeList()) {

					BasetreeinstanceVo btVo = new BasetreeinstanceVo();
					BeanUtils.copyProperties(bt, btVo);

					RoomAreaSumVo raSumVo = new RoomAreaSumVo(sourceVo.getCode(), bt.getCode());
					raSumVo.setOwner(sourceVo.getOwner());
					raSumVo.setOwnerList(sourceVo.getOwnerList());

					Double sumArea = roominfoMapper.sumAreaByCondition(raSumVo);
					if (sumArea != null && sumArea > 0.0) {
						btVo.setSumArea(sumArea);
					} else {
						btVo.setSumArea(0.0);
					}
					resultVOList.add(btVo);
				}
			}
			if (resultVOList.size() > 0) {
				return resultVOList;
			} else {
				throw new LogicalException("查询失败");
			}

		} catch (Exception e) {
			log.info("接口调用失败：");
			throw new LogicalException("接口调用失败");
		}
	}

	//
	private String transform(String codeType) {
		// paas层"architecture"========== 建筑类型：buildingtype
		// paas层"land"================== 土地性质：landnature
		// paas层"management"============ 经营类型：housingtype
		HashMap<String, String> map = new HashMap<>();
		map.put("architecture", "buildingtype");
		map.put("land", "landnature");
		map.put("management", "housingtype");
		return map.get(codeType);
	}

	/**
	 * roominfoVoList :房间列表
	 * usable：房间可用/不可用状态
	 */
	@Override
	public void usableRoom(List<RoominfoVo> roominfoVoList, String usable)throws LogicalException {

		try {
			//房间可用/不可用状态
			roominfoMapper.usableRoom(roominfoVoList, usable);

			Set<String> floorIdSet = new HashSet<>();
			for (int i = 0, length = roominfoVoList.size(); i < length; i++) {
				//楼层去除重复数据
				floorIdSet.add(roominfoVoList.get(i).getFloorid());
			}
			for (String floorId : floorIdSet) {
				// 更新floorinfo可租赁面积
				roominfoMapper.updateRentableareaAndBuildingarea(floorId);
			}
			// 更新buildinginfo可租赁面积
			Floorinfo floorinfo = new  Floorinfo();
			floorinfo.setBuildingid(roominfoVoList.get(0).getBuildingid());
			floorinfoMapper.updateRentableareaAndBuildingarea(floorinfo);

		} catch (Exception e) {
			throw new LogicalException("房间停用/可用更新失败!");
		}
	}

	/**
	 *
	 * 查询委托房源
	 */
	@Override
	public List<RoominfoVo> selectAllTrustRoom(RoominfoVo roominfovo) throws LogicalException{
		try {
			// 查询联系人相关信息
			List<RoominfoVo> roominfovoList = roominfoMapper.selectTrustRoomInfo(roominfovo);
			// 声明基础库房间id list
			List<String> roomids = new ArrayList<String>();
			// 写入基础人员id
			for (int i = 0; i < roominfovoList.size(); i++) {
				roomids.add(roominfovoList.get(i).getRoomid());
			}
			// 根据基础人员id查询相关信息
			for (int i = 0; i < roominfovoList.size(); i++) {
				// get请求
				ApiResult result = this.restTemplate.getForObject(
						"http://BasicResources/room/selectRoomById?roomId=" + roominfovoList.get(i).getRoomid(),
						ApiResult.class);

				if (result.getCode() == 0) {
					// pass层返回数据
					JSONObject jsonobject = JSONObject.fromObject(result.getData());
					Room room = (Room) JSONObject.toBean(jsonobject, Room.class);
					BeanUtils.copyProperties(room, roominfovoList.get(i));
				}
			}

			return roominfovoList;
		} catch (Exception e) {
			log.warn(e.getMessage());
			throw new LogicalException("查询操作异常！");
		}
	}

	@Override
	public void roomSplit(RoomSplitInfoVo roomsplitinfoVo) throws LogicalException {
		RoomSplitInfo roomSplitInfo=new RoomSplitInfo();
		BeanUtils.copyProperties( roomsplitinfoVo,roomSplitInfo);
		//1 更改状态为失效(启用，停用，失效）
		StringBuffer oldRoomIds=new StringBuffer();
		StringBuffer newRoomIds=new StringBuffer();
		Roominfo roominfo =new Roominfo();

		for (RoominfoVo oldroomTempVo:roomsplitinfoVo.getOldroomlist()) {

			oldRoomIds.append(oldroomTempVo.getRoomid()).append(",");
			BeanUtils.copyProperties( oldroomTempVo,roominfo);
			roominfoMapper.updateByPrimaryKeySelective(roominfo);
		}
		for (RoominfoVo newroomTempVo:roomsplitinfoVo.getNewroomlist()) {

			newRoomIds.append(newroomTempVo.getRoomid()).append(",");
			BeanUtils.copyProperties(newroomTempVo,roominfo);
			roominfoMapper.insertSelective(roominfo);
		}
		//2 插入新增房间o
		roomSplitInfo.setOldroomids(oldRoomIds.toString());
		roomSplitInfo.setNewroomids(newRoomIds.toString());
		roomSplitInfoMapper.insertSelective(roomSplitInfo);
	}

	//class-end
}
