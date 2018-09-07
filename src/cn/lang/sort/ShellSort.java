package cn.lang.sort;

import edu.princeton.cs.algs4.StdDraw;

public class ShellSort extends AbsSort{
	public static void main(String[] args) {
		Comparable<?>[] aa = random2Sort(10);
		AbsSort sort = new ShellSort();
//		StdDraw.setCanvasSize(800, 300);
		sort.sort(aa);
		System.out.println(show(aa));
	}
	@Override
	public void sort(Comparable<?>[] aa) {
		int a = 3;
		int length = aa.length;
		int h = 1;
		while(h<length/a) {
			h = h*a+1;
		}
		while(h>=1) {
			for(int i=h;i<length;i++) {
				for(int j=i;j>=h && less(aa[j],aa[j-h]);j -= h) {
					exch(aa,j,j-h);
//					AbsSort.animation((Integer[])aa, 300l, j,j-1);
				}
			}
			h=h/a;
		}
	}

}
