package cn.lang.sort.merge;

import cn.lang.sort.AbsSort;

/**
 * 自顶向下的归并排序
 * 先分后合
 * @author Lang
 *
 */
public class MergeSortTop2Bottom extends AbsMergeSort{
	public static void main(String[] args) {
		Integer[] aa = new Integer[] {3,6,2,4,1,8,5,9,0};
		AbsSort sort = new MergeSortTop2Bottom();
		sort.sort(aa);
		System.out.println(show(aa));
	}
	
	

	@Override
	public void sort(Comparable<?>[] comparables) {
		aux = new Comparable[comparables.length];
		sort(comparables,0,comparables.length/2-1,comparables.length-1);
	}
	
	void sort(Comparable<?>[] aa, int low,int mid, int high) {
		if(low>mid || mid>=high) {
			return;
		}
		sort(aa,low,low+mid/2,mid);
		sort(aa,mid+1,(mid+high)/2,high);
		merge(aa, low, mid, high);
		System.out.println(show(aa));
	}

}
