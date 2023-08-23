public class SolutionGeomatric {

	public static double findGeometricSum(int k){
		if(k==0)return 1.0;
		double small =findGeometricSum(k-1);
        if(k!=0){
		small=(double)(small+(1/(2*k)));
        System.out.print(small+" ");
        }
        return small;
	}
    public static void main(String[] args){
        int k=3;
        System.out.print(findGeometricSum(k));
    }
}
