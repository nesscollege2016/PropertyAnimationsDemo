package ness.tomerbu.edu.propertyanimationsdemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView ivDroid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ivDroid = (ImageView) findViewById(R.id.ivDroid);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void fadeIn(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            Animator anim =
                    AnimatorInflater.loadAnimator(this, R.animator.fade_in);
            anim.setTarget(view);
            anim.start();
         }
    }

    public void fade(View view) {
        Animator anim = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            anim = AnimatorInflater.loadAnimator(this, R.animator.fade);
            anim.setTarget(ivDroid);
            anim.start();
        }
    }
    public void scale(View view) {
        Animator anim = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            anim = AnimatorInflater.loadAnimator(this, R.animator.scale);
            anim.setTarget(ivDroid);
            anim.start();
        }
    }
    public void rotate(View view) {
        Animator anim = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            anim = AnimatorInflater.loadAnimator(this, R.animator.rotate);
            anim.setTarget(ivDroid);
            anim.start();
        }
    }
    public void slide(View view) {
        Animator anim = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            anim = AnimatorInflater.loadAnimator(this, R.animator.slide);
            anim.setTarget(ivDroid);
            anim.start();
        }
    }

    public void viewPropertyAnimator(View view) {
/*        if (android.os.Build.VERSION.SDK_INT >=
                Build.VERSION_CODES.HONEYCOMB_MR1) {
            ivDroid.animate()
                    .alpha(0)
                    .rotation(180)
                    .rotationX(180)
                    .setDuration(4000)
                    .setInterpolator(new CycleInterpolator(2));
        }*/

        ViewCompat.animate(ivDroid)
                .alpha(0)
                .rotation(180)
                .rotationX(180)
                .setDuration(4000)
                .setInterpolator(new CycleInterpolator(2));
    }

    public void fab(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            ObjectAnimator anim = ObjectAnimator.ofFloat(ivDroid, "scaleX", 1,2, 3, 4, 2);
                anim.setRepeatCount(2);
            anim.setRepeatMode(ValueAnimator.RESTART);

            ObjectAnimator anim2 = ObjectAnimator.ofFloat(ivDroid, "scaleX", 1,2, 3, 4, 2);
            anim2.setRepeatCount(2);
            anim2.setRepeatMode(ValueAnimator.RESTART);

            AnimatorSet set = new  AnimatorSet();
            set.playTogether(anim, anim2);
            set.start();
        }
    }
}
