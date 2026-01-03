package JAVA.SHASHCODE.LECTURE119;

import java.util.ArrayList;
import java.util.Collections;

public class Bucket_Sort {
    public static void main(String[] args) {
        float arr[]={0.78f,0.17f,0.39f,0.26f,0.72f,0.94f,0.21f,0.12f,0.23f,0.68f};
        ArrayList<Float> res=bucketSort(arr);
        System.out.println(res);
    }

    public static float findMax(float arr[]){
        // N
        float maximum=Float.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            maximum=Math.max(maximum,arr[i]);
        }
        return maximum;
    }
    public static ArrayList<Float> bucketSort(float arr[]){
        if(arr.length==0){
            return new ArrayList<>();
        }

        // finding the bucket size
        // N
        float maxElement=findMax(arr);
        int maxIndex=(int)(maxElement*arr.length);
        int bucketSize=maxIndex+1;

        // Init bucket list
        // N
        ArrayList<Float> buckets[]=new ArrayList[bucketSize];
        for(int i=0;i<bucketSize;i++){
            buckets[i]=new ArrayList<>();
        }

        // // insert element in bucket
        // // N ^ 2
        // for(int i=0;i<arr.length;i++){
        //     int index=(int)(arr[i]*arr.length);
        //     buckets[index].add(arr[i]);
        // }

        // // sort the bucket
        // // N
        // for(int i=0;i<bucketSize;i++){
        //     Collections.sort(buckets[i]);
        // }

        // insert element in bucket USING INSERTION SORT 
        // N ^ 2
        for(int i=0;i<arr.length;i++){
            int index=(int)(arr[i]*arr.length);
            // INSERTION SORT
            int targetIndex=0;
            while(targetIndex<buckets[index].size() && arr[i]>buckets[index].get(targetIndex)){
                targetIndex++;
            }
            buckets[index].add(targetIndex,arr[i]);
        }

        // Store elements into result list
        // N * M + K
        ArrayList<Float> res=new ArrayList<>();
        for(int i=0;i<bucketSize;i++){
            System.out.println("Buckets ["+i+"] -> "+ buckets[i]);
            for(Float element:buckets[i]){
                res.add(element);
            }
        }
        return res;
    }

}
