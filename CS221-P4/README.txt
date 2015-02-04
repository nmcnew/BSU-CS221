*******************************************************************************
* Project: 4/MergeSort
* Class:   CS221-02
* Date:    12-12-2014
* Name:    Nicholas McNew
********************************************************************************

OVERVIEW:

This program tests a Merge Sort and it's accompanying methods to ensure accuracy and usability of 
the merge sort.

INCLUDED FILES:

Files:
DoubleLinkedListADT.java: ADT for DoubleLinkedList
ElementNotFoundException.java: Throws when Element is not found
EmptyCollectionException.java: Throws when the list is empty
IndexedListADT.java: ADT for Indexed Lists
InverseComparator.java: Comparator that gives the inverse of the natural order
ListADT.java: ADT for Lists
MergeSort.java: Class that can find the largest, shortest elements and sort lists using the MergeSort idea
MergeSortTester.java: (Runnable) Tests that the MergeSort does what it is supposed to.
UnorderedListADT.java: ADT for Unordered Lists
WrappedDLL.java: Wrapping the list class in a usable format for 

BUILDING AND RUNNING:

1. Open up a Terminal or Command prompt
2. Navigate to the correct Directory for the MergeSortTester.java
3. Compile the program by "javac MergeSortTester.java"
4. Once that is complete you can run the program by running "java MergeSortTester"
5. It will output the tests for MergeSort
 

PROGRAM DESIGN:

The MergeSort class has the following methods:
	sort(DoubleLinkedListADT<T>):
		This sorts using the recursive algorithm for Merge Sort. It is accompanied by MergeSortHelper and merge.
		MergeSortHelper(): Splits the list into sublists
		merge(): Merges the list after being split.
	sort(DoubleLinkedListADT<T>, Comparator<T>)
		Sorts based on the comparators ordering
		accompanied by similar MergeSortHelper and Merge methods.
	findSmallest(DoubleLinkedLIstADT<T>):
		Finds the smallest element recursively in the list from the natural order of the elements in the list.
		Accompanied by:
			findSmallestHelper():
				Does the recursive portion of the algorithm. 
	findSmallest(DoubleLinkedListADT<T>, Comparator<T>)
		Same as the other findSmallest but does it in the order of the comparator.
		
	findLargest(DoubleLinkedListADT<T>)
		Finds the largest element from the natural order of the elements. initiates the recursion
		Accompanied by:
			findLargestHelper():
				does the recursive search through the list.
				
The MergeSortTester is set up to test an empty, one element, two element, 1000 Integer list and
 1000 Character List. Random generator for the list is using the Java.util.Random class to generate 
 pseudorandom integers for the list

PROGRAM DEVELOPMENT AND TESTING DISCUSSION:

I had a lot of troubles on the find Largest method since it was the first method I started to make 
and it was just a little difficult to make a find method recursive of O(n). I tried a lot of different 
methods to try and make it recursive but finally landed on the idea f calling the method with a variable. 
I also was confused with the mergesort until i was told that we should split the list into smaller 
lists. I had a lot of fun having the opportunity to mke my oown merge sort without much guidance, it 
allowed me to fail and fix what I needed to. Also having the class made it nice for making the mergesort 
since it was what I did before anything else.

I also think it was a lot easier that doublelinkedlist's iterator methods, in the size of scale and understandability.

