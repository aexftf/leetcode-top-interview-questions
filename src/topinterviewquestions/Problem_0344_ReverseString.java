package topinterviewquestions;

public class Problem_0344_ReverseString {
//用双指针交换即可

	public void reverseString(char[] s) {
		int l = 0;
		int r = s.length - 1;

		while (l < r) {
			char tmp = s[l];
			s[l++] = s[r];
			s[r--] = tmp;
		}

	}


}
