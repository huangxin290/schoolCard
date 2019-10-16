package org.StudentCard.service.impl;

import java.util.List;

import org.StudentCard.dao.IPersonDao;
import org.StudentCard.dao.impl.PersonDaoImpl;
import org.StudentCard.entity.Person;
import org.StudentCard.service.IPersonService;


public class PersonServiceImpl implements IPersonService{
	
	IPersonDao personDao=new PersonDaoImpl();
	
    public PersonServiceImpl() {
        super();
    }
	
    public boolean addPerson(Person person) {
    	if(!personDao.isExist(person.getNo())) {
    		personDao.addPerson(person);
    		return true;
    	}else {
    		System.out.println("此人已存在！");
    		return false;
		}
    }
    
    public boolean updatePerson(int no,Person person) {
    	if(personDao.isExist(no)) {
    		return personDao.updatePersonByNo(no, person);
    	}else {
    		System.out.println("此人不存在！");
    		return false;
		}
	}
    
    public boolean deletePerson(int no) {
    	if(personDao.isExist(no)) {
    		return personDao.deletePersonByNo(no);
    	}else {
    		System.out.println("此人不存在！");
    		return false;
		}
	}
    
    public Person queryPersonByNo(int sno) {
    	if(personDao.isExist(sno)) {
    		return personDao.queryPersonByNo(sno);
    	}else {
    		System.out.println("此人不存在！");
    		return null;
		}
	}
    
    public List<Person> queryAllStudent() {
    		return personDao.queryAllStudent();
	}

	@Override
	public int getTotalCount() {
		return personDao.getTotalCount();
	}

	/*
	@Override
	public List<Person> queryStudentsByPage(int currentPage, int pageSize) {
		return studentdao.queryPersonsByPage(currentPage, pageSize);
	}*/

	@Override
	public List<Person> queryAllPerson() {
		return personDao.queryAllStudent();
	}

	@Override
	public Person login(int no, String pwd) {
		if(personDao.isExist(no)) {
			return personDao.login(no, pwd);
		}else {
			return null;
		}
	}

}
