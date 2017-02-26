public class Solution {
	public static int hammingDistance(int x, int y) {
		String binaryX = Integer.toBinaryString(x);
		String binaryY = Integer.toBinaryString(y);
		int sub=binaryX.length()-binaryY.length();
		
		
		return y;
	}

	public static void main(String[] args) {
		hammingDistance(12, 23);
	}

}