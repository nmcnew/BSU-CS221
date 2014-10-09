Quick Sort values 
(First, Last, PivotIndex, Pivot Value)
0 49 41 83
0 40 38 73
0 37 2  11
0 1  1  11
3 37 15 4
5 37 19 35
5 18 16 29
5 15 12 26
Recognizer:
1)
	"["
	pop();
	"("
	bop();
	"x"
	pop();
	bop();
	boop();
	")"
	",";

2)
	Callstack:
		boop();
		bop();
		pop();
		pop();
		bop();
		pop();
		bop();
		pop();
		pop();
		pop();
		recognize();
		main();
	I put the line break in boop(); on line 69 because boop was expecting to get 'y'.
	I used the condition:
		lookahead == 'y'