package com.syncrown.androidarchitechturepractice;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.syncrown.androidarchitechturepractice.mvc.MVCActivity;
import com.syncrown.androidarchitechturepractice.mvp.MVPActivity;
import com.syncrown.androidarchitechturepractice.mvvm.MVVMActivity;

public class ArchitechturesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_architechtures);
    }

    public void onMVC(View view) {
        startActivity(MVCActivity.getIntent(this));
    }
    public void onMVP(View view) {
        startActivity(MVPActivity.getIntent(this));
    }
    public void onMVVM(View view) {
        startActivity(MVVMActivity.getIntent(this));
    }
}