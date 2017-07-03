package com.szyciov.entity;

/**
 * 返回码
 * @ClassName Retcode 
 * @author Efy Shu
 * @Description 返回码枚举类 
 * @date 2016年8月23日 下午7:45:33
 */
public enum Retcode {
	/**************************************************通用状态*************************************************/
	/**
	 * 请求成功
	 */
	OK(0,"请求成功,无异常"),
	/**
	 * 请求失败
	 */
	FAILED(-1,"请求失败,无异常"),
	/**
	 * 请求异常
	 */
	EXCEPTION(-2,"服务器异常"),
	
	/**************************************************服务前状态*************************************************/
	/**
	 * 无效token
	 */
	INVALIDTOKEN(1000,"无效token"),
	/**
	 * 本地版本过低
	 */
	LOWVERSION(1001,"本地版本过低"),
	/**
	 * 用户已在其他地方登录
	 */
	ANOTHERLOGIN(1002,"您的账号在另一个终端登录，如果不是您本人操作，请立即联系客服。"),
	/**
	 * 短信验证码获取过频
	 */
	SENDSMSTOOOFTEN(1003,"短信验证码获取过频"),
	/**
	 * 短信验证码不正确
	 */
	SMSCODEINVALID(1004,"验证码错误！"),
	/**
	 * 短信验证码已过期
	 */
	SMSCODEOUTTIME(1005,"验证码过期！"),
	/**
	 * 用户不存在
	 */
	USERNOTEXIST(1006,"您的账号不存在！请与系统管理员联系。"),
	/**
	 * 用户已停止服务
	 */
	USERNOTSUPPORT(1007,"账号禁用！请联系管理员"),
	/**
	 * 用户已注销
	 */
	USERSIGNOFF(1008,"账号注销！请联系管理员"),
	/**
	 * 用户已存在
	 */
	USERALREADYEXIST(1009,"用户已存在"),
	/**
	 * 密码错误
	 */
	PASSWORDWRONG(1010,"密码错误 ! 请重新输入。"),
	/**
	 * 该用户不是机构用户
	 */
	NOTORGANIZEDUSER(1011,"该用户不是机构用户"),
	/**
	 * 原密码不正确
	 */
	OLDPASSWRONG(1012,"原密码不正确"),
	/**
	 * 司机未绑定车辆
	 */
	DRIVERNOCAR(1013,"您当前未绑定任何服务车辆，绑定车辆后方可提供服务，请与管理员联系。"),
	/**
	 * 司机正在上班
	 */
	DRIVERATWORK(1014,"您处于上班中，请下班后再退出登录。"),
	/**
	 * 司机被解绑
	 */
	DRIVERUNBIND(1015,"您已被解绑，请联系客服。"),
	/**
	 * 当前司机不是交接班司机,不允许发起交接班
	 */
	DRIVERNOTSHIFTSTATUS(1016,"当前司机不是交接班司机,不允许发起交接班"),
	/**
	 * 交班失败
	 */
	SHIFTOFFFAILED(1017,"交班失败"),
	/**
	 * 持卡人姓名不正确
	 */
	CARDPERSONINVALID(1018,"持卡人姓名不正确"),

    /**
     * 未排班次，不可上班
     */
    DRIVER_AT_NO_WORK(1019,"未排班次，不可上班"),
	
	/**************************************************服务状态*************************************************/
	/**
	 * 此城市没有服务
	 */
	NOSERVICESINCITY(2000,"当前城市没有开通服务,请静候。"),
	/**
	 * 没有权限
	 */
	NOPERMISSION(2001,"您没有用车权限，请和管理员联系。"),
	/**
	 * 订单已被抢
	 */
	ORDERISGONE(2002,"订单已被抢"),
	/**
	 * 订单已取消
	 */
	ORDERISCANCEL(2003,"订单已取消"),
	/**
	 * 存在未完成订单
	 */
	ORDERNOTDONE(2004,"您有服务中订单,请完成后再进行操作。"),
	
	/**
	 * 存在未支付订单
	 */
	ORDERNOTPAY(2005,"有未支付订单，需要先完成支付才能继续下单"),
	/**
	 * 订单不存在
	 */
	ORDERNOTEXIT(2006,"订单不存在"),
	/**
	 * 订单状态不正确
	 */
	INVALIDORDERSTATUS(2007,"订单状态不正确"),
	/**
	 * 未完成订单已超限
	 */
	ORDEROUTOFLIMIT(2008,"未完成订单已超限"),
	/**
	 * 余额不足
	 */
	NOTENOUGHBALANCE(2009,"余额不足"),
	/**
	 * 当前城市没有服务车型
	 */
	NOCARTYPEINCITY(2010,"当前租赁公司在当前城市没有服务车型！"),
	/**
	 * 当前城市已有交接班规则
	 */
	SAMECITY(2011,"当前城市已有交接班规则，不可重复添加"),
	/**
	 * 商户没有开通支付渠道
	 */
	NOPAYCHANNEL(2012,"商户没有开通支付渠道"),
	/**
	 * 重复支付
	 */
	DUPLICATEPAY(2013,"重复支付"),
	/**
	 * 无对班司机
	 */
	NOWORKMATE(2014,"您当前没有对班司机,请收工"),
	/**
	 * 存在未出行的即刻单
	 */
	HASUSENOWORDER(2015,"存在未出行的即刻单"),
	/**
	 * 无交接班规则
	 */
	NOSHIFTRULE(2016,"您登记的城市无交接班规则，请联系客服"),
	/**
	 * 存在未结算订单
	 */
	DRIVERNOPAYORDER(2017,"存在未结算订单"),
	/**
	 * 未付结订单超限
	 */
	NOPAYORDEROUTOFLIMIT(2018,"未付结订单超限"),
	/**
	 * 用车时间早于本订单的未服务订单
	 */
	HASEARLIERORDER(2019,"您有用车时间早于本订单的未服务订单，请完成或联系客服取消后再开始本订单"),
	
	/**
	 * 用车时间比当前时间早
	 */
	BEFORENOWTIME(2020,"用车时间失效，请重新选择");

	
	
	public int code ;
	public String msg;
	Retcode(int code,String msg){
		this.code = code;
		this.msg = msg;
	}
}
