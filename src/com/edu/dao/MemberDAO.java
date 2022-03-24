package com.edu.dao;

import static common.MyConnectionPool.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.entity.MemberEntity;

public class MemberDAO {

	public ArrayList<MemberEntity> getMemberList() { // 전체보기
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		MemberEntity entity = null;
		ArrayList<MemberEntity> list = null;

		String sql = "select * from member order by 1";

		list = new ArrayList<MemberEntity>();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				entity = new MemberEntity();
				entity.setIdx(rs.getInt("idx"));
				entity.setName(rs.getString("name"));
				entity.setPhone(rs.getString("phone"));
				list.add(entity);
			}

		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
			close(pstmt);
			close(rs);
		}

		return list;

	}

	public MemberEntity getMember(String name) { // 검색
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		MemberEntity entity = null;

		String sql = "select * from member where name=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				entity = new MemberEntity();
				entity.setName(rs.getString("name"));
				entity.setPhone(rs.getString("phone"));
			}

		} catch (SQLException e) {
			rollback(conn);
		} finally {
			close(conn);
			close(pstmt);
			close(rs);
		}

		return entity;

	}

	public int insertMember(MemberEntity ob) { // 추가
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		int n = 0;
		
		String sql="insert into member (idx, name, phone) values(mp_idx.nextval,?, ?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ob.getName());
			pstmt.setString(2, ob.getPhone());
			n=pstmt.executeUpdate();
						
		} catch (SQLException e) {
			rollback(conn);
		} finally {
			close(conn);
			close(pstmt);
		}
		
		return n;
		
		
	}
	
	public int deleteMember(String name) { // 삭제 
		Connection conn=getConnection();
		PreparedStatement pstmt=null;
		int n = 0;
		
		String sql="delete from member where name=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			n=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			rollback(conn);
		} finally {
			close(conn);
			close(pstmt);
		}
		
		return n;
		
	}

}
