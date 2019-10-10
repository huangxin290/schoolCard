package org.StudentCard.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.StudentCard.dao.IRecordDao;
import org.StudentCard.entity.Person;
import org.StudentCard.entity.Record;
import org.StudentCard.util.DBUtil;

public class RecordDaoImpl implements IRecordDao{

	@Override
	public List<Record> queryRecordByNo(int no) {
		ResultSet rSet = null;
		Record record = null;
		List<Record> records=new ArrayList<Record>();
		try {

			String sql = "select * from record where no=?";

			Object[] params = { no };

			rSet = DBUtil.executeQuery(sql, params);

			while (rSet.next()) {
				int no1 =Integer.parseInt(rSet.getString("no")) ;
				String time=rSet.getString("time");//时间
				String place=rSet.getString("place");//地点
				Float cost=rSet.getFloat("cost");//花费
				Float balance = rSet.getFloat("balance");
				record = new Record(no1, time, place,cost , balance);
				records.add(record);
			}
			return records;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeAll(rSet, DBUtil.preparedStatement, DBUtil.connection);
		}
	}

	@Override
	public List<Record> queryAllRecord() {
		ResultSet rSet = null;
		Record record = null;
		List<Record> records=new ArrayList<Record>();
		try {
			String sql = "select * from record";

			rSet = DBUtil.executeQuery(sql,null);

			while (rSet.next()) {
				int no1 =Integer.parseInt(rSet.getString("no")) ;
				String time=rSet.getString("time");//时间
				String place=rSet.getString("place");//地点
				Float cost=rSet.getFloat("cost");//花费
				Float balance = rSet.getFloat("balance");
				record = new Record(no1, time, place,cost , balance);
				records.add(record);
			}
			return records;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeAll(rSet, DBUtil.preparedStatement, DBUtil.connection);
		}
	}

	@Override
	public List<Record> queryRecordByPlace(String place) {
		ResultSet rSet = null;
		Record record = null;
		List<Record> records=new ArrayList<Record>();
		try {
			String sql = "select * from record where place=?";

			Object[] params = { place };
			
			rSet = DBUtil.executeQuery(sql,params);

			while (rSet.next()) {
				int no1 =Integer.parseInt(rSet.getString("no")) ;
				String time=rSet.getString("time");//时间
				String place1=rSet.getString("place");//地点
				Float cost=rSet.getFloat("cost");//花费
				Float balance = rSet.getFloat("balance");
				record = new Record(no1, time, place1,cost , balance);
				records.add(record);
			}
			return records;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeAll(rSet, DBUtil.preparedStatement, DBUtil.connection);
		}
	}

	@Override
	public Boolean createRecord(Record record) {
		String sql = "insert into record(no,time,place,cost,balance) values(?,?,?,?,?)";
		Object[] params = { record.getNo(), record.getTime(), record.getPlace(), record.getCost(),record.getBalance() };
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public Boolean deleteRecords(int no) {
		String sql = "delete from record where id=?";
		Object[] params = { no };
		return DBUtil.executeUpdate(sql, params);
	}

}
