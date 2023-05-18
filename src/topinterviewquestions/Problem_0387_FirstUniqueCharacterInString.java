package topinterviewquestions;

public class Problem_0387_FirstUniqueCharacterInString {
//firstUniqChar
	public int firstUniqChar(String s) {

		char[] str = s.toCharArray();
		int N = str.length;
		int count[] = new int[26];

		for (int i = 0; i < N; i++) {
			count[str[i] - 'a']++;//当map用
		}

		for (int i = 0; i < N; i++) {
			if (count[str[i] - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}

}
