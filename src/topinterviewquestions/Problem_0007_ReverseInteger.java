package topinterviewquestions;
//整数反转
public class Problem_0007_ReverseInteger {

	public static int reverse(int x) {
		//正数变成负数处理，因为负数范围比正数多一个；
		boolean neg = x>0 ? true:false;
		x = neg ? x : -x;

		//边界
		int m = Integer.MIN_VALUE / 10;
		int o = Integer.MIN_VALUE % 10;

		int res = 0;

		while (x != 0) {

			//不写也可以
			if (res < m || (res == m && x % 10 < o)) {
				return 0;
			}

			//main
			res = res * 10 + x % 10;
			x /= 10;
		}
		return  Math.abs(res);
	}






}
