package com.edu.entity;

public class MemberEntity {
	private int idx;
	private String name;
	private String phone;

	public MemberEntity() {
	}

	public MemberEntity(int idx, String name, String phone) {
		super();
		this.idx = idx;
		this.name = name;
		this.phone = phone;
	}

	public int getIdx() {
		return idx;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
