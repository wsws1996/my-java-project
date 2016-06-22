package com.wang.ws.pojo;

import java.util.Date;

/**
 * 天气信息模型
 * 
 * @author wang
 *
 */
public class WeatherModel {
	private String detail;

	private Date date;

	private int temperature_max;

	private int temperature_min;

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTemperature_max() {
		return temperature_max;
	}

	public void setTemperature_max(int temperature_max) {
		this.temperature_max = temperature_max;
	}

	public int getTemperature_min() {
		return temperature_min;
	}

	public void setTemperature_min(int temperature_min) {
		this.temperature_min = temperature_min;
	}

}
