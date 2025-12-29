import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a hash map to store number & index
        Map<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate what number we need to reach target
            int complement = target - nums[i];
            
            // Check if we've already seen this needed number
            if (map.containsKey(complement)) {
                // Found the pair! Return indices
                return new int[] {map.get(complement), i};
            }
            
            // Store current number with its index for future reference
            map.put(nums[i], i);
        }
        
        // According to problem, we should never reach here
        return new int[0];
    }
}
