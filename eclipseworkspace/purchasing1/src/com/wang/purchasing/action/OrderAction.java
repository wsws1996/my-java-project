package com.wang.purchasing.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wang.purchasing.exception.SysException;
import com.wang.purchasing.po.PurBusOrder;
import com.wang.purchasing.po.PurBusOrderAudit;
import com.wang.purchasing.service.OrderService;
import com.wang.purchasing.util.UserUtil;

@Controller
@RequestMapping("/order")
public class OrderAction {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private OrderService orderService;

	// 创建采购单页面
	@RequestMapping("/addOrder")
	public String addOrder(Model model) throws Exception {

		return "order/addOrder";
	}

	// 创建采购单提交
	@RequestMapping("/addOrderSubmit")
	public String addOrderSubmit(HttpSession session, PurBusOrder purBusOrder)
			throws Exception {

		String userId = UserUtil.getUserFromSession(session).getUserid();

		orderService.saveOrder(userId, purBusOrder);

		return "redirect:orderList.action?type=1";
	}

	// 待提交采购单列表
	/*@RequestMapping("/createOrderList")
	public String createOrderList(HttpSession session, Model model)
			throws Exception {

		String userId = UserUtil.getUserFromSession(session).getUserid();
		List<PurBusOrder> list = orderService.findCreateOrderList();

		model.addAttribute("list", list);
		return "order/createOrderList";
	}*/

	// 提交采购单
	@RequestMapping("/submitOrder")
	public String submitOrder(HttpSession session, Model model, String orderId)
			throws Exception {
		String userId = UserUtil.getUserFromSession(session).getUserid();
		orderService.saveSubmitOrder(orderId);

		return "redirect:orderList.action?type=2";
	}
    
	//采购单处理
	@RequestMapping("/orderList")
	public String orderList(HttpSession session, Model model,String type)throws Exception{
		String userId = UserUtil.getUserFromSession(session).getUserid();
		List<PurBusOrder> list = null;
		if(type!=null && type.equals("1")){
			list = orderService.findCreateOrderList();
		}else if(type!=null && type.equals("2")){
			list = orderService.findFirstAuditList();
		}else if(type!=null && type.equals("3")){
			list = orderService.findSecondAuditList();
		}
		model.addAttribute("list", list);
		model.addAttribute("type", type);
		return "order/orderList";
	}
	
	// 部门经理审核列表
	/*@RequestMapping("/firstAuditList")
	public String firstAuditList(HttpSession session, Model model)
			throws Exception {
		String userId = UserUtil.getUserFromSession(session).getUserid();
		List<PurBusOrder> list = orderService.findFirstAuditList();
		model.addAttribute("list", list);
		return "order/firstAuditList";
	}*/

	// 部门经理审核页面
	@RequestMapping("/firstAudit")
	public String firstAudit(Model model, String orderId) throws Exception {
		model.addAttribute("orderId", orderId);
		return "order/firstAudit";
	}

	// 部门经理审核提交
	@RequestMapping("/firstAuditSubmit")
	public String firstAuditSubmit(HttpSession session, Model model,
			String orderId, PurBusOrderAudit purBusOrderAudit) throws Exception {
		String userId = UserUtil.getUserFromSession(session).getUserid();
		orderService.saveFirstAuditSubmit(userId, orderId, purBusOrderAudit);
		return "redirect:orderList.action?type=2";
	}

	// 总经理审核列表
	/*@RequestMapping("/secondAuditList")
	public String secondAuditList(HttpSession session, Model model)
			throws Exception {
		String userId = UserUtil.getUserFromSession(session).getUserid();
		List<PurBusOrder> list = orderService.findSecondAuditList();
		model.addAttribute("list", list);
		return "order/secondAuditList";
	}*/

	// 总经理审核页面
	@RequestMapping("/secondAudit")
	public String secondAudit(Model model, String orderId) throws Exception {
		model.addAttribute("orderId", orderId);
		return "order/secondAudit";
	}

	// 总经理审核提交
	@RequestMapping("/secondAuditSubmit")
	public String secondAuditSubmit(HttpSession session, Model model,
			String orderId, PurBusOrderAudit purBusOrderAudit) throws Exception {
		String userId = UserUtil.getUserFromSession(session).getUserid();
		orderService.saveSecondAuditSubmit(userId, orderId, purBusOrderAudit);
		return "redirect:orderList.action?type=3";
	}

}
