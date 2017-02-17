package com.tianyapeng.entity;

import java.util.List;

public class LoginResultInfo {

	private int code;
	private String msg;
	private String token;
	private UserInfo LoginInfo;
	
	public UserInfo getLoginInfo() {
		return LoginInfo;
	}

	public void setLoginInfo(UserInfo loginInfo) {
		LoginInfo = loginInfo;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "UserInfo [code=" + code + ", msg=" + msg + ", token=" + token + "]";
	}

}
