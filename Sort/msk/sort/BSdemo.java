package msk.sort;

//桶排序：将N个数，分成m个桶，桶之间的元素递增，然后对桶内的元素进行排序，最后输出所有元素
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
* @author Gavenyeah
* @date Time: 2016年4月20日下午10:12:43
* @des:
*/
public class BSdemo {
  int bucketSize = 10;
  int arraySize = 10000;

  public static void main(String[] args) {
      BSdemo bs = new BSdemo();
      int[] array = bs.getArray();
      bs.bucketSort(array);
  }

  public int[] getArray() {
      int[] arr = new int[arraySize / 3];
      Random r = new Random();
      for (int i = 0; i < arraySize; i++) {
          arr[i] = r.nextInt(100000);
      }
      return arr;
  }

  public void bucketSort(int[] a) {
      @SuppressWarnings("unchecked")
      List<Integer> bucket[] = new ArrayList[bucketSize];
      for (int i = 0; i < a.length; i++) {
          int temp = a[i] / 10000;
          if (bucket[temp] == null) {
              bucket[temp] = new ArrayList<Integer>();
          }
          bucket[temp].add(a[i]);
      }
      // 对各个桶内的list中的元素进行排序
      for (int j = 0; j < bucketSize; j++) {
          insertSort(bucket[j]);// 对桶内的元素进行排序
          printList(bucket[j]);// 输出桶中的元素
      }
  }

  public void printList(List<Integer> list) {
      while (list.size() > 0) {
          System.out.print(list.remove(0) + "\t");
      }
  }

  public void insertSort(List<Integer> list) {// 对每个list进行排序
      Collections.sort(list);
  }
}