package CigaretteSmokersProblem;

import static CigaretteSmokersProblem.Main.matches;
import static CigaretteSmokersProblem.Main.*;

public class Smoker implements Runnable {

    String name;
    String ingredient;
    Smoker (String name, String ingredient) {
        this.name = name;
        this.ingredient = ingredient;
    }

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                // SmokerA - tobacco
                if(ingredient.compareTo("tobacco") == 0)
                    while (!paper && !matches) {
                        try {
                            smokerOne.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                // SmokerB - paper
                if(ingredient.compareTo("paper") == 0)
                    while (!tobacco && !matches) {
                        try {
                            smokerTwo.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                // SmokerC - matches
                if(ingredient.compareTo("matches") == 0)
                    while (!paper && !tobacco) {
                        try {
                            smokerThree.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                System.out.println("Smoker " + name + " is making and smoking a cigarette.\n");

                makeCigaretteAndSmoke();
                nonSmokingAgent.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    private void makeCigaretteAndSmoke() {
        // Making a cigarette
        paper = false;
        matches = false;
        tobacco = false;

        // Smoking
        try {
            Thread.sleep(2020);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}