package com.example.lzj.rxandroiddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.lzj.rxandroiddemo.bean.Contributor;
import com.example.lzj.rxandroiddemo.utils.TestUtils;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import rx.Observable;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.bt)
    Button bt;
    private final static String PATH = "https://api.github.com";
    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        TestUtils testUtils = new TestUtils();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testUtils.Test(PATH);
            }
        });
    }

}
