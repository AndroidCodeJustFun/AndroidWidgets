package com.xiao.demo.retrofit.own.response;

/**
 * 返回体基类
 * 
 * @author rh-max
 */
public class BaseRespone
{
	/**
	 * 错误信息
	 */
	private String errMsg;

	/**
	 * 返回码
	 */
	private int code;

	public String getErrMsg()
	{
		return errMsg;
	}

	public void setErrMsg(String errMsg)
	{
		this.errMsg = errMsg;
	}

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

}
