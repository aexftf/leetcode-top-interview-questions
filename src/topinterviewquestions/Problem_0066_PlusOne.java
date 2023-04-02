package topinterviewquestions;
//自己复习即可

public class Problem_0066_PlusOne {
	public static int[] plusOne(int[] digits) {
		int n = digits.length;
		//从最低位开始，i--去上一位
		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		//全是9，跳出来了，最高位是1，其余全是0
		int[] ans = new int[n + 1];
		ans[0] = 1;
		return ans;
	}

}
