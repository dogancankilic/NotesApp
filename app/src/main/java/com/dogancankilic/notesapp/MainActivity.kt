package com.dogancankilic.notesapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.content.ContextCompat
import android.widget.*
import com.dogancankilic.notesapp.Adapter.ListNoteAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dayandnight.*
import kotlinx.android.synthetic.main.list_layout.*
import kotlinx.android.synthetic.main.show_note.*
import android.support.v4.view.MenuItemCompat.getActionView
import android.support.v7.app.AppCompatDelegate
import android.view.*
import android.widget.Switch
import kotlinx.android.synthetic.main.activity_update_notes.*
import java.lang.reflect.Type


class MainActivity : AppCompatActivity() {
    internal lateinit var db:DatabaseHelper
    internal var lstNotes:List<Notes> = ArrayList<Notes>()
    /*lateinit var fab : FloatingActionButton*/










        override fun onCreate(savedInstanceState: Bundle?) {








        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)



            /*fab = findViewById(R.id.fab)*/

            
            fab.setOnClickListener{
                var intent = Intent(this@MainActivity,AddNotes::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
                /*finish()*/
            }





            /*val DatabaseHelper = DatabaseHelper(this)
            val title = etv1.text.toString()
            val note = etv2.text.toString()
            DatabaseHelper.addData(Notes(title,note))*/
            db = DatabaseHelper(this)
            refreshData()







    }
     fun refreshData(){
        lstNotes = db.showNote()
        val adapter = ListNoteAdapter(this@MainActivity, lstNotes)
        lv.adapter=adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu,menu)


        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        var view : View
        view = findViewById(R.id.alarm)
        view.setOnClickListener{


            val intent = Intent(this@MainActivity, AlarmActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)

            startActivity(intent)

        }



        return super.onOptionsItemSelected(item)
    }







}
