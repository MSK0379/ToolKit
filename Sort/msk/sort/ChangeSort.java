package msk.sort;

public final class ChangeSort {
	public static void bubbleUp(int[] array){
		int temp = 0;
		boolean exchange = true;//��ĳ��ð��û�б仯����˵������ֹͣѭ��
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
	 * ����˼���ǣ�
	 * 	ͨ��һ������Ҫ��������ݷָ�ɶ����������֣�����һ���ֵ��������ݶ�������һ����
	 * 	���������ݶ�ҪС��Ȼ���ٰ��˷����������������ݷֱ���п�����������������̿���
	 * 	�ݹ���У��Դ˴ﵽ�������ݱ���������С�
	 */
	public static  void quickUp(int[] array){
		if(array.length > 8)   //���鳤�ȶ̣�����ѡ���������򷽷�
        {
			quickSort(array, 0, array.length-1);
        }else if(array.length >0){//�鿴�����Ƿ�Ϊ��
        	bubbleUp(array);
        }
	}
	/**
	 * ���ҳ����ᣨĬ�������λlow������numbers�������������λ��
	 * 
     * @param array ����������
     * @param low   ��ʼλ��
     * @param high  ����λ��
     * @return  ��������λ��
     */
    private static int getMiddle(int[] array, int low,int high)
    {
        int temp = array[low]; //����ĵ�һ����Ϊ����
        while(low < high)
        {
        	while(low < high && array[high] >= temp)
        		high--;
        	array[low] = array[high] ;
	        while(low < high && array[low] < temp)
	            low++;
	        array[high] = array[low] ;
	    }
	    array[low] = temp ; //�����¼��β
        return low ; // ���������λ��
    }
    /**
     * 
     * @param array ����������
     * @param low  ��ʼλ��
     * @param high ����λ��
     */
    private static void quickSort(int[] array,int low,int high)
    {
        if(low < high)
        {
        	int middle = getMiddle(array,low,high); //��numbers�������һ��Ϊ��
        	quickSort(array, low, middle-1);   //�Ե��ֶα���еݹ�����
        	quickSort(array, middle+1, high); //�Ը��ֶα���еݹ�����
        }
    
    }
}
