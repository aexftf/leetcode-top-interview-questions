package topinterviewquestions;
//54. 螺旋矩阵   https://leetcode.cn/problems/spiral-matrix/
import java.util.ArrayList;
import java.util.List;
//笔试
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5],,,,,,,看图啊
public class Problem_0054_SpiralMatrix {//看左程云的视频吧
//
    public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<>();

		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return ans;
		}

		int a = 0;
		int b = 0;
		int c = matrix.length - 1;
		int d = matrix[0].length - 1;

		while (a <= c && b <= d) {
			addEdge(matrix, a++, b++, c--, d--, ans);
		}
		return ans;
	}




	public static void addEdge(int[][] m, int a, int b, int c, int d, List<Integer> ans) {
		if (a == c) {
			for (int i = b; i <= d; i++) {
				ans.add(m[a][i]);
			}
		} else if (b == d) {
			for (int i = a; i <= c; i++) {
				ans.add(m[i][b]);
			}
		} else {
			int curC = b;
			int curR = a;
			//左上角的数变化
			while (curC != d) {
				ans.add(m[a][curC]);
				curC++;
			}
			while (curR != c) {
				ans.add(m[curR][d]);
				curR++;
			}
			//右下角的数变化
			while (curC != b) {
				ans.add(m[c][curC]);
				curC--;
			}
			while (curR != a) {
				ans.add(m[curR][b]);
				curR--;
			}
		}
	}

}
