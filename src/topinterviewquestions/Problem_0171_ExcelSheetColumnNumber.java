package topinterviewquestions;

public class Problem_0171_ExcelSheetColumnNumber {
//给你一个字符串columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号。
//例如：
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28
//...

//示例1:
//输入: columnTitle = "A"
//输出:1
//示例2:
//输入: columnTitle = "AB"
//输出: 28
////链接：https://leetcode.cn/problems/excel-sheet-column-number
	// 这道题反过来也要会写
	public static int titleToNumber(String s) {
		char[] str = s.toCharArray();

		int ans = 0;

		for (int i = 0; i < str.length; i++) {
			ans = ans * 26 + (str[i] - 'A') + 1;
		}
		return ans;
	}





}
