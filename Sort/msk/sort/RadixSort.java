package msk.sort;

/**
 * Ͱ����Ļ���˼���ǣ������� arr ����Ϊn����С��ͬ�����䣨Ͱ����ÿ������������������ϲ���
 * ����������Ͱ�����һ��������������԰Ѽ������򵱳�ÿ��Ͱ��ֻ��һ��Ԫ�ص������
 * @author MSK
 * 1.�ҳ������������е����ֵmax����Сֵmin
 * 2.����ʹ�� ��̬����ArrayList ��ΪͰ��Ͱ��ŵ�Ԫ��Ҳ�� ArrayList �洢��Ͱ������Ϊ(max-min)/arr.length+1
 * 3.�������� arr������ÿ��Ԫ�� arr[i] �ŵ�Ͱ
 * 4.ÿ��Ͱ��������
 * 5.����Ͱ���飬������õ�Ԫ�طŽ��������
 *  @param array  ����; 
 *  @param max ����array�����ֵ�ķ�Χ
 *  
 *  �㷨ʵ��һֱ�����⣬��ʱ���������лл!
 */
public class RadixSort {
	public static void buckerUp(int array[],int max){
		int[] buckets;

        if (array==null || max<1)
            return ;

        // ����һ������Ϊmax������buckets�����ҽ�buckets�е��������ݶ���ʼ��Ϊ0��
        buckets = new int[max];

        // 1. ����
        for(int i = 0; i < array.length; i++) 
            buckets[array[i]]++; 

        // 2. ����
        for (int i = 0, j = 0; i < max; i++) {
            while( (buckets[i]--) >0 ) {
                array[j++] = i;
            }
        }

        buckets = null;
	   }
}
