package cn.lang.sort.exec;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cn.lang.sort.AbsSort;
import cn.lang.sort.ShellSort;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class ShellExec {

	public static void main(String[] args) {
		Map<Integer,Long> map = new TreeMap<Integer,Long>();
		AbsSort sort = new ShellSort();
		for(int i=10000;i<1000000;i+=10000) {
			Double[] d = new Double[i];
			for(int j=0;j<i;j++) {
				d[j]=StdRandom.uniform();
			}
			long start = System.currentTimeMillis();
			sort.sort(d);
			long end = System.currentTimeMillis()-start;
			map.put(i, end);
			System.out.println(i+" : "+end);
		}
		System.out.println(map);
		Long base = map.get(10000);
		for(Map.Entry<Integer, Long> entry : map.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue()/base+"------------"+(1.0*entry.getKey()/entry.getValue()));
		}
	}
}
