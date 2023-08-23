public class MergeSolution {
    public static void mergeSort(int[] input,int start,int end){
		if(start>=end){
			return;
		}
		int mid = (start+end)/2;
        mergeSort(input,start,mid);
		mergeSort(input,mid+1,end);
		merge(input,start,end);
	}
		public static void merge(int[] input,int start,int end){
			int mid=(start+end)/2;
			int i=start;
			int j=mid+1;
			int m=mid;
			int n=end;
			int k=0;
			int[] ans = new int[end-start+1];
			while(i<=m && j<=n){
			if(	input[i]>input[j]){
					ans[k++]=input[j++];
				}
			else{
				ans[k++]=input[i++];
			}
			}
			while(i<=m){
				ans[k++]=input[i++];
			}
			while(j<=n){
				ans[k++]=input[j++];
			}
             for(int index=0;i<ans.length;i++){
				 input[start+index]=ans[index];
			 }
			}
}
