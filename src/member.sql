create table member (
 idx number primary key, 
 name varchar2(15) not null,
 phone varchar2(15)
  );
  
  
create sequence mp_idx increment by 1 start with 1 nocycle nocache;


insert into member (idx, name, phone) values (mp_idx.nextval, '��ȣ��', '010-123-4567');
insert into member (idx, name, phone) values (mp_idx.nextval, 'ȫ�浿', '011-789-4561');

 select * from member; 
