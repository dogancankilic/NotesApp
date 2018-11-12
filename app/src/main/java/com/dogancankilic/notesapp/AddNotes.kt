package com.dogancankilic.notesapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.widget.ImageView
import android.widget.Toast
import com.dogancankilic.notesapp.R.id.etvNote
import com.dogancankilic.notesapp.R.id.etvTitle
import kotlinx.android.synthetic.main.list_layout.*

class AddNotes : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_layout)
        val db = DatabaseHelper(this)
           /* val title = etvTitle.text.toString
            val note = etvNote.text.toString()
            DatabaseHelper.addData(Notes(title,note))*/


        img_add.setOnClickListener {
            if (etvTitle.text.toString().equals("")&& etvNote.text.toString().equals("")){
                Toast.makeText(this,"Bir şeyler yazmalısın",Toast.LENGTH_LONG).show()
                var intent = Intent(this@AddNotes,MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)


            }
            else if (etvTitle.text.toString().equals("")  ){
                db.addData(Notes("Başlıksız", etvNote.text.toString()))
                var intent = Intent(this@AddNotes,MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)


            }
            else{
                db.addData(Notes(etvTitle.text.toString(), etvNote.text.toString()))
                var intent = Intent(this@AddNotes,MainActivity::class.java)
                startActivity(intent)


            }




        }


    }
}
