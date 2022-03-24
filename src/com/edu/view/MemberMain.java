package com.edu.view;

import java.util.Scanner;

import com.edu.controller.MemberController;
import com.edu.entity.MemberEntity;

public class MemberMain {
	Scanner sc = new Scanner(System.in);
	int num;
	String name1;
	String phone1;
	MemberController mc = null;
	MemberEntity entity = null;

	public MemberMain() {
		mc = new MemberController();
		entity = new MemberEntity();
	}

	private void menu() {

		while (true) {
			System.out.print("1.추가  2.삭제  3.전체보기  4.찾기  5.종료\r\n" + "선택(1~5) : ");
			num = sc.nextInt();

			switch (num) {
			case 1:
				System.out.print("이름 : ");
				entity.setName(sc.next());
				System.out.print("전화 : ");
				entity.setPhone(sc.next());
				mc.insertMember(entity);

				break;

			case 2:

				System.out.print("삭제할 사람 : ");
				name1 = sc.next();
				mc.deleteMember(name1);

				break;

			case 3:
				mc.getMemberList();
				break;

			case 4:
				System.out.print("찾는사람 : ");
				name1 = sc.next();
				mc.getMember(name1);

				break;

			case 5:

				sc.close();
				System.exit(0);

			}

		}

	}

	public static void main(String[] args) {
		new MemberMain().menu();

	}

}
