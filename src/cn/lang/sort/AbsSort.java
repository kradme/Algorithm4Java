package cn.lang.sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class AbsSort {
	
	abstract <T> void sort(Comparable<T>[] comparables);
	
	public static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b)<0;
	}
	
	public static boolean isSorted(Comparable<?>[] comparables) {
		for(int i=1;i<comparables.length;i++) {
			if(!less(comparables[i],comparables[i-1])) {
				return false;
			}
		}
		return true;
		
	}
	
	public static String show(Comparable<?>[] comparables) {
		StringBuffer sb = new StringBuffer();
		for(Comparable<?> a :comparables) {
			sb.append("["+a+"]");
		}
		return sb.toString();
	}
	
	public String[] readIn(String path) {
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
}
