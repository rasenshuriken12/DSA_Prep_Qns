# 1. Two Sum

## ⚙️ Qn: 

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

<img src="https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png" width="100%" height="10px"/>

## 🧮 Logic:

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

- Try all possible pairs and check if their sum equals the target. 
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

- Time Complexity: Sorting(✅ Merge Sort O(nlog(n) < O(n²) Quick Sort, Bubble Sort)
- Space Complexity: Sorting(Merge Sort O(nlog(n) > O(n²) Quick Sort > O(1) Bubble Sort ✅)
- 


🟡 3) Hash Map

