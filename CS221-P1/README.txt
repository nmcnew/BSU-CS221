****************
* Project 1
* CS 221
* September 5th, 2014
* Nicholas Mcnew
**************** 

OVERVIEW:

Monitors panels to see if any of the panels are destined to fail.

INCLUDED FILES:

Text Files:
	README.txt: 	Understanding how this program works
	negatives.txt: 	Represents a negative panel to test the system.
	oneByOne.txt: 	Represents a one by one panel to test with.
	sample.txt: 	Basic 3x3 sample to begin testing. 
	sample4x5.txt: 	Basic 4x5 grid to test the system.
	sampleDouble.txt: 3x3 grid with decimal point values.
	wideRange.txt:	Tests the ability to read in long number.
	
Java Files:
	GridMonitor.java: Class that does the digesting and processing of data from text files
	GridMonitorInterface: Contains methods to be added into the application from the senior engineer
	GridMonitorTest.java: Test Class to test GridMonitor and see if it stands up to the stress. Has various methods for various use cases

BUILDING AND RUNNING:

-Make sure all files are located in the same folder(text and java files)
-CD into the folder that you placed the files in
-Compile the application write: JAVAC *.java 
-Once that is compiled you can type "ls" or "dir" to make sure a .class form of it exists
-You can run that class by typing in: JAVA GridMonitorTest
	-And it should output the proper information
	-Note: You don't need the .class when running a compiled file
 

PROGRAM DESIGN:

I started by taking the Interface file from the instructor and 
created GridMonitor around those basic methods, outputting the arrays 
and setting up how the arrays would be used in the application. It would read in the array then go 
through and determine what the proper values were in the constructor Then I 
started fleshing out those methods and giving some helper private methods 
that would do the hard work for the project. GridMonitor does all the hard 
work of digesting and processing that information. The interface sets up
the way I have to go about setting up the design of this application.

The various GridMonitorTest programs use the GridMonitor and various txt files
to test GridMonitor and make sure everything works.
 

TESTING:

My program will handle a majority of numbers. Doubles support up to 15 significant figures.
This will also take bad input, if their are letters at all in the file that is in the grid,
It will convert that string to a 0.0 value. 
i also ran through some negative testing and rectangular array testing.


DISCUSSION:
 
 At first I started developing the wrong idea. I didn't understand how the file was 
 Formatted so I ran into thinking that the files would just be the array values themselves
 Not the actual dimensions on the first line. So I rewrote it to work a little better
 with the way the files are formatted. I also found out that you have to have a different
 test to make sure negatives work fine. 
 
 A huge thing I discovered was that BufferedReader only throws IOException not 
 FileNotFoundException and that using Scanner was the easier paradigm for this
 use case.
 
 I found out that rewriting the tests were quite tedious.
 

