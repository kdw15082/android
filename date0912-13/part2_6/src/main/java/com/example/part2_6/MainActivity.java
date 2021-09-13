package com.example.part2_6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    TextView bellTextView;
    TextView labelTextView;
    CheckBox repeatCheckview;
    CheckBox vibrateCheckView;
    Switch switchView;
    float initX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bellTextView = findViewById(R.id.bell_name);
        labelTextView = findViewById(R.id.label);
        repeatCheckview = findViewById(R.id.repeatCheck);
        vibrateCheckView = findViewById(R.id.vibrate);
        switchView = findViewById(R.id.onOff);


        bellTextView.setOnClickListener(this);
        labelTextView.setOnClickListener(this);

        repeatCheckview.setOnCheckedChangeListener(this);
        vibrateCheckView.setOnCheckedChangeListener(this);
        switchView.setOnCheckedChangeListener(this);
    }

    public void showToast(String message){
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onClick(View v){
        if (v==bellTextView){
            showToast("bell text click event...");
        }else if(v == labelTextView){
            showToast("label text click evetn...");
        }
    }

    @Override
    public void onCheckedChanged (CompoundButton buttonView, boolean isChecked){
        if (buttonView == repeatCheckview){
            showToast("repeat check box is" + isChecked);
        }else if(buttonView == vibrateCheckView){
            showToast("vibrate checkbox is" + isChecked);
        }else if(buttonView == switchView){
            showToast("switch is" + isChecked);
        }
    }
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            initX=event.getRawX();
        }else if(event.getAction()==MotionEvent.ACTION_UP){

            float diffx = initX-event.getRawX();
            if (diffx > 30) {
                showToast("왼쪽으로 화면을 밀었습니다.");
            } else if (diffx < -30) {
                showToast("오른쪽으로 화면을 밀었습니다.");
            }

        }
        return true;
    }
}
