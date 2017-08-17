package com.example.deepthigunasekara.smartdoorlock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button  admin = (Button)findViewById(R.id.admin);         //admin button
        final Button  family = (Button)findViewById(R.id.family);          //family button
        final Button guest = (Button)findViewById(R.id.guest);             //guest button

        admin.setOnClickListener(new View.OnClickListener() {           //admin
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AdminActivity.class));
            }
        });

        family.setOnClickListener(new View.OnClickListener() {          //family
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FamilyActivity.class));
            }
        });
        guest.setOnClickListener(new View.OnClickListener() {           //guest
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GuestActivity.class));
            }
});
    }
}
