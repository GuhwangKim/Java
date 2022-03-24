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
			System.out.print("1.�߰�  2.����  3.��ü����  4.ã��  5.����\r\n" + "����(1~5) : ");
			num = sc.nextInt();

			switch (num) {
			case 1:
				System.out.print("�̸� : ");
				entity.setName(sc.next());
				System.out.print("��ȭ : ");
				entity.setPhone(sc.next());
				mc.insertMember(entity);

				break;

			case 2:

				System.out.print("������ ��� : ");
				name1 = sc.next();
				mc.deleteMember(name1);

				break;

			case 3:
				mc.getMemberList();
				break;

			case 4:
				System.out.print("ã�»�� : ");
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
