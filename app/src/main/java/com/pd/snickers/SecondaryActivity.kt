package com.pd.snickers

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatImageButton
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.pd.chocobarKotlin.ChocoBar

class SecondaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_secondary)

        findViewById<Button>(R.id.button_default).setOnClickListener {
            ChocoBar.builder()
                .setView(it)
                .setActionText("ACTION")
                .setActionClickListener {
                    Toast.makeText(this, "You clicked ACTION", Toast.LENGTH_LONG).show()
                }
                .setText("Default ChocoBar")
                .setDuration(ChocoBar.LENGTH_INDEFINITE)
                .build()
                .show()
        }

        findViewById<View>(R.id.button_success).setOnClickListener { v: View? ->
            com.pd.chocobar.ChocoBar
                .builder()
                .setActivity(this)
                .setDuration(com.pd.chocobar.ChocoBar.LENGTH_SHORT)
                .green()
                .show()
        }

        findViewById<View>(R.id.button_info).setOnClickListener { v: View? ->
            com.pd.chocobar.ChocoBar.builder()
                .setActivity(this)
                .setDuration(com.pd.chocobar.ChocoBar.LENGTH_LONG)
                .orange()
                .show()
        }

        findViewById<View>(R.id.button_warning).setOnClickListener { v: View? ->
            com.pd.chocobar.ChocoBar
                .builder()
                .setView(v)
                .centerText()
                .setDuration(com.pd.chocobar.ChocoBar.LENGTH_LONG)
                .cyan()
                .show()
        }

        findViewById<View>(R.id.button_error).setOnClickListener { v: View? ->
            com.pd.chocobar.ChocoBar
                .builder()
                .setView(v)
                .setDuration(com.pd.chocobar.ChocoBar.LENGTH_INDEFINITE)
                .setActionText(android.R.string.ok)
                .red()
                .show()
        }

        findViewById<View>(R.id.button_good).setOnClickListener { v: View? ->
            com.pd.chocobar.ChocoBar.builder()
                .setView(v)
                .centerText()
                .setDuration(com.pd.chocobar.ChocoBar.LENGTH_LONG)
                .good()
                .show()
        }

        findViewById<View>(R.id.button_bad).setOnClickListener { v: View? ->
            com.pd.chocobar.ChocoBar.builder()
                .setView(v)
                .centerText()
                .setDuration(com.pd.chocobar.ChocoBar.LENGTH_LONG)
                .bad()
                .show()
        }

        findViewById<View>(R.id.button_love).setOnClickListener { v: View? ->
            com.pd.chocobar.ChocoBar.builder()
                .setView(v)
                .centerText()
                .setDuration(com.pd.chocobar.ChocoBar.LENGTH_LONG)
                .love()
                .show()
        }

        findViewById<View>(R.id.button_custom).setOnClickListener { v: View? ->
            com.pd.chocobar.ChocoBar.builder()
                .setBackgroundColor(Color.parseColor("#00bfff"))
                .setTextSize(18f)
                .setTextColor(Color.parseColor("#FFFFFF"))
                .setTextTypefaceStyle(Typeface.ITALIC)
                .setText("This is a custom Chocobar")
                .setMaxLines(4)
                .centerText()
                .setActionText("ChocoBar")
                .setActionTextColor(Color.parseColor("#66FFFFFF"))
                .setActionTextSize(20f)
                .setActionTextTypefaceStyle(Typeface.BOLD)
                .setIcon(R.mipmap.ic_launcher)
                .setActivity(this)
                .setDuration(com.pd.chocobar.ChocoBar.LENGTH_INDEFINITE)
                .build()
                .show()
        }

        findViewById<View>(R.id.button_off_notification).setOnClickListener { v: View? ->
            com.pd.chocobar.ChocoBar.builder()
                .setView(v)
                .centerText()
                .setDuration(com.pd.chocobar.ChocoBar.LENGTH_LONG)
                .black()
                .show()
        }

        findViewById<View>(R.id.button_on_notification).setOnClickListener { v: View? ->
            com.pd.chocobar.ChocoBar.builder()
                .setView(v)
                .centerText()
                .setDuration(com.pd.chocobar.ChocoBar.LENGTH_LONG)
                .notificationsOn()
                .show()
        }

        findViewById<View>(R.id.button_blocked).setOnClickListener { v: View? ->
            com.pd.chocobar.ChocoBar.builder()
                .setView(v)
                .centerText()
                .setDuration(com.pd.chocobar.ChocoBar.LENGTH_LONG)
                .blocked()
                .show()
        }

        findViewById<AppCompatImageButton>(R.id.button_previous).setOnClickListener {
            val newIntent = Intent(this, MainActivity::class.java)
            startActivity(newIntent)
        }
    }
}