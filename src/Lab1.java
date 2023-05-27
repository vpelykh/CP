import java.util.Scanner;
import java.lang.Math;

public class Lab1 {
    public static double findHeight(double oppositeSide, double secondSide, double thirdSide) {
        double p = (oppositeSide + secondSide + thirdSide) / 2;
        return (2 / oppositeSide) * Math.sqrt(p * (p - oppositeSide) * (p - secondSide) * (p - thirdSide));
    }

    public static double calculatePolygonArea(double radius, int anglesNumber) {
        return anglesNumber * Math.pow(radius, 2) * Math.tan(Math.toRadians(180.0 / anglesNumber));
    }

    public static double calculatePolygonPerimeter(double radius, int anglesNumber) {
        double sideLength = 2 * radius * Math.tan(Math.toRadians(180.0 / anglesNumber));
        return sideLength * anglesNumber;
    }

    public static double calculateSegmentArea(double radius, double chord) {
        double angle = 2 * Math.toDegrees(Math.asin(chord / (2 * radius)));
        return Math.pow(radius, 2) / 2 * (Math.PI * angle / 180 - Math.sin(Math.toRadians(angle)));
    }

    public static void main(String[] args) {
        int n, taskNumber, at, bt, ct;
        double r, a_num, a, b, x, y, d1, d2, d3, d4, d5, d6, S;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of the task");
        taskNumber = scan.nextInt();

        switch(taskNumber) {
            case 1:
                System.out.println("Enter the number to get to the power of 28 ");
                a_num = scan.nextInt();
                d1 = a_num * a_num;
                d2 = d1 * a_num;
                d3 = d2 * d1;
                d4 = d3 * d1;
                d5 = d4 * d4;
                d6 = d5 * d5;
                System.out.println("Result is " + d6);
                break;
            case 2:
                System.out.print("Enter the value of X ");
                x = scan.nextInt();
                System.out.print("Enter the value of Y ");
                y = scan.nextInt();
                a = Math.log((y - Math.sqrt(Math.abs(x))) * (x - (y / (x + Math.pow(x, 2) / 4))));
                b = Math.pow(1 - Math.tan(Math.toRadians(x)), 1.0 / Math.tan(Math.toRadians(x))) + Math.cos(Math.toRadians(x - y));
                System.out.println("a " + a);
                System.out.println("b = " + b);
                break;
            case 3:
                System.out.println("Enter the length of A side of a triagle");
                at = scan.nextInt();
                System.out.println("Enter the length of B side of a triagle");
                bt = scan.nextInt();
                System.out.println("Enter the length of C side of a triagle");
                ct = scan.nextInt();
                System.out.println("The opposite to A height: " + findHeight(at, bt, ct));
                System.out.println("The opposite to B height: " + findHeight(bt, at, ct));
                System.out.println("The opposite to C height: " + findHeight(ct, bt, at));
                break;
            case 4:
                System.out.println("Enter the radius ");
                r = scan.nextInt();
                System.out.println("Enter the number of angles: ");
                n = scan.nextInt();
                System.out.println("Area of the polygon is " + calculatePolygonArea(r, n));
                System.out.println("Perimeter of the polygon is " + calculatePolygonPerimeter(r, n));
                break;
            case 5:
                System.out.println("Enter the length of chord: ");
                a = scan.nextInt();
                System.out.println("Enter the length of radius");
                r = scan.nextInt();
                System.out.println("Answer: " + Math.PI * Math.pow(r, 2) / calculateSegmentArea(r, a));
                break;
        }
        scan.close();
    }
}
