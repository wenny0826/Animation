package com.wenny.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Interpolator;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewAnimator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private Button button;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        image = (ImageView) findViewById(R.id.image);
        context = this;
        button.setOnClickListener(this);
    }
    private void startValueAnimator(){
        ValueAnimator anim = ValueAnimator.ofFloat(0f, 1f);
        anim.setDuration(200);
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float)animation.getAnimatedValue();
                image.setTranslationX(animatedValue);
            }
        });
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                //动画启动时调用
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //当动画结束时调用
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                //当动画被取消调用,被取消的动画还会调用onAnimationEnd方法
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                //当动画重演调用
            }
        });
    }
    private void startObjectAnimator(){
//      ObjectAnimator.ofFloat(image,"rotationX",0.0f,180f)
//              .setDuration(100)
//              .start();
//        new IntEvaluator()
        ObjectAnimator objectAnimator = ObjectAnimator.ofObject(image,"translationX",new MyTypeEvaluator(),0,200);
        objectAnimator.setDuration(500);
        objectAnimator.start();
    }
    private void animatorSet(){
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(image, "translationX", -500f, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(image, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(image, "alpha", 1f, 0f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        //三个动画按顺序执行
//        animSet.play(rotate).with(fadeInOut).after(moveIn);

        //三个动画同时执行
        animSet.playTogether(moveIn,rotate,fadeInOut);

        animSet.setDuration(5000);
        animSet.start();
    }

    private void startViewAnimator(){
        TranslateAnimation rotateAnimation = new TranslateAnimation(0,200,0,0);
        rotateAnimation.setDuration(500);
        //创建对于的插值器
        MyInterpolator interpolator = new MyInterpolator();
        //设置插值器
        rotateAnimation.setInterpolator(interpolator);
        image.startAnimation(rotateAnimation);

//        Animation animation = AnimationUtils.loadAnimation(context,R.anim.view_anin);
//        image.startAnimation(animation);

    }

    private void startDrawableAnimator(){
        // 通过逐帧动画的资源文件获得AnimationDrawable示例
//        AnimationDrawable animationDrawable =(AnimationDrawable) getResources().getDrawable(R.drawable.animation_loading);
//        image.setImageDrawable(animationDrawable);
//        animationDrawable.start();

        AnimationDrawable drawable = new AnimationDrawable();
        drawable.addFrame(getResources().getDrawable(R.drawable.loading_1),100);
        drawable.addFrame(getResources().getDrawable(R.drawable.loading_2),100);
        drawable.addFrame(getResources().getDrawable(R.drawable.loading_3),100);
        drawable.addFrame(getResources().getDrawable(R.drawable.loading_4),100);
        drawable.addFrame(getResources().getDrawable(R.drawable.loading_5),100);
        drawable.addFrame(getResources().getDrawable(R.drawable.loading_6),100);
        drawable.addFrame(getResources().getDrawable(R.drawable.loading_7),100);
        drawable.addFrame(getResources().getDrawable(R.drawable.loading_8),100);
        drawable.addFrame(getResources().getDrawable(R.drawable.loading_9),100);
        drawable.addFrame(getResources().getDrawable(R.drawable.loading_10),100);
        drawable.addFrame(getResources().getDrawable(R.drawable.loading_11),100);
        drawable.addFrame(getResources().getDrawable(R.drawable.loading_12),100);
        drawable.setOneShot(true);
        image.setImageDrawable(drawable);
        drawable.start();
    }


    @Override
    public void onClick(View v) {
        startObjectAnimator();
    }
}
