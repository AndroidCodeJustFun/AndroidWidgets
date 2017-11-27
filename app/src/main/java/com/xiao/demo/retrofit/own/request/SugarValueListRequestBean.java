package com.xiao.demo.retrofit.own.request;

/**
 * 查询血糖记录列表
 */
public class SugarValueListRequestBean extends BaesRequest {
	private String startTime;
	private String endTime;
	private int page;
	/**
	 * 为0表示按日期查询，为1表示按分页查询
	 */
	private int type;

	public SugarValueListRequestBean() {
	}

	/**
	 * @param patientId
	 * @param startTime
	 * @param endTime
	 * @param page
	 * @param type      0 日期查询  ，1 分页查询
	 */
	public SugarValueListRequestBean(int patientId, String startTime,
	                                 String endTime, int page, int type) {
		setPatientId(patientId);
		setStartTime(startTime);
		setEndTime(endTime);
		setPage(page);
		setType(type);
		setActId(1);

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

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
