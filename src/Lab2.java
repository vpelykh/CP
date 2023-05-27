import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class Lab2 {

    public static void main(String[] args) {
        int n, taskNumber, m, numberOfFive, numberOFThree, numberOfTwo;
        double r, a_num, a, b, x, c, d, res1, res2, res4, previous, sum;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of the task");
        taskNumber = scan.nextInt();

        switch (taskNumber) {
            case 1:
                System.out.println("Enter a:");
                a = scan.nextDouble();
                System.out.println("Enter b:");
                b = scan.nextDouble();
                System.out.println("Enter c:");
                c = scan.nextDouble();

                d = Math.pow(b, 2) - 4 * a * c;
                x = (Math.sqrt(d) - b) / (2 * a);
                if (x == 0 && b != 0) {
                    System.out.println("F = " + (a * Math.pow(x + c, 2) - b));
                } else if (x == 0) {
                    System.out.println("F = " + ((x - a) / -c));
                } else {
                    System.out.println("F = " + (a + (x / c)));
                }
                break;
            case 2:
                System.out.print("Enter the number");
                m = scan.nextInt();

                switch (m) {
                    case 1:
                        System.out.print("піки");
                        break;
                    case 2:
                        System.out.print("трефи");
                        break;
                    case 3:
                        System.out.print("бубни");
                        break;
                    case 4:
                        System.out.print("черви");
                        break;
                    default:
                        System.out.print("Incorrect m");
                }
                break;
            case 3:
                System.out.println("Enter the number of elements ");
                n = scan.nextInt();
                res1 = 0;
                res2 = 1;
                res4 = 0;
                previous = 0;
                double res3[] = new double[n + 1];


                for (int i = 0; i < n; i++) {
                    System.out.println("Enter the resistance of element " + (i + 1) + " ");
                    a = scan.nextDouble();
                    res1 += Math.abs(a);
                    res2 *= a;

                    res3[i] = a + previous;
                    previous = a;

                    res4 += (-1 + ((i + 1) % 2 * 2)) * a;
                }


                System.out.println("Result 1: " + res1);
                System.out.println("Result 2: " + res2);
                System.out.print("Result 3: ");

                for (int i = 1; i < n; i++) {
                    System.out.print(res3[i] + " ");
                }

                System.out.println();
                System.out.println("Result 4: " + res4);
                break;
            case 4:
                System.out.println("Enter n");
                a_num = scan.nextDouble();
                sum = 1;
                n = 1;

                while (a_num >= sum) {
                    sum += (double) 1 / n;
                }

                System.out.println("Result: " + sum);
                break;
            case 5:
                int[][] matrix = { { 3, 2, 1 },
                        { 5, 4, 3},
                        { 5, 4, 5},
                        { 4, 4, 5},
                        { 4, 4, 3},
                        { 4, 4, 3},
                        { 2, 4, 3},
                        { 2, 4, 3},
                        { 2, 2, 3},
                        { 5, 4, 3},
                        { 5, 4, 5},
                        { 4, 4, 5},
                        { 4, 4, 3},
                        { 4, 4, 3},
                        { 2, 4, 3},
                        { 2, 4, 3},
                        { 2, 2, 3},
                        { 5, 2, 4 } };

                System.out.println("\t\t\tSubject 1\t Subject 2\t Subject 3\t Number Of 3");

                for (int i = 0; i < matrix.length; i++) {
                    numberOFThree = 0;
                    System.out.print("Student " + (i + 1) + "\t\t");

                    for (int j = 0; j < matrix[i].length; j++) {
                        System.out.print(matrix[i][j] + "\t\t\t");

                        if (matrix[i][j] == 3) {
                            numberOFThree++;
                        }

                    }
                    System.out.println(numberOFThree);

                }

                numberOfFive = 0;
                System.out.print("\nNumber of 2: \t");
                for (int j = 0; j < matrix[0].length; j++) {
                    numberOfTwo = 0;
                    for (int i = 0; i < matrix.length; i++) {
                        if (matrix[i][j] == 3) {
                            numberOfTwo++;
                        } else if (matrix[i][j] == 5) {
                            numberOfFive++;
                        }

                    }
                    System.out.print(numberOfTwo + "\t\t\t");
                }
                System.out.print("\nNumber of 5: " + numberOfFive);

                break;
        }
        scan.close();
    }
}
