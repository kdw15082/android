package com.example.db_practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import io.realm.Realm;

public class RealmReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm_read);

        TextView titleView=findViewById(R.id.realm_read_title);
        TextView contentview=findViewById(R.id.realm_read_content);

        //넘어온 title 문자열 추출
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");

        Realm mRealm=Realm.getDefaultInstance();
        MemoVO vo = mRealm.where(MemoVO.class).equalTo("title", title).findFirst();
        titleView.setText(vo.title);
        contentview.setText(vo.content);
    }
}
