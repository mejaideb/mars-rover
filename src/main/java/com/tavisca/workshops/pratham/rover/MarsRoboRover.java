package com.tavisca.workshops.pratham.rover;
public class MarsRoboRover {
	private  int y;
	private  int x;
	private  char dir;
	public static final char North='N';
	public static final char West='W';
	public static final char East='E';
	public static final char South='S';
	public static final char Right='R';
	public static final char Left='L';
	public static final char Move='M';

	private MarsRoboRover(int x,int y,char dir)
	{
		this.x=x;
		this.y=y;
		this.dir=dir;
	}

	public static void main(String[] args) {

		String currentPosition = "3 3 E";
		String commands = "MMRMMRMRRM";

		String[] positions = currentPosition.split(" ");
		int x = Integer.valueOf(positions[0]);
		int y = Integer.valueOf(positions[1]);
		char dir = positions[2].charAt(0);
		MarsRoboRover mb=new MarsRoboRover(x,y,dir);

		for (char command : commands.toCharArray()) {
			mb.rove(command);
		}

		System.out.println("currentPosition..." + currentPosition);
		System.out.println("commands..." + commands);
		System.out.println("newPosition..." + mb.x + " " + mb.y + " " + mb.dir);
	}

	private void Move()
	{
		switch(dir)
		{
			case North:y++;break;
			case South:y--;break;
			case East:x++;break;
			case West:x--;break;
		}
	}

	private void LeftTurn()
	{
		switch(dir) {
			case North: dir = West;break;
			case South:dir=East;break;
			case East:dir=North;break;
			case West:dir=South;break;
		}
	}
	private void RightTurn()
	{
		switch(dir) {
			case North: dir = East;break;
			case South:dir=West;break;
			case East:dir=South;break;
			case West:dir=North;break;
		}
	}

	private void rove(char command)
	{
		switch (command){
			case Move:Move();break;
			case Right:RightTurn();break;
			case Left:LeftTurn();break;
		}

	}

}
