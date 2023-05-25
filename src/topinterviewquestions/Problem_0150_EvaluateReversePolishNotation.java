package topinterviewquestions;

import java.util.Stack;

public class Problem_0150_EvaluateReversePolishNotation {
//编译原理有点像

	//给你一个字符串数组 tokens ，表示一个根据逆波兰表示法 表示的算术表达式。
	//请你计算该表达式。返回一个表示表达式值的整数。
	//注意：
	//有效的算符为 '+'、'-'、'*' 和 '/' 。
	//每个操作数（运算对象）都可以是一个整数或者另一个表达式。
	//两个整数之间的除法总是 向零截断 。
	//表达式中不含除零运算。
	//输入是一个根据逆波兰表示法表示的算术表达式。
	//答案及所有中间计算结果可以用 32 位 整数表示。
	//示例1：
	//输入：tokens = ["2","1","+","3","*"]
	//输出：9
	//解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9

	//示例2：
	//输入：tokens = ["4","13","5","/","+"]
	//输出：6
	//解释：该算式转化为常见的中缀算术表达式为：( (13 / 5)+4) = 6

	//链接：https://leetcode.cn/problems/evaluate-reverse-polish


	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();

		for (String str : tokens) {
			if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
				compute(stack, str);
			} else {
				stack.push(Integer.valueOf(str));
			}
		}
		return stack.peek();
	}







	public static void compute(Stack<Integer> stack, String op) {
		int num2 = stack.pop();
		int num1 = stack.pop();

		int ans = 0;

		switch (op) {
		case "+":
			ans = num1 + num2;
			break;
		case "-":
			ans = num1 - num2;
			break;
		case "*":
			ans = num1 * num2;
			break;
		case "/":
			ans = num1 / num2;
			break;
		}
		stack.push(ans);
	}








}
