# 49. Group Anagrams

## ⚙️ Problem Statement 

Given an array of strings `strs`, group the anagrams together. You can return the answer in any order.

<img src="https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png" width="100%" height="10px"/>

## 🧮 Logic

🟢 Given: An array of strings `strs`

```bash
strs = ["eat","tea","tan","ate","nat","bat"]
```

🟢 To find: Group all anagrams together

*Example:*

```bash
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
```

*Explanation:*

- "eat", "tea", "ate" are anagrams → group together
- "tan", "nat" are anagrams → group together  
- "bat" has no anagram → single group

✨ Remember:

> What is an Anagram?
> - A word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

> Two strings are anagrams, if they have:
> - Same length
> - Exact same characters with the same frequencies
> - Identical sorted versions

<img src="https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png" width="100%" height="10px"/>

## 💡 Approach 

🟡 **1) Hash Map with Sorted String as Key** ( Most Common )

- Time Complexity: O(n * m log m)  where n = number of strings, m = max length of string
- Space Complexity: O(n * m)

*Logic:*

> - Anagrams become identical when sorted alphabetically
> - Use the sorted version of each string as a key in a hash map
> - All anagrams will map to the same key
> - The hash map values will be lists of grouped anagrams

*Steps:*

1. Create an empty dictionary to map sorted string → list of anagrams
2. For each string in the input array:
   · Sort the string (convert to list, sort, join back)
   · Use the sorted string as the dictionary key
   · Append the original string to the corresponding list
3. Return all values from the dictionary as a list of lists

*Code:*

```python
def groupAnagrams(strs):
    """
    Groups anagrams using sorted string as key
    
    Example Walkthrough:
    Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
    
    Process:
    - "eat" → sorted("eat") = "aet" → dict["aet"] = ["eat"]
    - "tea" → sorted("tea") = "aet" → dict["aet"] = ["eat", "tea"]
    - "tan" → sorted("tan") = "ant" → dict["ant"] = ["tan"]
    - "ate" → sorted("ate") = "aet" → dict["aet"] = ["eat", "tea", "ate"]
    - "nat" → sorted("nat") = "ant" → dict["ant"] = ["tan", "nat"]
    - "bat" → sorted("bat") = "abt" → dict["abt"] = ["bat"]
    
    Output: Values of dict = [["eat","tea","ate"], ["tan","nat"], ["bat"]]
    """
    anagram_groups = {}
    
    for word in strs:
        # Create the key by sorting characters alphabetically
        sorted_word = ''.join(sorted(word))
        
        # Group words with the same sorted key
        if sorted_word in anagram_groups:
            anagram_groups[sorted_word].append(word)
        else:
            anagram_groups[sorted_word] = [word]
    
    # Return all grouped anagrams as a list of lists
    return list(anagram_groups.values())
```

*Example:*

```
Input: ["eat", "tea", "tan", "ate", "nat", "bat"]

Dictionary Development:
1. "eat" → "aet" → {"aet": ["eat"]}
2. "tea" → "aet" → {"aet": ["eat", "tea"]}
3. "tan" → "ant" → {"aet": ["eat", "tea"], "ant": ["tan"]}
4. "ate" → "aet" → {"aet": ["eat", "tea", "ate"], "ant": ["tan"]}
5. "nat" → "ant" → {"aet": ["eat", "tea", "ate"], "ant": ["tan", "nat"]}
6. "bat" → "abt" → {"aet": ["eat", "tea", "ate"], "ant": ["tan", "nat"], "abt": ["bat"]}

Output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
```

---

