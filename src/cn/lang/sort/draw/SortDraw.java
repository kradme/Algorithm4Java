package cn.lang.sort.draw;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import cn.lang.sort.AbsSort;
import cn.lang.sort.ShellSort;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class SortDraw {
	
	public static void main(String[] args) {
		Map<Integer,Double> xy = new HashMap<Integer,Double>();
		AbsSort sort = new ShellSort();
		int minX = 0;
		int maxX = 1000000;
		int step = 20000;
		int maxY = 0;
		for(int i=minX;i<maxX;i+=step) {
			Double[] d = new Double[i];
			for(int j=0;j<i;j++) {
				d[j]=StdRandom.uniform();
			}
			long start = System.currentTimeMillis();
			sort.sort(d);
			long end = System.currentTimeMillis()-start;
			maxY = (int) end;
			xy.put(i, 1.0*end);
			System.out.println(i+" : "+end);
		}
		drawXY(xy,minX,step,maxX,maxY);
	}
	
	public static void drawXY(Map<Integer,Double> xy,int minX,int step, int maxX, int maxY) {
		StdDraw.setXscale(0, maxX);
		StdDraw.setYscale(0, maxY);
		StdDraw.setPenRadius(0.01);
		for(int i=minX;i<maxX;i+=step) {
			if(xy.containsKey(i)) {
				StdDraw.point(i, xy.get(i));;
			}
		}
	}

	
//	public static void main(String[] args) {
//			Integer[] comparables = AbsSort.random2Sort(100);
////			Comparable<?>[] comparables = readIn("data//largeW.txt");
//			AbsSort sort = new InsertionSort();
//			System.out.println("===============  排序开始    ===============");
//			long start = System.currentTimeMillis();
//			StdDraw.setCanvasSize(800, 300);
//			sort.sort(comparables);
//			System.out.println("耗时："+(System.currentTimeMillis()-start)+"ms");
//			System.out.println(AbsSort.show(comparables));
////			AbsSort.draw(comparables);
//			System.out.println("Is Sorted? : "+AbsSort.isSorted(comparables));
//	}
}
