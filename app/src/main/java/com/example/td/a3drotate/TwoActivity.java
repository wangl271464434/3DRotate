package com.example.td.a3drotate;

import android.app.Activity;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TwoActivity extends Activity implements View.OnClickListener{
    ConstraintLayout layout2;
    Button btn;
    RotationHelper rotateHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        layout2 = (ConstraintLayout) findViewById(R.id.layout2);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }
    public void jumpToFirst() {
        Intent in = new Intent();
        in.setClass(this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("second", "Second");
        in.putExtras(bundle);
        startActivity(in);
        finish();
    }

    @Override
    public void onClick(View v) {
        rotateHelper = new RotationHelper(this,
                Constants.KEY_SECOND_CLOCKWISE);
        rotateHelper.applyFirstRotation(layout2, 0, -90);
    }
}
