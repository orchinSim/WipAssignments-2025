
import java.util.Scanner;

public class menuDriven {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char Choose;



        do {

        	System.out.println("********** MENU **********\n1. Print Table of a Number\n2. Calculate Factorial\n3. Check Prime Number\n4. Print Fibonacci Series\n5. Exit\n**************************\nEnter your choice: ");

            int choice = sc.nextInt();



            switch (choice) {

                case 1:

                    // Multi-Table

                    System.out.print("enter: ");

                    int a = sc.nextInt();

                    System.out.println("Table" + a);

                    for (int i = 1; i <= 10; i++) {

                        System.out.println(a + " x " + i + " = " + (a * i));

                    }

                    break;



                case 2:

                    // Factorial

                    System.out.print("enter: ");

                    int b = sc.nextInt();

                    long fact = 1;

                    for (int i = 1; i <= b; i++) {

                        fact *= i;

                    }

                    System.out.println("Fact" + b + " is: " + fact);

                    break;



                case 3:

                    // Prime

                    System.out.print("enter: ");

                    int c = sc.nextInt();

                    boolean isPrime = true;



                    if (c <= 1) {

                        isPrime = false;

                    } else {

                        int i = 2;

                        while (i <= c / 2) {

                            if (c % i == 0) {

                                isPrime = false;

                                break;

                            }

                            i++;

                        }

                    }



                    if (isPrime) {

                        System.out.println(c + "prime.");

                    } else {

                        System.out.println(c + "not prime.");

                    }

                    break;



                case 4:

                    // Fibonacci

                    System.out.print("NUM: ");

                    int terms = sc.nextInt();

                    int p = 0, q = 1;

                    System.out.print("Fibonacci: ");

                    for (int i = 1; i <= terms; i++) {

                        System.out.print(p + " ");

                        int next = p + q;

                        a = q;

                        b = next;

                    }

                    System.out.println();

                    break;



                case 5:

                    System.out.println("Exit!");

                    return;



                default:

                    System.out.println("Invalid.");

            }

            System.out.print("\nBack to Menu? (Y/N): ");

            Choose = sc.next().charAt(0);



        } while (Choose == 'Y' || Choose == 'y');



        System.out.println("ended.");

        sc.close();

    }

}