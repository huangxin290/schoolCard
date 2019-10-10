package org.StudentCard.service.impl;

import java.util.List;

import org.StudentCard.dao.IRecordDao;
import org.StudentCard.dao.impl.RecordDaoImpl;
import org.StudentCard.entity.Record;
import org.StudentCard.service.IRecordService;

public class RecordServiceImpl implements IRecordService{

	IRecordDao recordDao=new RecordDaoImpl();
	
	@Override
	public List<Record> queryRecordByNo(int no) {
		return recordDao.queryRecordByNo(no);
	}

	@Override
	public List<Record> queryAllRecord() {
		return recordDao.queryAllRecord();
	}

	@Override
	public List<Record> queryRecordByPlace(String place) {
		return recordDao.queryRecordByPlace(place);
	}

	@Override
	public Boolean createRecord(Record record) {
		return recordDao.createRecord(record);
	}

	@Override
	public Boolean deleteRecords(int no) {
		return recordDao.deleteRecords(no);
	}

}
