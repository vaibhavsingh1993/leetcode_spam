import java.util.concurrent.*;

class FooBar {
    private int n;

    Semaphore s2 = new Semaphore(0);
    Semaphore s3 = new Semaphore(1);
    
    public FooBar(int n) {
        this.n = n;

    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            s3.acquire();
        	printFoo.run();
            s2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
            s2.acquire();
        	printBar.run();
            s3.release();
        }
    }
}
