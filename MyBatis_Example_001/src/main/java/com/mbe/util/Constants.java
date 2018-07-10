package com.mbe.util;

public class Constants {
	//单价类型（1：平方米/天，2：平方米/月，3：天，4：月)
	public  final static String RMBMDAY="0001";
	public  final static String RMBMMONTH="0002";
	public  final static String RMBDAY="0003";
	public  final static String RMBMONTH="0004";
	
	//提前付款类型(1：自然，2：指定日期)
	public  final static String NATURE="0001";
	public  final static String APPOINT="0002";
	
	//计算精度(1：每步保留2位，2：最终保留2位，3：最终保留1位，4：最终保留整数（四舍五入），5：最终保留整数（去尾），6：最终保留整数（进位）)
	public  final static String FINAL="0002";
	public  final static String STEP="0001";
	public  final static String FINALONE="0003";
	public  final static String FINALROUNDINTEGER="0004";
	public  final static String FINALINTEGE="0005";
	public  final static String FINALINTEGEUP="0006";
	
	//押金类型(1:元，2：月)
	public  final static String RMB="0001";
	public  final static String MONTH="0002";
	
	//优惠类型(1:租金物业费全免，2：单独免租金，3：单独免物业费)
	public  final static String FREE="0001";
	public  final static String RENTALFREE="0002";
	public  final static String PROPERTYFREE="0003";
	
	//房间状态(0:未出租, 1:已出租)
	public  final static String NO_RENT_TYPE="0";
	public  final static String RENT_TYPE="1";

	//房屋发布状态
	public  final static String HOUSE_INFO_NEW="新建";
	public  final static String HOUSE_INFO_ISSUED="已发布";
	public  final static String HOUSE_INFO_CANCELLED="已撤销";
}
