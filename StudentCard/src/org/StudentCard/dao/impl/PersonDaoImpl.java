package org.StudentCard.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.StudentCard.dao.IPersonDao;
import org.StudentCard.entity.Person;
import org.StudentCard.util.DBUtil;

public class PersonDaoImpl implements IPersonDao {
	// 通过id查找人
	public Person queryPersonByNo(int no) {
		ResultSet rSet = null;
		Person person = null;
		try {

			String sql = "select * from person where no=?";

			Object[] params = { no };

			rSet = DBUtil.executeQuery(sql, params);

			if (rSet.next()) {
				String name = rSet.getString("name");
				String pwd = rSet.getString("pwd");
				Float balance = rSet.getFloat("balance");
				String identity = rSet.getString("identity");
				person = new Person(no, name, pwd, balance, identity);
			}
			return person;
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

	// 查询全部学生
	public List<Person> queryAllStudent() {
		List<Person> students = new ArrayList<>();
		Person student = null;
		ResultSet rSet = null;
		try {
			String sql = "select * from person";
			rSet = DBUtil.executeQuery(sql, null);

			while (rSet.next()) {
				int no = rSet.getInt("no");
				String name = rSet.getString("name");
				String pwd = rSet.getString("pwd");
				Float balance = rSet.getFloat("balance");
				String identity = rSet.getString("identity");
				if ("student".equals(identity)) {
					student = new Person(no, name, pwd, balance, identity);
					students.add(student);
				}
			}
			return students;
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

	// 查询全部人员
	public List<Person> queryAllPerson() {
		List<Person> students = new ArrayList<>();
		Person student = null;
		ResultSet rSet = null;
		try {
			String sql = "select * from person";
			rSet = DBUtil.executeQuery(sql, null);

			while (rSet.next()) {
				int no = rSet.getInt("no");
				String name = rSet.getString("name");
				String pwd = rSet.getString("pwd");
				Float balance = rSet.getFloat("balance");
				String identity = rSet.getString("identity");
				student = new Person(no, name, pwd, balance, identity);
				students.add(student);
			}
			return students;
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

	// 查看指定id是否存在
	public boolean isExist(int no) {
		return queryPersonByNo(no) == null ? false : true;
	}

	//添加人
	public boolean addPerson(Person person) {
		String sql = "insert into person(no,name,pwd,balance,identity) values(?,?,?,?,?)";
		Object[] params = { person.getNo(), person.getName(), person.getPwd(), person.getBalance(),person.getIdentity() };
		return DBUtil.executeUpdate(sql, params);
	}

	//删除人通过id
	public boolean deletePersonByNo(int no) {
		String sql = "delete from person where no=?";
		Object[] params = { no };
		return DBUtil.executeUpdate(sql, params);
	}

	//更新信息
	public boolean updatePersonByNo(int no, Person person) {
		String sql = "update person set name=?,pwd=?,balance=?,identity=?  where no=?";
		Object[] params = {person.getName(), person.getPwd(), person.getBalance(),person.getIdentity(), no };
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public int getTotalCount() {// 查询总数据量
		String sql = "select count(1) from person";
		return DBUtil.getTotalCount(sql);
	}

	@Override
	public Person login(int no, String pwd) {

		ResultSet rSet = null;
		Person person = null;
		try {

			String sql = "select * from person where no=? and pwd=?";

			Object[] params = { no ,pwd};

			rSet = DBUtil.executeQuery(sql, params);

			if (rSet.next()) {
				String name = rSet.getString("name");
				String pwd1 = rSet.getString("pwd");
				Float balance = rSet.getFloat("balance");
				String identity = rSet.getString("identity");
				person = new Person(no, name, pwd1, balance, identity);
			}else {//登录失败，用户名或密码错误
				return null;
			}
			return person;
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

	/*
	@Override
	public List<Person> queryPersonsByPage(int currentPage, int pageSize) {
		List<Person> students = new ArrayList<>();
		Person student = null;
		ResultSet rSet = null;
		try {
			String sql = "select * from student limit ?,?";
			Object[] params = { currentPage * pageSize - pageSize, pageSize };
			rSet = DBUtil.executeQuery(sql, params);
			if (rSet == null) {
				System.out.println("rset为空");
			}
			while (rSet.next()) {
				int noString = rSet.getInt("stuno");
				String name = rSet.getString("stuname");
				int age = rSet.getInt("stuage");
				String pwd = rSet.getString("stupwd");
				student = new Person(noString, name, age, pwd);
				students.add(student);
			}
			return students;
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
*/
}
