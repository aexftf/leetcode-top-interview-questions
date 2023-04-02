package topinterviewquestions;

// 有关这个游戏更有意思、更完整的内容：
// https://www.bilibili.com/video/BV1rJ411n7ri
//
public class Problem_0289_GameOfLife {


	//方法1最简单的做法
	//思路:
	// 1 创建新的矩阵循环a，存储'虚无0'有没有下一代，有的打标为true
	// 2 创建新的矩阵数组b，判断下一次1，有没有存活
	// 3 b覆盖掉原来的矩阵数组，再循环判断虚无标记，若为true则覆盖掉虚无标记。
	//至此已经达到要求

	public static int[][] gameOfLife(int[][] board) {
		int N = board.length;
		int M = board[0].length;

		boolean[][] isHaveNewSon = new boolean[N][M];
		int[][] newBoard = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				int neighbors = neighbors(board, i, j);

				if (neighbors == 3) {
					isHaveNewSon[i][j] = true;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int neighbors = neighbors(board, i, j);
				if (neighbors == 3 || (neighbors == 2)) {
				newBoard[i][j] = 1;
				}
			}
		}



		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int neighbors = neighbors(board, i, j);
				if (isHaveNewSon[i][j]==true) {
					newBoard[i][j] = 1;
				}
			}
		}

		return	newBoard;


	}


	public static int neighbors(int[][] board, int i, int j) {
		int count = 0;
		count += ok(board, i - 1, j - 1) ? 1 : 0;
		count += ok(board, i - 1, j) ? 1 : 0;
		count += ok(board, i - 1, j + 1) ? 1 : 0;
		count += ok(board, i, j - 1) ? 1 : 0;
		count += ok(board, i, j + 1) ? 1 : 0;
		count += ok(board, i + 1, j - 1) ? 1 : 0;
		count += ok(board, i + 1, j) ? 1 : 0;
		count += ok(board, i + 1, j + 1) ? 1 : 0;
		return count;
	}

	public static boolean ok(int[][] board, int i, int j) {
		return i >= 0 && i < board.length && j >= 0 && j < board[0].length && (board[i][j] & 1) == 1;
	}

	public static void tag(int[][] board, int N, int M) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

			}
			}
	}






	//这个思路比较复杂，不推荐，但是空间复杂度小。
	public static void gameOfLife2(int[][] board) {
		int N = board.length;
		int M = board[0].length;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int neighbors = neighbors(board, i, j);
				if (neighbors == 3 || (board[i][j] == 1 && neighbors == 2)) {
					set(board, i, j);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = get(board, i, j);
			}
		}
	}

	public static int neighbors2(int[][] board, int i, int j) {
		int count = 0;
		count += ok2(board, i - 1, j - 1) ? 1 : 0;
		count += ok2(board, i - 1, j) ? 1 : 0;
		count += ok2(board, i - 1, j + 1) ? 1 : 0;
		count += ok2(board, i, j - 1) ? 1 : 0;
		count += ok2(board, i, j + 1) ? 1 : 0;
		count += ok2(board, i + 1, j - 1) ? 1 : 0;
		count += ok2(board, i + 1, j) ? 1 : 0;
		count += ok2(board, i + 1, j + 1) ? 1 : 0;
		return count;
	}

	public static boolean ok2(int[][] board, int i, int j) {
		return i >= 0 && i < board.length && j >= 0 && j < board[0].length && (board[i][j] & 1) == 1;
	}

	public static void set(int[][] board, int i, int j) {
		board[i][j] |= 2;
	}

	public static int get(int[][] board, int i, int j) {
		return board[i][j] >> 1;
	}

}
