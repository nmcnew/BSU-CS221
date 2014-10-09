

import java.io.*;
import java.util.Scanner;

/**
 * Created by Nicholas on 8/30/2014.
 */
public class GridMonitor implements GridMonitorInterface {

	// various arrays to store data
	private double[][] baseGrid;
	private double[][] surroundingSum;
	private double[][] surroundingAvg;
	private double[][] deltaGrid;
	private boolean[][] dangerGrid;

	public GridMonitor(String file) throws FileNotFoundException {
		baseGrid = parseGrid(file);
		surroundingSum = findSurroundingSum();
		surroundingAvg = findSurroundingAvgs();
		deltaGrid = findDeltaGrid();
		dangerGrid = findDangerGrid();
	}
	/**
	 * Outputs the baseGrid into a string
	 */
	public String toString() {
		String returnString = "";
		for (int i = 0; i < baseGrid.length; i++) {
			for (int j = 0; j < baseGrid[i].length; j++) {
				if (dangerGrid[i][j]) {
					returnString +="Dangerous Panel at: " + i + ", " + j + "\n";
				} else {
					returnString += "Safe Panel3 at: " + i + ", " + j + "\n";
				}
			}
		}

		return returnString;

	}
	/**
	 * Parses in array from a file into baseGrid
	 * @param file File to parse From
	 * @return 2d array containg double values for the grid
	 * @throws FileNotFoundException If the scanner cannot find the file specified
	 */
	private double[][] parseGrid(String file) throws FileNotFoundException {
		// Creates some grid that is 0 0 in size
		double[][] grid = new double[0][0];
		File f = new File(file);
		Scanner eye = new Scanner(f);
		String curLine;
		// keeping track of the curLine so I can properly place it in the array
		int curLineNum = 0;
		String[] dims = eye.nextLine().split(" ");
		// re-inits the grid with the proper dimensions
		grid = new double[parseGridInt(dims[0])][parseGridInt(dims[1])];
		while (eye.hasNext()) {
			curLine = eye.nextLine();
			String[] numbers = curLine.split(" ");
			for (int i = 0; i < numbers.length; i++) {
				grid[curLineNum][i] = parseGridDouble(numbers[i]);
			}
			curLineNum++;
		}
		return grid;
	}
	private double parseGridDouble(String number){
		try{
			return Double.parseDouble(number);
		}
		catch(NumberFormatException e){
			return 0.0;
		}
	}
	private int parseGridInt(String number){
		try{
			return Integer.parseInt(number);
		}
		catch(NumberFormatException e){
			return 0;
		}
	}
	/**
	 * Gathers values around a point in the 2d array to determine what the sum should be
	 * @return 2d array with added values
	 */
	private double[][] findSurroundingSum() {
		double[][] gridOfSums = new double[baseGrid.length][baseGrid[0].length];
		for (int i = 0; i < baseGrid.length; i++) {
			for (int j = 0; j < baseGrid[i].length; j++) {
				//if-else statements to confirm the sum of the are around a point
				double left = (i - 1 < 0) ? 
						baseGrid[i][j] : baseGrid[i - 1][j]; 
				double right = (i + 1 >= baseGrid.length) ?
						baseGrid[i][j] : baseGrid[i + 1][j];
				double up = (j - 1 < 0) ? 
						baseGrid[i][j] : baseGrid[i][j - 1];
				double down = (j + 1 >= baseGrid[i].length) ?
						baseGrid[i][j] : baseGrid[i][j + 1];
				gridOfSums[i][j] = left + right + up + down;
			}
		}
		return gridOfSums;
	}
	/**
	 * Averages the surroundingSum values by dividing by 4
	 * @return 2d array with average values
	 */
	private double[][] findSurroundingAvgs() {
		double[][] avgs = new double[baseGrid.length][baseGrid[0].length];
		for (int i = 0; i < avgs.length; i++) {
			for (int j = 0; j < avgs[i].length; j++) {
				avgs[i][j] = surroundingSum[i][j] / 4.0;
			}
		}
		return avgs;
	}

	private double[][] findDeltaGrid() {
		double[][] delta = new double[baseGrid.length][baseGrid[0].length];
		for (int i = 0; i < delta.length; i++) {
			for (int j = 0; j < delta[i].length; j++) {
				delta[i][j] = surroundingAvg[i][j] / 2.0;
			}
		}
		return delta;
	}

	private boolean[][] findDangerGrid() {
		boolean[][] danger = new boolean[baseGrid.length][baseGrid[0].length];
		for (int i = 0; i < danger.length; i++) {
			for (int j = 0; j < danger[i].length; j++) {
				double max = surroundingAvg[i][j] + deltaGrid[i][j];
				double min = surroundingAvg[i][j] - deltaGrid[i][j];
				if(Double.compare(baseGrid[i][j], 0) < 0){

					if ((baseGrid[i][j] < max || baseGrid[i][j] > min) )
						danger[i][j] = true;
					else
						danger[i][j] = false;
				}
				else if (baseGrid[i][j] > max || baseGrid[i][j] < min)
					danger[i][j] = true;
				else
					danger[i][j] = false;
			}
		}
		return danger;
	}

	private double[][] createCopy(double[][] array) {
		double[][] copy = new double[array.length][array[0].length];
		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy[i].length; j++) {
				copy[i][j] = array[i][j];
			}
		}
		return copy;
	}

	public double[][] getBaseGrid() {
		return createCopy(baseGrid);
	}

	public double[][] getSurroundingSumGrid() {
		return createCopy(surroundingSum);
	}

	public double[][] getSurroundingAvgGrid() {
		return createCopy(surroundingAvg);
	}

	public double[][] getDeltaGrid() {
		return createCopy(deltaGrid);
	}

	public boolean[][] getDangerGrid() {
		boolean[][] copy = new boolean[dangerGrid.length][dangerGrid[0].length];
		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy[i].length; j++) {
				copy[i][j] = dangerGrid[i][j];
			}
		}
		return copy;
	}
}
