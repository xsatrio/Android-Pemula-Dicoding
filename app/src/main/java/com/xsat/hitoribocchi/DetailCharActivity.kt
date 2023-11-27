package com.xsat.hitoribocchi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailCharActivity  : AppCompatActivity() {

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_char)

        val dataChar = intent.getParcelableExtra<Char>("key_char")!!

        val tvDetailName = findViewById<TextView>(R.id.tv_detail_name)
        val tvDetailDescription = findViewById<TextView>(R.id.tv_detail_description)
        val ivDetailPhoto = findViewById<ImageView>(R.id.iv_detail_photo)

        tvDetailName.text = dataChar.name
        tvDetailDescription.text = dataChar.description
        ivDetailPhoto.setImageResource(dataChar.photo)

        val tvDetailAge = findViewById<TextView>(R.id.tv_detail_age)
        val tvDetailGender = findViewById<TextView>(R.id.tv_detail_gender)
        val ageString = resources.getString(R.string.age, dataChar.age)
        val genderString = resources.getString(R.string.gender, dataChar.gender)

        tvDetailAge.text = ageString
        tvDetailGender.text = genderString
    }

    @SuppressLint("QueryPermissionsNeeded")
    @Suppress("DEPRECATION")
    fun onShareClicked(view: View) {
        val dataChar = intent.getParcelableExtra<Char>("key_char")!!
        val shareText = "Name: ${dataChar.name}\n\nDescription: \n${dataChar.description}"
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, shareText)
        }

        if (shareIntent.resolveActivity(packageManager) != null) {
            startActivity(shareIntent)
        } else {
            Toast.makeText(this, "No app found to handle this action", Toast.LENGTH_SHORT).show()
        }
    }

    @Suppress("DEPRECATION")
    fun onBackPressed(view: View) {
        onBackPressed()
    }
}