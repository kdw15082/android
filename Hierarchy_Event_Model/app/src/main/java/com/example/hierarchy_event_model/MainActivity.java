package com.example.hierarchy_event_model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hierarchy_event_model.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    TextView bellTextView;
    TextView labelTextView;
    CheckBox repeatCheckview;
    CheckBox vibrateCheckView;
    Switch switchView;
    float initX;
    long initTime = 0;

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
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - initTime > 3000) {
                //back 버튼을 누른지 3초 지난거라면..
                showToast("종료하려면 한 번 더 누르세요.");
                //현재 시간 저장
                initTime = System.currentTimeMillis();
            } else {
                //3초 이내에 Back 버튼이 두번 눌린 경우. Activity 종료
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }
}
