package topinterviewquestions;
//旋转图像
//给定一个n  ×  n的二维矩阵 matrix表示一个图像。请你将图像顺时针旋转90度。
//
//您必须在原地旋转图像，这意味着您需要直接修改输入的二维矩阵。请不要使用其他矩阵来旋转图像。
public class Problem_0048_RotateImage {
//https://leetcode.cn/problems/rotate-image/

	//正方形
	public static void rotate(int[][] matrix) {
		// matrix.len == matrix[0].len
		int tR = 0;
		int tC = 0;

		int dR = matrix.length - 1;
		int dC = matrix[0].length - 1;

		while (tR < dR) {
			rotateEdge(matrix, tR++, tC++, dR--, dC--);
		}
	}


	public static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
		int times = dC - tC;
		int tmp = 0;
		//好好看看
		for (int i = 0; i != times; i++) {//仔细想想也可以

			tmp = m[tR][tC + i];//暂存左上角
			m[tR][tC + i] = m[dR - i][tC];//左下角覆盖到左上角
			m[dR - i][tC] = m[dR][dC - i];//右下角覆盖到左下角
			m[dR][dC - i] = m[tR + i][dC];//右上角覆盖到右下角
			m[tR + i][dC] = tmp;    //左上角覆盖到右上角
		}
	}




}
