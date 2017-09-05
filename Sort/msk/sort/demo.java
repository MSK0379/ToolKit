package msk.sort;

public class demo {
	public static void main(String[] args) {
		int [] a = {-1,5,8,9,0,10,8,9};
		//SortSelect.selectUp(a);
		//int [] b = MergeSort.mergeUp(a, 0, a.length-1);
		InsertionSort.ShellUp(a);
		//SelectSort.bigHeap(a);
	//	ChangeSort.quickUp(a);
		MergeSort.mergeUp(a, 0, 7);
		//RadixSort.buckerUp(a, 102);
		//SortInsertion.insertionDown(a);
		 for(int i = 0; i< a.length; i++){
				System.out.print(a[i]+" ");
		 }
	}
}
