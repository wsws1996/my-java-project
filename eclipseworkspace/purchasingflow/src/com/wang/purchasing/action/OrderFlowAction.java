package com.wang.purchasing.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wang.purchasing.service.OrderService;
import com.wang.purchasing.util.UserUtil;
import com.wang.purchasing.vo.ActiveUser;
import com.wang.purchasing.vo.OrderCustom;
import com.wang.purchasing.vo.OrderVo;

@Controller
@RequestMapping("/orderflow")
public class OrderFlowAction {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/addOrder")
	public String addOrder(Model model) throws Exception {
		return "order/addOrder";
	}

	@RequestMapping("/addOrderSave")
	public String addOrderSave(HttpSession session, OrderVo orderVo) throws Exception {
		ActiveUser activeUser = UserUtil.getUserFromSession(session);
		String userId = activeUser.getUserid();

		orderService.saveOrder(userId, orderVo.getOrderCustom());
		return "redirect:orderTaskList.action";
	}

	@RequestMapping("/orderTaskList")
	public String orderTaskList(HttpSession session, Model model) throws Exception {
		ActiveUser activeUser = UserUtil.getUserFromSession(session);
		String userId = activeUser.getUserid();
		List<OrderCustom> list = orderService.findOrderTaskList(userId);
		model.addAttribute("list", list);
		return "order/orderTaskList";
	}

	@RequestMapping("/submitOrder")
	public String submitOrder(HttpSession session, String taskId) throws Exception {
		ActiveUser activeUser = UserUtil.getUserFromSession(session);
		String userId = activeUser.getUserid();
		orderService.saveOrderSubmitStatus(userId, taskId);
		return "redirect:orderTaskList.action";
	}

	@RequestMapping("/orderAudit")
	public String orderAudit(Model model, String taskId, String orderId, String auditType) throws Exception {
		model.addAttribute("taskId", taskId);
		model.addAttribute("orderId", orderId);
		model.addAttribute("auditType", auditType);
		return "order/orderAudit";
	}

	@RequestMapping("/submitOrderAudit")
	public String submitOrderAudit(HttpSession session, String taskId, String orderId, String auditType,
			OrderVo orderVo) throws Exception {
		ActiveUser activeUser = UserUtil.getUserFromSession(session);
		String userId = activeUser.getUserid();

		orderService.saveOrderAuditStatus(taskId, userId, orderId, auditType, orderVo.getOrderAuditCustom());

		return "redirect:orderTaskList.action";

	}

	@RequestMapping("/queryActivityOrder")
	public String queryActivityOrder(Model model) throws Exception {
		List<OrderCustom> list = orderService.findActivityOrderList();
		model.addAttribute("list", list);
		return "order/queryActivityOrder";
	}

	@RequestMapping("/queryHistoryOrder")
	public String queryHistoryOrder(Model model) throws Exception {
		List<OrderCustom> list = orderService.findFinishedOrderList();
		model.addAttribute("list", list);
		return "order/queryHistoryOrder";
	}

	@RequestMapping("/queryOrderTaskByPid")
	public String queryOrderTaskByPid(Model model, String processInstanceId) throws Exception {
		List<OrderCustom> list = orderService.findOrderTaskListByPid(processInstanceId);
		model.addAttribute("list", list);
		return "order/queryOrderTaskByPid";
	}

	@RequestMapping("/settlement")
	public String settlement(HttpSession session, String taskId) throws Exception {
		ActiveUser activeUser = UserUtil.getUserFromSession(session);
		String userId = activeUser.getUserid();
		orderService.saveSettlement(taskId, userId);
		return "redirect:orderTaskList.action";
	}

	@RequestMapping("/storage")
	public String storage(HttpSession session, String taskId) throws Exception {
		ActiveUser activeUser = UserUtil.getUserFromSession(session);
		String userId = activeUser.getUserid();
		orderService.saveStorage(taskId, userId);
		return "redirect:orderTaskList.action";
	}

	@RequestMapping("/orderGroupTaskList")
	public String orderGroupTaskList(HttpSession session, Model model) throws Exception {
		ActiveUser activeUser = UserUtil.getUserFromSession(session);
		String userId = activeUser.getUserid();
		List<OrderCustom> list = orderService.findOrderGroupTaskList(userId);
		model.addAttribute("list", list);
		return "order/orderGroupTaskList";
	}
	@RequestMapping("/claimTask")
	public String claimTask(HttpSession session,String taskId) throws Exception {
		ActiveUser activeUser = UserUtil.getUserFromSession(session);
		String userId = activeUser.getUserid();
		orderService.saveClaimTask(taskId, userId);
		return "redirect:orderGroupTaskList.action";		
	}
}
