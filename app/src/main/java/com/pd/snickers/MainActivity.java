package com.pd.snickers;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;



import com.pd.chocobar.ChocoBar;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_default).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ChocoBar.builder().setActivity(MainActivity.this).setActionText("ACTION").setActionClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this,"You clicked",Toast.LENGTH_LONG).show();
                            }
                        }).setText("This is a normal ChocoBar").setDuration(ChocoBar.LENGTH_INDEFINITE).build().show();
            }
        });

        findViewById(R.id.button_success).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChocoBar.builder().setActivity(MainActivity.this).setText("GREEN").setDuration(ChocoBar.LENGTH_SHORT).green().show();
            }
        });

        findViewById(R.id.button_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar warningSnackBar = ChocoBar.builder().setActivity(MainActivity.this).setText("ORANGE").setDuration(ChocoBar.LENGTH_LONG).orange();
                warningSnackBar.show();
            }
        });

        findViewById(R.id.button_warning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChocoBar.builder().setView(v).setText("CYAN").centerText().setDuration(ChocoBar.LENGTH_LONG).cyan().show();
            }
        });

        findViewById(R.id.button_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChocoBar.builder().setView(v).setText("RED").setDuration(ChocoBar.LENGTH_INDEFINITE).setActionText(android.R.string.ok).red().show();
            }
        });

        findViewById(R.id.button_custom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChocoBar.builder().setBackgroundColor(Color.parseColor("#00bfff")).setTextSize(18).setTextColor(Color.parseColor("#FFFFFF")).setTextTypefaceStyle(Typeface.ITALIC).setText("This is a custom Chocobar").setMaxLines(4).centerText().setActionText("ChocoBar").setActionTextColor(Color.parseColor("#66FFFFFF")).setActionTextSize(20).setActionTextTypefaceStyle(Typeface.BOLD).setIcon(R.mipmap.ic_launcher).setActivity(MainActivity.this).setDuration(ChocoBar.LENGTH_INDEFINITE).build().show();
            }
        });

    }

}