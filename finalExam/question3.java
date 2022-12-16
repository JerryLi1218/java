package finalExam;

import java.util.Objects;
import java.util.Random;

/*
 * 四个孩子在玩球类游戏。有一个大盒子，里面有一些球。
 * 两个孩子A和B不断地把球放进盒子里，
 * 另外两个孩子C和D不断地把球从盒子里拿出来。
 * 每个孩子每次放或拿一个随机数量的球(不超过5个)。
 * 如果盒子是空的，C和D会等到有足够的球出来。
 * 如果盒子满了，A和B就会等待，直到有足够的空间。
 * 编写程序来模拟游戏。
 */

public class question3 {

	public static void main(String[] args) {
		Box balls = new Box();
		PersonA a = new PersonA(balls,"putBall");
		PersonB b = new PersonB(balls,"putBall");
		PersonC c = new PersonC(balls,"getBall");
		PersonD d = new PersonD(balls,"getBall");
		a.start();
		b.start();
		c.start();
		d.start();	
	}
}


class Box{
	//假设箱子里默认有一百个球
	static int balls = 100;
	
	Object lock = new Object();
	//取球
	public synchronized void getBall(int balls,String mode) throws Exception{
		if(balls > Box.balls) {
			throw new Exception("there are only "+Box.balls+" in the Box,not enough "+balls);
			//lock.wait();
		}else {
			Box.balls += balls;
			System.out.println("there are "+balls+" balls in the box now");
		}

		
	}
	
	//放球
	public synchronized void putBall(int balls, String mode) throws Exception{
		if(balls<Box.balls) {
			throw new Exception("there are "+Box.balls+" in the box,no room for "+balls+" more.");
		}else {
			Box.balls -= balls;
			System.out.println("there are "+balls+" balls in the box now");
		}
		
	}
	
	//做临界限制
	/*
	 * public synchronized void judgement(int balls,String mode)throws Exception {
	 * if(balls > Box.balls) { throw new
	 * Exception("there are only "+Box.balls+" in the Box,not enough "+balls); }else
	 * { throw new
	 * Exception("there are "+Box.balls+" in the box,no room for "+balls+" more.");
	 * } if(Objects.equals(mode, "getBalls")) { getBall(balls); }else {
	 * putBall(balls); } }
	 */
}


class PersonA extends Thread {
	 
	Box balls;
	
	String mode;
	
	Random random = new Random();
	//找一个0-5之间的数
	int putNum = random.nextInt(5);
	
	public PersonA(Box balls, String mode) {
		this.mode = mode;
		this.balls = balls;
	}
 
	public void run (){
		while(Box.balls >= 100 && Box.balls <= 0){
			try {
				balls.putBall(putNum, mode);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class PersonB extends Thread {
	 
	Box balls;
	
	String mode;
	
	Random random = new Random();
	//找一个0-5之间的数
	int putNum = random.nextInt(5);
	
	public PersonB(Box balls, String mode) {
		this.mode = mode;
		this.balls = balls;
	}
 
	public void run (){
		while(Box.balls >= 100 && Box.balls <= 0){
			try {
				balls.putBall(putNum, mode);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class PersonC extends Thread {
	 
	Box balls;
	
	String mode;
	
	Random random = new Random();
	//找一个0-5之间的数
	int getNum = random.nextInt(5);
	
	public PersonC(Box balls, String mode) {
		this.mode = mode;
		this.balls = balls;
	}
 
	public void run (){
		while(Box.balls >= 100 && Box.balls <= 0){
			try {
				balls.getBall(getNum, mode);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class PersonD extends Thread {
	 
	Box balls;
	
	String mode;
	
	Random random = new Random();
	//找一个0-5之间的数
	int getNum = random.nextInt(5);
	
	public PersonD(Box balls, String mode) {
		this.mode = mode;
		this.balls = balls;
	}
 
	public void run (){
		while(Box.balls >= 100 && Box.balls <= 0){
			try {
				balls.getBall(getNum, mode);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
