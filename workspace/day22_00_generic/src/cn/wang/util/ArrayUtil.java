package cn.wang.util;

public class ArrayUtil {
	public static <T> void exchange(T[] t, int index1, int index2) {
		T temp = t[index1];
		t[index1] = t[index2];
		t[index2] = temp;
	}

	public static <T> void reverse(T[] t) {
		int startIndex = 0;
		int endIndex = t.length - 1;
		while (startIndex < endIndex) {
			exchange(t, startIndex, endIndex);
			startIndex++;
			endIndex--;
		}
	}
}
