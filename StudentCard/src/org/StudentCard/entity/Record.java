package org.StudentCard.entity;

public class Record {

	private int no;//消费者的no
	private String time;//时间
	private String place;//地点
	private Float cost;//花费
	private Float balance;//余额
	
	public Record() {
		super();
	}

	public Record(int no, String time, String place, Float cost, Float balance) {
		super();
		this.no = no;
		this.time = time;
		this.place = place;
		this.cost = cost;
		this.balance = balance;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Record [no=" + no + ", time=" + time + ", place=" + place + ", cost=" + cost + ", balance=" + balance
				+ "]";
	}
	
	
	
	
}
