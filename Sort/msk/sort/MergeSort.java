package msk.sort;

public class MergeSort {
    /** 
     * �鲢���� 
     * ���:�����������������ϣ������ϲ���һ���µ������ ���Ѵ��������з�Ϊ���ɸ������У�ÿ��������������ġ�Ȼ���ٰ����������кϲ�Ϊ������������ 
     * ʱ�临�Ӷ�ΪO(nlogn) 
     * �ȶ�����ʽ 
     * @param array ���������� 
     * @param low  low��high��lowΪ0��highΪarray.length-1; 
     * @param high ���鳤��
     * 	
     */  
    public static int[] mergeUp(int[] array, int low, int high) { 
        int mid = (low + high) / 2;  
        if (low < high) {  
            // ���  
            mergeUp(array, low, mid);  
            // �ұ�  
            mergeUp(array, mid + 1, high);  
            // ���ҹ鲢  
            merge(array, low, mid, high);  
        }  
        return array;  
    }  
  
    public static void merge(int[] nums, int low, int mid, int high) {  
        int[] temp = new int[high - low + 1];  
        int i = low;// ��ָ��  
        int j = mid + 1;// ��ָ��  
        int k = 0;  
  
        // �ѽ�С�������Ƶ���������  
        while (i <= mid && j <= high) {  
            if (nums[i] < nums[j]) {  
                temp[k++] = nums[i++];  
            } else {  
                temp[k++] = nums[j++];  
            }  
        }  
  
        // �����ʣ�������������  
        while (i <= mid) {  
            temp[k++] = nums[i++];  
        }  
  
        // ���ұ߱�ʣ�������������  
        while (j <= high) {  
            temp[k++] = nums[j++];  
        }  
  
        // ���������е�������nums����  
        for (int k2 = 0; k2 < temp.length; k2++) {  
            nums[k2 + low] = temp[k2];  
        }  
    } 
}
