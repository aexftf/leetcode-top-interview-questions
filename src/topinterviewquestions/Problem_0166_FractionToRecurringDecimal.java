package topinterviewquestions;

import java.util.HashMap;
import java.util.Map;
//给定两个整数，分别表示分数的分子numerator 和分母 denominator，以 字符串形式返回小数 。
//如果小数部分为循环小数，则将循环的部分括在括号内。
//如果存在多个答案，只需返回 任意一个 。

//输入：numerator = 1, denominator = 2
//输出："0.5"
//示例 2：
//
//输入：numerator = 2, denominator = 1
//输出："2"
//示例 3：
//
//输入：numerator = 4, denominator = 333
//输出："0.(012)"
//
//链接：https://leetcode.cn/problems/fraction-to-recurring-decimal
public class Problem_0166_FractionToRecurringDecimal {



	public String fractionToDecimal(int numerator, int denominator) {
		long numeratorLong = (long) numerator;
		long denominatorLong = (long) denominator;

		if (numeratorLong % denominatorLong == 0) {
			return String.valueOf(numeratorLong / denominatorLong);
		}

		StringBuffer sb = new StringBuffer();
		if (numeratorLong < 0 ^ denominatorLong < 0) {
			sb.append('-');
		}

		// 整数部分
		numeratorLong = Math.abs(numeratorLong);
		denominatorLong = Math.abs(denominatorLong);

		long integerPart = numeratorLong / denominatorLong;
		sb.append(integerPart);
		sb.append('.');

		// 小数部分
		StringBuffer fractionPart = new StringBuffer();
		Map<Long, Integer> remainderIndexMap = new HashMap<Long, Integer>();
		long remainder = numeratorLong % denominatorLong;
		int index = 0;
		while (remainder != 0 && !remainderIndexMap.containsKey(remainder)) {
			remainderIndexMap.put(remainder, index);
			remainder *= 10;
			fractionPart.append(remainder / denominatorLong);
			remainder %= denominatorLong;
			index++;
		}
		if (remainder != 0) { // 有循环节
			int insertIndex = remainderIndexMap.get(remainder);
			fractionPart.insert(insertIndex, '(');
			fractionPart.append(')');
		}
		sb.append(fractionPart.toString());

		return sb.toString();
	}








	//----------------------------------------

	public String fractionToDecimal1(int numerator, int denominator) {

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
