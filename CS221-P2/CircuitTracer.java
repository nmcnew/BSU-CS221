import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Search for shortest paths between start and end points on a circuit board as
 * read from an input file using either a stack or queue as the underlying
 * search state storage structure and displaying output to the console or to a
 * GUI according to options specified via command-line arguments.
 * 
 * @author mvail
 */
public class CircuitTracer {
	private CircuitBoard board;
	private Storage<TraceState> stateStore;
	private ArrayList<TraceState> bestPaths;

	/**
	 * launch the program
	 * 
	 * @param args
	 *            three required arguments: first arg: -s for stack or -q for
	 *            queue second arg: -c for console output or -g for GUI output
	 *            third arg: input file name
	 */
	public static void main(String[] args) {
		if (args.length != 3) {
			printUsage();
			System.exit(1);
		}
		try {
			new CircuitTracer(args); // create this with args
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	/** Print instructions for running CircuitTracer from the command line. */
	private static void printUsage() {
		// TODO: print out clear usage instructions when there are problems with
		// any command line args
		System.out.print("First Argument: -q for queue, -s for stack\nSecond Argument: -c for console or -g for GUI-based output\nThird Argument should be the file path to the input file.");
	}

	/**
	 * Set up the CircuitBoard and all other components based on command line
	 * arguments.
	 * 
	 * @param args
	 *            command line arguments passed through from main()
	 * @throws InvalidCommandLineArgumentException When an invalid command is ran
	 */
	private CircuitTracer(String[] args) throws InvalidCommandLineArgumentException {
		// parse command line args
		String type = args[0];
		String viewport = args[1];
		if (viewport.equals("-g"))
			throw new InvalidCommandLineArgumentException("-g is not yet supported");
		String file = args[2];
		// initialize the Storage to use either a stack or queue
		switch (type) {
		case ("-q"):// queue
			stateStore = Storage.getStackInstance();
			break;
		case ("-s"):// stack
			stateStore = Storage.getQueueInstance();
			break;
		default:
			printUsage();
			throw new InvalidCommandLineArgumentException(type + " is not supported");
		}
		// read in the CircuitBoard from the given file
		try {
			board = new CircuitBoard(file);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		// run the search for best paths
		Point start = board.getStartingPoint();
		bestPaths = new ArrayList<TraceState>();
		if (board.isOpen(start.x - 1, start.y))
			stateStore.store(new TraceState(board, start.x - 1, start.y));
		if (board.isOpen(start.x + 1, start.y))
			stateStore.store(new TraceState(board, start.x + 1, start.y));
		if (board.isOpen(start.x, start.y - 1))
			stateStore.store(new TraceState(board, start.x, start.y - 1));
		if (board.isOpen(start.x, start.y + 1))
			stateStore.store(new TraceState(board, start.x, start.y + 1));
		while (!stateStore.isEmpty()) {
			TraceState current = stateStore.retreive();
			if (current.isComplete()) {
				if (bestPaths.isEmpty() || current.pathLength() < bestPaths.get(0).pathLength()) {
					bestPaths.clear();
					bestPaths.add(current);
				} else if (current.pathLength() == bestPaths.get(0).pathLength()) {
					bestPaths.add(current);
				}

			} else {
				if (current.getBoard().isOpen(current.getRow() - 1, current.getCol())) {
					stateStore.store(new TraceState(current, current.getRow() - 1, current.getCol()));
				}
				if (current.getBoard().isOpen(current.getRow() + 1, current.getCol())) {
					stateStore.store(new TraceState(current, current.getRow() + 1, current.getCol()));
				}
				if (current.getBoard().isOpen(current.getRow(), current.getCol() - 1)) {
					stateStore.store(new TraceState(current, current.getRow(), current.getCol() - 1));
				}
				if (current.getBoard().isOpen(current.getRow(), current.getCol() + 1)) {
					stateStore.store(new TraceState(current, current.getRow(), current.getCol() + 1));
				}
			}
		}

		// TODO: output results to console or GUI, according to specified choice
		if (viewport.equals("-c")) {
			for (TraceState state : bestPaths) {
				System.out.print(state.toString());
				System.out.println();
			}
		}
		if(viewport.equals("-g")){
			//TODO: Create gui for circuit tracer
		}
	}
} // class CircuitTracer
