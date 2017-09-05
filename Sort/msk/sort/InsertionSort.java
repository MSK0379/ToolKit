package msk.sort;

/**
 * 插入排序分为：直接插入排序和希尔排序
 * 直接插入排序：每步将一个待排序的记录按其关键字的大小插到前面已经排序的序列中的适当位置，
 * 		直到全部记录插入完毕为止。
 * 	方法：
 * 		void insertionUp(int[] array):数组升序排列
 * 		void insertionUp(int[] array):数组降序排列
 * 		int[] insertionUp(int[] array,int a)：插入a到array中
 *		int[] insertionDown(int[] array,int a)：插入a到array中
 * 希尔排序：也称缩小增量排序，是直接插入排序算法的一种更高效的改进版本。
 * 		   希尔排序是非稳定排序算法。
 * 	方法：
 * 		void ShellUp(int[] array):数组升序排列
 * 		void ShellDown(int[] array):数组降序排列
 * 
 * @author MSK
 * 
 */
public final class InsertionSort {
	
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
	 public static void insertionDown(int[] array) {
		 if((array==null)||(array.length==0))
		        return;
		 //排序整个数组
		 int[] a = array.clone();
		 InsertionSort.insertionUp(a);
		 for(int i = 0; i < array.length; i++){
			 array[i] = a[array.length-i-1];
		 }
	 }
	 //插入某个值
	 public static int[] insertionUp(int[] array,int a){
		 if((array==null)||(array.length==0))
		        return array;
		 //默认为有序
		 int [] b = new int [array.length+1];
		 boolean flag = true;
		 for(int i = 0 , k =0; i < array.length; i++ , k++){
			 if(a < array[i] && flag){
				 flag = false;
				 b[k] = a;
				 k++;
			 }
			 System.out.println(k+" "+i);
			 b[k] = array[i];
		 }
		 return b;
	 }
	 public static int[] insertionDown(int[] array,int a){
		 if((array==null)||(array.length==0))
		        return array;
		 //默认为有序
		 int [] b = new int [array.length+1];
		 boolean flag = true;
		 for(int i = 0 , k =0; i < array.length; i++ , k++){
			 if(a > array[i] && flag){
				 flag = false;
				 b[k] = a;
				 k++;
			 }
			 System.out.println(k+" "+i);
			 b[k] = array[i];
		 }
		 return b;
	 }
	 //希尔排序
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
	 public static void ShellDown(int[] array) {
		 if((array==null)||(array.length==0))
		        return;
		 //排序整个数组
		 int[] a = array.clone();
		 InsertionSort.ShellUp(a);
		 for(int i = 0; i < array.length; i++){
			 array[i] = a[array.length-i-1];
		 }
	 }
		 
}
