package com.edu.view;

import java.util.ArrayList;

import com.edu.entity.MemberEntity;


public class MemberView {
	public void getMemberList(ArrayList<MemberEntity> list) {
		for(MemberEntity entity:list) {
			System.out.println(entity.getName()+"\t"+entity.getPhone());
		}
	}
	
	
	public void getMember(MemberEntity entity) {
		System.out.println(entity.getName()+"\t"+entity.getPhone());
	}

	public void insertMember(int n) {
		if(n>0) {
			System.out.println("�߰��Ǿ����ϴ�");
		}
		
	}
	
	public void deleteMember(int n) {
		if(n>0) {
			System.out.println("�����Ǿ����ϴ�");
		}
	}
}




