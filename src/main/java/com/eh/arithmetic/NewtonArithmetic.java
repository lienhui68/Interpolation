package com.eh.arithmetic;

import com.beust.jcommander.internal.Lists;
import com.eh.model.Point;

import java.util.Collections;
import java.util.List;

/**
 * Created by David on 2016/4/10.
 */
public class NewtonArithmetic extends Arithmetic {
    @Override
    public List<Point> buildViewPoints(List<Point> viewPoints) {
        Collections.sort(viewPoints);
        List<Point> newViewPoints = buildNewViewPoints(viewPoints);
        return newViewPoints;
    }

    private List<Point> buildNewViewPoints(List<Point> viewPoints) {
        List<Point> newViewPoints = Lists.newArrayList();
        int minX = viewPoints.get(0).getX();
        int maxX = viewPoints.get(viewPoints.size() - 1).getX();
        int X[] = new int[viewPoints.size()];
        int Y[] = new int[viewPoints.size()];
        for (int i = 0; i < viewPoints.size(); i++) {
            Point p = viewPoints.get(i);
            X[i] = p.getX();
            Y[i] = p.getY();
        }

        double[] X0 = new double[(maxX - minX) * 100];
        int num = 0;
        for (double x = minX; num < X0.length; x += 0.01, num++) {
            X0[num] = x;
        }

        double[] Y0 = newton_inter_method(convertIntArr2DoubleArr(X), convertIntArr2DoubleArr(Y), X0);

        for (int i = 0; i < X0.length; i++) {
            newViewPoints.add(new Point((int) X0[i], (int) Y0[i]));
        }
        return newViewPoints;
    }

    private static double[] newton_inter_method(double[] X, double[] Y, double X0[]) {
        int m = X.length;
        int n = X0.length;
        double[] Y0 = new double[n];
        double[] cp_Y = new double[m];
        for (int i1 = 0; i1 < n; i1++) {
            int j = 0;
            copy_vector(Y, cp_Y);
            int kk = j;
            while (kk < m - 1) {
                kk = kk + 1;
                for (int i2 = kk; i2 < m; i2++) {
                    cp_Y[i2] = (cp_Y[i2] - cp_Y[kk - 1]) / (X[i2] - X[kk - 1]);
                }
            }
            double temp = cp_Y[0];
            for (int i = 1; i <= m - 1; i++) {
                double u = 1;
                int jj = 0;
                while (jj < i) {
                    u *= (X0[i1] - X[jj]);
                    jj++;
                }
                temp += cp_Y[i] * u;
            }

            Y0[i1] = temp;
        }

        return Y0;
    }

    private static void copy_vector(double from[], double to[]) {
        int k = from.length;
        int k2 = to.length;
        if (k != k2) {
            System.out.println("the two vector's length is not equal!");
            System.exit(0);
        }
        for (int i = 0; i < k; i++) {
            to[i] = from[i];
        }

    }

    private double[] convertIntArr2DoubleArr(int[] intArr) {
        double[] doubleArr = new double[intArr.length];
        for (int i = 0; i < intArr.length; i++) {
            doubleArr[i] = intArr[i];
        }
        return doubleArr;
    }
}
