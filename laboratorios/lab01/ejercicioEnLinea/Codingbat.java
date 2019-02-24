
/**
 * Write a description of class Codingbat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Codingbat
{
    // Recursion 1
    public int count7(int n) {
        if(n == 0){
            return 0;       //T(C)
        }
        if (n%10 == 7){
            return 1 + count7(n/10);   //(T(n/10))
        }
        return count7 (n/10);       //T(n/10)
    }

    public int countX(String str) {
        if (str.length()==0){
            return 0;             //O(0)
        }
        char x = 'x';
        if (str.charAt(0) ==  x){
            return 1 + countX(str.substring(1));   //O(1)
        }
        return countX(str.substring(1));         // O(1)
    }

    public int bunnyEars2(int bunnies) {
        if (bunnies == 0){ 
            return 0;          // C
        }
        if (bunnies % 2 == 1){
            return 2 + bunnyEars2(bunnies - 1);  //T(n-1)
        }
        return 3 + bunnyEars2(bunnies - 1);
    }

    public int powerN(int base, int n) {
        if (n == 0){
            return 1;      //C
        } return base * powerN(base, n - 1);  // T(n-1)
    }

    public String changePi(String str) {
        if(str.length() <= 1){ 
            return str;       //C
        }
        if(str.startsWith("pi")){
            return "3.14"+changePi(str.substring(2));    //2C
        }
        return str.charAt(0)+changePi(str.substring(1));  // 2C
    }
    // Recursion 2
    public boolean groupSum5(int start, int[] nums, int target)
    {
        if(start >= nums.length)
        {
            if(target == 0)
                return true;
            return false;
        }
        if(nums[start] % 5 == 0)
        {
            if(start < nums.length - 1 && nums[start+1] == 1){
                return groupSum5(start + 2, nums, target - nums[start]);     // T(n+2)
            }
            return groupSum5(start + 1, nums, target - nums[start]);   //T(n+1) + c
        }
        if(groupSum5(start + 1, nums, target - nums[start])){
            return true;
        }
        return groupSum5(start + 1, nums, target);     //T(n+1)
    }

    public boolean sidesAreEqual53(int[] nums, int i, int balance)
    {
        if(i == nums.length){
            return (balance == 0);
        }        //C
        if(nums[i] % 5 == 0){
            return sidesAreEqual53(nums, i + 1, balance + nums[i]);
        }  //T(n+1)+c
        if(nums[i] % 3 == 0){
            return sidesAreEqual53(nums, i + 1, balance - nums[i]);
        }
        if(sidesAreEqual53(nums, i + 1, balance + nums[i])){
            return true;
        }
        return sidesAreEqual53(nums, i + 1, balance - nums[i]);
    }

    public boolean sidesAreOdd10(int[] nums, int i, int g1, int g2)
    {
        if(i == nums.length){
            return (g1 % 2 == 1 && g2 % 10 == 0 || g2 % 2 == 1 && g1 % 10 == 0);
        }
        if(sidesAreOdd10(nums, i + 1, g1 + nums[i], g2)){  //n+1 + c
            return true;
        }
        return sidesAreOdd10(nums, i + 1, g1, g2 + nums[i]);
    }

    public boolean sidesAreEqual(int[] nums, int i, int balance)
    {
        if(i == nums.length){
            return (balance == 0);
        }
        if(sidesAreEqual(nums, i + 1, balance + nums[i])){
            return true;
        }
        return sidesAreEqual(nums, i + 1, balance - nums[i]);
    }

    public boolean groupNoAdj(int start, int[] nums, int target)
    {
        if(target == 0){
            return true;
        }
        if(start >= nums.length){
            return false;
        }
        if(groupNoAdj(start + 2, nums, target - nums[start])){
            return true;
        }
        return groupNoAdj(start + 1, nums, target);
    }

    // referencias
    // http://gregorulm.com/codingbat-java-recursion-1-part-i/
    //https://github.com/ozelentok/CodingBat-Solutions/blob/master/Java/Recursion-2.java
}

