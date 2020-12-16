import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution 
{
    // This function returns a List<List<Integer>> of all unique quadruplets in int[] nums that sum up to the target integer. Time Complexity: O(n^3)
    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
        ArrayList<List<Integer>> uniqueQuadruplets = new ArrayList<List<Integer>>();
        
        // sorts int[] nums in ascending order
        Arrays.sort(nums, 0, nums.length);
        
        int first, second, leftIndex, rightIndex;

        int prevLeftVal = Integer.MIN_VALUE;
        int prevRightVal = Integer.MIN_VALUE;
        
        long quadSum = 0;
        
        for (first = 0; first < nums.length; first++)
        {
            // skips to next interation to avoid duplicate quadruplets by comparing previous index to current index
            if ( (first != 0) && (nums[first - 1] == nums[first]) ) 
                continue;
            
            for (second = first + 1; second < nums.length - 1; second++)
            {
                // skips to next interation to avoid duplicate quadruplets by comparing previous index to current index
                if ( (second != (first + 1)) && (nums[second - 1] == nums[second]) )
                    continue;
                
                // gets the two indexes to use in while loop below
                leftIndex = second + 1;
                rightIndex = nums.length - 1;
                
                // stores the previous indexes for comparision
                prevLeftVal = Integer.MIN_VALUE;
                prevRightVal = Integer.MIN_VALUE;
                
                // while loop uses two pointer technique to reduce time complexity
                while (leftIndex < rightIndex)
                {
                    // skips to enxt iteration if the left and right values are duplicates
                    if ( (prevLeftVal == nums[leftIndex]) && (prevRightVal == nums[rightIndex]) )
                    {
                        leftIndex++;
                        continue;
                    }
                    
                    //calculates the quadruple sum
                    quadSum = nums[first] + nums[second] + nums[leftIndex] + nums[rightIndex];
                    
                    // increments the left pointer if quadSum is less then target
                    if (quadSum < target)
                        leftIndex++;
                    // if quadSum is equal to target, add the lsit of values to uniqueQuadruplets and save the left and right indexs to prevLeftVal and prevRightVal
                    else if (quadSum == target)
                    {
                        prevLeftVal = nums[leftIndex];
                        prevRightVal = nums[rightIndex];
                        uniqueQuadruplets.add( Arrays.asList(nums[first], nums[second], nums[leftIndex], nums[rightIndex]) );
                        leftIndex++;
                    }
                    // decrements the right pointer if quadSUm is greater than target
                    else 
                        rightIndex--;
                }
            }
        }
        
        return uniqueQuadruplets;
    }

}