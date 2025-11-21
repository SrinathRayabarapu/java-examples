# Divide and Conquer Algorithms - Interview Practice

This package contains beginner to intermediate level divide and conquer problems commonly asked in technical interviews, especially for experienced Java engineers.

## Overview

Divide and Conquer is a fundamental algorithmic paradigm that:
1. **Divide**: Break the problem into smaller subproblems
2. **Conquer**: Solve the subproblems recursively
3. **Combine**: Combine the solutions to solve the original problem

## Problems Included

### 1. Power of a Number (x^n)
**File**: `PowerOfNumberMain.java`

**Problem**: Calculate x raised to the power n efficiently.

**Key Insight**: 
- x^n = (x^(n/2))^2 if n is even
- x^n = (x^(n/2))^2 * x if n is odd

**Time Complexity**: O(log n)  
**Space Complexity**: O(log n) for recursive, O(1) for iterative

**Interview Tips**:
- Handle negative exponents
- Handle edge cases (n=0, x=0, x=1)
- Discuss iterative vs recursive trade-offs

---

### 2. Find Peak Element
**File**: `FindPeakElementMain.java`

**Problem**: Find a peak element in an array (element greater than its neighbors).

**Key Insight**: Use binary search. If middle element > right neighbor, peak is in left half.

**Time Complexity**: O(log n)  
**Space Complexity**: O(1)

**Interview Tips**:
- Explain why binary search works even on unsorted array
- Handle edge cases (array boundaries)
- Discuss multiple peaks scenario

---

### 3. Count Inversions
**File**: `CountInversionsMain.java`

**Problem**: Count the number of inversions in an array (pairs where i < j and arr[i] > arr[j]).

**Key Insight**: Modified merge sort - count inversions during merge step.

**Time Complexity**: O(n log n)  
**Space Complexity**: O(n)

**Interview Tips**:
- Explain the merge sort modification
- Discuss real-world applications (collaborative filtering, ranking systems)
- Handle large numbers (use long for count)

---

### 4. Majority Element
**File**: `MajorityElementMain.java`

**Problem**: Find element that appears more than ⌊n/2⌋ times.

**Approaches**:
1. Divide and Conquer: O(n log n)
2. Boyer-Moore Voting: O(n) time, O(1) space (optimal)
3. HashMap: O(n) time, O(n) space

**Time Complexity**: O(n log n) for D&C, O(n) for Boyer-Moore  
**Space Complexity**: O(log n) for D&C, O(1) for Boyer-Moore

**Interview Tips**:
- Compare different approaches
- Explain Boyer-Moore algorithm intuition
- Discuss when to use which approach

---

### 5. Search in Rotated Sorted Array
**File**: `SearchInRotatedSortedArrayMain.java`

**Problem**: Search for target in a rotated sorted array.

**Key Insight**: Determine which half is sorted, then decide which half to search.

**Time Complexity**: O(log n)  
**Space Complexity**: O(1)

**Interview Tips**:
- Draw examples to explain the logic
- Handle duplicates (if asked)
- Discuss variations (find rotation point, search with duplicates)

---

### 6. Find First and Last Position
**File**: `FindFirstLastPositionMain.java`

**Problem**: Find starting and ending position of target in sorted array.

**Key Insight**: Two binary searches - one for first occurrence, one for last.

**Time Complexity**: O(log n)  
**Space Complexity**: O(1)

**Interview Tips**:
- Explain why two separate searches are needed
- Discuss single-pass optimization
- Handle edge cases (target not found, single occurrence)

---

### 7. Maximum Subarray Sum
**File**: `MaximumSubarraySumMain.java`

**Problem**: Find contiguous subarray with maximum sum.

**Approaches**:
1. Divide and Conquer: O(n log n)
2. Kadane's Algorithm: O(n) time, O(1) space (optimal)

**Time Complexity**: O(n log n) for D&C, O(n) for Kadane's  
**Space Complexity**: O(log n) for D&C, O(1) for Kadane's

**Interview Tips**:
- Explain the three cases in D&C (left, right, crossing)
- Compare with Kadane's algorithm
- Discuss variations (return subarray indices, handle all negatives)

---

### 8. Kth Largest Element (QuickSelect)
**File**: `KthLargestElementMain.java`

**Problem**: Find kth largest element without sorting entire array.

**Key Insight**: QuickSelect - similar to QuickSort but only recurses into relevant partition.

**Time Complexity**: O(n) average, O(n^2) worst case  
**Space Complexity**: O(1) for iterative, O(log n) for recursive

**Interview Tips**:
- Explain QuickSelect vs QuickSort
- Discuss pivot selection strategies
- Compare with heap-based approach
- Handle worst-case optimization (median-of-medians)

---

## Common Patterns

### Binary Search Pattern
Many divide and conquer problems use binary search:
- Find Peak Element
- Search in Rotated Array
- Find First/Last Position

### Merge Sort Pattern
- Count Inversions
- Maximum Subarray (crossing case)

### QuickSelect Pattern
- Kth Largest Element

## Time Complexity Analysis

| Problem | Best Case | Average Case | Worst Case | Space |
|---------|-----------|--------------|------------|-------|
| Power of Number | O(log n) | O(log n) | O(log n) | O(log n) |
| Find Peak | O(log n) | O(log n) | O(log n) | O(1) |
| Count Inversions | O(n log n) | O(n log n) | O(n log n) | O(n) |
| Majority Element (D&C) | O(n log n) | O(n log n) | O(n log n) | O(log n) |
| Search Rotated Array | O(1) | O(log n) | O(log n) | O(1) |
| First/Last Position | O(log n) | O(log n) | O(log n) | O(1) |
| Max Subarray (D&C) | O(n log n) | O(n log n) | O(n log n) | O(log n) |
| Kth Largest | O(n) | O(n) | O(n^2) | O(1) |

## Practice Tips for Interviews

1. **Start with brute force**: Always mention the naive approach first
2. **Identify the pattern**: Recognize D&C applicability
3. **Draw examples**: Visualize the problem with small examples
4. **Handle edge cases**: Empty arrays, single elements, boundaries
5. **Discuss trade-offs**: Time vs space, recursive vs iterative
6. **Optimize**: Mention better approaches if available (e.g., Kadane's for max subarray)

## Additional Problems to Practice

1. **Closest Pair of Points** (Intermediate)
2. **Strassen's Matrix Multiplication** (Advanced)
3. **Karatsuba Multiplication** (Advanced)
4. **Count of Smaller Numbers After Self** (Medium)
5. **Reverse Pairs** (Medium)
6. **Different Ways to Add Parentheses** (Medium)

## Resources

- [LeetCode Divide and Conquer Tag](https://leetcode.com/tag/divide-and-conquer/)
- [GeeksforGeeks Divide and Conquer](https://www.geeksforgeeks.org/divide-and-conquer/)
- [MIT 6.006 - Divide and Conquer](https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/)

---

**Author**: srayabar  
**Last Updated**: 2024

