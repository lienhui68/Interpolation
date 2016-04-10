package com.eh.arithmetic;

import com.beust.jcommander.internal.Lists;
import com.eh.model.Point;

import java.util.Collections;
import java.util.List;

/**
 * Created by David on 2016/4/10.
 */
public class LagrangeArithmetic extends Arithmetic {

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

        double[] Y0 = lag_method(X, Y, X0);

        for (int i = 0; i < X0.length; i++) {
            newViewPoints.add(new Point((int) X0[i], (int) Y0[i]));
        }
        return newViewPoints;
    }

    private static double[] lag_method(int X[], int Y[], double X0[]) {
        int m = X.length;
        int n = X0.length;
        double Y0[] = new double[n];
        for (int i1 = 0; i1 < n; i1++) {
            double t = 0;
            for (int i2 = 0; i2 < m; i2++) {
                double u = 1;
                for (int i3 = 0; i3 < m; i3++) {
                    if (i2 != i3) {
                        u = u * (X0[i1] - X[i3]) / (X[i2] - X[i3]);
                    }
                }
                u = u * Y[i2];
                t = t + u;
            }
            Y0[i1] = t;
        }

        return Y0;

    }
}
