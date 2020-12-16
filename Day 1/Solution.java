import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution 
{
    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
        ArrayList<List<Integer>> uniqueQuadruplets = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums, 0, nums.length);
        
        int first, second, leftIndex, rightIndex;

        int prevLeftVal = Integer.MIN_VALUE;
        int prevRightVal = Integer.MIN_VALUE;
        
        long quadSum = 0;
        
        for (first = 0; first < nums.length; first++)
        {
            if ( (first != 0) && (nums[first - 1] == nums[first]) ) 
                continue;
            
            for (second = first + 1; second < nums.length - 1; second++)
            {
                if ( (second != (first + 1)) && (nums[second - 1] == nums[second]) )
                    continue;
                
                leftIndex = second + 1;
                rightIndex = nums.length - 1;
                
                prevLeftVal = Integer.MIN_VALUE;
                prevRightVal = Integer.MIN_VALUE;
                
                while (leftIndex < rightIndex)
                {
                    if ( (prevLeftVal == nums[leftIndex]) && (prevRightVal == nums[rightIndex]) )
                    {
                        leftIndex++;
                        continue;
                    }
                    
                    quadSum = nums[first] + nums[second] + nums[leftIndex] + nums[rightIndex];
                    
                    if (quadSum < target)
                        leftIndex++;
                    else if (quadSum == target)
                    {
                        prevLeftVal = nums[leftIndex];
                        prevRightVal = nums[rightIndex];
                        uniqueQuadruplets.add( Arrays.asList(nums[first], nums[second], nums[leftIndex], nums[rightIndex]) );
                        leftIndex++;
                    }
                    else
                        rightIndex--;
                }
            }
        }
        
        return uniqueQuadruplets;
    }
}