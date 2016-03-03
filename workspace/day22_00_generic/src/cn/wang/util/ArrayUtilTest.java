package cn.wang.util;

import java.util.Arrays;

import org.junit.Test;

public class ArrayUtilTest {
	@Test
	public void testExchange() {
		Integer ii[] = { 1, 2, 3, 4, 5 };
		ArrayUtil.exchange(ii, 1, 4);
		System.out.println(Arrays.asList(ii));
	}

	@Test
	public void testReverse() {
		Integer ii[] = { 1, 2, 3, 4, 5, 6 };
		ArrayUtil.reverse(ii);
		System.out.println(Arrays.asList(ii));
	}
}
