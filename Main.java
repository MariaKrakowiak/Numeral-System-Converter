package converter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws NumberFormatException {
        Scanner sca = new Scanner(System.in);
        int sourceBase = 0;
        int newBase = 0;


        try {
            sourceBase = sca.nextInt();
            if (sourceBase < 1 || sourceBase > 36) {
                System.out.println("Error");
                System.exit(0);
            }

        } catch (InputMismatchException e) {
            System.out.println("Error");
            System.exit(0);
        }


        String str = sca.next();
        String regex1 = "[A-Za-z0-9]{1,9}([.][A-Za-z0-9]{1,9})?";
        if (!str.matches(regex1)) {

            System.out.println("Error");
            System.exit(0);
        }

        if (str.matches(regex1) && !str.contains(".") && sourceBase > 1) {
            for (int i = 0; i < str.length(); i++) {

                if (!((str.charAt(i) >= '0' &&
                        str.charAt(i) < ('0' + sourceBase)) ||
                        (str.charAt(i) >= 'A' &&
                                str.charAt(i) < ('A' + sourceBase - 10))
                )) {
                    System.out.println("Error");
                    System.exit(0);

                }
            }

        }


        try {
            newBase = sca.nextInt();
            if (newBase < 1 || newBase > 36) {
                System.out.println("Error");
                System.exit(0);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error");
            System.exit(0);
        }


        long len = str.length();


        if (!str.matches(".*[a-z].*")) {
            double v = Double.parseDouble(str);

            ArrayList<java.io.Serializable> solution = new ArrayList<java.io.Serializable>();


            if (sourceBase == 10 && v < 1) {

                double first = v * newBase;

                int intPart1 = (int) first;
                convertToSolution(solution, intPart1);

                double decPart1 = first - intPart1;

                double second = decPart1 * newBase;

                int intPart2 = (int) second;
                convertToSolution(solution, intPart2);
                double decPart2 = second - intPart2;

                double third = decPart2 * newBase;
                int intPart3 = (int) third;
                convertToSolution(solution, intPart3);
                double decPart3 = third - intPart3;


                double fourth = decPart3 * newBase;
                int intPart4 = (int) fourth;
                convertToSolution(solution, intPart4);
                double decPart4 = fourth - intPart4;


                double fifth = decPart4 * newBase;
                int intPart5 = (int) fifth;
                convertToSolution(solution, intPart5);


                String s = solution.toString();
                String s1 = s.replace(",", "");
                String s2 = s1.replace(" ", "");
                String s3 = s2.replace("[", "");
                String s4 = s3.replace("]", "");
                System.out.println("0." + s4);

            }

            if (sourceBase == 10 && v > 1) {
                int calosc = (int) v;
                double first = (v - calosc) * newBase;

                int intPart1 = (int) first;
                convertToSolution(solution, intPart1);

                double decPart1 = first - intPart1;


                double second = decPart1 * newBase;

                int intPart2 = (int) second;
                convertToSolution(solution, intPart2);
                double decPart2 = second - intPart2;


                double third = decPart2 * newBase;
                int intPart3 = (int) third;
                convertToSolution(solution, intPart3);
                double decPart3 = third - intPart3;


                double fourth = decPart3 * newBase;
                int intPart4 = (int) fourth;
                convertToSolution(solution, intPart4);
                double decPart4 = fourth - intPart4;


                double fifth = decPart4 * newBase;
                int intPart5 = (int) fifth;
                convertToSolution(solution, intPart5);


                String s = solution.toString();
                String s1 = s.replace(",", "");
                String s2 = s1.replace(" ", "");
                String s3 = s2.replace("[", "");
                String s4 = s3.replace("]", "");

                int decimalNumber = Integer.parseInt(String.valueOf(calosc), sourceBase);
                System.out.println(Integer.toString(decimalNumber, newBase) + "." + s4);


            }

            if (sourceBase == 1) {

                String s1 = String.valueOf(len);
                long l = Long.parseLong(s1, 10);
                System.out.println(Long.toString(l, newBase));

            }
            if (newBase == 1) {
                System.out.println(String.valueOf(len).repeat(Integer.parseInt(str)));
            }

            if (sourceBase != 1 && sourceBase != 10 && newBase != 1) {
                int decimalNumber = Integer.parseInt(str, sourceBase);
                System.out.println(Integer.toString(decimalNumber, newBase));

            }

        } else {
            ArrayList solution = new ArrayList();

            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {

                int numericValue = Character.getNumericValue(chars[i]);
                solution.add(numericValue);
            }
            int dot = 0;
            for (int i = 0; i < solution.size(); i++) {
                if (solution.get(i).equals(-1)) {
                    dot = i;
                }
            }

            double sumaPierwsza = 0.0;
            for (int i = 0; i < dot; i++) {
                double i1 = ((Integer) solution.get(i)).doubleValue();
                sumaPierwsza = sumaPierwsza + i1 / Math.pow(sourceBase, i + 1);


            }
            double sumaDruga = 0.0;
            for (int i = dot + 1; i < solution.size(); i++) {
                double i1 = ((Integer) solution.get(i)).doubleValue();
                sumaDruga = sumaDruga + i1 / Math.pow(sourceBase, i - 1);
            }


            double suma = 0.0;
            for (int i = dot - 1; i >= 0; --i) {

                convertToSol(solution, (Integer) solution.get(i));

                double i1 = ((Integer) solution.get(i)).doubleValue();

                if (i > 0) {
                    suma = suma + i1 * Math.pow(sourceBase, i - 1);
                }
                if (i == 0) {
                    suma = suma + i1 * Math.pow(sourceBase, dot - 1);
                }
            }


            double suma1 = 0.0;
            for (int i = dot + 1; i < solution.size(); i++) {
                convertToSol(solution, (Integer) solution.get(i));

                double i1 = ((Integer) solution.get(i)).doubleValue();

                suma1 = suma1 + i1 / Math.pow(sourceBase, i - dot);

            }


            double suma2 = suma1 + suma;


            double v = Double.parseDouble(String.valueOf(suma2));


            int calosc = (int) v;
            double first = (v - calosc) * newBase;

            int intPart1 = (int) first;
            convertToSolution(solution, intPart1);

            double decPart1 = first - intPart1;

            double second = decPart1 * newBase;

            int intPart2 = (int) second;
            convertToSolution(solution, intPart2);
            double decPart2 = second - intPart2;

            double third = decPart2 * newBase;
            int intPart3 = (int) third;
            convertToSolution(solution, intPart3);
            double decPart3 = third - intPart3;


            double fourth = decPart3 * newBase;
            int intPart4 = (int) fourth;
            convertToSolution(solution, intPart4);
            double decPart4 = fourth - intPart4;


            double fifth = decPart4 * newBase;
            int intPart5 = (int) fifth;
            convertToSolution(solution, intPart5);


            String s = solution.toString();
            String s1 = s.replace(",", "");
            String s2 = s1.replace(" ", "");
            String s3 = s2.replace("[", "");
            String s4 = s3.replace("]", "");


            convertToSolution(solution, (int) suma1);


            ArrayList<java.io.Serializable> solution1 = new ArrayList<java.io.Serializable>();

            double sec = suma1 * newBase;


            int intPart11 = (int) sec;
            convertToSolution(solution1, intPart11);

            double decPart11 = sec - intPart1;


            double second1 = decPart11 * newBase;

            int intPart21 = (int) second1;
            convertToSolution(solution1, intPart21);
            double decPart21 = second1 - intPart21;


            double third1 = decPart21 * newBase;
            int intPart31 = (int) third1;
            convertToSolution(solution1, intPart31);
            double decPart31 = third1 - intPart31;

            double fourth1 = decPart31 * newBase;
            int intPart41 = (int) fourth1;
            convertToSolution(solution1, intPart41);
            double decPart41 = fourth - intPart41;

            double fifth1 = decPart41 * newBase;
            int intPart51 = (int) fifth1;
            convertToSolution(solution1, intPart51);


            String s00 = solution1.toString();
            String s11 = s00.replace(",", "");
            String s21 = s11.replace(" ", "");
            String s31 = s21.replace("[", "");
            String s41 = s31.replace("]", "");


            System.out.println(Integer.toString((int) suma, newBase) + "." + s41);


        }

    }


    private static void convertToSolution(ArrayList<java.io.Serializable> solution, int intPart1) {
        if (intPart1 <= 9) {
            solution.add(intPart1);
        } else if (intPart1 == 10) {
            solution.add('a');
        } else if (intPart1 == 11) {
            solution.add('b');
        } else if (intPart1 == 12) {
            solution.add('c');
        } else if (intPart1 == 13) {
            solution.add('d');
        } else if (intPart1 == 14) {
            solution.add('e');
        } else if (intPart1 == 15) {
            solution.add('f');
        } else if (intPart1 == 16) {
            solution.add('g');
        } else if (intPart1 == 17) {
            solution.add('h');
        } else if (intPart1 == 18) {
            solution.add('i');
        } else if (intPart1 == 19) {
            solution.add('j');
        } else if (intPart1 == 20) {
            solution.add('k');
        } else if (intPart1 == 21) {
            solution.add('l');
        } else if (intPart1 == 22) {
            solution.add('m');
        } else if (intPart1 == 23) {
            solution.add('n');
        } else if (intPart1 == 24) {
            solution.add('o');
        } else if (intPart1 == 25) {
            solution.add('p');
        } else if (intPart1 == 26) {
            solution.add('q');
        } else if (intPart1 == 27) {
            solution.add('r');
        } else if (intPart1 == 28) {
            solution.add('s');
        } else if (intPart1 == 29) {
            solution.add('t');
        } else if (intPart1 == 30) {
            solution.add('u');
        } else if (intPart1 == 31) {
            solution.add('v');
        } else if (intPart1 == 32) {
            solution.add('w');
        } else if (intPart1 == 33) {
            solution.add('x');
        } else if (intPart1 == 34) {
            solution.add('y');
        } else if (intPart1 == 35) {
            solution.add('z');
        }
    }

    private static void convertToSol(ArrayList<Integer> solution, int intPart) {
        if (intPart == 'A') {
            solution.add(10);
        } else if (intPart == 'B') {
            solution.add(11);
        } else if (intPart == 'C') {
            solution.add(12);
        } else if (intPart == 'D') {
            solution.add(13);
        } else if (intPart == 'E') {
            solution.add(14);
        } else if (intPart == 'F') {
            solution.add(15);
        } else if (intPart == 'G') {
            solution.add(16);
        } else if (intPart == 'H') {
            solution.add(17);
        } else if (intPart == 'I') {
            solution.add(18);
        } else if (intPart == 'J') {
            solution.add(19);
        } else if (intPart == 'K') {
            solution.add(20);
        } else if (intPart == 'L') {
            solution.add(21);
        } else if (intPart == 'M') {
            solution.add(22);
        } else if (intPart == 'N') {
            solution.add(23);
        } else if (intPart == 'O') {
            solution.add(24);
        } else if (intPart == 'P') {
            solution.add(25);
        } else if (intPart == 'Q') {
            solution.add(26);
        } else if (intPart == 'R') {
            solution.add(27);
        } else if (intPart == 'S') {
            solution.add(28);
        } else if (intPart == 'T') {
            solution.add(29);
        } else if (intPart == 'U') {
            solution.add(30);
        } else if (intPart == 'V') {
            solution.add(31);
        } else if (intPart == 'W') {
            solution.add(32);
        } else if (intPart == 'X') {
            solution.add(33);
        } else if (intPart == 'Y') {
            solution.add(34);
        } else if (intPart == 'Z') {
            solution.add(35);
        }
    }

}


