package topinterviewquestions;

public class Problem_0012_IntegerToRoman {
//罗马数字
	public static String intToRoman(int num) {
		String[][] c = { 
				{ "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
				{ "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
				{ "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
				{ "", "M", "MM", "MMM" } };
		StringBuilder roman = new StringBuilder();
//1000
		roman
		.append(c[3][num / 1000 % 10])
		.append(c[2][num / 100 % 10])
		.append(c[1][num / 10 % 10])
		.append(c[0][num % 10]);

		return roman.toString();
	}



}
