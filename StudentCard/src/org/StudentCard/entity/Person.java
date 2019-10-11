package org.StudentCard.entity;

public class Person {

	private int no;//id��Ψһ��ʶ��Ҳ���˻���
	private String name;//����
	private String pwd;//�˻�������
	private Float balance;//���
	private String identity;//student����ѧ����administrator���ǹ���Ա
	private boolean isLost=false;//��ʧ״̬��true���ǹ�ʧ��
	
	public Person() {
		
	}
	
	public Person(int no, String name, String pwd, Float balance, String identity,boolean isLost) {
		super();
		this.no = no;
		this.name = name;
		this.pwd = pwd;
		this.balance = balance;
		this.identity = identity;
		this.isLost=isLost;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	@Override
	public String toString() {
		return "Person [no=" + no + ", name=" + name + ", pwd=" + pwd + ", balance=" + balance + ", identity="
				+ identity + ", isLost=" + isLost +"]";
	}

	public boolean getisLost() {
		return isLost;
	}

	public void setLost(boolean isLost) {
		this.isLost = isLost;
	}
	
	
	
}
