//import java.util.*;
//
///**
// * 正式面试用
// */
//public class SolutionInterview {
//
//
//
//
//
//
//
//















//
//    public int  solveFunction1() {
//
//        int n=0;
//        for (int i = 0; i < 100; i++) {
//            n=n+1;
//        }
//
//        return n;
//    }
//
//
////
//
//    static int n=0;
//
//    static Thread thread = new Thread(new Runnable() {
//        @Override
//        public void run() {
//
//            n = 0;
//            for (int i = 0; i < 100; i++) {
//                n = n + 1;
//            }
//
//        }
//    });
//
//
//
//    public static int  solveFunction() {
//
//        thread.start();
//        return n;
//
//    }
//
//    public static void main(String[] args) {
//        int i = solveFunction();
//        System.out.println(i);
//    }
//
//
//
//
//

//

//
//不用List接口实现栈结构
//int[] arr = new int[10];
//
//int top = -1;
//
//public void push(int val) {
//  if(top == arr.length-1) { // 扩容数组 }
//
//  arr[++top] = val;
//}
//
//
//public int pop() {
//  if(top == -1) {
//    // 空栈不能pop
//    return -1;
//  }
//
//  int res = arr[top];
//  top--;
//
//  return res;
//}
//
//
//
//

//
//
////    public class Main4 {//卖矿泉水瓶 2元一个
////        public static void main(String[] args) {
////            Scanner sc = new Scanner(System.in);
////
////            while (sc.hasNext()) {
////                int n = sc.nextInt();
////
////                System.out.println(n/2);
////            }
////
////        }
////    }
//
//
//    public class Main {
//
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            while (sc.hasNext()) {//这题还考察了一点就是需要多次执行，不是只执行一次，所以这个while语句一定不要少了，尴尬
//                int number = sc.nextInt();
//                int shuzu[] = new int[number];
//                for (int i = 0; i < shuzu.length; i++) {
//                    shuzu[i] = sc.nextInt();
//                }
//                // 利用Set把重复的元素去掉
//                Set<Object> set = new HashSet<>();
//                for (int i = 0; i < shuzu.length; i++) {
//                    set.add(shuzu[i]);
//                }
//                // 遍历set集合 无序的
//                // 转化成int数组
//                int[] uArray = new int[set.size()];
//                int count = 0;
//                for (Object str : set) {
//                    // 将Object转化成 int
//                    uArray[count++] = Integer.parseInt(String.valueOf(str));
//                }
//                Arrays.sort(uArray);
//                for (int i = 0; i < uArray.length; i++) {
//                    System.out.println(uArray[i]);
//                }
//
//            }
//        }
//    }
//
//
//
//
//    //明明生成了
////N个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出
//    public class Main1 {
//
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            while (sc.hasNext()) {//这题还考察了一点就是需要多次执行，不是只执行一次，所以这个while语句一定不要少了，尴尬
//                int number = sc.nextInt();
//                int shuzu[] = new int[number];
//                for (int i = 0; i < shuzu.length; i++) {
//                    shuzu[i] = sc.nextInt();
//                }
//                // 利用Set把重复的元素去掉
//                Set<Object> set = new HashSet<>();
//                for (int i = 0; i < shuzu.length; i++) {
//                    set.add(shuzu[i]);
//                }
//                // 遍历set集合 无序的
//                // 转化成int数组
//                int[] uArray = new int[set.size()];
//                int count = 0;
//                for (Object str : set) {
//                    // 将Object转化成 int
//                    uArray[count++] = Integer.parseInt(String.valueOf(str));
//                }
//                Arrays.sort(uArray);
//                for (int i = 0; i < uArray.length; i++) {
//                    System.out.println(uArray[i]);
//                }
//
//            }
//        }
//    }
//    public class Main2vd{//写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
//
//        public static void main(String[] args){
//            Scanner in = new Scanner(System.in);
//            while(in.hasNextLine()){
//                String n = in.nextLine();
//                boolean isValid = true;
//                int sum = 0;
//
//                for(int i=n.length()-1;i>=0;i--){
//                    char c = n.charAt(i);
//                    if(c-'0'>=0&&c-'0'<=9)
//                        sum+=(c-'0')*Math.pow(16,n.length()-1-i);
//                    else if(Character.toUpperCase(c)>='A'&&Character.toUpperCase(c)<='F')
//                        sum+=(c-'A'+10)*Math.pow(16,n.length()-1-i);
//                    else if(c=='x'&&i==1)break;
//                    else{
//                        isValid=false;
//                        break;
//                    }
//                }
//                if(!isValid) sum=-1;
//                System.out.println(sum);
//
//            }
//        }
//    }
//
//
//
//
//
//    public void solveFunctions() {
//        //Example
//    }
//
//
//
//
//
//
//
//
//
//    public  int maxPath(int[][] matrix) {
//        int ans = Integer.MIN_VALUE;
//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[0].length; col++) {
//                ans = Math.max(ans, process(matrix, row, col));
//            }
//        }
//        return ans;
//    }
//
//
//
//
//    // 假设在matrix中，从i行，j列出发，能走出的最长递增路径，返回最长递增路径的长度
//    public static int process(int[][] matrix, int i, int j) {
//        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
//            return -1;
//        }
//        int up = 0;
//        int down = 0;
//        int left = 0;
//        int right = 0;
//        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
//            up = process(matrix, i - 1, j);
//        }
//        if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
//            down = process(matrix, i + 1, j);
//        }
//        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
//            left = process(matrix, i, j - 1);
//        }
//        if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) {
//            right = process(matrix, i, j + 1);
//        }
//        return 1 + Math.max(Math.max(up, down), Math.max(left, right));
//    }
//
//    //微软实习一面
//    //在一n长度数组，0-n范围，找重复
//    //^
//    public static int solveReNumber(int[] nums) {
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] == nums[j]) {
//                    return nums[i];
//                }
//
//            }
//        }
//
//        return -1;
//    }
//
//    public static int solveReNumber2(int[] nums) {
//
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//
//            if (i == nums.length - 1) {
//                return -1;
//            }
//            if (nums[i] == nums[i + 1]) {
//                return nums[i];
//            }
//
//        }
//
//
//        return -1;
//    }
//
//
//    //for Test
////    public static void main(String[] args) {
////    //今天你测试了吗？
////
////
////    }
//
//
//    //qq阅读校招笔试
//    public static int[] merge2(int[] nums1, int m, int[] nums2, int n) {
//        //m 是合并结果固定数组的长度（0补齐），n是第二个的长度。
//
//        System.arraycopy(nums2, 0, nums1, m, n);
//        Arrays.sort(nums1);
//        return nums1;
//    }
//
//    public static int[] merge1(int[] nums1, int m, int[] nums2, int n) {
//        int p1 = 0, p2 = 0;
//        int[] sorted = new int[m + n];
//        int cur;
//
//        while (p1 < m || p2 < n) {
//            if (p1 == m) {
//                cur = nums2[p2++];
//            } else if (p2 == n) {
//                cur = nums1[p1++];
//                //-------------
//            } else if (nums1[p1] < nums2[p2]) {
//                cur = nums1[p1++];
//            } else {
//                cur = nums2[p2++];
//            }
//            sorted[p1 + p2 - 1] = cur;
//        }
//        for (int i = 0; i != m + n; ++i) {
//            nums1[i] = sorted[i];
//        }
//        return sorted;
//    }
//
//
//    //合并有序数组
//    private static int[] twoConvertOne(int[] a, int[] b) {
//        //判断边界
//        if (a == null || a.length == 0) {
//            return b;
//        }
//        if (b == null || b.length == 0) {
//            return a;
//        }
//
//        //定义一个新的数组
//        int[] c = new int[a.length + b.length];
//        //定义初始索引;
//        //m是a的索引,n是b的索引
//        int m = 0;
//        int n = 0;
//        //遍历
//        for (int i = 0; i < c.length; i++) {
//            if (m < a.length && n < b.length) {
//                if (a[m] < b[n]) {
//                    c[i] = a[m];
//                    m++;
//                } else {
//                    c[i] = b[n];
//                    n++;
//                }
//            } else if (m < a.length) {
//                c[i] = a[m];
//                m++;
//            } else if (n < b.length) {
//                c[i] = b[n];
//                n++;
//            }
//        }
//        //返回新的数组
//        return c;
//    }
//
//
//
//    public static int[] merge2(int[] nums1, int[] nums2) {
//        int p1 = 0, p2 = 0;
//        int m = nums1.length;
//        int n = nums2.length;
//        int[] sorted = new int[m + n];
//
//        ArrayList<Integer> nums11 = new ArrayList<>();
//        ArrayList<Integer> nums22 = new ArrayList<>();
//        for (int i = 0; i < nums1.length; i++) {
//            nums11.add(nums1[i]);
//        }
//        for (int i = 0; i < nums2.length; i++) {
//            nums22.add(nums2[i]);
//        }
//
//
//        for (int i = 0; i < sorted.length; i++) {
//
//            try {
//                Integer integer = nums11.get(i);
//            } catch (Exception e) {
//                sorted[i] = nums2[i];
//                break;
//            }
//            try {
//                Integer integer = nums22.get(i);
//            } catch (Exception e) {
//                sorted[i] = nums1[i];
//                break;
//            }
//
//
//            if (nums1[i] <= nums2[i]) {
//                sorted[i] = nums1[i];
//            } else {
//                sorted[i] = nums2[i];
//            }
//
//        }
//
//        return sorted;
//    }
//
//
//    public static List<List<Integer>> permute(int n) {
//        List<List<Integer>> result = new ArrayList<>();
//
//        if (n == 0) {
//            result.add(new ArrayList<>());
//            return result;
//        }
////
//        List<List<Integer>> prevPermutations = permute(n - 1);
//        int num = n;
//
//        for (List<Integer> prevPermutation : prevPermutations) {
//            for (int i = 0; i <= prevPermutation.size(); i++) {
//                List<Integer> permutation = new ArrayList<>(prevPermutation);
//                permutation.add(i, num);
//                result.add(permutation);
//            }
//        }
//
//        return result;
//    }
//
//    //   output
////[4, 3, 2, 1]
////[3, 4, 2, 1]
////[3, 2, 4, 1]
////[3, 2, 1, 4]
////[4, 2, 3, 1]
//// ...
//
//
//
//
////
////public ListNode reverseList(ListNode head){
////    ListNode pre = null;
////    ListNode current = head;
////
////    while(current != null){
////        //score
////        ListNode next = current.next;
////        current.next=pre;
////        //准备下一轮
////        pre=current;
////        current=next;
////    }
////    return head;
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    public static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        public TreeNode() {
//        }
//
//        public TreeNode(int val) {
//            this.val = val;
//        }
//
//        public TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
//
//
//
//
//
//
//
//    public static class ListNode {
//        int val;
//        ListNode next;
//
//        public ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//
//        public ListNode(int val) {
//            this.val = val;
//        }
//
//        public ListNode(ListNode next) {
//            this.next = next;
//        }
//
//        public ListNode() {
//        }
//    }
//
//
//}