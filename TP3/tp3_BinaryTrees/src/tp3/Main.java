package tp3;

import tests.Corrector;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bienvenue au troisieme labo de INF2010!");
        Corrector.executeTester("AllTesters", Corrector::start, 20.0);
    }
}
