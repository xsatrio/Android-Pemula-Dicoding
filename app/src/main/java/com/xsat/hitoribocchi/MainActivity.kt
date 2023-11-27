package com.xsat.hitoribocchi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var lastClickTime: Long = 0
    private val doubleClickDelay = 500
    private lateinit var rvChar: RecyclerView
    private val list = ArrayList<Char>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvChar = findViewById(R.id.rv_char)
        rvChar.setHasFixedSize(true)

        list.addAll(getListChar())
        showRecyclerList()
    }

    fun openAboutPage(view: View) {
        val clickTime = System.currentTimeMillis()

        if (clickTime - lastClickTime > doubleClickDelay) {
            lastClickTime = clickTime

            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getListChar(): ArrayList<Char> {
        val dataName = resources.getStringArray(R.array.char_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataGender = resources.getStringArray(R.array.data_gender)
        val dataAge = resources.getStringArray(R.array.data_age)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val listChar = ArrayList<Char>()

        for (i in dataName.indices) {
            val char = Char(
                dataName[i],
                dataDescription[i],
                dataGender[i],
                dataAge[i],
                dataPhoto.getResourceId(i, -1)
            )
            listChar.add(char)
        }
        dataPhoto.recycle()

        return listChar
    }

    private fun showRecyclerList() {
        rvChar.layoutManager = LinearLayoutManager(this)
        val listCharAdapter = ListCharAdapter(list)
        rvChar.adapter = listCharAdapter
    }
}