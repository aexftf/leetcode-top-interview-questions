import java.util.ArrayList;
import java.util.Scanner;

/**
 * TODO
 *
 * @author Jack Geller
 * @version 1.0
 * @date 2023年03月22日 19:39
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;
    }























    public static void main(String[] args) {
        //ACM模式

//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int[] ints = new int[256];
//            int b = in.nextInt();
//
//        }


        Scanner in = new Scanner(System.in);

        int count = 0;
        int b = in.nextInt();

        // 注意 hasNext 和 hasNextLine 的区别
        while (in.nextLine() != null) {
            // 注意 while 处理多个 case
            String s = in.nextLine();
            count++;
        }

        String[] strings = new String[count];

        for (int i = 0; i < strings.length; i++) {

            String temp = strings[i];

        }


    }





    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}





