package topinterviewquestions;

import java.util.Stack;
//有效的括号，栈实现，简单
public class Problem_0020_ValidParentheses {

	public static boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		char[] str = s.toCharArray();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length; i++) {
			char cha = str[i];

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
