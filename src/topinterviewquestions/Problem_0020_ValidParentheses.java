package topinterviewquestions;

import java.util.Stack;
//有效的括号，栈实现，简单
//给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
//有效字符串需满足：
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//每个右括号都有一个对应的相同类型的左括号。
//示例 1：
//输入：s = "()"
//输出：true

//示例2：
//输入：s = "()[]{}"
//输出：true
//链接：https://leetcode.cn/problems/valid-parentheses
public class Problem_0020_ValidParentheses {

	public static boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		char[] str = s.toCharArray();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length; i++) {
			char cha = str[i];
//
//输入：s = "()[]{}"
//输出：true

			if (cha == '(' || cha == '[' || cha == '{') {
				stack.add(cha == '(' ? ')' : (cha == '[' ? ']' : '}'));
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				char last = stack.pop();
				if (cha != last) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

}
