package com.example.paavai_budget_plan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash_Screen extends AppCompatActivity {

    ImageView piggyImage;
    TextView TopText,BottomText;

    // Declaring the Splash duration in int type
    private static int SPLASH_SCREEN = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        // This to remove the title
        // requestWindowFeature(Window.FEATURE_NO_TITLE);

        // This is to hide the action bar
         getSupportActionBar().hide();

        // This is to flag full screen activity
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        // Hooking
        piggyImage = findViewById(R.id.Piggy_Icon_Splash);
        TopText = findViewById(R.id.Splash_Paavai);
        BottomText = findViewById(R.id.Splash_Paavai_BudgetPlan);

        // By using the threads in main thread or UI thread it causes memory leak
        // Instead of using that, will wrap the thread in the handler class

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();

            }
        },SPLASH_SCREEN);


    }
}