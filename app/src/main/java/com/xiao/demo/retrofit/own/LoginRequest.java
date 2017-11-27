package com.xiao.demo.retrofit.own;

/**
 * Created by xiao on 2017/9/2.
 */

public class LoginRequest {

	public String name;

	private int age;

	public LoginRequest() {
	}

	public LoginRequest(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


}
