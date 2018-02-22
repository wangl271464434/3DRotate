package com.example.td.a3drotate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
    ConstraintLayout layout1;
    Button btn;
    RotationHelper rotateHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout1 = (ConstraintLayout) findViewById(R.id.layout1);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }
    public void jumpToSecond() {
        Intent in = new Intent();
        in.setClass(this, TwoActivity.class);
        // new一个Bundle对象，并将要传递的数据传入  +4
        Bundle bundle = new Bundle();
        bundle.putString("front", "First");
        /* 将Bundle对象assign给Intent */
        in.putExtras(bundle);
        // 如果已经打开过的实例，将不会重新打开新的Activity
        // in.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(in);
        finish();
    }

    @Override
    public void onClick(View v) {
        rotateHelper = new RotationHelper(this, Constants.KEY_FIRST_INVERSE);
        rotateHelper.applyFirstRotation(layout1, 180, 270);
    }
}
