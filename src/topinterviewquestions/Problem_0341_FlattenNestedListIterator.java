package topinterviewquestions;
//341. 扁平化嵌套列表迭代器
//给你一个嵌套的整数列表 nestedList 。每个元素要么是一个整数，要么是一个列表；该列表的元素也可能是整数或者是其他列表。请你实现一个迭代器将其扁平化，使之能够遍历这个列表中的所有整数。
//实现扁平迭代器类 NestedIterator ：
//NestedIterator(List<NestedInteger> nestedList) 用嵌套列表 nestedList 初始化迭代器。
//int next() 返回嵌套列表的下一个整数。
//boolean hasNext() 如果仍然存在待迭代的整数，返回 true ；否则，返回 false 。
//你的代码将会用下述伪代码检测：
//
//initialize iterator with nestedList
//res = []
//while iterator.hasNext()
//    append iterator.next() to the end of res
//return res
//如果 res 与预期的扁平化列表匹配，那么你的代码将会被判为正确。

//示例 1：
//输入：nestedList = [[1,1],2,[1,1]]
//输出：[1,1,2,1,1]
//解释：通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
import java.util.*;

//341. 扁平化嵌套列表迭代器
public class Problem_0341_FlattenNestedListIterator {


// 笔试


//方法一：深度优先搜索
//思路
//嵌套的整型列表是一个-----树形结构----，树上的叶子节点对应一个整数，非叶节点对应一个列表。
//在这棵树上深度优先搜索的顺序就是迭代器遍历的顺序。
//我们可以先遍历整个嵌套列表，将所有整数存入一个数组，然后遍历该数组从而实现
//next
//next 和
//hasNext
//hasNext 方法。


	public class NestedIterator implements Iterator<Integer> {
		private List<Integer> vals;
		private Iterator<Integer> cur;

		public NestedIterator(List<NestedInteger> nestedList) {
			vals = new ArrayList<Integer>();
			dfs(nestedList);
			cur = vals.iterator();
		}

		@Override
		public Integer next() {
			return cur.next();
		}

		@Override
		public boolean hasNext() {
			return cur.hasNext();
		}

		private void dfs(List<NestedInteger> nestedList) {
			for (NestedInteger nest : nestedList) {
				if (nest.isInteger()) {
					vals.add(nest.getInteger());
				} else {
					dfs(nest.getList());
				}
			}
		}





	}















	public interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather than a
		// nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a
		// single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a nested
		// list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}



//栈实现好理解
	//方法二：栈
	//思路:
	//我们可以用一个栈来代替方法一中的递归过程。
	//具体来说，用一个栈来维护深度优先搜索时，从根节点到当前节点路径上的所有节点。
	// 由于非叶节点对应的是一个列表，我们在栈中存储的是指向列表当前遍历的元素的指针（下标）。
	// 每次向下搜索时，取出列表的当前指针指向的元素并将其入栈，同时将该指针向后移动一位。
	//如此反复直到找到一个整数。循环时若栈顶指针指向了列表末尾，则将其从栈顶弹出。
	//下面的代码中，
	//C++ 和
	//Java
	//Java 的栈存储的是迭代器，迭代器可以起到指向元素的指针的效果，
	//链接：https://leetcode.cn/problems/flatten-nested-list-iterator/solution/bian-ping-hua-qian-tao-lie-biao-die-dai-ipjzq/

	public class NestedIterator1 implements Iterator<Integer> {
		// 存储列表的当前遍历位置
		private Deque<Iterator<NestedInteger>> stack;

		public NestedIterator1(List<NestedInteger> nestedList) {
			stack = new LinkedList<Iterator<NestedInteger>>();
			stack.push(nestedList.iterator());
		}

		@Override
		public Integer next() {
			// 由于保证调用 next 之前会调用 hasNext，直接返回栈顶列表的当前元素
			return stack.peek().next().getInteger();
		}

		@Override
		public boolean hasNext() {
			while (!stack.isEmpty()) {
				Iterator<NestedInteger> it = stack.peek();

				if (!it.hasNext()) { // 遍历到当前列表末尾，出栈
					stack.pop();
					continue;
				}

				// 若取出的元素是整数，则通过创建一个额外的列表将其重新放入栈中
				NestedInteger nest = it.next();

				if (nest.isInteger()) {
					List<NestedInteger> list = new ArrayList<NestedInteger>();
					list.add(nest);
					stack.push(list.iterator());
					return true;
				}
				stack.push(nest.getList().iterator());
			}
			return false;
		}
	}


}
