package com.xsat.hitoribocchi

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val ivProfile = findViewById<ImageView>(R.id.ivProfile)
        val tvName = findViewById<TextView>(R.id.tvName)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val tvSynopsis = findViewById<TextView>(R.id.tvSynopsis)

        ivProfile.setImageResource(R.drawable.myphoto)
        tvName.text = getString(R.string.myname)
        tvEmail.text = getString(R.string.myemail)
        tvSynopsis.text = getString(R.string.synopsis)
    }

    @Suppress("DEPRECATION")
    fun onBackPressed(view: View) {
        onBackPressed()
    }
}
