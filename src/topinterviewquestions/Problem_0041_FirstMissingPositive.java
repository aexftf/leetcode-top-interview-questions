package topinterviewquestions;
//缺失的第一个正数
//示例1：
//
//输入： nums = [1,2,0]
//输出： 3
//示例2：
//
//输入： nums = [3,4,-1,1]
//输出： 2
//示例3：
//
//输入： nums = [7,8,9,11,12]
//输出： 1
//
public class Problem_0041_FirstMissingPositive {


	//必须画图，分三种情况讨论
    public static int firstMissingPositive(int[] arr) {
		int l = 0;
		int r = arr.length;

		while (l < r) {
			//需要的情况
			if (arr[l] == l + 1) {
				l++;
			//超过边界，太离谱，直接丢到垃圾堆
			} else if (arr[l] <= l || arr[l] > r || arr[arr[l] - 1] == arr[l]) {
				swap(arr,l,--r);

			} else {//有可能是需要的数，没超过左右边界，交换
				swap(arr, l, arr[l] - 1);
			}
		}
		return l + 1;
	}













	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}




}
