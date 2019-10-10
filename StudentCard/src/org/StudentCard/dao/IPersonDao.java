package org.StudentCard.dao;

import java.util.List;

import org.StudentCard.entity.Person;

public interface IPersonDao {
	//通过id查找人
	public Person queryPersonByNo(int no) ;
	
	//查询全部学生
	public List<Person> queryAllStudent();
	
	//查询全部人员
	public List<Person> queryAllPerson();
	
	//查看指定id是否存在
	public boolean isExist(int sno);
	
	//添加人
	public boolean addPerson(Person person) ;
	
	//删除人通过id
	public boolean deletePersonByNo(int no) ;
	
	//更新信息
	public boolean updatePersonByNo(int no,Person person);
		
	//登录操作
	public Person login(int no, String pwd) ;
	
	
	
	//
	public int getTotalCount();
	
	
//	public List<Person> queryPersonsByPage(int currentPage,int pages) ;
}
