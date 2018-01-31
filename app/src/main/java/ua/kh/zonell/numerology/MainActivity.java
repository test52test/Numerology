package ua.kh.zonell.numerology;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.methodOne, R.id.methodTwo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.methodOne:
                startActivity(new Intent(this, PageOne.class));
                break;
            case R.id.methodTwo:
                startActivity(new Intent(this, PageTWO.class));
                break;
        }
    }
}