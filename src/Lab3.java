import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        int taskNumber;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of the task");
        taskNumber = scan.nextInt();

        switch (taskNumber) {
            case 1:
                System.out.println("Enter the number of elements ");
                int n = scan.nextInt(), numberOfZero = 0;
                double a, max = -1000000.0;
                double array[] = new double[n];

                for (int i = 0; i < n; i++) {
                    System.out.println("Enter value of element " + (i + 1) + " ");
                    a = scan.nextDouble();
                    array[i] = a;

                    if (a > max) {
                        max = a;
                    }
                    if (Math.round(a) == 0) {
                        numberOfZero++;
                    }
                }

                System.out.println("1. Max value: " + max);

                if (numberOfZero < 2) {
                    System.out.println("2. Lack of zero elements");
                } else {
                    boolean start = false;
                    double total = 1;
                    for (int i = 0; i < n; i++) {
                        if (start && Math.round(array[i]) == 0) {
                            break;
                        } else if (start) {
                            total *= array[i];
                        } else if (!start && Math.round(array[i]) == 0) {
                            start = true;
                        }
                    }
                    System.out.println("2. Result: " + total);
                }

                double tmp;
                int index;
                System.out.println("Sorting start");
                for (int i = 1; i <= Math.floorDiv(n, 2); i += 2) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(array[j] + "\t");
                    }
                    System.out.println();
                    index = n - i - 1 + i % 2;
                    tmp = array[index];
                    array[index] = array[i];
                    array[i] = tmp;
                }
                System.out.println("Sorting result");
                for (int j = 0; j < n; j++) {
                    System.out.print(array[j] + "\t");
                }
                break;
            case 2:
                System.out.println("Enter the number of rows ");
                int rows = scan.nextInt();
                System.out.println("Enter the number of columns ");
                int columns = scan.nextInt();
                double matrix[][] = new double[rows][columns];

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        System.out.println("Enter value of element " + (i + 1) + " " + (j + 1));
                        matrix[i][j] = scan.nextDouble();
                    }
                }

                System.out.println("Choose row for 1st element");
                int row1 = scan.nextInt();
                System.out.println("Choose column for 1st element");
                int column1 = scan.nextInt();
                System.out.println("Choose row for 2nd element");
                int row2 = scan.nextInt();
                System.out.println("Choose column for 2nd element");
                int column2 = scan.nextInt();

                System.out.println("Subtraction: " + (matrix[row1 - 1][column1 - 1] - matrix[row2 - 1][column2 - 1]));
                System.out.println("Geometric mean: " + Math.sqrt(matrix[row1 - 1][column1 - 1] * matrix[row2 - 1][column2 - 1]));

        }
        scan.close();
    }
}
