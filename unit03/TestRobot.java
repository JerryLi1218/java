package unit03;

import java.util.Arrays;

public class TestRobot {

	
	public static void main(String[] args) {
		Robot r = new Robot();
		Coordinate c = new Coordinate(0,0);
		SmartRobot r1 = new SmartRobot("SR",c);
		Robot []r2= {r,r1};
		r.move(1);
		r1.move(4);
		System.out.println(r2[0].toString());
		System.out.println(r2[1].toString());
	}

}

class Coordinate{
	public void Coordinate() {
		x=0;y=0;
	};
	Coordinate(int x,int y) {
		this.x = x;
		this.y = y;
	};
	public int x = 0;
	public int y = 0;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}

enum direaction{
	east,west,south,north;
}


class Robot{
	private String name;
	private Coordinate cor ;
	direaction dir;
	public Robot() {
		this.name = "R";
		this.dir = direaction.east;
		this.cor = new Coordinate(0,0);
	}
	public Robot(String name ,Coordinate cor,direaction dir) {
		this.name = name;
		this.cor = cor;
		this.dir = dir;
	}
	public void move(int steps) {
		switch(dir) {
		case east -> cor.setX(cor.getX() + steps);
		case north -> cor.setY(cor.getY() + steps);
		case west -> cor.setX(cor.getX() - steps);
		case south -> cor.setY(cor.getY() - steps);
		}
	}
	public void turnLeft() {
		 switch(dir){
		 case east -> dir = direaction.north;
		 case north -> dir = direaction.west;
		 case west -> dir = direaction.south;
		 case south -> dir = direaction.east;
		 }
	}
	public void turnRight() {
		switch(dir){
		case east -> dir = direaction.south;
		case north -> dir = direaction.east;
		case west -> dir = direaction.north;
		case south -> dir = direaction.west;
		}
	}
	public String toString() {
		return (cor.x+" "+cor.y);
	}
	public Coordinate getPosition() {return cor;}
}

class SmartRobot
	extends Robot{
	private int[][] pos= new int[100][100];
	public SmartRobot() {this(direaction.east);}
	public SmartRobot(String name,Coordinate cor){
		super(name,cor,direaction.east);
		}
	public SmartRobot(direaction e) {
		super();
		this.dir = e;
	}
	@Override
	public void move(int steps) {
		int x = getPosition().x;
		int y = getPosition().y;
		super.move(steps);
		int x_ = getPosition().x;
		int y_ = getPosition().y;
		if(x==x_) {
			if(y<y_) {
				int temp = y;
				y = y_;
				y_ = temp;
			}
			for(int i=y_;i<=y;i++) {
				pos[x][i] = 1;
			}
		}
		if(y==y_) {
			if(x<x_) {
				int temp = x;
				x = x_;
				x_ = temp;
			}
			for(int i=x_;i<=x;i++) {
				pos[i][y] = 1;
			}
		}
	}
	@Override
	public String toString() {
		return Arrays.deepToString(pos);
	}
}