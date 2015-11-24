package cn.wang.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	@Test
	public void test3() {
		ArrayList list=new ArrayList<String>();
		list.add(1);
		list.get(0);
	}
	public void test4() {
		List q= test5();
	}
	public List<Integer> test5() {
		return new ArrayList<Integer>();
	}
	@Test
	public void test2() {
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("aa", 1);
		map.put("bb", 2);
		
	Set<Map.Entry<String, Integer>> set= map.entrySet();
	for (Map.Entry<String, Integer> entry : set) {
		System.out.println(entry.getKey()+":"+entry.getValue());
	}
	}
	public static void test1() {
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		Integer i=list.get(0);
	}

}
