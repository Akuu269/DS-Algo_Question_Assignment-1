// Question - Sort the given Array using Merge Sort Algorithms
// Time complexity >= O(nlogn);
import java.util.*;
public class mergeSort{
    // Sort The Array
    public static int[] sortArr(int[] arr , int lo , int hi){
        // base case
        if(lo == hi){
            int[] bres = new int[1];
            bres[0] = arr[lo];
            return bres;
        }
        
        int mid = lo + (hi - lo) / 2;
        // sort from low indx To mid indx
        int[] firstHalf = sortArr(arr , lo , mid);
        // sort form mid+1 indx To high indx
        int[] secondHalf = sortArr(arr , mid + 1 , hi);

        // Call Merge two Sorted Array
        int[] res = mergeTwoSortedArr(firstHalf , secondHalf);

        return res;
        
    }

    // Merge Two Sorted Array
    public static int[] mergeTwoSortedArr(int[] arr1 , int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] resArr = new int[n1 + n2];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] <= arr2[j]){
                resArr[k] = arr1[i];
                i++;

            }
            else{
                resArr[k] = arr2[j];
                j++;
            }
            k++;

        } 
        
        while(i < arr1.length){
            resArr[k] = arr1[i];
            k++;
            i++;
        }

        while(j < arr2.length){
            resArr[k] = arr2[j];
            k++;
            j++;
        }

        return resArr;
    }
    // take Input
    public static void input(){
        int[] arr = {7 , -2 , 4 , 1 , 3 , 9 , 11 , -1 , 4 , 0};
        int lo = 0;
        int hi = arr.length - 1;
        int[] res = sortArr(arr , lo , hi);
        display(res);
    }
    // Display
    public static void display(int[] res){
        System.out.print("[ " );
        for(int i = 0 ; i < res.length - 1 ;i++){
            System.out.print( res[i] + " , ");
        }
        System.out.println(res[res.length - 1] + " ]");

    }
    public static void main(String[] args) {
        input();

        
    }
}