package CigaretteSmokersProblem;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static boolean tobacco = false;
    static boolean paper = false;
    static boolean matches = false;

    static final Lock lock = new ReentrantLock();
    static final Condition nonSmokingAgent = lock.newCondition();

    static final Condition smokerOne = lock.newCondition();
    static final Condition smokerTwo = lock.newCondition();
    static final Condition smokerThree = lock.newCondition();

    static final Object mutex = new Object();

    public static void main(String[] args) {
        new Thread(new Smoker("Mike", "tobacco")).start();
        new Thread(new Smoker("Eric", "paper")).start();
        new Thread(new Smoker("Daniel", "matches")).start();
        new Thread(new NonSmokingAgent()).start();
    }
}
