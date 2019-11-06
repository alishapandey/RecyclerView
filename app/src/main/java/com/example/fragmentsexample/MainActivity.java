package com.example.fragmentsexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragmentsexample.fragments.FirstFragment;
import com.example.fragmentsexample.fragments.SecondFragment;

public class MainActivity extends AppCompatActivity {

    private Button btnFragment;
    private Boolean status = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragment = findViewById(R.id.btnFragment);
        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if(status){
                    FirstFragment first = new FirstFragment();
                    fragmentTransaction.add(R.id.fragmentContainer,first);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    btnFragment.setText("Load Second Fragment");
                    status = false;
                }else{
                    SecondFragment second = new SecondFragment();
                    fragmentTransaction.add(R.id.fragmentContainer,second);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    btnFragment.setText("Load First Fragment");
                    status = true;
                }
            }
        });
    }
}
