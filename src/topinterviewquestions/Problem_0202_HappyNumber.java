package topinterviewquestions;

import java.util.HashSet;

public class Problem_0202_HappyNumber {
//编写一个算法来判断一个数 n 是不是快乐数。
//「快乐数」定义为：
//对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
//然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//如果这个过程 结果为1，那么这个数就是快乐数。
//如果 n 是 快乐数 就返回 true ；不是，则返回 false 。

//示例 1：
//输入：n = 19
//输出：true
//解释：2都是平方
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1

//链接：https://leetcode.cn/problems/happy-number
    public static boolean isHappy1(int n) {
		HashSet<Integer> set = new HashSet<>();
		//X平方+X平方==1则是快乐数
		while (n != 1) {
			int sum = 0;
			while (n != 0) { //反复求
				int r = n % 10;
				sum += r * r;
				n /= 10;
			}

			n = sum;
			if (set.contains(n)) {
				break;
			}
			set.add(n);
		}
		return n == 1;
	}











	public static boolean isHappy2(int n) {
		while (n != 1 && n != 4) {
			int sum = 0;
			while (n != 0) {
				sum += (n % 10) * (n % 10);
				n /= 10;
			}
			n = sum;
		}
		return n == 1;
	}



}
