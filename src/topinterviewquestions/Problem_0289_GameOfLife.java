package topinterviewquestions;
//生命游戏，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。

//给定一个包含 m × n个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
//1如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
//2如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
//3如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
//4如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
//下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
//链接：https://leetcode.cn/problems/game-of-life
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


		// 1 创建新的矩阵循环a，存储'虚无0'有没有下一代，有的打标为true
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				int neighbors = neighbors(board, i, j);

				if (neighbors == 3) {
					isHaveNewSon[i][j] = true;
				}
			}
		}





		// 2 创建新的矩阵数组b，判断下一次1，有没有存活
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int neighbors = neighbors(board, i, j);
				if (neighbors == 3 || (neighbors == 2)) {
					newBoard[i][j] = 1;
				}
			}
		}

		// 3 b覆盖掉原来的矩阵数组，再循环判断虚无标记，若为true则覆盖掉虚无标记。
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (isHaveNewSon[i][j] == true) {
					newBoard[i][j] = 1;
				}
			}
		}

		return newBoard;

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







}
