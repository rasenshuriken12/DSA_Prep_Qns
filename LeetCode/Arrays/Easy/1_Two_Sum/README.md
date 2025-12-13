# 1. Two Sum

## ⚙️ Qn: 

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

<img src="https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png" width="100%" height="10px"/>

## 🧮 Logic

🟢 Given: An array `nums`, A `target` number

```c
nums[] = array of integers
target = integer
```

🟢 To find: two indices (i, j) such that:

```c
nums[i] + nums[j] == target   # i != j
```

<img src="https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png" width="100%" height="10px"/>

## 💡 Approach 
🟡 1) Linear Search (Brute Force)

1. Try all possible pairs and check if their sum equals the target. 

- Time Complexity: O(n²)
- Space Complexity: O(1)

```c
for (i = 0; i < n; i++) {
    for (j = i + 1; j < n; j++) {
        if (nums[i] + nums[j] == target) {
            printf("[%d, %d]", i, j);
            return;
        }
    }
}

```

🟡 2) Sorting + Two-Pointer

*Steps:*

1. Sort the array (but need to preserve original indices)

2. Use two pointers: left at start, right at end

3. If sum < target → sum is too small → need larger number → move left right

4. If sum > target → sum is too large → need smaller number → move right left

5. If sum == target → found our pair!

6. Return original indices

- Sorting( Optimal - Merge Sort )
  - Time Complexity:  Sorting(Quick Sort, Bubble Sort O(n²) > Merge Sort O(nlog(n) ✅ )
  - Space Complexity: Sorting(Quick Sort O(nlog(n)) > Merge Sort O(n) > Bubble Sort O(1) ✅ )


- Traversal 


🟡 3) Hash Map

