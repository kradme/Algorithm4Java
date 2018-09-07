package cn.lang.sort.compare;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cn.lang.sort.AbsSort;
import cn.lang.sort.InsertionSort;
import cn.lang.sort.InsertionSortWithoutSwap;
import cn.lang.sort.SelectionSort;
import cn.lang.sort.ShellSort;
import cn.lang.sort.ShellSortWithoutSwap;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
	
	public static void main(String[] args) {
		compareShow(10, 1000000,new ShellSort(), new ShellSort(), new ShellSortWithoutSwap());
	}
	
	public static void compareShow(int count, int length, AbsSort...sorts) {
		Map<String, Double> timeMap = new LinkedHashMap<>();
		List<Double[]> array = new ArrayList<Double[]>();
		for(int i=0;i<count;i++) {
			Double[] d = new Double[length];
			for(int j=0;j<length;j++) {
				d[j]=StdRandom.uniform();
			}
			array.add(d);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("======================================");
		for(AbsSort sort : sorts) {
			double sortTime = timeRandomInput(sort, array);
			String sortName = sort.getClass().getSimpleName();
			System.out.println(sortName+"耗时: "+sortTime);
			timeMap.put(sortName, sortTime);
		}
		System.out.println("===================================");
		int i = 0;
		Entry<String,Double> baseEntry = null;
		for(Map.Entry<String, Double> entry : timeMap.entrySet()) {
			if(i==0) {
				baseEntry=entry;
			}else {
				System.out.println(entry.getKey()+" is "+baseEntry.getValue()/entry.getValue()+" times faster than "+baseEntry.getKey());
			}
			i++;
		}
	}
	/**
	 * 统计耗时
	 * @param sort
	 * @param aa
	 * @return
	 */
	public static double sortTime(AbsSort sort, Double[] aa) {
		Stopwatch timer = new Stopwatch();
		sort.sort(aa);
		return timer.elapsedTime();
	}
	
	public static double timeRandomInput(AbsSort sort, List<Double[]> array) {
		double total = 0.0;
		for(Double[] a : array) {
			total += sortTime(sort, a);
		}
		return total;
	}
	

}
