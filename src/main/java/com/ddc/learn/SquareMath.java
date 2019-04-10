package com.ddc.learn;

/**
 * 求整数平方根
 */
public class SquareMath {
    public static void main(String[] args) {
        double id = 17;
        System.out.println(getSquareRoot(id));
    }

    private static int getSquareRoot(double id) {
        double middle, square;
        double min = 0;
        double max = id;

        while(max - min > 0.0000001) {
            middle = (min + max) / 2;
            square = middle * middle;
            if(square > id) {
                max = middle;
            } else {
                min = middle;
            }
        }

        return (int) ((min + max) / 2);
    }
}
