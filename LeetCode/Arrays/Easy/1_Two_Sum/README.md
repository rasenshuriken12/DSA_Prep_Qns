# 1. Two Sum

## ⚙️ Qn: 

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

<img src="https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png" width="100%" height="10px"/>

## 🧮 Logic

🟢 Given: An array `nums`, A `target` number

```bash
nums[] = array of integers
target = integer
```

🟢 To find: two indices (`i`, `j`) such that:

```bash
nums[i] + nums[j] == target   # i != j
```

*Example:*

```bash
Input: nums = [2,7,11,15], target = 9
Output: [0,1]          # Because nums[0] + nums[1] == 9, we return [0, 1].
```

<img src="https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png" width="100%" height="10px"/>

## 💡 Approach 
🟡 1) Linear Search (Brute Force)

- Time Complexity: O(n²)
- Space Complexity: O(1)

*Steps:*

1. Check every possible pair in the array

2. For each element at index i, check with all elements after it (j > i)

3. If nums[i] + nums[j] == target, return [i, j]

```python
def twoSum(nums, target):
    n = len(nums)
    for i in range(n):
        for j in range(i + 1, n):
            if nums[i] + nums[j] == target:
                return [i, j]
    return []
```

🟡 2) Sorting + Two-Pointer

- Sorting( Optimal - Merge Sort )
  - Time Complexity:  Sorting(Quick Sort, Bubble Sort `O(n²)` > Merge Sort `O(nlog(n)` ✅ )
  - Space Complexity: Sorting(Quick Sort `O(nlog(n))` > Merge Sort `O(n)` ✅ > Bubble Sort `O(1)` )

- Traversal

*Steps:*

1. Sort the array (but need to preserve original indices)

2. Use two pointers: left at start, right at end

3. If sum < target → sum is too small → need larger number → move left ptr right

4. If sum > target → sum is too large → need smaller number → move right ptr left

5. If sum == target → found our pair!

6. Return original indices

```python
def twoSum(nums, target):
    indexed_nums = []     # Create list of (value, original_index)
    for i, num in enumerate(nums):
        indexed_nums.append((num, i))
    
    indexed_nums.sort()
    
    left = 0
    right = len(nums) - 1

    while left < right:
        left_val, left_idx = indexed_nums[left]
        right_val, right_idx = indexed_nums[right]
        current_sum = left_val + right_val
        
        if current_sum == target:
            return [left_idx, right_idx]
        elif current_sum < target:
            left += 1
        else:
            right -= 1
    
    return []
```
 


🟡 3) Hash Map

What is a Hash Map?
- Key-value pair data structure
- Dictionary-like structure (Python: dict, Java: HashMap, C++: unordered_map)
- Fast lookups: O(1) average time for insert/search/delete
- Uses hash function to convert keys into array indices

*Steps:*

1. Create an empty dictionary to store numbers - {number: index}

2. 

```python
def twoSum(nums, target):
    seen = {}
    for i, num in enumerate(nums):
        need = target - num
        if need in seen:
            return [seen[need], i]
        seen[num] = i
    return []
```

