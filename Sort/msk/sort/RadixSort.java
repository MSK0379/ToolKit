package msk.sort;

/**
 * 桶排序的基本思想是：把数组 arr 划分为n个大小相同子区间（桶），每个子区间各自排序，最后合并。
 * 计数排序是桶排序的一种特殊情况，可以把计数排序当成每个桶里只有一个元素的情况。
 * @author MSK
 * 1.找出待排序数组中的最大值max、最小值min
 * 2.我们使用 动态数组ArrayList 作为桶，桶里放的元素也用 ArrayList 存储。桶的数量为(max-min)/arr.length+1
 * 3.遍历数组 arr，计算每个元素 arr[i] 放的桶
 * 4.每个桶各自排序
 * 5.遍历桶数组，把排序好的元素放进输出数组
 *  @param array  数组; 
 *  @param max 数组array中最大值的范围
 *  
 *  算法实现一直有问题，暂时忽略这个，谢谢!
 */
public class RadixSort {
	public static void buckerUp(int array[],int max){
		int[] buckets;

        if (array==null || max<1)
            return ;

        // 创建一个容量为max的数组buckets，并且将buckets中的所有数据都初始化为0。
        buckets = new int[max];

        // 1. 计数
        for(int i = 0; i < array.length; i++) 
            buckets[array[i]]++; 

        // 2. 排序
        for (int i = 0, j = 0; i < max; i++) {
            while( (buckets[i]--) >0 ) {
                array[j++] = i;
            }
        }

        buckets = null;
	   }
}
