package topinterviewquestions;
//自己看就会
//矩阵置零
public class Problem_0073_SetMatrixZeroes {

	//方法一：使用标记数组
	//思路和算法
	//我们可以用两个标记数组分别记录每一行和每一列是否有零出现。
	//具体地，我们首先遍历该数组一次，如果某个元素为
	//0，那么就将该元素所在的行和列所对应标记数组的位置置为
	//true
	//最后我们再次遍历该数组，用标记数组更新原数组即可。
	public void setZeroes(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;

		boolean[] row = new boolean[m];
		boolean[] col = new boolean[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if 	(matrix[i][j] == 0) {
					row[i] = col[j] = true;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (row[i] || col[j]) {
					matrix[i][j] = 0;
				}
			}
		}


	}









}





