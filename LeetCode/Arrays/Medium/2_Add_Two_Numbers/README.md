# 2. Add Two Numbers

## ⚙️ Problem Statement

You are given two **non-empty linked lists** representing two **non-negative integers**.  
The digits are stored in **reverse order**, and each of their nodes contains a **single digit**.  
Add the two numbers and return the sum **as a linked list**.

You may assume the two numbers do **not** contain any leading zero, except the number `0` itself.

<img src="https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png" width="100%" height="10px">

## 🧮 Logic

### 📊 Input Format

- `l1`: Linked list representing the first number (digits in reverse order)
- `l2`: Linked list representing the second number (digits in reverse order)
- Each node contains single digit (0–9) numbers. Digits are stored backwards (units digit first)

### 🔁 Example
```bash
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8] → (807 in reverse order)   # 342 + 465 = 807

  Step 1: 2 + 5 = 7       (no carry)  → [7]
  Step 2: 4 + 6 = 10      (carry 1)   → [7,0]
  Step 3: 3 + 4 + 1 = 8   (carry 0)   → [7,0,8]
  
Result: [7,0,8] represents 807 (342 + 465 = 807 ✓)
```

### 🎯 Key Points
- Numbers are stored in **reverse order** (units digit at head)
- No leading zeros except for the number `0` itself
- Handle **different list lengths**
- Manage **carry-over** when sum ≥ 10

<img src="https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png" width="100%" height="10px">

---

## 💡 Approach & Algorithm

### 🟢 **Optimal Solution: Digit-by-Digit Addition with Carry**
- **Time Complexity**: `O(max(m, n))` where m,n are lengths of lists
- **Space Complexity**: `O(max(m, n))` for the result list

### 📝 Steps:
1. **Initialize**:
   - `dummy` node to simplify result building
   - `current` pointer to build result list
   - `carry = 0`

2. **Traverse both lists** while either has nodes or carry exists:
   - Get values from current nodes (0 if node is `null`)
   - Calculate `sum = val1 + val2 + carry`
   - Update `carry = sum // 10`
   - Create new node with digit = `sum % 10`
   - Move pointers forward

3. **Return** `dummy.next` (skip dummy head)

---

## 🔧 Implementation

### **Python Solution**
```python
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)  # Dummy head to simplify
        current = dummy
        carry = 0
        
        # Traverse both lists
        while l1 or l2 or carry:
            # Get values (0 if list exhausted)
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0
            
            # Calculate sum and carry
            total = val1 + val2 + carry
            carry = total // 10
            digit = total % 10
            
            # Create new node
            current.next = ListNode(digit)
            current = current.next
            
            # Move to next nodes if available
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next
        
        return dummy.next  # Skip dummy head
```

<img src="https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png" width="100%" height="10px">

---

## 🧪 Test Cases

| Test Case | Input (l1 → l2) | Expected Output | Explanation |
|-----------|----------------|-----------------|-------------|
| **TC1** | [2,4,3] + [5,6,4] | [7,0,8] | 342 + 465 = 807 |
| **TC2** | [0] + [0] | [0] | 0 + 0 = 0 |
| **TC3** | [9,9,9,9,9,9] + [9,9,9,9] | [8,9,9,9,0,0,1] | 999999 + 9999 = 1009998 |
| **TC4** | [5] + [5] | [0,1] | 5 + 5 = 10 |

---

## 📊 Complexity Analysis

| Approach | Time | Space | Remarks |
|----------|------|-------|---------|
| **Digit-by-Digit** | `O(max(m,n))` | `O(max(m,n))` | ✅ Optimal |
| **Convert to Int** | `O(m+n)` | `O(1)` | ❌ Integer overflow for large numbers |
| **Recursive** | `O(max(m,n))` | `O(max(m,n))` | ⚠️ Stack overhead |

---

## 🎯 Key Insights
1. **Reverse order simplifies addition** → we add from least significant digit
2. **Carry handling** is crucial when sum ≥ 10
3. **Edge cases**: Different list lengths, final carry (e.g., 5+5=10)
4. **Dummy node pattern** simplifies linked list construction

---

## 🔗 Related Problems
- **445. Add Two Numbers II** (Digits in forward order)
- **67. Add Binary** (Binary string addition)
- **415. Add Strings** (String number addition)

---
