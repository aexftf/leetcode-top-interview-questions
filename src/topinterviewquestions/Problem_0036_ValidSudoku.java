package topinterviewquestions;

public class Problem_0036_ValidSudoku {

	public static boolean isValidSudoku(char[][] board) {
		boolean[][] row = new boolean[9][10];//行判断
		boolean[][] col = new boolean[9][10];//列判断
		boolean[][] bucket = new boolean[9][10];//九宫格判断

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				//规律：就是这个数值
				int bid = 3 * (i / 3) + (j / 3);

				if (board[i][j] != '.') {//这判断纯扯淡，就是证明别逗你玩有效给的。

					int num = board[i][j] - '0';//随便一个数字标记一下而已别太在意。
					if (row[i][num] || col[j][num] || bucket[bid][num]) {
						return false;
					}
				//有了就记录一下，下次同行同列同九宫格就完蛋了。
					row[i][num] = true;
					col[j][num] = true;
					bucket[bid][num] = true;
					board[i][j] = '.';

				}
			}
		}
		return true;
	}






}
