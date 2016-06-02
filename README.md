# quickSortScalaTimes
Combining some of the techniques shown here:

http://stackoverflow.com/questions/20880427/quicksort-traditional-vs-functional-style-what-causes-this-difference

we see that the functional paradigm suffers from overhead in repeatedly copying data to maintain an immutable state 
(recall immutability of Java String and all string operations creating new String object).

There are ways to optimize the functional approach but as we see in the typical times here, tweaking mutable data structures
cannot be beat:

Functional1 style : 148094869 : 0,0,3,3,4,4,5,5,6,7,8,8,8,9,10,12,13...
Functional2 style : 376783798 : 0,0,3,3,4,4,5,5,6,7,8,8,8,9,10,12,13,1.
Traditional2 style : 32557591 : 0,0,3,3,4,4,5,5,6,7,8,8,8,9,10,12,13,1...
