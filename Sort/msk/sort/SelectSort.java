package msk.sort;

public final class SelectSort {
	public static void selectUp(int[] array){
		int min ,max ,tmp;//������������
		int len = array.length;
		if((array==null)||(array.length==0))
	        return;
		 for (int i=1 ;i <= len/2;i++) { 
			  // ��������n/2��ѡ������   
			 min = i; max = i ; //�ֱ��¼������С�ؼ��ּ�¼λ��
			 for (int j= i+1; j<= len-i; j++) {
				 if (array[j] > array[max]) {   
		                max = j ; continue ;   
		            }    
		            if (array[j]< array[min]) {   
		                min = j ;   
		            }     
			 }
			 //�ý����������ɷ�������������Ч��  
		      tmp = array[i-1]; array[i-1] = array[min]; array[min] = tmp;  
		      tmp = array[len-i]; array[len-i] = array[max]; array[max] = tmp;   
		  
		 }   
	}
	//�õıȽ���
	//�󶥶�����
	 //������
	 public static int[] bigHeap(int[] array){
		 array = heapUp(array); //��ʼ���ѣ�array[0]Ϊ��һ��ֵ����Ԫ��
		 for(int i=array.length-1;i>1;i--){  
		 	int temp = array[0];  //���Ѷ�Ԫ�غͶѵ�Ԫ�ؽ��������õ���ǰ���Ԫ����ȷ������λ��
		 	array[0] = array[i];
		 	array[i] = temp;
		 	adjustDownToUp(array, 0,i);  //������ʣ���Ԫ������ɶ�
		 }
		return array;
	}
	private static int[] heapUp(int[] array){
		 //�����һ���ڵ�array.length-1�ĸ��ڵ㣨array.length-1-1��/2��ʼ��ֱ�����ڵ�0������������
		 for(int i=(array.length-2)/2;i>=0;i--){ 
			 adjustDownToUp(array, i,array.length);
		 }
		 return array;
	}
	private static void adjustDownToUp(int[] array, int k, int length) {
		// TODO Auto-generated method stub
		 int temp = array[k];   
		 for(int i=2*k+1; i<length-1; i=2*i+1){    //iΪ��ʼ��Ϊ�ڵ�k�����ӣ��ؽڵ�ϴ���ӽڵ����µ���
			 if(i<length && array[i]<array[i+1]){  //ȡ�ڵ�ϴ���ӽڵ���±�
				 i++;   //����ڵ���Һ���>���ӣ���ȡ�Һ��ӽڵ���±�
			 }
			 if(temp>=array[i]){  //���ڵ� >=������Ů�йؼ��ֽϴ��ߣ���������
				 break;
			 }else{   //���ڵ� <������Ů�йؼ��ֽϴ���
			 	array[k] = array[i];  //�������ӽ���нϴ�ֵarray[i]������˫�׽ڵ���
			 	k = i; //���ؼ����޸�kֵ���Ա�������µ���
			 }
		 }
		 array[k] = temp;  //�������Ľ���ֵ��������λ��
	}
	
}
