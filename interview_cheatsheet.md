## Cheatsheet for interviews

This list is meant to be a both a quick guide and reference for further research into these topics.  It's basically a summary of that comp sci course you never took or forgot about, so there's no way it can cover everything in depth.

## Other good Cheatsheets / TODOs
https://heapclub.gitbook.io/heapclub-algorithms/interview-preparation/important-topics

## Data Structure Basics

###**Array**
####Definition:
- Stores data elements based on an sequential, most commonly 0 based, index.
- Based on [tuples](http://en.wikipedia.org/wiki/Tuple) from set theory.
- They are one of the oldest, most commonly used data structures.  
  
####What you need to know:
- Optimal for indexing; bad at searching, inserting, and deleting (except at the end).
- **Linear arrays**, or one dimensional arrays, are the most basic.
  - Are static in size, meaning that they are declared with a fixed size.
- **Dynamic arrays** are like one dimensional arrays, but have reserved space for additional elements.
  - If a dynamic array is full, it copies it's contents to a larger array.
- **Two dimensional arrays** have x and y indices like a grid or nested arrays.  
  
####Big O efficiency:
- Indexing:         Linear array: O(1),      Dynamic array: O(1)
- Search:           Linear array: O(n),      Dynamic array: O(n)
- Optimized Search: Linear array: O(log n), Dynamic array: O(log n)
- Insertion:        Linear array: n/a        Dynamic array: O(n)
  

###**Linked List**
####Definition: 
- Stores data with **nodes** that point to other nodes.
  - Nodes, at its most basic it has one datum and one reference (another node).
  - A linked list _chains_ nodes together by pointing one node's reference towards another node.  

####What you need to know:
- Designed to optimize insertion and deletion, slow at indexing and searching.
- **Doubly linked list** has nodes that reference the previous node.
- **Circularly linked list** is simple linked list whose **tail**, the last node, references the **head**, the first node.
- **Stack**, commonly implemented with linked lists but can be made from arrays too.
  - Stacks are **last in, first out** (LIFO) data structures.
  - Made with a linked list by having the head be the only place for insertion and removal.
- **Queues**, too can be implemented with a linked list or an array.
  - Queues are a **first in, first out** (FIFO) data structure.
  - Made with a doubly linked list that only removes from head and adds to tail.  

####Big O efficiency:
- Indexing:         Linked Lists: O(n)
- Search:           Linked Lists: O(n)
- Optimized Search: Linked Lists: O(n)
- Insertion:        Linked Lists: O(1)  


###**Hash Table or Hash Map**
####Definition: 
- Stores data with key value pairs.
- **Hash functions** accept a key and return an output unique only to that specific key. 
  - This is known as **hashing**, which is the concept that an input and an output have a one-to-one correspondence to map information.
  - Hash functions return a unique address in memory for that data.

####What you need to know:
- Designed to optimize searching, insertion, and deletion.
- **Hash collisions** are when a hash function returns the same output for two distinct inputs.
  - All hash functions have this problem.
  - This is often accommodated for by having the hash tables be very large.
- Hashes are important for associative arrays and database indexing.

####Big O efficiency:
- Indexing:         Hash Tables: O(1)
- Search:           Hash Tables: O(1)
- Insertion:        Hash Tables: O(1)  


###**Binary Tree**
####Definition: 
- Is a tree like data structure where every node has at most two children.
  - There is one left and right child node.

####What you need to know:
- Designed to optimize searching and sorting.
- A **degenerate tree** is an unbalanced tree, which if entirely one-sided is a essentially a linked list.
- They are comparably simple to implement than other data structures.
- Used to make **binary search trees**.
  - A binary tree that uses comparable keys to assign which direction a child is.
  - Left child has a key smaller than it's parent node.
  - Right child has a key greater than it's parent node.
  - There can be no duplicate node.
  - Because of the above it is more likely to be used as a data structure than a binary tree.

####Big O efficiency:
- Indexing:  Binary Search Tree: O(log n)
- Search:    Binary Search Tree: O(log n)
- Insertion: Binary Search Tree: O(log n) 


## Search Basics
###**Breadth First Search**
####Definition:
- An algorithm that searches a tree (or graph) by searching levels of the tree first, starting at the root.
  - It finds every node on the same level, most often moving left to right. 
  - While doing this it tracks the children nodes of the nodes on the current level.
  - When finished examining a level it moves to the left most node on the next level.
  - The bottom-right most node is evaluated last (the node that is deepest and is farthest right of it's level). 

####What you need to know:
- Optimal for searching a tree that is wider than it is deep.
- Uses a queue to store information about the tree while it traverses a tree.
  - Because it uses a queue it is more memory intensive than **depth first search**.
  - The queue uses more memory because it needs to stores pointers
  
####Big O efficiency:
- Search: Breadth First Search: O(|E| + |V|)
- E is number of edges
- V is number of vertices

###**Depth First Search**
####Definition:
- An algorithm that searches a tree (or graph) by searching depth of the tree first, starting at the root.
  - It traverses left down a tree until it cannot go further.
  - Once it reaches the end of a branch it traverses back up trying the right child of nodes on that branch, and if possible left from the right children.
  - When finished examining a branch it moves to the node right of the root then tries to go left on all it's children until it reaches the bottom.
  - The right most node is evaluated last (the node that is right of all it's ancestors). 
  
####What you need to know:
- Optimal for searching a tree that is deeper than it is wide.
- Uses a stack to push nodes onto.
  - Because a stack is LIFO it does not need to keep track of the nodes pointers and is therefore less memory intensive than breadth first search.
  - Once it cannot go further left it begins evaluating the stack.
  
####Big O efficiency:
- Search: Depth First Search: O(|E| + |V|)
- E is number of edges
- V is number of vertices


####Breadth First Search Vs. Depth First Search
- The simple answer to this question is that it depends on the size and shape of the tree.
  - For wide, shallow trees use Breadth First Search
  - For deep, narrow trees use Depth First Search

####Nuances:
  - Because BFS uses queues to store information about the nodes and its children, it could use more memory than is available on your computer.  (But you probably won't have to worry about this.)
  - If using a DFS on a tree that is very deep you might go unnecessarily deep in the search. See [xkcd](http://xkcd.com/761/) for more information.
  - Breadth First Search tends to be a looping algorithm.
  - Depth First Search tends to be a recursive algorithm.


## Efficient Sorting Basics
###**Merge Sort**
####Definition:
- A comparison based sorting algorithm
  - Divides entire dataset into groups of at most two.
  - Compares each number one at a time, moving the smallest number to left of the pair.
  - Once all pairs sorted it then compares left most elements of the two leftmost pairs creating a sorted group of four with the smallest numbers on the left and the largest ones on the right. 
  - This process is repeated until there is only one set.

####What you need to know:
- This is one of the most basic sorting algorithms.
- Know that it divides all the data into as small possible sets then compares them.

####Big O efficiency:
- Best Case Sort: Merge Sort: O(n)
- Average Case Sort: Merge Sort: O(n log n)
- Worst Case Sort: Merge Sort: O(n log n)

###**Quicksort**
####Definition:
- A comparison based sorting algorithm
  - Divides entire dataset in half by selecting the average element and putting all smaller elements to the left of the average.
  - It repeats this process on the left side until it is comparing only two elements at which point the left side is sorted.
  - When the left side is finished sorting it performs the same operation on the right side.
- Computer architecture favors the quicksort process.

####What you need to know:
- While it has the same Big O as (or worse in some cases) many other sorting algorithms it is often faster in practice than many other sorting algorithms, such as merge sort.
- Know that it halves the data set by the average continuously until all the information is sorted.

####Big O efficiency:
- Best Case Sort: Merge Sort: O(n)
- Average Case Sort: Merge Sort: O(n log n)
- Worst Case Sort: Merge Sort: O(n^2)

###**Bubble Sort**
####Definition:
- A comparison based sorting algorithm
  - It iterates left to right comparing every couplet, moving the smaller element to the left.
  - It repeats this process until it no longer moves and element to the left.

####What you need to know:
- While it is very simple to implement, it is the least efficient of these three sorting methods.
- Know that it moves one space to the right comparing two elements at a time and moving the smaller on to left.

####Big O efficiency:
- Best Case Sort: Merge Sort: O(n)
- Average Case Sort: Merge Sort: O(n^2)
- Worst Case Sort: Merge Sort: O(n^2)

####Merge Sort Vs. Quicksort
- Quicksort is likely faster in practice.
- Merge Sort divides the set into the smallest possible groups immediately then reconstructs the incrementally as it sorts the groupings.
- Quicksort continually divides the set by the average, until the set is recursively sorted.

## Basic Types of Algorithms
###**Recursive Algorithms**
####Definition:
- An algorithm that calls itself in its definition.
  - **Recursive case** a conditional statement that is used to trigger the recursion.
  - **Base case** a conditional statement that is used to break the recursion.

####What you need to know:
- **Stack level too deep** and **stack overflow**.
  - If you've seen either of these from a recursive algorithm, you messed up.
  - It means that your base case was never triggered because it was faulty or the problem was so massive you ran out of RAM before reaching it.
  - Knowing whether or not you will reach a base case is integral to correctly using recursion.
  - Often used in Depth First Search


###**Iterative Algorithms**
####Definition:
- An algorithm that is called repeatedly but for a finite number of times, each time being a single iteration.
  - Often used to move incrementally through a data set.

####What you need to know:
- Generally you will see iteration as loops, for, while, and until statements.
- Think of iteration as moving one at a time through a set.
- Often used to move through an array.

####Recursion Vs. Iteration
- The differences between recursion and iteration can be confusing to distinguish since both can be used to implement the other. But know that,
  - Recursion is, usually, more expressive and easier to implement.
  - Iteration uses less memory.
- **Functional languages** tend to use recursion. (i.e. Haskell)
- **Imperative languages** tend to use iteration. (i.e. Ruby)
- Check out this [Stack Overflow post](http://stackoverflow.com/questions/19794739/what-is-the-difference-between-iteration-and-recursion) for more info.

####Pseudo Code of Moving Through an Array (this is why iteration is used for this)
```
Recursion                         | Iteration
----------------------------------|----------------------------------
recursive method (array, n)       | iterative method (array)
  if array[n] is not nil          |   for n from 0 to size of array
    print array[n]                |     print(array[n])
    recursive method(array, n+1)  |
  else                            |
    exit loop                     |
```
###**Greedy Algorithm**
####Definition:
- An algorithm that, while executing, selects only the information that meets a certain criteria.
- The general five components, taken from [Wikipedia](http://en.wikipedia.org/wiki/Greedy_algorithm#Specifics):
  - A candidate set, from which a solution is created.
  - A selection function, which chooses the best candidate to be added to the solution.
  - A feasibility function, that is used to determine if a candidate can be used to contribute to a solution.
  - An objective function, which assigns a value to a solution, or a partial solution.
  - A solution function, which will indicate when we have discovered a complete solution.

####What you need to know:
- Used to find the optimal solution for a given problem.
- Generally used on sets of data where only a small proportion of the information evaluated meets the desired result.
- Often a greedy algorithm can help reduce the Big O of an algorithm.

####Pseudo Code of a Greedy Algorithm to Find Largest Difference of any Two Numbers in an Array.
```
greedy algorithm (array)
  var largest difference = 0
  var new difference = find next difference (array[n], array[n+1])
  largest difference = new difference if new difference is > largest difference
  repeat above two steps until all differences have been found
  return largest difference
```

This algorithm never needed to compare all the differences to one another, saving it an entire iteration.



​

I have done about 250 Leetcode problems in all problem categories and read the fantastic book "Elements of Programming Interviews" by Adnan Aziz, Tsung-Hsien Lee, and Amit Prakash about 5 times and skimmed it 3 times.

​

Really really really recommend EPI over CTCI but that is personal preference. EPI dives very very deep into the reasoning behind how we go from brute force solutions for each problem, to the optimal solution but it is less beginner friendly since it is more intellectually rigorous. It instills an apparatus of thinking that no other resource I have found does.

​

I want to make a small guide answering questions people often have about these problems as well as things to watch out for.
An Exhaustive List of Topics You'll Need To Know Well

    Fundamentals of Computers (just a general knowing how computers store information etc.)
        This is just a basal thing. Knowing how binary works, how memory is managed in a program (stack & heap), etc.
    Big O Time & Space Complexity Computation
        Know asymptotic bounds. If you can be flexible in how you analyze a solution you come up with (lower bounding it, upper bounding, exact bounding) it can help you see whether you can do better and make an improved algorithm
    Arrays
        This is pretty straightforward. Often questions that work within arrays will be solved in linear time ( O(n) ) for the most part and that linear time solution will be tricky.
    Primitives
        Things like bit shifting. This is more rare and I don't think this is as important since it doesn't test real thinking abilities since it mixes with one's abilities to bit shift which is an esoteric skill.
    Strings
        These are problems that often deal with strings like permutations, backtracking problems that have use take an exhaustive approach in producing decompositions of a string to search a possibility space (which is often a brute force way of solving a problem since it will be exponential in time), etc etc. String problems are often solved most optimally in O(n) time or O(s1 + s2) time (linear with respect to each string) if we are given 2 strings...whatever the problem may be.
    Dynamic Programming
        One of the most difficult subjects. This is the key: subproblems. If you can identify the subproblem, you have cracked the problem. Because from there it is all about memoization to cache and leverage previous solutions.
    Recursion / Backtracking
        This is a comfort thing. The more of these you do, the better you get. At some point you will naturally think of solutions in a recursive manner (if backtracking could be a possible approach used). Problems that use backtracking often say..."generate all"..."compute every"....this indicates an expression of exhaustively expressing all the possibilities of a decision space. Recursion is beautiful for this.
    Graphs
        Know DFS & BFS. DFS uses a stack (either implicit with the call stack and recursion or explicit if we create our own stack) & BFS uses a queue.
    Greedy Algorithms
        These are algorithms that take the locally most optimal solution to achieve a global optimal. In contrast to problems that use dynamic programming (which is characterized by caching previous subproblems to find a global optimum), greedy algorithms take locally optimal choices.
        Not all greedy approaches one comes up with will work 100% of the time so it hinges on being able to use deductive logic to prove that a given approach will always work
    Hashtables
        Very very very common in mid-level interviews. This is a must know. It is pretty simple, when our time complexity is too high, we can often reduce time and increase space by using some sort of auxiliary structure to cache work. Hashtables are often that auxiliary structure.
    Linked Lists
        A tricky structure to work with. It is hard because we can't index into items. It gets easier with time but always remain tricky.
    Sorting
        Know the fundamental sorting algorithms. Bubble, Insertion, Selection, Merge, Quick, Heap, ...etc
    Searching
        If an array is sorted. IMMEDIATELY know that that is a strong hint that the optimal solution will use binary search and stay to the order of O(log(n))
    Min/Max Heaps
        Heaps are really cool. Just know...if you see "find the LARGEST"...or ... "find the SMALLEST"...anything to do with size...think heap. Min or max. If we want larger items we use a min heap since we can throw away small items (to leave the large ones behind). And vice versa for when we want the smaller items
    Stacks
        LIFO structures. Know how to implement a stack inside out. it is fairly easy so don't fear it. I'd suggest knowing how to implement all data structures stated here. Why not?
    Queues
        FIFO structures. Used for Breadth First Search.
    Trees, Binary Trees, & Binary Search Trees
        Trees are connected, acyclic, graphs. You can do DFS and BFS on them. Print all the characters in the tree in this order? Does it look like DFS? You can do that. Traverse the tree level by level? Looks like BFS. (BFS goes out level by level).
    System and OO design Principles (sometimes)
        Some compaines ask Object Oriented questions. A great great resource for this is the book "Clean Architecture" by Robert C. Martin. I also highly recommend his book "Clean Code" but it won't help you for interviews (but will make you a better programmer)

An Approach To Preparation

    Find your weak topics. For me those were trees, backtracking, dynamic programming, and linked lists.
    Start with easys. My first Leetcode problem was Jewels & Stones (you can search it) and it took me 30 minutes......it was just 2 for loops. Am I dumb? ... maybe ... but these problems are so far divorced from daily programming tasks that it was difficult for me.
    Easys will be very difficult when you just start...then they will start getting...easy...hmmmm...onto the mediums.
    Your summer internship interviews will be medium difficulty questions. Full-time roles will be upper medium questions sprinkled with a few hard questions. Stay rooted in the fundamentals above and you can survive.
    Go onto hards if you want...but don't get lost on esoteric problems that require "special" tricks. This is all about getting ready to pass an interview for a job, not so much to have bragging rights.
    Top it all off with polishing your delivery. pramp.com interviews helped me immensely. I did about 8 in person interviews this past season.

F.A.Q.

How many Leetcode until I'm ready?

There is no finite amount. Every person comes to the table with their own weaknesses in all topics above. You will know when you are ready. You will see a problem and say..."Oh...yeah I know what principle to apply here". The more you get that spark, the higher the chances you pass.

​

Should I time myself?

Yes and no. Time is critical. Speed is critical. But timing yourself is useless if you are very uncomfortable with a specific problem class. I suggest solving many problems (peeping the solutions often is fine...just gain comfort) in your weak points. Then when you get sick of jumping to answers you will soon take the leap and just solve the problem yourself because you will become familiar with the techniques required for the approach. (this is how backtracking was for me. I went from total confusion to it becoming a default way of thinking.)

​

What should I focus my studying on?

Weak points. And then popular problems. Find a list of problems the company you are interviewing at asks. No idea whether this is a myth or not (and CTCI addressed this as false...that companies repeat questions from a list) but I have friends that told me of getting exactly questions from these lists. It isn't critical but it can help.

​

Reading books vs. Leetcode/HackerRank?

Books give you theory. Coding gives you the memory in your fingers and the necessary practice. Like...if I know a problem will use BFS, how fast can I put the logic in place for a basic search? If I know that a problem may use a heap...how fast can I throw up a priority queue with the right comparator (if it is a max or min heap...Java defaults to a min heap without a comparator)
