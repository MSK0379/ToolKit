package msk.sort;

//Ͱ���򣺽�N�������ֳ�m��Ͱ��Ͱ֮���Ԫ�ص�����Ȼ���Ͱ�ڵ�Ԫ�ؽ�����������������Ԫ��
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
* @author Gavenyeah
* @date Time: 2016��4��20������10:12:43
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
      // �Ը���Ͱ�ڵ�list�е�Ԫ�ؽ�������
      for (int j = 0; j < bucketSize; j++) {
          insertSort(bucket[j]);// ��Ͱ�ڵ�Ԫ�ؽ�������
          printList(bucket[j]);// ���Ͱ�е�Ԫ��
      }
  }

  public void printList(List<Integer> list) {
      while (list.size() > 0) {
          System.out.print(list.remove(0) + "\t");
      }
  }

  public void insertSort(List<Integer> list) {// ��ÿ��list��������
      Collections.sort(list);
  }
}