package topinterviewquestions;
//130. 被围绕的区域
//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

//示例 1：
//输入：board = [["X","X","X","X"],
//             ["X","O","O","X"],
//             ["X","X","O","X"],
//             ["X","O","X","X"]]
// 	 输出：	[["X","X","X","X"],
//   	   	["X","X","X","X"],
//      	["X","X","X","X"],
//      	["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。

//示例 2：
//输入：board = [["X"]]
//输出：[["X"]]

//本题给定的矩阵中有三种元素：
//
//字母 X；
//被字母 X 包围的字母 O；
//没有被字母 X 包围的字母 O。
//本题要求将所有被字母 X 包围的字母 O都变为字母 X ，但很难判断哪些 O 是被包围的，哪些 O 不是被包围的。
//
//注意到题目解释中提到：任何边界上的 O 都不会被填充为 X。 我们可以想到，所有的不被包围的 O 都直接或间接与边界上的 O 相连。我们可以利用这个性质判断 O 是否在边界上，具体地说：
//
//对于每一个边界上的 O，我们以它为起点，标记所有与它直接或间接相连的字母 O；
//最后我们遍历这个矩阵，对于每一个字母：
//如果该字母被标记过，则该字母为没有被字母 X 包围的字母 O，我们将其还原为字母 O；
//如果该字母没有被标记过，则该字母为被字母 X 包围的字母 O，我们将其修改为字母 X。
//方法一：深度优先搜索
//思路及解法
//我们可以使用深度优先搜索实现标记操作。在下面的代码中，我们把标记过的字母 O 修改为字母 A。
//作者：力扣官方题解
//链接：https://leetcode.cn/problems/surrounded-regions/solutions/369110/bei-wei-rao-de-qu-yu-by-leetcode-solution/
public class Problem_0130_SurroundedRegions {






	// 从边界开始感染的方法，比第一种方法更好
	public static void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
			return;
		}
		int N = board.length;
		int M = board[0].length;

		for (int j = 0; j < M; j++) {//横着
			if (board[0][j] == 'O') {//上面
				free(board, 0, j);
			}
			if (board[N - 1][j] == 'O') {
				free(board, N - 1, j);//下面
			}
		}

		for (int i = 1; i < N - 1; i++) {//竖着
			if (board[i][0] == 'O') {//左面
				free(board, i, 0);
			}
			if (board[i][M - 1] == 'O') {//右边
				free(board, i, M - 1);
			}
		}




		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if (board[i][j] == 'F') {
					board[i][j] = 'O';
				}
			}
		}
	}

	public static void free(char[][] board, int i, int j) {
		if (i < 0 || i == board.length || j < 0 || j == board[0].length ||
				board[i][j] != 'O') {
			return;
		}
		board[i][j] = 'F';

		free(board, i + 1, j);
		free(board, i - 1, j);
		free(board, i, j + 1);
		free(board, i, j - 1);
	}













//====================================66666666666666666666666666666666666666666666666666

	public static void solve1(char[][] board) {
		boolean[] ans = new boolean[1];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O') {
					ans[0] = true;
					can(board, i, j, ans);
					board[i][j] = ans[0] ? 'T' : 'F';
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				char can = board[i][j];
				if (can == 'T' || can == 'F') {
					board[i][j] = '.';
					change(board, i, j, can);
				}
			}
		}

	}

	public static void can(char[][] board, int i, int j, boolean[] ans) {
		if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
			ans[0] = false;
			return;
		}
		if (board[i][j] == 'O') {
			board[i][j] = '.';
			can(board, i - 1, j, ans);
			can(board, i + 1, j, ans);
			can(board, i, j - 1, ans);
			can(board, i, j + 1, ans);
		}
	}

	public static void change(char[][] board, int i, int j, char can) {
		if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
			return;
		}

		if (board[i][j] == '.') {
			board[i][j] = can == 'T' ? 'X' : 'O';

			change(board, i - 1, j, can);
			change(board, i + 1, j, can);
			change(board, i, j - 1, can);
			change(board, i, j + 1, can);
		}
	}




}
