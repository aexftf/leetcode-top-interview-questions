package topinterviewquestions;

import java.util.LinkedList;
//在一条环路上有 n个加油站，其中第 i个加油站有汽油gas[i]升。
//你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。
//给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。

//示1:
//输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
//输出: 3
//解释:
//从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
//开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
//开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
//开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
//开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
//开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
//因此，3 可为起始索引。
//链接：https://leetcode.cn/problems/gas-station
public class Problem_0134_GasStation {

	//总结：如果x到不了y+1（但能到y），那么从x到y的任一点出发都不可能到达y+1。
	// 因为从其中任一点出发的话，相当于从0开始加油，
	// 而如果从x出发到该点则不一定是从0开始加油，可能还有剩余的油。
	// 既然不从0开始都到不了y+1，那么从0开始就更不可能到达y+1了...

	//直观理解2，不用公式推导。可以这样想：
	// 假设从x加油站出发经过z加油站最远能到达y加油站，那么从z加油站直接出发，不可能到达y下一个加油站。
	// 因为从x出发到z加油站时肯定还有存储的油，这都到不了y的下一站，
	// 而直接从z出发刚开始是没有存储的油的，所以更不可能到达y的下一站。
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int n = gas.length;
		int i = 0;

		while (i < n) {
			int sumOfGas = 0, sumOfCost = 0;
			int cnt = 0;

			while (cnt < n) {
				int j = (i + cnt) % n;
				sumOfGas += gas[j];
				sumOfCost += cost[j];
				if (sumOfCost > sumOfGas) {
					break;
				}
				cnt++;
			}
			if (cnt == n) {
				return i;
			} else {
				i = i + cnt + 1;
			}
		}
		return -1;
	}







}