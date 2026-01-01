# Data Structures and Algorithms Module

This module provides comprehensive implementations of fundamental data structures and algorithms in Java, covering interview preparation and competitive programming topics.

## Module Overview

The `ds-algo` module is a comprehensive collection of:
- Classic data structure implementations
- Sorting and searching algorithms
- Dynamic programming solutions
- Graph algorithms
- Common interview problems and puzzles

## Package Structure

### Core Data Structures (`com.dsalgo.datastructures`)

| Data Structure | Description |
|----------------|-------------|
| `BinarySearchTree` | BST with insert, delete, search operations |
| `AVLTree` | Self-balancing BST |
| `RedBlackTree` | Self-balancing BST with color properties |
| `BinaryHeap` | Min/Max heap implementation |
| `HashMap` | Hash table with collision handling |
| `Graph` | Graph representation and algorithms |
| `Trie` / `TrieMap` | Prefix tree for string operations |
| `SegmentTree` | Range query data structure |
| `Queue` / `Stack` | FIFO and LIFO implementations |
| `SkipList` | Probabilistic alternative to balanced trees |

### Algorithms by Category

#### Arrays (`com.dsalgo.arrays`)
- Two pointer techniques
- Sliding window problems
- Kadane's algorithm (maximum subarray)
- Array rotation and manipulation
- Finding duplicates, missing elements

#### Sorting (`com.dsalgo.sort`)

| Algorithm | Time (Avg) | Time (Worst) | Space | Stable |
|-----------|------------|--------------|-------|--------|
| `BubbleSort` | O(n²) | O(n²) | O(1) | Yes |
| `InsertionSort` | O(n²) | O(n²) | O(1) | Yes |
| `MergeSort` | O(n log n) | O(n log n) | O(n) | Yes |
| `QuickSort` | O(n log n) | O(n²) | O(log n) | No |
| `HeapSort` | O(n log n) | O(n log n) | O(1) | No |
| `CountingSort` | O(n+k) | O(n+k) | O(k) | Yes |
| `RadixSort` | O(nk) | O(nk) | O(n+k) | Yes |

#### Searching (`com.dsalgo.search`)
- Binary Search and variants
- Linear Search
- Interpolation Search
- Jump Search
- Exponential Search

#### Linked Lists (`com.dsalgo.linkedlist`)
- Singly and Doubly linked lists
- Circular linked lists
- Reverse a linked list (iterative/recursive)
- Detect and remove cycles
- Find middle element
- Merge sorted lists
- Palindrome check

#### Trees (`com.dsalgo.trees`)
- Tree traversals (Inorder, Preorder, Postorder, Level-order)
- Height and depth calculations
- Lowest Common Ancestor (LCA)
- Diameter of tree
- Check if BST
- Serialize/Deserialize

#### Graphs (`com.dsalgo.graph`)
- BFS (Breadth-First Search)
- DFS (Depth-First Search)
- Dijkstra's shortest path
- Topological sorting
- Cycle detection
- Connected components

#### Dynamic Programming (`com.dsalgo.dynamicprog`)
- Fibonacci variations
- Climbing stairs
- Frog jump problems
- Grid traveler
- Subset sum (CanSum, HowSum)
- Jump game

#### Divide and Conquer (`com.dsalgo.divideandconquer`)
- Power of a number (x^n)
- Search in rotated sorted array
- Find peak element
- Kth largest element
- Maximum subarray sum
- Count inversions
- Majority element

#### Stacks and Queues (`com.dsalgo.stacksnqueues`)
- Stack implementations
- Queue using stacks
- Balanced parentheses
- Next greater element
- Min stack

#### Strings (`com.dsalgo.strings`)
- String manipulation
- Anagram detection
- Palindrome variations
- String compression
- Pattern matching

#### Hashing (`com.dsalgo.hashing`)
- Two sum problem
- Group anagrams
- First non-repeating character
- Subarray with given sum

### Puzzles and Interview Problems (`com.puzzles`)
- Fibonacci series
- Palindrome variations
- FizzBuzz
- Stock buy/sell problems
- Container with most water
- Trapping rain water
- Meeting room scheduling

### Caches (`com.dsalgo.caches`)
- LRU (Least Recently Used) Cache
- MRU (Most Recently Used) Cache

## Prerequisites

- **Java 17** or higher
- **Maven 3.6+**

## Building the Module

```bash
# From the root project directory
mvn clean install -pl ds-algo

# Or from the ds-algo directory
cd ds-algo
mvn clean install
```

## Running Examples

Each algorithm/data structure has a Main class:

```bash
# Run QuickSort example
mvn compile exec:java -Dexec.mainClass="com.dsalgo.sort.QuickSortRecursionSinglePivotMain"

# Run Linked List Reversal
mvn compile exec:java -Dexec.mainClass="com.dsalgo.linkedlist.ReverseLinkedListMain"

# Run Binary Search Tree
mvn compile exec:java -Dexec.mainClass="com.dsalgo.trees.BinarySearchTreeMain"

# Run LRU Cache
mvn compile exec:java -Dexec.mainClass="com.dsalgo.caches.LRUCacheMain"
```

## Running Tests

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=MergeSortDemoVogellaTest
```

## Big-O Complexity Reference

### Common Time Complexities

| Notation | Name | Example |
|----------|------|---------|
| O(1) | Constant | Array access, hash lookup |
| O(log n) | Logarithmic | Binary search |
| O(n) | Linear | Linear search |
| O(n log n) | Linearithmic | Merge sort, Quick sort (avg) |
| O(n²) | Quadratic | Bubble sort, nested loops |
| O(2^n) | Exponential | Recursive Fibonacci (naive) |

### Space Complexity Tips
- Recursive algorithms use O(depth) stack space
- In-place algorithms use O(1) extra space
- Dynamic programming often trades space for time

## Study Guide

### For Beginners
1. Start with Arrays and Strings
2. Learn basic sorting (Bubble, Insertion)
3. Understand linked list operations
4. Practice recursion with simple problems

### For Interviews
1. Master Binary Search patterns
2. Know all sorting algorithm trade-offs
3. Practice Two Pointers and Sliding Window
4. Understand Dynamic Programming patterns
5. Graph traversal (BFS/DFS) is essential

### For Competitive Programming
1. Segment Trees, Fenwick Trees
2. Advanced graph algorithms
3. String algorithms (KMP, Rabin-Karp)
4. Number theory basics

## Dependencies

- Gson (for JSON operations in some examples)
- JUnit (for testing)
- Lombok (for reducing boilerplate)

## Related Modules

- `core-java` - Uses this module for data structure examples
- `lld` - Applies algorithms in low-level design problems

