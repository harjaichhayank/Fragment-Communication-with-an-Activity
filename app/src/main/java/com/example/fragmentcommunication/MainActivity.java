package com.example.fragmentcommunication;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements ColorFragment.OnColorChangeListener {

    LinearLayout linearLayout;
    String color_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.main_layout);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        ColorFragment colorFragment = new ColorFragment();
        fragmentTransaction.add(R.id.fragment_container,colorFragment);
        fragmentTransaction.commit();

    }

    @Override
    public void colorChanged(String color_name) {
        this.color_name = color_name;
        switch (color_name){
            case "RED":
                linearLayout.setBackgroundColor(Color.RED);
                break;
            case "BLUE":
                linearLayout.setBackgroundColor(Color.BLUE);
                break;
            case "GREEN":
                linearLayout.setBackgroundColor(Color.GREEN);
                break;
        }
    }
}
