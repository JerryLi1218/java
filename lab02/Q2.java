package lab02;

import java.util.Random;


public class Q2 {

    public static void main(String[] args) {
	Random random = new Random();
	Server server = new Server(random);
	Client c1 = new Client(server, random);
	Thread t1 = new Thread(c1);
	Client c2 = new Client(server, random);
	Thread t2 = new Thread(c2);
	server.setC1(c1);
	server.setC2(c2);

	t1.start();
	t2.start();
	server.start();
    }

}

class Server extends Thread {

    private Random random;
    private boolean isRun;
    private Client c1;
    private Client c2;

    public Server(Random random) {
	this.random = random;
	this.isRun = true;
    }

    public boolean isRun() {
	return isRun;
    }

    public void setC1(Client c1) {
	this.c1 = c1;
    }

    public void setC2(Client c2) {
	this.c2 = c2;
    }

    @Override
    public void run() {
    	
    	//进行五轮比大小
		int count = 5;

		//打印表格
		System.out.println("\tThread A\t\t\t\tThread B");
		System.out.println("Round\tSleep\tRandom\t\tPoints\t\tSleep\tRandom\t\tPoints");
		System.out.println("\ttime\tcharacter\tobtained\ttime\tcharacter\tobtained");
		System.out.println("--------------------------------------------------------------------------------");
	
		for (int i = 0; i < count;) {
		    if (c1.isFinished() && c2.isFinished()) {
				i++;
				if (c1.getResult() > c2.getResult()) {
				    System.out.printf("%d\t%d\t%c\t\t%d\t\t", i, c1.getSleepTime(), c1.getResult(), 2);
				    c1.setScore(c1.getScore() + 2);
				    System.out.printf("%d\t%c\t\t%d\n", c2.getSleepTime(), c2.getResult(), 0);
				} 
				else if (c1.getResult() < c2.getResult()) {
				    System.out.printf("%d\t%d\t%c\t\t%d\t\t", i, c1.getSleepTime(), c1.getResult(), 0);
				    System.out.printf("%d\t%c\t\t%d\n", c2.getSleepTime(), c2.getResult(), 2);
				    c2.setScore(c2.getScore() + 2);
				} 
				else {
				    System.out.printf("%d\t%d\t%c\t\t%d\t\t", i, c1.getSleepTime(), c1.getResult(), 1);
				    c1.setScore(c1.getScore() + 1);
				    System.out.printf("%d\t%c\t\t%d\n", c2.getSleepTime(), c2.getResult(), 1);
				    c2.setScore(c2.getScore() + 1);
				}
		
				c1.setFinished(false);
				c2.setFinished(false);
				
				synchronized (this) {
				    this.notifyAll();
				}
		    } 
		    else {
			try {
			    Thread.sleep(250);
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
		    }
		}
	
		isRun = false;
	
		
		synchronized (this) {
		    this.notifyAll();
		}
	
		System.out.println("--------------------------------------------------------------------------------");
	
		
		if (c1.getScore() > c2.getScore()) {
		    System.out.println("A is the winner");
		} 
		
		else if (c1.getScore() < c2.getScore()) {
		    System.out.println("B is the winner");
		} 
		
		else {
		    System.out.printf("%d : %d draw", c1.getScore(), c2.getScore());
		}
    }

}

class Client implements Runnable {

    private Server server;
    private Random random;
    private char result;
    private boolean isFinished;
    private int score;
    private long sleepTime;

    public Client(Server server, Random random) {
	this.server = server;
	this.random = random;
	this.result = '\u0000';
	this.isFinished = false;
	this.score = 0;
	this.sleepTime = -1;
    }

    public char getResult() {
	return result;
    }

    public boolean isFinished() {
	return isFinished;
    }

    public void setFinished(boolean isFinished) {
	this.isFinished = isFinished;
    }

    public int getScore() {
	return score;
    }

    public void setScore(int score) {
	this.score = score;
    }

    public long getSleepTime() {
	return sleepTime;
    }

    @Override
    public void run() {
		while (server.isRun()) {
		    try {
			sleepTime = random.nextInt(1000);
			Thread.sleep(sleepTime);
		    } catch (InterruptedException e) {
			e.printStackTrace();
		    }
	
		    result = (char) (random.nextInt(26) + 'a');
		    isFinished = true;
	
		    synchronized (server) {
				try {
				    server.wait();
				} catch (InterruptedException e) {
				    e.printStackTrace();
				}
		    }
		}
    }

}