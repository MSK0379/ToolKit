[个人博客查看原文](ttp://blog.csdn.net/android_msk/article/details/77856901)

&emsp;&emsp;排序算法可以分为内部排序和外部排序，内部排序是数据记录在内存中进行排序，而外部排序是因排序的数据很大，一次不能容纳全部的排序记录，在排序过程中需要访问外存。

&emsp;&emsp;常见的内部排序算法有：插入排序、希尔排序、选择排序、冒泡排序、归并排序、快速排序、堆排序、基数排序(笔者对其算法实现没有弄明白，在后面文章中补上)等。

![排序分类](http://osz73wqbv.bkt.clouddn.com/sort/%E6%8E%92%E5%BA%8F.png)


## 插入排序
### 直接插入排序
![直接插入排序示意图](http://osz73wqbv.bkt.clouddn.com//sort/insert-sort.gif)


&emsp;&emsp;将一个待排序的记录按其关键字的大小插到前面已经排序的序列中的适当位置，直到全部记录插入完毕为止。   

算法实现：

```java
public static void insertionUp(int[] array) {
		 if((array==null)||(array.length==0))
		        return;
		 //排序整个数组
		 for(int i=1;i<array.length;i++)//第0位独自作为有序数列，从第1位开始向后遍历
	        {
	            if(array[i]<array[i-1])//0~i-1位为有序，若第i位小于i-1位，继续寻位并插入，否则认为0~i位也是有序的，忽略此次循环，相当于continue
	            {
	                int temp=array[i];//保存第i位的值
	                int k = i - 1;
	                for(int j=k;j>=0 && temp<array[j];j--)//从第i-1位向前遍历并移位，直至找到小于第i位值停止
	                {
	                    array[j+1]=array[j];
	                    k--;
	                }
	                array[k+1]=temp;//插入第i位的值
	            }
	        } 
		 
	 }
```
### 希尔排序
![希尔排序示意图](http://osz73wqbv.bkt.clouddn.com//sort/shellsort_anim.gif)

&emsp;&emsp;希尔排序，也称递减增量排序算法，是插入排序的一种更高效的改进版本。但希尔排序是非稳定排序算法。

&emsp;&emsp;希尔排序的基本思想是：先取一个小于n的整数d1作为第一个增量，把文件的全部记录分组。所有距离为d1的倍数的记录放在同一个组中。先在各组内进行直接插入排序；然后，取第二个增量d2<d1重复上述的分组和排序，直至所取的增量  =1(  <  …<d2<d1)，即所有记录放在同一组中进行直接插入排序为止。

算法实现：

```
public static void ShellUp(int[] array){
		 if((array==null)||(array.length==0))
		        return;
	        int d=array.length;//增量初始值。使用时一般为d/2。
            while(true)
            {
                d=d/2;
                for(int x=0;x<d;x++)
                {
                    for(int i=x+d;i<array.length;i=i+d)
                    {
                        int temp=array[i];
                        int j;
                        for(j=i-d;j>=0&&array[j]>temp;j=j-d)
                        {
                        	array[j+d]=array[j];
                        }
                        array[j+d]=temp;
                    }
                }
                if(d==1)
                {
                    break;
                }
            }
	}
```
## 选择排序(Selection sort)
### 简单选择排序

![简单选择排序示意图](http://osz73wqbv.bkt.clouddn.com//sort/selection_sort_animation.gif)
&emsp;&emsp;简单选择排序也是一种简单直观的排序算法。   
算法实现：

优化的算法：每次遍历查找最大和最小两个数据。

```
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
```

### 堆排序
![堆排序示意图](http://osz73wqbv.bkt.clouddn.com//sort/Sorting_heapsort_anim.gif)

&emsp;&emsp;堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点    
&emsp;&emsp;堆排序的平均时间复杂度为Ο(nlogn) 。
算法实现：（以大顶为例）

```
//堆排序
//大顶堆
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
```
## 交换排序
### 冒泡排序
![冒泡排序示意图](http://osz73wqbv.bkt.clouddn.com//sort/bubble_sort_animation.gif)    

&emsp;&emsp;冒泡排序（Bubble Sort）也是一种简单直观的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。

算法实现：

```
public static void bubbleUp(int[] array){
		int temp = 0;
		boolean exchange = true;//若某次冒泡没有变化，则说明有序，停止循环
        for (int i = array.length - 1; i > 0&&exchange; --i)
        {
        	exchange = false;
            for (int j = 0; j < i; ++j)
            {
                if (array[j + 1] < array[j])
                {
                	exchange = true;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
```

### 快速排序
![快速排序示意图](http://osz73wqbv.bkt.clouddn.com//sort/Sorting_quicksort_anim.gif)   
&emsp;&emsp;快速排序是由东尼·霍尔所发展的一种排序算法。在平均状况下，排序 n 个项目要Ο(n log n)次比较。在最坏状况下则需要Ο(n2)次比较，但这种状况并不常见。事实上，快速排序通常明显比其他Ο(n log n) 算法更快，因为它的内部循环（inner loop）可以在大部分的架构上很有效率地被实现出来。   
基本思想是：  
&emsp;&emsp;通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。

```
	public static  void quickUp(int[] array){
		if(array.length > 8)   //数组长度短，可以选择其它排序方法
        {
			quickSort(array, 0, array.length-1);
        }else if(array.length >0){//查看数组是否为空
        	bubbleUp(array);
        }
	}
	/**
	 * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
	 * 
     * @param array 待查找数组
     * @param low   开始位置
     * @param high  结束位置
     * @return  中轴所在位置
     */
    private static int getMiddle(int[] array, int low,int high)
    {
        int temp = array[low]; //数组的第一个作为中轴
        while(low < high)
        {
        	while(low < high && array[high] >= temp)
        		high--;
        	array[low] = array[high] ;
	        while(low < high && array[low] < temp)
	            low++;
	        array[high] = array[low] ;
	    }
	    array[low] = temp ; //中轴记录到尾
        return low ; // 返回中轴的位置
    }
    /**
     * 
     * @param array 待排序数组
     * @param low  开始位置
     * @param high 结束位置
     */
    private static void quickSort(int[] array,int low,int high)
    {
        if(low < high)
        {
        	int middle = getMiddle(array,low,high); //将numbers数组进行一分为二
        	quickSort(array, low, middle-1);   //对低字段表进行递归排序
        	quickSort(array, middle+1, high); //对高字段表进行递归排序
        }
    
    }
```
## 归并排序
![归并排序示意图](http://osz73wqbv.bkt.clouddn.com//sort/merge_sort_animation2.gif)   

&emsp;&emsp;（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。

算法步骤：

1. 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序。
2. 设定两个指针，最初位置分别为两个已经排序序列的起始位置。
3. 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置。
4. 重复步骤3直到某一指针达到序列尾。
5. 将另一序列剩下的所有元素直接复制到合并序列尾。

算法实现：

```

    /** 
     * 归并排序 
     * 简介:将两个（或两个以上）有序表合并成一个新的有序表 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列 
     * 时间复杂度为O(nlogn) 
     * 稳定排序方式 
     * @param array 待排序数组 
     * @param low  low和high中low为0，high为array.length-1; 
     * @param high 数组长度
     * 	
     */  
    public static int[] mergeUp(int[] array, int low, int high) { 
        int mid = (low + high) / 2;  
        if (low < high) {  
            // 左边  
            mergeUp(array, low, mid);  
            // 右边  
            mergeUp(array, mid + 1, high);  
            // 左右归并  
            merge(array, low, mid, high);  
        }  
        return array;  
    }  
  
    public static void merge(int[] nums, int low, int mid, int high) {  
        int[] temp = new int[high - low + 1];  
        int i = low;// 左指针  
        int j = mid + 1;// 右指针  
        int k = 0;  
  
        // 把较小的数先移到新数组中  
        while (i <= mid && j <= high) {  
            if (nums[i] < nums[j]) {  
                temp[k++] = nums[i++];  
            } else {  
                temp[k++] = nums[j++];  
            }  
        }  
  
        // 把左边剩余的数移入数组  
        while (i <= mid) {  
            temp[k++] = nums[i++];  
        }  
  
        // 把右边边剩余的数移入数组  
        while (j <= high) {  
            temp[k++] = nums[j++];  
        }  
  
        // 把新数组中的数覆盖nums数组  
        for (int k2 = 0; k2 < temp.length; k2++) {  
            nums[k2 + low] = temp[k2];  
        }  
    } 

```
![image](http://osz73wqbv.bkt.clouddn.com//sort/sort_table.jpg)


---
笔者知识有限，有疑问或者错误，欢迎留言或者邮件告知。
