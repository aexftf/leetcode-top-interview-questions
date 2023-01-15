import java.util.ArrayList;
import java.util.Arrays;

/**
 * 正式面试用
 */
public class Solution {


    public void solveFunctions() {
        //Example
    }









    //微软实习一面
    //在一n长度数组，0-n范围，找重复
    //^
    public static int solveReNumber(int[] nums){

     for (int i = 0; i <nums.length ; i++) {
         for (int j = i+1; j < nums.length ; j++) {
          if (nums[i]==nums[j]){
              return nums[i];
          }

         }
     }

        return -1;
 }

    public static int solveReNumber2(int[] nums) {

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

        if (i== nums.length-1){
            return -1;
        }
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }

        }


        return -1;
    }

//        public static void main(String[] args) {
////input: [1,3,1,0,2,5,3] output: 2 or 3
//    int []num={1,3,1,0,2,5,3};
//        int solve = solveReNumber(num);
//        System.out.println(solve);
//
//
//    }











    //for Test
//    public static void main(String[] args) {
//    //今天你测试了吗？
//
//
//    }

//qq阅读校招笔试
    public static int[] merge2(int[] nums1, int m, int[] nums2, int n) {
        //m 是合并结果固定数组的长度（0补齐），n是第二个的长度。

        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        return nums1;
    }

    public static int[] merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;

        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
                //-------------
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
        return sorted;
    }




    //合并有序数组
    private static int[] twoConvertOne(int[] a,int[] b){
        //判断边界
        if (a==null||a.length==0){
            return b;
        }
        if (b==null||b.length==0){
            return a;
        }

        //定义一个新的数组
        int[] c=new int[a.length+b.length];
        //定义初始索引;
        //m是a的索引,n是b的索引
        int m=0;
        int n=0;
        //遍历
        for (int i = 0; i < c.length; i++) {
            if (m<a.length&&n<b.length){
                if (a[m]<b[n]){
                    c[i]=a[m];
                    m++;
                }else {
                    c[i]=b[n];
                    n++;
                }
            }else if (m<a.length){
                c[i]=a[m];
                m++;
            }else if (n<b.length){
                c[i]=b[n];
                n++;
            }
        }
        //返回新的数组
        return c;
    }

    //测试
    public static void main(String[] args) {
        int[] a=new int[]{1,3,5,7};
        int[] b=new int[]{2,4,6,8,10,11};
        int[] c = twoConvertOne(a, b);
        System.out.println(Arrays.toString(c));
    }
   public static int[] merge2(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0;
        int m = nums1.length;
        int n = nums2.length;
        int[] sorted = new int[m + n];

        ArrayList<Integer> nums11 = new ArrayList<>();
        ArrayList<Integer> nums22 = new ArrayList<>();
        for (int i = 0; i <nums1.length ; i++) {
            nums11.add(nums1[i]);
        }
        for (int i = 0; i <nums2.length ; i++) {
            nums22.add(nums2[i]);
        }



        for (int i = 0; i <sorted.length ; i++) {

            try {
                Integer integer = nums11.get(i);
            } catch (Exception e) {
                sorted[i] = nums2[i];
                break;
            }
            try {
                Integer integer = nums22.get(i);
            } catch (Exception e) {
                sorted[i] = nums1[i];
                break;
            }



            if (nums1[i] <= nums2[i]) {
                sorted[i] = nums1[i];
            }
            else {
                sorted[i] = nums2[i];
            }

        }

        return sorted;
    }







//
//public ListNode reverseList(ListNode head){
//    ListNode pre = null;
//    ListNode current = head;
//
//    while(current != null){
//        //score
//        ListNode next = current.next;
//        current.next=pre;
//        //准备下一轮
//        pre=current;
//        current=next;
//    }
//    return head;


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(ListNode next) {
            this.next = next;
        }

        public ListNode() {
        }
    }


}