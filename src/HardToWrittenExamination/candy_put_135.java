package HardToWrittenExamination;

import java.util.Arrays;

/**
 * TODO
 *
 * @author Jack Geller
 * @version 1.0
 * @date 2023年07月13日 08:56
 */
public class candy_put_135 {

    //n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
    //
    //你需要按照以下要求，给这些孩子分发糖果：
    //
    //每个孩子至少分配到 1 个糖果。
    //相邻两个孩子评分更高的孩子会获得更多的糖果。
    //请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
    //
    //输入：ratings = [1,0,2]
    //输出：5
    //解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
    //示例2：
    //
    //输入：ratings = [1,2,2]
    //输出：4
    //解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
    //     第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。

//    链接：https://leetcode.cn/problems/candy/solution/fen-fa-tang-guo-by-leetcode-solution-f01p/

        public int candy(int[] ratings) {
            int n = ratings.length;
            int[] left = new int[n];
            for (int i = 0; i < n; i++) {
                if (i > 0 && ratings[i] > ratings[i - 1]) {
                    left[i] = left[i - 1] + 1;
                } else {
                    left[i] = 1;
                }
            }
            int right = 0, ret = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                    right++;
                } else {
                    right = 1;
                }
                ret += Math.max(left[i], right);
            }
            return ret;
        }



//    链接：https://leetcode.cn/problems/candy/solution/candy-cong-zuo-zhi-you-cong-you-zhi-zuo-qu-zui-da-/
//贪心
        public int candy1(int[] ratings) {
            int[] left = new int[ratings.length];
            int[] right = new int[ratings.length];
            Arrays.fill(left, 1);
            Arrays.fill(right, 1);

            for(int i = 1; i < ratings.length; i++)
                if(ratings[i] > ratings[i - 1]) left[i] = left[i - 1] + 1;
            int count = left[ratings.length - 1];

            for(int i = ratings.length - 2; i >= 0; i--) {
                if(ratings[i] > ratings[i + 1]) right[i] = right[i + 1] + 1;
                count += Math.max(left[i], right[i]);
            }
            return count;
        }






}
