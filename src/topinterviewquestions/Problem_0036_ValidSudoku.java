package topinterviewquestions;
//你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
//
//数字1-9在每一行只能出现一次。
//数字1-9在每一列只能出现一次。
//数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
//
//注意：
//一个有效的数独（部分已被填充）不一定是可解的。
//只需要根据以上规则，验证已经填入的数字是否有效即可。
//空白格用'.'表示。

//示例 1：
//输入：board =
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：true
public class Problem_0036_ValidSudoku {

	public static boolean isValidSudoku(char[][] board) {

		boolean[][] row = new boolean[9][10];//行判断
		boolean[][] col = new boolean[9][10];//列判断
		boolean[][] bucket = new boolean[9][10];//九宫格判断

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				//规律：就是这个数值
				int bid = 3 * (i / 3) + (j / 3);//多好记对吧，两个除三的加起来，第一个还需要整体乘3

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
