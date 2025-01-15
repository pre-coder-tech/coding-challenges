package io.github.precodertech.codingjava;

public class FindTriplets {
    public static void main(String[] args) {
        /** Find Triplets i.e. those 3 number groups from the int array provided which sums up to 0 */

        getList(new int[] {1,0,-1,-4,2,-1});
        System.out.println("-------------------------");
        getList(new int[] {1,0});
        System.out.println("-------------------------");
        getList(new int[] {1,0,-1});
        System.out.println("-------------------------");
        getList(new int[] {1,0,-1,-4,2,-1,-2,-4,0,-5,5});
    }
    
    static void getList(int[] nums) {
        int startIndex = 0;
        int midIndex = startIndex + 1;
        int lastIndex = midIndex + 1;
        if(nums.length < 3) {
            System.out.println("List smaller than 3");
        } else if (nums.length == 3) {
            if(nums[0] + nums[1] + nums[2] == 0) {
                System.out.println(nums[0] + " " + nums[1] + " " + nums[2]);
            }
        } else {
            while (startIndex < nums.length-2) {
                if(nums[startIndex] + nums[midIndex] + nums[lastIndex] == 0) {
                    System.out.println(nums[startIndex] + " " + nums[midIndex] + " " + nums[lastIndex]);
                } 
                if(lastIndex == nums.length -1) {
                    if(midIndex == nums.length - 2) {
                        startIndex++;
                        midIndex = startIndex + 1;
                    } else {
                        midIndex++;
                    }
                    lastIndex = midIndex + 1;
                } else {
                    lastIndex++;
                }
                
            }
        }
    }
}
