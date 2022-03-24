package com.edu.controller;

import java.util.ArrayList;

import com.edu.dao.MemberDAO;
import com.edu.entity.MemberEntity;
import com.edu.view.MemberView;

public class MemberController {


	public MemberController() {

	}

	public void getMemberList() { // ��ü����
		MemberDAO md = new MemberDAO();
		MemberView view = new MemberView();
		
		ArrayList<MemberEntity> list= md.getMemberList();
		view.getMemberList(list);
		
	}
	
	public void getMember(String name) { // �˻�
		MemberDAO md = new MemberDAO();
		MemberView view = new MemberView();
		
		MemberEntity entity= md.getMember(name);
		view.getMember(entity);
	}
	
	public void insertMember(MemberEntity ob) { // �߰�
		MemberDAO md = new MemberDAO();
		MemberView view = new MemberView();
		
		int n=md.insertMember(ob);
		view.insertMember(n);
	}
	
	public void deleteMember(String name) { // ���� 
		MemberDAO md = new MemberDAO();
		MemberView view = new MemberView();
		
		int n=md.deleteMember(name);
		view.deleteMember(n);
		
	}

}
