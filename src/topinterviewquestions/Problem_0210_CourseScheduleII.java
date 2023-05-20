package topinterviewquestions;

import java.util.*;

public class Problem_0210_CourseScheduleII {







	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] ans = new int[numCourses];
		Map<Integer, List<Integer>> graph = new HashMap<>();
		int[] indegree = new int[numCourses];

		// 根据prerequisites初始化indegree[]和graph
		for(int[] ab : prerequisites){
			int a = ab[0]; // b是a的先修课程，b指向a
			int b = ab[1];
			indegree[a]++; // a的入度加1

			// 将a作为b的邻接顶点加入到b的邻接表中
			List<Integer> adjs = graph.getOrDefault(b, new ArrayList<>());
			adjs.add(a);
			graph.put(b, adjs);
		}
		// 找到入度为0的顶点并入队
		int count = 0;
		Deque<Integer> q = new ArrayDeque<>();
		for(int i = 0; i < numCourses; i++){
			if(indegree[i] == 0) {
				q.add(i);
				ans[count++] = i; // 入度为0的顶点可以先输出到ans
			}
		}
		// 拓扑排序
		while(!q.isEmpty()){
			int u = q.remove();
			List<Integer> adjs = graph.get(u);
			if(adjs != null){ // 图不连通时，有的顶点可能无邻接顶点
				for(int v : graph.get(u)){
					indegree[v]--; // u的邻接顶点v入度减1
					if(indegree[v] == 0){
						q.add(v);
						ans[count++] = v; // 入度减为0时输出到ans
					}
				}
			}
		}
		return count == numCourses ? ans : new int[]{};
	}











	public static class Node {
		public int name;
		public int in;
		public ArrayList<Node> nexts;

		public Node(int n) {
			name = n;
			in = 0;
			nexts = new ArrayList<>();
		}
	}

	public int[] findOrder1(int numCourses, int[][] prerequisites) {
		int[] ans = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			ans[i] = i;
		}

		if (prerequisites == null || prerequisites.length == 0) {
			return ans;
		}

		HashMap<Integer, Node> nodes = new HashMap<>();

		for (int[] arr : prerequisites) {
			int to = arr[0];
			int from = arr[1];

			if (!nodes.containsKey(to)) {
				nodes.put(to, new Node(to));
			}
			if (!nodes.containsKey(from)) {
				nodes.put(from, new Node(from));
			}
			Node t = nodes.get(to);
			Node f = nodes.get(from);
			f.nexts.add(t);
			t.in++;
		}
		int index = 0;

		Queue<Node> zeroInQueue = new LinkedList<>();

		for (int i = 0; i < numCourses; i++) {
			if (!nodes.containsKey(i)) {
				ans[index++] = i;
			} else {
				if (nodes.get(i).in == 0) {
					zeroInQueue.add(nodes.get(i));
				}
			}
		}
		int needPrerequisiteNums = nodes.size();
		int count = 0;

		while (!zeroInQueue.isEmpty()) {
			Node cur = zeroInQueue.poll();
			ans[index++] = cur.name;
			count++;

			for (Node next : cur.nexts) {
				if (--next.in == 0) {
					zeroInQueue.add(next);
				}
			}
		}
		return count == needPrerequisiteNums ? ans : new int[0];
	}

}
