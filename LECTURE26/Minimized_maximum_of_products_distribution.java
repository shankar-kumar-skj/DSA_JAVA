package JAVA.SHASHCODE.LECTURE26;

public class Minimized_maximum_of_products_distribution {
    public static void main(String [] args){

    }
    public int minimizedMaximum(int n, int[] quantities) {
        int start=1; // to avoid divide by zero error
        int end=Integer.MIN_VALUE;
        for (int i=0;i<quantities.length;i++){
            if(quantities[i]>end){
                end=quantities[i];

            }
        }
        int res=-1;
        while(start<=end){
            int mid=start +(end-start)/2;
            if(isDistributionPossible(quantities,mid,n)){
                res=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return res;
    }
    boolean isDistributionPossible(int quantities[],int maxProducts,int stores){
        int storeCount =0;
        for(int i=0;i<quantities.length;i++){
            storeCount+=quantities[i]/maxProducts;
        if(quantities[i]%maxProducts!=0){
            storeCount+=1;
        }
        if(storeCount>stores){
            return false;
        }
    }
    return true;
}
}
