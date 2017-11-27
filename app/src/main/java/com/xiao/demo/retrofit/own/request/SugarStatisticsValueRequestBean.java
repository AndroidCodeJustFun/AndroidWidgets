package com.xiao.demo.retrofit.own.request;

/**
 * 查询血糖统计指标
 * 
 * @author 鲨鱼
 * 
 */
public class SugarStatisticsValueRequestBean extends BaesRequest {
	private String startTime;
	private String endTime;

	public SugarStatisticsValueRequestBean() {
		super();
	}

	public SugarStatisticsValueRequestBean(int patientId, String startTime,
			String endTime) {
		setPatientId(patientId);
		setStartTime(startTime);
		setEndTime(endTime);
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
