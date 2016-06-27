package com.wang.ssm.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.ssm.po.Cjb;
import com.wang.ssm.po.Kcb;
import com.wang.ssm.po.Score;
import com.wang.ssm.service.ScoreInfoService;

@Controller
public class ScoreInfoAction {
	@Autowired
	private ScoreInfoService scoreInfoService;

	@RequestMapping("queryScoreUI")
	public String queryScoreUI() throws Exception {
		return "ScoreInfo";
	}

	@RequestMapping("queryScore")
	public @ResponseBody List<Score> queryScore(String xh) throws Exception {
		return scoreInfoService.findScoreInfoByXh(xh);
	}

	@RequestMapping("queryKcb")
	public @ResponseBody List<Kcb> queryKcb() throws Exception {
		return scoreInfoService.findCourse();
	}

	@RequestMapping("editScoreInfo")
	public void editScoreInfo(Cjb cjb) throws Exception {
		scoreInfoService.updateScoreInfo(cjb);
	}

	@RequestMapping("addScoreInfo")
	public void addScoreInfo(Cjb cjb) throws Exception {
		scoreInfoService.insertScoreInfo(cjb);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
