package cn.lang.sort;

import edu.princeton.cs.algs4.StdDraw;

public class ShellSortWithoutSwap extends AbsSort{
	
	public static void main(String[] args) {
		Comparable<?>[] aa = random2Sort(10);
		AbsSort sort = new ShellSortWithoutSwap();
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
				Comparable<?> tmp = aa[i];
				int j=i;
				while(j>=h && less(tmp,aa[j-h])) {
					aa[j]=aa[j-h];
					j -= h;
				}
				aa[j]=tmp;
			}
			h=h/a;
		}
	}

}
