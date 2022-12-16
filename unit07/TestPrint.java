package unit07;

public class TestPrint {
	public static void main(String[] args) {
        var testPrint = new TestPrint();
        // testPrint.PrintChar();
        // testPrint.PrintNum();
        var printChar = testPrint.new PrintChar(); 
        var printNum = testPrint.new PrintNum(); // Runnable object
        var thread = new Thread(printNum);

        printChar.start(); //Sub class of Thread
        thread.start();
    }

    public class PrintChar extends Thread{
        @Override
        public void run() {
            this.PrintChar_();
        }
        void PrintChar_() {
            // 打印'a'-'z'
            for (int i = 0; i < 26; i++) {
                System.out.print( (char) ('a'+i) + " ");
            }
            System.out.print("\n");
        }
    }

    public class PrintNum implements Runnable {
        @Override
        public void run() {
            this.PrintNum_();
        }
        void PrintNum_() {
            for (int i = 1; i <= 26; i++) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }
    
}



