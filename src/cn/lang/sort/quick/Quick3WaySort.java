package cn.lang.sort.quick;

import cn.lang.sort.AbsSort;

/**
 * 三分切分快速排序
 * @author Lang
 *
 */
public class Quick3WaySort extends AbsSort{
	public static void main(String[] args) {
		Integer[] aa = random2Sort(1000);
		AbsSort sort = new Quick3WaySort();
		sort.sort(aa);
		System.out.println(show(aa));
		System.out.println("Is Sorted? : "+isSorted(aa));
	}

	@Override
	public void sort(Comparable<?>[] comparables) {
		sort(comparables,0,comparables.length-1);
	}
	
	public void sort(Comparable<?>[] aa, int low, int high) {
		if(low>=high) {
			return;
		}
		int lt=low,gt=high,i=low+1;
		Comparable base = aa[low];
		while(i<=gt) {
			int c = base.compareTo(aa[i]);
			if(c<0) {
				exch(aa, i, gt--);
			}else if(c>0) {
				exch(aa,i++, lt++);
			}else {
				i++;
			}
		}
		sort(aa,low,lt-1);
		sort(aa,gt+1,high);
	}
	
}
