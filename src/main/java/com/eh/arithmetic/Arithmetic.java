package com.eh.arithmetic;

import com.eh.enums.InterpolationKind;
import com.eh.model.Point;

import java.util.List;

/**
 * Created by David on 2016/4/10.
 */
public abstract class Arithmetic {
    public static Arithmetic lagrangeArithmetic = new LagrangeArithmetic();
    public static Arithmetic newtonArithmetic = new NewtonArithmetic();
    public static Arithmetic splineArithmetic = new SplineArithmetic();

    public static Arithmetic buildArithmetic(InterpolationKind interpolationKind) {
        switch (interpolationKind) {
            case Lagrange:
                return lagrangeArithmetic;
            case Newton:
                return newtonArithmetic;
            case Spline:
                return splineArithmetic;
            default:
                return lagrangeArithmetic;
        }
    }

    public abstract List<Point> buildViewPoints(List<Point> viewPoints);
}
