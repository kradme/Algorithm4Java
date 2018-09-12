package cn.lang.sort.exec;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cn.lang.sort.AbsSort;
import cn.lang.sort.ShellSort;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class ShellExec extends AbsSort{

//	public static void main(String[] args) {
//		Map<Integer,Long> map = new TreeMap<Integer,Long>();
//		AbsSort sort = new ShellSort();
//		for(int i=10000;i<1000000;i+=10000) {
//			Double[] d = new Double[i];
//			for(int j=0;j<i;j++) {
//				d[j]=StdRandom.uniform();
//			}
//			long start = System.currentTimeMillis();
//			sort.sort(d);
//			long end = System.currentTimeMillis()-start;
//			map.put(i, end);
//			System.out.println(i+" : "+end);
//		}
//		System.out.println(map);
//		Long base = map.get(10000);
//		for(Map.Entry<Integer, Long> entry : map.entrySet()) {
//			System.out.println(entry.getKey()+":"+entry.getValue()/base+"------------"+(1.0*entry.getKey()/entry.getValue()));
//		}
//	}

	@Override
	public void sort(Comparable<?>[] aa) {
		int N = aa.length;
		int h = 1;
		while(h<N) {
			h = h*3+1;
		}
		h = h/3;
		System.out.println("h: "+h);
		while(h>=1) {
			for(int i=h;i<N;i++) {
				Comparable<?> tmp  = aa[i];
				int j = i;
				for(j=i;j>=h && less(tmp,aa[j-h]);j-=h) {
					aa[j]=aa[j-h];
				}
				aa[j]=tmp;
			}
			System.out.println(show(aa));
			h = h/3;
		}
		
	}
	
	public static void main(String[] args) {
		AbsSort sort = new ShellExec();
		Integer[] aa = new Integer[] {4,2,6,3,8,1,5,0};
		sort.sort(aa);
		System.out.println(AbsSort.show(aa));
	}
	
	
}
