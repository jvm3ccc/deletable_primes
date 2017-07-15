package com.company;

import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

    private static int ways = 0;

    public static void main(String[] args) {

        int test = 4125673;
//        int testA[] = new int[]{4,1,2,5,6,7,3};

        ArrayList<Integer> testA = new ArrayList<>();
//        testA.add(4);
//        testA.add(6);
//        testA.add(2);
//        testA.add(1);
//        testA.add(6);
//        testA.add(5);
//        testA.add(6);
//        testA.add(7);
//        testA.add(6);
//        testA.add(2);
//        testA.add(9);
//        testA.add(1);
//        testA.add(3);
//        testA.add(7);
//        testA.add(9);

        testA.add(4);
        testA.add(5);
        testA.add(6);
        testA.add(7);

        solveProblem(testA);
        System.out.print("Insgesamt: " + ways);

    }

    /**
     * Loesche jede Stelle einzeln und checke ob die neue Zahl eine Primzahl gibt.
     * Falls es eine Primzahl ist, durchlaufe eine Rekursion.
     * Wenn es keine ist fahre fort.
     * Nach jedem Schleifen durchlauf wird die geloeschte Zahl zurueck eingesetzt um alle moeglichen Stellen
     * zu untersuchen.
     *
     * Rekursion:
     *  Loesche eine Ziffer, ueberpruefe ob diese neue Zahl eine Primzahl ist.
     *  Setze die geloeschte Ziffer am Ende zurueck ein, damit eine andere Stelle nach einer Primzahl gecheckt wird
     *
     * @param number
     */
    public static void solveProblem(ArrayList<Integer> number) {

        // Jede Stelle von der Zahl
        for(int i=0; i < number.size(); i++) {

            int backup = number.get(i);             // Die geloeschte Zahl muss wieder zurueck eingesetzt werden um alle Faelle zu untersuchen
            number.remove(i);                       // Loesche eine Ziffer
            long tempI = convertIntegers(number);   // Wandle von ArrayList zu long um (fuer fette zahlen)

            if(tempI == -1) { return; }  // Vorsichtsmassnahme, kann wsl entfernt werden

            BigInteger bla = BigInteger.valueOf(tempI); // Fuer fette Zahlen

            if(bla.isProbablePrime(5)) {
                System.out.println(tempI);  // Debugzwecke

                if(number.size() == 1)
                    ways++; // Laut Angabe wird nur dann hochgezaehlt wenn die unterste Ebene erreicht wurde

                else
                    solveProblem(number);   // Beginn der Rekursion

                // Aus der Rekursion raus muss wieder die geloeschte Zahl wieder
                // hinzugefuegt werden
            }

            // Setze Zahl zurueck ein, um weitere Faellen zu untersuchen
            number.add(i, backup);
        }

    }

    /**
     * Wandelt die ArrayList zu einem Integer um.
     *
     * @param integers
     * @return
     */
    public static long convertIntegers(ArrayList<Integer> integers)
    {
        // Bastle einen String und parse diesen dann zu einem Integer

        String integer = "";
        if(integers.size() == 0)
            return -1;

        for (int i = 0; i < integers.size(); i++) {
            String s = String.valueOf(integers.get(i));
            integer = integer + s;
        }

        return Long.parseLong(integer);
    }

    //checks whether an int is prime or not.
    public static boolean isPrime(long n) {

        if(n == 1)
            return false;
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            System.out.print(i);
            System.out.println("ich bin schleife");
            if(n%i==0)
                return false;
        }
        return true;
    }



}