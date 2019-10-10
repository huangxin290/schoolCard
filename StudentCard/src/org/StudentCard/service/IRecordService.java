package org.StudentCard.service;

import java.util.List;

import org.StudentCard.entity.Record;

public interface IRecordService {

	//通过id查找此人所有的消费记录
		public List<Record> queryRecordByNo(int no);
		
		//查询全部消费记录
		public List<Record> queryAllRecord();
		
		//通过地点查找所有在此地的消费记录
		public List<Record> queryRecordByPlace(String place);
		
		//创建记录
		public Boolean createRecord(Record record) ;
		
		//删除某个人的所有记录
		public Boolean deleteRecords(int no) ;
	
}
