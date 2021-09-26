
import java.util.concurrent.atomic.AtomicBoolean;
public class leetcoded_ez_1114_printinorderfoo {
    private AtomicBoolean firstdone = new AtomicBoolean();
    private AtomicBoolean seconddone = new AtomicBoolean(); 

    // 16m
    public leetcoded_ez_1114_printinorderfoo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstdone.set(true);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(!firstdone.get()) { } // do nothing
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        seconddone.set(true);
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(!seconddone.get()) { } // do nothing
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
