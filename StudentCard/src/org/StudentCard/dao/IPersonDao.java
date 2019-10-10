package org.StudentCard.dao;

import java.util.List;

import org.StudentCard.entity.Person;

public interface IPersonDao {
	//ͨ��id������
	public Person queryPersonByNo(int no) ;
	
	//��ѯȫ��ѧ��
	public List<Person> queryAllStudent();
	
	//��ѯȫ����Ա
	public List<Person> queryAllPerson();
	
	//�鿴ָ��id�Ƿ����
	public boolean isExist(int sno);
	
	//�����
	public boolean addPerson(Person person) ;
	
	//ɾ����ͨ��id
	public boolean deletePersonByNo(int no) ;
	
	//������Ϣ
	public boolean updatePersonByNo(int no,Person person);
		
	//��¼����
	public Person login(int no, String pwd) ;
	
	
	
	//
	public int getTotalCount();
	
	
//	public List<Person> queryPersonsByPage(int currentPage,int pages) ;
}
