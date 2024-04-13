package tester;

import static java.lang.Thread.sleep;

public class Test {

    public static int move(int steps, int xc, int yc, double degrees) {
        int originalXc = xc;
        int originalYc = yc;
        for (int i=0;i<steps;i++) {
            System.out.println("sin: " + Math.sin(Math.PI * (double) degrees / 180.0));
            System.out.println("cos: " + Math.cos(Math.PI * (double) degrees / 180.0));
            double newXc = (i+1) * Math.sin(Math.PI * (double) degrees / 180.0);
            double newYc = (i+1) * Math.cos(Math.PI * (double) degrees / 180.0);
            xc = originalXc + (int) newXc;
            yc = originalYc + (int) newYc;
            System.out.println(xc + " " + yc);
        }
        System.out.println(xc + " " + yc);
        return xc;
    }

    public static void testAgent_Move() {
        int result = move(10, 0,0,120);
        System.out.println("xc is correct? " + (result == 3));
        assert result == 3;
    }

    public static void main(String[] args) {
        testAgent_Move();
        System.out.println(((-9 % 4) + 4) % 4 == 3);
        System.out.println(((9 % 4) + 4) % 4 == 1);
    }
}
