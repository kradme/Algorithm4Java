package cn.lang.sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import edu.princeton.cs.algs4.StdDraw;

public abstract class AbsSort {
	
	public abstract void sort(Comparable<?>[] comparables);
	
	public static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b)<0;
	}
	
	public static void exch(Comparable<?>[] comparables, int a, int b) {
		Comparable<?> tmp = comparables[a];
		comparables[a]=comparables[b];
		comparables[b]=tmp;
	}
	
	public static boolean isSorted(Comparable<?>[] comparables) {
		for(int i=1;i<comparables.length;i++) {
			if(less(comparables[i],comparables[i-1])) {
				return false;
			}
		}
		return true;
		
	}
	
	public static String show(Comparable<?>[] comparables) {
		StringBuffer sb = new StringBuffer();
		for(Comparable<?> a :comparables) {
			sb.append(a+",");
		}
		return sb.toString();
	}
	
	public static String[] readIn(String path) {
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			br = new BufferedReader(new FileReader(new File(path)));
			String line = null;
			while((line=br.readLine())!=null) {
				sb.append(line.trim()+" ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(sb.length()==0) {
			return null;
		}
		String str = sb.toString();
		return str.split(" ");
	}
	
	public static Integer[] random2Sort(int bound) {
		Random ran = new Random();
		Integer[] ints = new Integer[bound];
		for(int i=0;i<bound;i++) {
			ints[i]=ran.nextInt(bound);
		}
		return ints;
	}
	
	public static void draw(Integer[] aa, int...red) {
		
		StdDraw.clear();
		int N = aa.length;
		for(int i=0;i<N;i++) {
			double x = 1.0*i/N;
			double y = aa[i]/2.0/N;
			double rw = 0.3/N;
			double rh = aa[i]/2.0/N;
			if(Arrays.binarySearch(red, i)>=0) {
				StdDraw.setPenColor(StdDraw.RED);
			}else {
				StdDraw.setPenColor(StdDraw.GRAY);
			}
			StdDraw.filledRectangle(x, y, rw, rh);
			
		}
		
	}
	/**
	 * 动画
	 * @param aa
	 * @param red
	 */
	public static void animation(Integer[] aa, int...red) {
		try {
			draw((Integer[]) aa,red);
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 动画
	 * @param aa
	 * @param red
	 */
	public static void animation(Integer[] aa, long timeInterval, int...red) {
		try {
			draw((Integer[]) aa,red);
			Thread.sleep(timeInterval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
