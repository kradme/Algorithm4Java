package cn.lang.sort.exec;

import cn.lang.sort.AbsSort;

public class MergeSortExecT2B extends AbsSort{
	
	private Comparable<?>[] aux;

	@Override
	public void sort(Comparable<?>[] aa) {
		if(aux==null || aux.length==0) {
			aux = new Comparable<?>[aa.length];
		}
		sort(aa, 0, aa.length-1);
		
	}
	public void sort(Comparable<?>[] aa, int low,int high) {
		if(low>=high) {return;}
		int mid = (low+high)/2;
		sort(aa,low,mid);
		sort(aa,mid+1,high);
		merge(aa,low,mid,high);
	}
	
	public void merge(Comparable<?>[] aa, int low, int mid, int high) {
		int i=low,j=mid+1;
		for(int a=low;a<=high;a++) {
			aux[a]=aa[a];
		}
		for(int k=low;k<=high;k++) {
			if(i>mid) {
				aa[k]=aux[j++];
			}else if(j>high){
				aa[k]=aux[i++];
			}else if(less(aux[i],aux[j])) {
				aa[k]=aux[i++];
			}else {
				aa[k]=aux[j++];
			}
		}
	}
	
	public static void main(String[] args) {
		Integer[] aa = new Integer[] {1,5,3,2,5,7,1,5,2,0};
		MergeSortExecT2B sort = new MergeSortExecT2B();
		sort.sort(aa);
		System.out.println(show(aa));
	}
	
}
