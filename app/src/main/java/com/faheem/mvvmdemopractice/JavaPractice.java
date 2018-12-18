package com.faheem.mvvmdemopractice;

import java.util.ArrayList;
import java.util.Scanner;

public class JavaPractice {

    public static void main(String args[]) {
//        pattern(); // TEST
//        numericEgyptPattern();
//        PyramidPattern2();
//        pattern3();
//        pattern4();
//        pattern_TEST();

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        ArrayList<Integer> list2 = list1;
        System.out.println(list1);
        System.out.println(list2);

        list2.clear();
        System.out.println(list1);
    }

    private static void numericEgyptPattern() {
        System.out.println("Enter no of lines of Pyramid");
        Scanner input = new Scanner(System.in);
        int numOfLines = input.nextInt();

        for (int i = 0; i < numOfLines; i++) {
            // loop for spaces
            for (int j = 0; j < (numOfLines - 1) - i; j++) {
                System.out.print(" ");
            }
            // loop for reverse int
            for (int k = i; k >= 0; k--) {
                System.out.print(k);
            }
            //loop for int
            for (int l = 1; l <= i; l++) {
                System.out.print(l);
            }
            System.out.println();
        }
    }

    private static void pattern() {

        System.out.println("Enter a string to print its pattern");
        Scanner input = new Scanner(System.in);

        String userInput = input.nextLine();
        int ln = userInput.length();
        for (int i = 1; i < (ln * 2); i++) {
            for (int j = 0; j < (ln - i); j++) {
                System.out.print(" ");
            }
            if (ln >= i) {
                for (int k = 0; k < i; k++) {
                    System.out.print(userInput.charAt(k));
                }
            } else {
                for (int l = i - ln; l < ln; l++) {
                    System.out.print(userInput.charAt(l));
                }
            }
            System.out.print("\n");
        }
    }

    private static void PyramidPattern2() {
        System.out.println("Enter no of lines");
        Scanner input = new Scanner(System.in);
        int ln = input.nextInt();

        for (int i = 1; i <= ln; i++) {

            for (int j = 0; j < ln - i; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < i; k++) {
                if (k % 2 == 0) {
                    System.out.print(i);
                } else {
                    System.out.print(" ");
                }
            }

            for (int l = i; l > 0; l--) {
                if (l % 2 == 0) {
                    System.out.print(i);
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();

        }
    }

    private static void pattern3() {
        int ln = 7;
        for (int i = 1; i < ln * 2; i++) {
            if (i <= ln) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(j);
                }
            } else {
                for (int k = 1; k <= (ln - (i - ln)); k++) {
                    System.out.print(k);
                }
            }
            System.out.println();
        }
    }

    private static void pattern4() {
        int ln = 7;
        for (int i = ln; i > 0; i--) {
            for (int j = ln; j > ln - i; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    private static void pattern_TEST() {
        System.out.println("Please enter string to print pattern");

        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        int ln = str.length();

        for (int i = 0; i < ln * 2; i++) {
            // loop for spaces
            for (int j = 0; j < (ln - i) - 1; j++) {
                System.out.print(" ");
            }

            if (i < ln) {
                for (int k = 0; k <= i; k++) {
                    System.out.print(str.charAt(k));
                }
            } else {
                for (int l = (i - ln) + 1; l<ln; l++){
                    System.out.print(str.charAt(l));
                }
            }
            System.out.println();
        }
    }
}
