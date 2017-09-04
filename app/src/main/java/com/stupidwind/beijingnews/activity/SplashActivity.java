package com.stupidwind.beijingnews.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Toast;

import com.stupidwind.beijingnews.R;
import com.stupidwind.beijingnews.utils.CacheUtil;

public class SplashActivity extends AppCompatActivity {

    private static final String START_MAIN = "start_main";

    // 动画持续时长
    private static final int DURATION = 2000;

    private View rl_splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        rl_splash = findViewById(R.id.rl_splash);

        // 渐变、缩放、旋转动画
        AlphaAnimation aa = new AlphaAnimation(0, 1);
        aa.setFillAfter(true);

        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1, ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
        sa.setFillAfter(true);

        RotateAnimation ra = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        ra.setFillAfter(true);

        // 添加动画
        AnimationSet set = new AnimationSet(false);
        set.addAnimation(aa);
        set.addAnimation(sa);
        set.addAnimation(ra);
        set.setDuration(DURATION);

        set.setAnimationListener(new MyAnimationListener());

        rl_splash.startAnimation(set);
    }

    class MyAnimationListener implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            // 判定是否进入过主页面
            boolean isStartMain = CacheUtil.getBoolean(SplashActivity.this, START_MAIN);
            if(isStartMain) {
                // 如果进入过主页面，直接进入主页面
            } else {
                // 如果没进入过主页面，则进入向导页面
                Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
                startActivity(intent);
            }

            // 关闭splash页面
            finish();

            // Toast.makeText(SplashActivity.this, "动画播放完成了", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

}
