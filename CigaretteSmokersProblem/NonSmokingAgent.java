package CigaretteSmokersProblem;

import java.util.Random;

import static CigaretteSmokersProblem.Main.*;

public class NonSmokingAgent implements Runnable {
    private Random rnd = new Random();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                while ((tobacco && paper) || (tobacco && matches) || (paper && matches)) {
                    try {
                        nonSmokingAgent.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int temp = rnd.nextInt(3);
                if (temp == 0) {
                    tobacco = true;
                    paper = false;
                    matches = true;
                    System.out.println("Non-Smoking Agent selects tobacco and matches and places \'em on the table.");
                    toPlace();
                    smokerTwo.signal();
                }
                if (temp == 1) {
                    tobacco = false;
                    paper = true;
                    matches = true;
                    System.out.println("Non-Smoking Agent selects paper and matches and places \'em on the table.");
                    toPlace();
                    smokerOne.signal();
                }
                else {
                    tobacco = true;
                    paper = true;
                    matches = false;
                    System.out.println("Non-Smoking Agent selects tobacco and paper and places \'em on the table.");
                    toPlace();
                    smokerThree.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    private void toPlace() {
        try {
            Thread.sleep(2020);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}