package com.wenny.animation;

import android.animation.TypeEvaluator;
import android.util.Log;

/**
 * Created by ${wenny} on 2017/8/10.
 */

public class MyTypeEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        // fraction：插值器getInterpolation（）的返回值
        // startValue：动画的初始值
        // endValue：动画的结束值
        Log.d("print", "fraction: " + fraction + "\nstartValue "+ startValue + " \nendValue" + endValue);
        return ((Integer)startValue + ((Integer)endValue - (Integer)startValue) * fraction);
    }
}
