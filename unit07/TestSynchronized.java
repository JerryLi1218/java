package unit07;

public class TestSynchronized {

	public static void main(String[] args) throws Exception{
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
 
		SeqThread pa = new SeqThread("A", c, a);
		SeqThread pb = new SeqThread("B", a, b);
		SeqThread pc = new SeqThread("C", b, c);
 
		new Thread(pa).start();
		Thread.sleep(5);
		new Thread(pb).start();
		Thread.sleep(5);
		new Thread(pc).start();
		Thread.sleep(5);

	}
}

class SeqThread implements Runnable {
	String name;
	Object prev;
	Object self;
 
	SeqThread(String _name, Object _prev, Object _self){
		name = _name;
		prev = _prev;
		self = _self;
	}
	@Override
	public void run() {
		int count = 10;
		while (count>0) {
			synchronized (prev){
				synchronized (self){
					System.out.print(name);
					count--;
					// yield to Main Thread, start next Thread
					try {
						Thread.sleep(1);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
					self.notifyAll();
				}
				try {
					prev.wait();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}