package ITMO.Programming.1Lab;
import java.util.Random;
import java.util.Arrays;

public class Laba {

    public static double FirstOperation(int i, int j, float[] x) {

        return Math.asin(Math.pow(Math.exp(1), (Math.cbrt(-Math.pow(Math.sin(x[j]) , 2)))));
        
    }

    public static double SecondOperation(int i, int j, float[] x) {

        return Math.pow(Math.exp(1), (Math.cos(Math.cbrt(x[j]))));

    }

    public static double ThirdOperation(int i, int j, float[] x) {

        double numerator = 1 - Math.pow((0.25 * Math.log(Math.pow(Math.cos(x[j]), 2))), (Math.pow(Math.exp(1), Math.atan((x[j] + 1) / 24))));
        double denominator = 2;
        double Ofpower = Math.cos(Math.pow((Math.PI * (Math.cos(x[j] + 1))) , 2));

        return Math.pow((numerator / denominator), Ofpower);

    }

    public static void OutputOperation(double[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(String.format("%8.3f", array[i][j]) + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        long[] z = new long[] {18, 16, 14, 12, 10, 8, 6};

        float[] x = new float[12];
        for (int i = 0; i < x.length; i++) {x[i] = -11.0f + new Random().nextFloat() * (13.0f - (-11.0f));}

        double[][] z1 = new double[7][12];

        for (int i = 0; i < z.length; i++) {

            for (int j = 0; j < x.length; j++) {

                if (z[i] == 16) {

                    z1[i][j] = FirstOperation(i, j, x);
                    
                } else if (z[i] == 10 || z[i] == 12 || z[i] == 18) {

                    z1[i][j] = SecondOperation(i, j, x);

                } else {

                    z1[i][j] = ThirdOperation(i, j, x);

                }

            }

        }

        System.out.println("First array: " + Arrays.toString(z) + "\n");
        System.out.println("Second array: " + Arrays.toString(x) + "\n");
        System.out.println("Third array:\n");

        OutputOperation(z1);

    }
}