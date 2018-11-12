package com.dogancankilic.notesapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.list_layout.*

class ListNotes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_layout)
        /*val DatabaseHelper = DatabaseHelper(this)
            val title = etvTitle.text.toString()
            val note = etvNote.text.toString()
            DatabaseHelper.addData(Notes(title,note))*/

    }



}