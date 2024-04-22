class temp
{
	public static void main(String[] args) {
		int[] arr = {1,7,5,3,2};
		int res = lins(arr,0,0);
		System.out.println(res);
	}

	public static int lins(int[] n,int index,int key)
	{
		if(index==n.length-1 && n[index]!=key)
		{
			return -1;
		}
		if(n[index]==key){
		    return index;
		}
		else
		{			
			return lins(n,index+1,key); 
		}
	}
}