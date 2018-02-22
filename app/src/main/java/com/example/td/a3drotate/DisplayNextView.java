package com.example.td.a3drotate;

import android.app.Activity;
import android.view.animation.Animation;

/**
 * Created by td on 2018/2/22.
 */

public class DisplayNextView implements Animation.AnimationListener {

    Object obj;

    // 动画监听器的构造函数
    Activity ac;
    int order;

    public DisplayNextView(Activity ac, int order) {
        this.ac = ac;
        this.order = order;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        doSomethingOnEnd(order);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    private final class SwapViews implements Runnable {
        public void run() {
            switch (order) {
                case Constants.KEY_FIRST_INVERSE:
                    ((MainActivity) ac).jumpToSecond();
                    break;
                case Constants.KEY_SECOND_CLOCKWISE:
                    ((TwoActivity) ac).jumpToFirst();
                    break;
            }
        }
    }

    public void doSomethingOnEnd(int _order) {
        switch (_order) {
            case Constants.KEY_FIRST_INVERSE:
                ((MainActivity) ac).layout1.post(new SwapViews());
                break;

            case Constants.KEY_SECOND_CLOCKWISE:
                ((TwoActivity) ac).layout2.post(new SwapViews());
                break;
        }
    }
}