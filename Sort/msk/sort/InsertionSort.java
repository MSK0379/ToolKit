package msk.sort;

/**
 * ���������Ϊ��ֱ�Ӳ��������ϣ������
 * ֱ�Ӳ�������ÿ����һ��������ļ�¼����ؼ��ֵĴ�С�嵽ǰ���Ѿ�����������е��ʵ�λ�ã�
 * 		ֱ��ȫ����¼�������Ϊֹ��
 * 	������
 * 		void insertionUp(int[] array):������������
 * 		void insertionUp(int[] array):���齵������
 * 		int[] insertionUp(int[] array,int a)������a��array��
 *		int[] insertionDown(int[] array,int a)������a��array��
 * ϣ������Ҳ����С����������ֱ�Ӳ��������㷨��һ�ָ���Ч�ĸĽ��汾��
 * 		   ϣ�������Ƿ��ȶ������㷨��
 * 	������
 * 		void ShellUp(int[] array):������������
 * 		void ShellDown(int[] array):���齵������
 * 
 * @author MSK
 * 
 */
public final class InsertionSort {
	
	 public static void insertionUp(int[] array) {
		 if((array==null)||(array.length==0))
		        return;
		 //������������
		 for(int i=1;i<array.length;i++)//��0λ������Ϊ�������У��ӵ�1λ��ʼ������
	        {
	            if(array[i]<array[i-1])//0~i-1λΪ��������iλС��i-1λ������Ѱλ�����룬������Ϊ0~iλҲ������ģ����Դ˴�ѭ�����൱��continue
	            {
	                int temp=array[i];//�����iλ��ֵ
	                int k = i - 1;
	                for(int j=k;j>=0 && temp<array[j];j--)//�ӵ�i-1λ��ǰ��������λ��ֱ���ҵ�С�ڵ�iλֵֹͣ
	                {
	                    array[j+1]=array[j];
	                    k--;
	                }
	                array[k+1]=temp;//�����iλ��ֵ
	            }
	        } 
		 
	 }
	 public static void insertionDown(int[] array) {
		 if((array==null)||(array.length==0))
		        return;
		 //������������
		 int[] a = array.clone();
		 InsertionSort.insertionUp(a);
		 for(int i = 0; i < array.length; i++){
			 array[i] = a[array.length-i-1];
		 }
	 }
	 //����ĳ��ֵ
	 public static int[] insertionUp(int[] array,int a){
		 if((array==null)||(array.length==0))
		        return array;
		 //Ĭ��Ϊ����
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
		 //Ĭ��Ϊ����
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
	 //ϣ������
	 public static void ShellUp(int[] array){
		 if((array==null)||(array.length==0))
		        return;
	        int d=array.length;//������ʼֵ��ʹ��ʱһ��Ϊd/2��
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
		 //������������
		 int[] a = array.clone();
		 InsertionSort.ShellUp(a);
		 for(int i = 0; i < array.length; i++){
			 array[i] = a[array.length-i-1];
		 }
	 }
		 
}
