package org.StudentCard.servlet;

import org.StudentCard.service.IPersonService;
import org.StudentCard.service.IRecordService;
import org.StudentCard.service.impl.PersonServiceImpl;
import org.StudentCard.service.impl.RecordServiceImpl;

public interface BasicServlet {
	
	IPersonService personService=new PersonServiceImpl();
	
	IRecordService recordService=new RecordServiceImpl();
	
}
