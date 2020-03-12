package com.bjsxt.car.pojo;

import java.util.Date;

/**
 * Loginlogs entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Loginlogs implements java.io.Serializable {

	// Fields
	private int start;
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	private int end;
	private Long loginlogid;
	private String loginname;
	private String loginip;
	private Date logintime;

	// Constructors

	/** default constructor */
	public Loginlogs() {
	}

	/** minimal constructor */
	public Loginlogs(Long loginlogid) {
		this.loginlogid = loginlogid;
	}

	/** full constructor */
	public Loginlogs(Long loginlogid, String loginname, String loginip,
			Date logintime) {
		this.loginlogid = loginlogid;
		this.loginname = loginname;
		this.loginip = loginip;
		this.logintime = logintime;
	}

	// Property accessors

	public Long getLoginlogid() {
		return this.loginlogid;
	}

	public void setLoginlogid(Long loginlogid) {
		this.loginlogid = loginlogid;
	}

	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getLoginip() {
		return this.loginip;
	}

	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

	public Date getLogintime() {
		return this.logintime;
	}

	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}

}