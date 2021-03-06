package com.szyciov.carservice.util.sendservice.sendmethod.op.taxi;

import java.util.Date;
import java.util.List;

import com.szyciov.carservice.service.OrderApiService;
import com.szyciov.carservice.service.SendInfoService;
import com.szyciov.carservice.util.OrderRedisMessageFactory;
import com.szyciov.carservice.util.sendservice.sendmethod.AbstractSendMethod;
import com.szyciov.carservice.util.sendservice.sendrules.SendRuleHelper;
import com.szyciov.carservice.util.sendservice.sendrules.impl.op.car.OpCarSystemSingleSendRuleImp;
import com.szyciov.driver.entity.OrderInfoDetail;
import com.szyciov.driver.enums.OrderState;
import com.szyciov.entity.AbstractOrder;
import com.szyciov.entity.PlatformType;
import com.szyciov.entity.PubDriver;
import com.szyciov.enums.VehicleEnum;
import com.szyciov.op.entity.PeUser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 纯人工派单实现类
 * @ClassName OpCarSystemSingleSendMethodImp
 * @Description TODO(这里用一句话描述这个类的作用)
 * @date 2017年6月1日 下午6:22:36
 */
@Service("systemSingleSendMethodImp")
public class SystemSingleSendMethodImp extends AbstractSendMethod {

	private static final Logger logger = Logger.getLogger(SystemSingleSendMethodImp.class);
    @Autowired
	private SendInfoService sendInfoService;
    @Autowired
	private OrderApiService orderApiService;


	/**
	 * 抢单派单规则
	 */
	@Override
	public void send(SendRuleHelper rules, AbstractOrder order) {
		if(rules==null||order==null){
			logger.info("信息不足，无法派单");
			return ;
		}
		OpCarSystemSingleSendRuleImp temprules = (OpCarSystemSingleSendRuleImp)rules;
		String usetype = temprules.getUsetype();
		if(SendRuleHelper.USE_TYPE_USENOW.equalsIgnoreCase(usetype)){
			//即可用车派单
			send_UseNow(temprules,order);
		}else if(SendRuleHelper.USE_TYPE_RESERVE.equalsIgnoreCase(usetype)){
			//预约用车派单
			send_Reserve(temprules,order);
		}
	}

	@Override
	protected void send_Reserve(SendRuleHelper rule, AbstractOrder orderinfo) {
		if(isOrderTakedOrCancel(orderinfo.getOrderno())){
			return;
		}
		doNoMoreDriver(orderinfo);
	}

	@Override
	protected void send_Reserve_SOW(SendRuleHelper rule, AbstractOrder orderinfo, boolean sow) {
		if(isOrderTakedOrCancel(orderinfo.getOrderno())){
			return;
		}
		doNoMoreDriver(orderinfo);
	}

	@Override
	protected void send_UseNow(SendRuleHelper rule, AbstractOrder orderinfo) {
		if(isOrderTakedOrCancel(orderinfo.getOrderno())){
			return;
		}
		doNoMoreDriver(orderinfo);
	}

	/**
	 * 订单进入人工派单
	 * @param orderinfo
	 */
	@Override
	protected void go2Mantic(AbstractOrder orderinfo){
		sendInfoService.go2Mantic(orderinfo);
		sendRedisMessage(orderinfo,OrderState.MANTICSEND.state);
	}

	@Override
	protected void saveDriverMessage(AbstractOrder orderinfo, List<PubDriver> drivers, Date grabEndTime) {

	}

	@Override
	protected List<String> listDriverUnServiceTimes(String driverId) {
		return null;
	}

	@Override
	protected String getOrderStatus(String orderNo) {
		return sendInfoService.getOpTaxiOrderStatus(orderNo);
	}

	@Override
	protected AbstractOrder getLastReverceOrder(String driverId) {
		return null;
	}

	/**
	 * 添加弹窗消息，仅限运管端出租车
	 * @param orderinfo
	 * @param state
	 */
	private void sendRedisMessage(AbstractOrder orderinfo,String state){


		OrderInfoDetail order = new OrderInfoDetail();
		//订单号
		order.setOrderno(orderinfo.getOrderno());
		//车型(中文)
		order.setCartype(orderinfo.getSelectedmodelname());
		//数据状态
		order.setStatus(state);
		//城市ID
		order.setCityid(orderinfo.getOncity());
		//租赁公司ID
		order.setCompanyid(orderinfo.getCompanyid());
		//订单属性 默认个人订单
		order.setOrderprop(1);
		//发送系统 默认运管端
		order.setPaymethod("0");
		//用车时间
		order.setUsetime(orderinfo.getUsetime());
		//乘车人姓名
		order.setPassengers(orderinfo.getPassengers());
		//乘车人电话
		order.setPassengerphone(orderinfo.getPassengerphone());

		PeUser peUser = sendInfoService.getPeUser(orderinfo.getUserid());
		if(peUser!=null) {
			order.setUsername(peUser.getNickname());
			order.setUserphone(peUser.getAccount());
		}

		//车辆类型 出租车
		order.setOrderstyle(VehicleEnum.VEHICLE_TYPE_TAXI.code);
		OrderRedisMessageFactory rmf = new OrderRedisMessageFactory(OrderRedisMessageFactory.RedisMessageType.MANTICORDER, PlatformType.OPERATING);
		rmf.setOrder(order);
		rmf.createMessage(orderApiService);
		rmf.sendMessage();
	}

	/**
	 * 没有可用司机的处理逻辑
	 * @param orderinfo
	 */
	private void doNoMoreDriver(AbstractOrder orderinfo){
		//进入人工派单
		logger.info("纯人工模式，系统派单结束，进入人工派单！");
		orderinfo.setOrderstatus(OrderState.MANTICSEND.state);
		orderinfo.setPushnumber(0);
		go2Mantic(orderinfo);
	}
	
}
