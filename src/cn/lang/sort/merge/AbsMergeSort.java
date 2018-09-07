package cn.lang.sort.merge;

import cn.lang.sort.AbsSort;

/**
 * 归并排序
 * @author Lang
 *
 */
public abstract class AbsMergeSort extends AbsSort{
	
	 static Comparable<?>[] aux;

	/**
	 * 原地归并
	 * 前提是low-mid,mid-high已经是有序的
	 * @param aa
	 * @param low
	 * @param mid
	 * @param high
	 */
	public static void merge(Comparable<?>[] aa, int low, int mid, int high) {
		
		for(int i=low;i<=high;i++) {
			aux[i]=aa[i];
//			aa[i]=null;
		}
		int x=low,y=mid+1;
		for(int i=low;i<=high;i++) {
			if(x>=mid+1) {
				aa[i]=aux[y++];
			}else if(y>high) {
				aa[i]=aux[x++];
			}else if(less(aux[x],aux[y])) {
				aa[i]=aux[x++];
			}else {
				aa[i]=aux[y++];
			}
		}
	}
	
}
