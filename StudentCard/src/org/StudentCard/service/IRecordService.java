package org.StudentCard.service;

import java.util.List;

import org.StudentCard.entity.Record;

public interface IRecordService {

	//ͨ��id���Ҵ������е����Ѽ�¼
		public List<Record> queryRecordByNo(int no);
		
		//��ѯȫ�����Ѽ�¼
		public List<Record> queryAllRecord();
		
		//ͨ���ص���������ڴ˵ص����Ѽ�¼
		public List<Record> queryRecordByPlace(String place);
		
		//������¼
		public Boolean createRecord(Record record) ;
		
		//ɾ��ĳ���˵����м�¼
		public Boolean deleteRecords(int no) ;
	
}
