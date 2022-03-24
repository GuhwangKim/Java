package com.edu.controller;

import java.util.ArrayList;

import com.edu.dao.MemberDAO;
import com.edu.entity.MemberEntity;
import com.edu.view.MemberView;

public class MemberController {


	public MemberController() {

	}

	public void getMemberList() { // 전체보기
		MemberDAO md = new MemberDAO();
		MemberView view = new MemberView();
		
		ArrayList<MemberEntity> list= md.getMemberList();
		view.getMemberList(list);
		
	}
	
	public void getMember(String name) { // 검색
		MemberDAO md = new MemberDAO();
		MemberView view = new MemberView();
		
		MemberEntity entity= md.getMember(name);
		view.getMember(entity);
	}
	
	public void insertMember(MemberEntity ob) { // 추가
		MemberDAO md = new MemberDAO();
		MemberView view = new MemberView();
		
		int n=md.insertMember(ob);
		view.insertMember(n);
	}
	
	public void deleteMember(String name) { // 삭제 
		MemberDAO md = new MemberDAO();
		MemberView view = new MemberView();
		
		int n=md.deleteMember(name);
		view.deleteMember(n);
		
	}

}
