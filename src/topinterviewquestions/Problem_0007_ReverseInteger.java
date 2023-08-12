package topinterviewquestions;
//整数反转
//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
//假设环境不允许存储 64 位整数（有符号或无符号）。

//示例 1：
//输入：x = 123
//输出：321

//示例 2：
//输入：x = -123
//输出：-321

//示例 3：
//输入：x = 120
//输出：21
//示例 4：
//输入：x = 0
public class Problem_0007_ReverseInteger {






//这个最好理解
	public int reverse(int x) {
		int a=Math.abs(x);
		long ans=0;
		while(a!=0) {
			ans=ans*10+a%10;
			a/=10;
		}
		if(ans>Integer.MAX_VALUE || ans<Integer.MIN_VALUE) return 0;

		if(x<0) return (int) ans * -1;

		else {
			return (int)ans;
		}
	}








	//--------------------------------------------------------------------------------



	public static int reverse1(int x) {
		//正数变成负数处理，因为负数范围比正数多一个；不加也行
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
