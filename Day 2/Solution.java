import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        // declare low, middle, and high varibles to represent the left side index, the caluated middle, and the right side index
        int low = 0;
        int high = nums.length - 1;
        int middle = -1;

        // binary search while loop that stops when low <= high, this means that the target was not found
        while (low <= high)
        {
            // change middle to a calculated value which is in the middle of the low and high indexes
            middle = low + ( (high - low) / 2 );

            // if the middle value is less than the target, we cut the left side by moving low closer to target
            if (nums[middle] < target)
                low = middle + 1;    
            // if the middle value equals the target, we must now calculate the range of target duplicates
            else if (nums[middle] == target)
            {
                // we expand towards the left until we find a value that is not a duplicate
                int expandLeft = middle - 1;
                while ( (expandLeft > -1) && (nums[expandLeft] == target) )
                {
                    expandLeft--;
                }
                expandLeft++;

                // we expand towards the right until we find a value that is not a duplicate
                int expandRight = middle + 1;
                while ( (expandRight < nums.length) && (nums[expandRight] == target) )
                {
                    expandRight++;
                }
                expandRight--;

                // return the duplicate target range, [expandLeft, expandRight]
                return new int[]{expandLeft, expandRight};
            }
            // if the middle value is greater than the target, we cut the right side by moving high closer to target
            else
                high = middle - 1;
        }

        // return [-1, -1] if target was not found
        return new int[]{-1, -1};
    }
}
