package msk.sort;

public final class ChangeSort {
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
	/**
	 * 基本思想是：
	 * 	通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分
	 * 	的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以
	 * 	递归进行，以此达到整个数据变成有序序列。
	 */
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
}
