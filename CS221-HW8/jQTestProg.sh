#!/bin/sh
#testProg for JosephusQueues

# testing compilation

# Usage: $ sh ./jQTestProg

echo
echo "Running this testProgram should compile and run your program.  
If it doesn't, check the name of your main class."
echo

echo "Differences between the output using your queue and the instructor's
queue are given after the word 'diff' for each test."

echo

if (test -f JosephusQueues.java)
	then
	javac JosephusQueues.java
fi

if (test -f JosephusQueues.class)
	then
	echo "==========================================="
	echo "Using a circular array based queue"
	echo "==========================================="
	java JosephusQueues -c 3 names.txt > circular_array.out
	echo
	echo diff
	echo
	diff circular_array.out names_c3.txt
	echo
else
    echo
    echo "class JosephusQueues not found - either your program didn't compile 
    or it has the wrong name."
fi

if (test -f JosephusQueues.class)
	then
	echo "==========================================="
	echo "Using a linked queue"
	echo "==========================================="
	java JosephusQueues -l 3 names.txt > linked_queue.out
	echo
	echo diff
	echo
	diff linked_queue.out names_l3.txt
	echo
fi

echo
echo The files circular_array.out and linked_queue.out contain search output for the sample names.txt
echo and names_xy.txt shows the expected output using queue option -x and skip value y.
echo
