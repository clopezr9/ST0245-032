
/**
 * Write a description of class Codingbat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Codingbat
{
    public boolean only14(int[] nums) {
        for(int i=0; i<nums.length ; i++){
            if(nums[i] != 1 && nums[i] != 4){
                return false;
            }
        }
        return true;
    }

    public int countEvens(int[] nums) {
        int cont = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i]%2 == 0){
                cont ++;
            }
        }return cont;
    }

    public int sum13(int[] nums) {
        int sum = 0;
        for(int i = 0; i<nums.length ; i++){
            if(nums[i]==13){
                i++;
            } else {
                sum = sum + nums[i];
            }
        }
        return sum;
    }

    public boolean lucky13(int[] nums) {
        for(int i = 0; i<nums.length ; i++){
            if(nums[i]==1 || nums[i]==3){
                return false;
            }
        }
        return true;
    }

    public int[] fizzArray(int n) {
        int [] melo = new int [n];
        for(int i = 0; i<n ; i++){
            melo[i]=i;
        }
        return melo;
    }

    //array3
    public boolean canBalance(int[] nums) {
        for (int i = 0; i < nums.length; i++) { 
            int sum = 0;
            for (int j = 0; j < i; j++){
                sum += nums[j];
            }
            for (int l = i; l < nums.length; l++){
                sum -= nums[l];
                if (sum == 0){
                    return true;
                }   
            }  
        }   
            return false;        
    }

    public boolean linearIn(int[] outer, int[] inner) {
        int indexInner = 0;
        int indexOuter = 0;
        while (indexInner < inner.length && indexOuter < outer.length) {
            if (outer[indexOuter] == inner[indexInner]) {
                indexOuter++;
                indexInner++;
            } else indexOuter++;
        }
        return (indexInner == inner.length);
    }

    public int[] seriesUp(int n) {
        int l = n*(n+1)/2;
        int [] arr = new int [l];
        int t = 0;
        for(int i = 1; i<=n ; i++){
            for(int j=1; j<=i; j++){
                arr[t]= j;
                t++;
            }
        }return arr;
    }

    public int[] fix34(int[] nums) {

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 3) {
                int temp = nums[i + 1];
                nums[i + 1] = 4;
                for (int j = i + 2; j < nums.length; j++)
                    if (nums[j] == 4) nums[j] = temp;
            }
        }
        return nums;
    }

    public int maxSpan(int[] nums) {
        int max = 0;
        for(int i=0 ; i<nums.length ; i++){
            for(int j=nums.length-1 ; j>=0 ; j--){
                if(nums[i]==nums[j]){
                    max= Math.max(max,Math.abs(i-j+1));
                }
            }
        }
        return max;
    }
}
// Referencias
// http://gregorulm.com/codingbat-java-array-3-part-i/

