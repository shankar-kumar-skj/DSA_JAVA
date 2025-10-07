package JAVA.SHASHCODE.LECTURE23;
// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/submissions/1788199680/
public class Book_allocation_binary_search {
    public static void main(String[] args){

    }
    public static int bookAllocation(int books[],int students){
        if(books.length<students){
            return -1;
        }
        // range will be max of array and sum of array ...
        int start=Integer.MIN_VALUE;//FOR FINDING MAX ELEMENT
        int end=0;
        for(int i=0;i<books.length;i++){
            if(books[i]>start){
                start=books[i];
            }
            end =end+books[i];
        }
        int res=-1;
        while(start<=end){
            // max pages that can be allocated to single student
            int mid=start+(end-start)/2;
            // if allocation is possible then minimize the number of pages.
            if(isAllocationPossible(books,mid,students)){
                res=mid;
                end=mid-1;
            }
            else{
               start=mid+1; 
            }
        }

        return res;
    }
    static boolean isAllocationPossible(int books[],int maxPages,int students){
       int currentStudent=1;
       int pages=0;
       for(int i=0;i<books.length;i++){
        pages+=books[i];
        // if pages exceed maxPages
        if(pages>maxPages){
            // allocated to next student
           currentStudent+=1;
           pages=books[i]; 
        }
        if(currentStudent>students){
            return false;
        }
       }
       return true;
    }
}
