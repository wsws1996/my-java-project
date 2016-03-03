package cn.wang.spring.xml.transaction;

public class Transaction {
	public void beginTransaction() {
		System.out.println("begin Transaction");
	}
	public void commit() {
		System.out.println("commit");
	}
}
