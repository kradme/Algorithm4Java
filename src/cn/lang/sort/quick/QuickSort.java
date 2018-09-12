package cn.lang.sort.quick;

import cn.lang.sort.AbsSort;
import cn.lang.sort.InsertionSort;

public class QuickSort extends AbsSort{
	
	private final static int M = 5;
	
	InsertionSort insertionSort = new InsertionSort();

	@Override
	public void sort(Comparable<?>[] comparables) {
		sort(comparables,0,comparables.length-1);
	}
	
	public void sort(Comparable<?>[] aa, int low, int high) {
//		if(low>=high ) {
//			return;
//		}
		//小数组用插入排序比快排更快
		if(low+M>=high) {
			InsertionSort.sort(aa,low,high);
			return;
		}
		int base = partition(aa, low, high);
		sort(aa,low,base-1);
		sort(aa,base+1,high);
		
	}
	
	public int partition(Comparable<?>[] aa, int low, int high) {
		int i = low, j=high+1;
		Comparable<?> tmp = aa[low];
		while(true) {
			while(less(aa[++i],tmp)) {
				if(i==high) {
					break;
				}
			}
			while(less(tmp,aa[--j])) {
				if(j==low) {
					break;
				}
			}
			if(i>=j) break;
			exch(aa,i,j);
		}
		exch(aa,low,j);
		return j;
	}
	
	public static void main(String[] args) {
		Integer[] aa = random2Sort(1000);
		QuickSort sort = new QuickSort();
		sort.sort(aa);
		System.out.println(show(aa));
		System.out.println("Is Sorted? : "+isSorted(aa));
	}
	

}

