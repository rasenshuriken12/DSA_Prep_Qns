import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();  // Create a hash map to store number & index
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];        // Calculate what number we need to reach target
            
            // Check if the needed number is already in our Hash map
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};     // Found the pair! Return indices
            }
            map.put(nums[i], i);     // Store current number with its index for future reference
        }
        
        return new int[0];
    }
}
