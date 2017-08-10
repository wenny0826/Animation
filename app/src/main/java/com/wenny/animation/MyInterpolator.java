package com.wenny.animation;


import android.view.animation.Interpolator;

/**
 * Created by ${wenny} on 2017/8/10.
 */

public class MyInterpolator implements Interpolator {

    @Override
    public float getInterpolation(float input) {
        float result;
        result = input * input;
        return result;
    }
}
