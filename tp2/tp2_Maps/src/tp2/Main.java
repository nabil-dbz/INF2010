package tp2;

import tests.Corrector;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bienvenue au deuxieme labo de INF2010!");
        Corrector.executeTester("AllTesters", Corrector::start, 20.0);
    }

}
