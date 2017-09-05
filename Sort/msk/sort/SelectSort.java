package msk.sort;

public final class SelectSort {
	public static void selectUp(int[] array){
		int min ,max ,tmp;//定义两个变量
		int len = array.length;
		if((array==null)||(array.length==0))
	        return;
		 for (int i=1 ;i <= len/2;i++) { 
			  // 做不超过n/2趟选择排序   
			 min = i; max = i ; //分别记录最大和最小关键字记录位置
			 for (int j= i+1; j<= len-i; j++) {
				 if (array[j] > array[max]) {   
		                max = j ; continue ;   
		            }    
		            if (array[j]< array[min]) {   
		                min = j ;   
		            }     
			 }
			 //该交换操作还可分情况讨论以提高效率  
		      tmp = array[i-1]; array[i-1] = array[min]; array[min] = tmp;  
		      tmp = array[len-i]; array[len-i] = array[max]; array[max] = tmp;   
		  
		 }   
	}
	//用的比较少
	//大顶堆排序
	 //堆排序
	 public static int[] bigHeap(int[] array){
		 array = heapUp(array); //初始建堆，array[0]为第一趟值最大的元素
		 for(int i=array.length-1;i>1;i--){  
		 	int temp = array[0];  //将堆顶元素和堆低元素交换，即得到当前最大元素正确的排序位置
		 	array[0] = array[i];
		 	array[i] = temp;
		 	adjustDownToUp(array, 0,i);  //整理，将剩余的元素整理成堆
		 }
		return array;
	}
	private static int[] heapUp(int[] array){
		 //从最后一个节点array.length-1的父节点（array.length-1-1）/2开始，直到根节点0，反复调整堆
		 for(int i=(array.length-2)/2;i>=0;i--){ 
			 adjustDownToUp(array, i,array.length);
		 }
		 return array;
	}
	private static void adjustDownToUp(int[] array, int k, int length) {
		// TODO Auto-generated method stub
		 int temp = array[k];   
		 for(int i=2*k+1; i<length-1; i=2*i+1){    //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
			 if(i<length && array[i]<array[i+1]){  //取节点较大的子节点的下标
				 i++;   //如果节点的右孩子>左孩子，则取右孩子节点的下标
			 }
			 if(temp>=array[i]){  //根节点 >=左右子女中关键字较大者，调整结束
				 break;
			 }else{   //根节点 <左右子女中关键字较大者
			 	array[k] = array[i];  //将左右子结点中较大值array[i]调整到双亲节点上
			 	k = i; //【关键】修改k值，以便继续向下调整
			 }
		 }
		 array[k] = temp;  //被调整的结点的值放入最终位置
	}
	
}
