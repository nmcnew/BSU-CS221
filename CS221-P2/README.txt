*******************************************************************************
* Project: Project2 - CircuitTracer
* Class:   CS221-02
* Date:    October 17, 2014
* Name:    Nicholas Mcnew
********************************************************************************

OVERVIEW:

to find a shortest path that connects the two components identified by digit characters. 
Diagonal traces, you have been told, are not allowed on account of issues with the 
manufacturing department (an old guy named Pak Mon, who believes diagonal motion is unnatural).

INCLUDED FILES:

README.txt: Defines what this application is.

CircuitBoard.java: defines the board onto which we find the shortest path
CircuitTracer.java: Runs through and gets the shortest path using the other included class files.
InvalidCommandLineArgumentException.java: When there is an invalid command line argument, I post this to show that it is wrong to use in that way
InvalidFileFormatException.java: Thrown when the file to be used is not formatted correctly.
OccupiedPositionException.java: To be thrown when a position is filled on the board.
Storage.java: The class that allows us to store data into either a stack or queue based on input.
TraceState.java: this stores the state of the board along with relevent information pertaining to the path.

BUILDING AND RUNNING:

To use this program follow the following instructions:
	1)Open up Command Prompt or Terminal
 	2)Navigate to the necessary folder
 	3)type in "javac CircuitTracer.java", this will compile the program
 	4)then you do "java CircuitTracer <Data Structure> <View type> <input file name>"
 		a)Data Structure can "-s" for a stack or "-q" for a queue
 		b)View Type must be "-c" as I have not implement a GUI based approach yet.
 		c)The input file name should be any plain text file, if it can't be read, bad things will happen.
	5) Watch the magic happen. 

PROGRAM DESIGN:

So the way this program works is by using CircuitTracer 
 Explain the main concepts and organization of your program so that
 the reader can understand how your program works. This is not a repeat
 of javadoc comments or an exhaustive listing of all methods, but an
 explanation of the critical algorithms and object interactions that make
 up the program.

 If your program has multiple classes, explain the main responsibilities
 of each class. Explain how the classes work together to achieve the
 program goals.
 
 If you were responsible for designing the program's classes and choosing
 how they work together, why did you design the program this way? What, if 
 anything, could be improved?


PROGRAM DEVELOPMENT AND TESTING DISCUSSION:

 Use this section of your README as a journal to discuss your development
 and testing experiences. It gives your instructor (and future self)
 insight into how you approached the project and how effectively you dealt
 with challenges you encountered. We want to know what went well and what
 didn't.

 Here are some ideas for discussion.

    - What issues did you encounter during programming and testing?
    - What went well?
    - What did you have to research and learn on your own? 
    - What kinds of errors did you get? How did you fix them?
    - How did you test your program to be sure it works and meets all
      of the requirements?
    - What are the known issues / bugs remaining in your program?
    - What parts of the project did you find challenging?
    - Is there anything that finally "clicked" for you in the process 
      of working on this project?
    - Did you like this project? How could it be improved? (We like 
      feedback!)

 
EXTRA CREDIT: (only necessary if you did available extra credit)

 If the project had opportunities for extra credit that you
 attempted, be sure to call it out so the grader does not overlook
 it.
