import java.io.File;
import java.util.Scanner;

/**
 * Execute a Josephus death circle on the names in a given file (one name per line) by
 * skipping given number of people between executions. The lucky martyrs are collected
 * in either a circular array-based queue or a linked node-based queue.
 * 
 * @author mvail
 */
public class JosephusQueues {

	/**
	 * @param args [-c|-l] [skip count] [namesFile]
	 */
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Usage: java JosephusQueues [-c|-l] [int i] [namesFile]");
			System.out.println("\twhere -c indicates that a circular array-based queue should be used");
			System.out.println("\tand -l indicates that a linked node-based queue should be used.");
			System.out.println("\tInteger i is the number of people to skip between swings of the sword.");
			System.exit(1);
		}
		
		QueueADT<String> herd = null;
		
		switch (args[0]) {
		case "-c":
			herd = new CircularArrayQueue<String>();
			break;
		case "-l":
			herd = new LinkedQueue<String>();
			break;
		default:
			System.out.println("Invalid queue type argument. Must be -c or -l.");
			System.exit(1);
			break;
		}
		
		int ith = 1;
		try {
			ith = Integer.parseInt(args[1]);
			if (ith < 1) {
				System.out.println("Invalid second argument. Must have a positive integer for number of people to skip.");
				System.exit(1);
			}
		} catch (Exception e) {
			System.out.println("Invalid second argument. Must have a positive integer for number of people to skip.");
			System.exit(1);
		}
		
		try {
			Scanner scan = new Scanner(new File(args[2]));
			while (scan.hasNextLine()) {
				String name = scan.nextLine().trim();
				if (name.length() > 0) {
					herd.enqueue(name);
				}
			}
			scan.close();
		} catch (Exception e) {
			System.out.println("Invalid third argument. Cannot open or read " + args[2]);
			System.exit(1);
		}
		
		if (herd.isEmpty()) {
			System.out.println("Failure! You can't have a death circle without at least 2 people!");
		} else {
			//who's present?
			System.out.println("The " + herd.size() + " not-so-lucky soldiers facing death or capture:");
			System.out.println(herd);
			
			//cull the herd
			cull(herd, ith);
		
			//who's left?
			if (herd.isEmpty()) {
				System.out.println("These people are incompetant. No one survived.");
			} else if (herd.size() > 1) {
				System.out.println("Cowards! There are " + herd.size() + " survivors!");
			} else {
				System.out.println("The lucky survivor who faces capture rather than death: " + herd.dequeue());
			}
		}
	}
	
	/**
	 * Skip ith-1 people and kill the ith until only one person remains.
	 * @param herd collection of potential martyrs
	 * @param ith will kill the ith person in each round of culling
	 */
	private static void cull(QueueADT<String> herd, int ith) {
		int victimNumber = 1;
		while (herd.size() > 1) {
			for (int i = 0; i < ith - 1; i++) {
				herd.enqueue(herd.dequeue());
			}
			System.out.printf("Victim %2d: %s\n", victimNumber, herd.dequeue());
			victimNumber++;
		}
	}
}