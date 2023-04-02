package topinterviewquestions;

import java.util.HashMap;
//给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
//
//如果小数部分为循环小数，则将循环的部分括在括号内。
//
//如果存在多个答案，只需返回 任意一个 。
public class Problem_0166_FractionToRecurringDecimal {

	public String fractionToDecimal(int numerator, int denominator) {

		if (numerator == 0) {
			return "0";
		}

		StringBuilder res = new StringBuilder();
		// "+" or "-"
		res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);

		// integral part
		res.append(num / den);
		num %= den;
		if (num == 0) {
			return res.toString();
		}

		// fractional part
		res.append(".");
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		map.put(num, res.length());

		while (num != 0) {
			num *= 10;
			res.append(num / den);
			num %= den;

			if (map.containsKey(num)) {
				int index = map.get(num);
				res.insert(index, "(");
				res.append(")");
				break;
			} else {
				map.put(num, res.length());
			}
		}
		return res.toString();
	}

}
