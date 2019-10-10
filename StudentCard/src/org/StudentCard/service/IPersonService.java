package org.StudentCard.service;

import java.util.List;

import org.StudentCard.entity.Person;

public interface IPersonService {
	
    public boolean addPerson(Person person) ;
    
    public boolean updatePerson(int no,Person person) ;
    
    public boolean deletePerson(int no) ;
    
    public Person queryPersonByNo(int no) ;
    
    public Person login(int no,String pwd);
    
    public List<Person> queryAllStudent() ;
    
    public List<Person> queryAllPerson() ;
    
    public int getTotalCount();
	
//	public List<Person> queryStudentsByPage(int currentPage,int pageSize) ;
}
