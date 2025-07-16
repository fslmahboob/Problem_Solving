/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	// You fill in this part
	public void run ()
	{		
		// complete initial row with 4 spaced beepers
		rowBuildComplete();
		
		// check if no wall above Karen 
		while (leftIsClear() || rightIsClear())
		{
			rotateKaren();
			rowBuildComplete();
		}
	}
	
	private void rowBuildComplete()
	{		
		placeBeeper();
		// move any number of times to the next column and place a beeper
		while (frontIsClear())
		{
			moveToNextColumn();
			placeBeeper();
		}
		//skipOneBlock();
	}
	
//	private void skipOneBlock()
//	{
//		turnLeft();
//		move();
//		turnRight();
//		move();
//		move();
//		turnRight();
//		move();
//		turnLeft();
//	}
	
	private void rotateKaren()
	{
		if (facingEast())
		{
			// fencepost error
			if (noBeepersPresent())
			{
				putBeeper();
			}
			turnLeft();
			move();
			turnLeft();
		}
		else 
		{
			turnRight();
			move();
			turnRight();
		}
	}
	
//	private void repositionForRowToEast()
//	{
//		if (noBeepersPresent())
//		{
//			putBeeper();
//		}
//		turnRight();
//		move();
//		turnRight();
//	}
	
	private void moveToNextColumn()
	{
		for (int i = 0; i < 4; i++)
		{
			move();
		}
	}
	
	private void placeBeeper()
	{
		if (noBeepersPresent())
		{
			putBeeper();
		}
	}

}