package com.dogancankilic.notesapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dogancankilic.notesapp.Adapter.ID
import com.dogancankilic.notesapp.Adapter.NOTE
import com.dogancankilic.notesapp.Adapter.TITLE
import kotlinx.android.synthetic.main.activity_update_notes.*

class UpdateNotes : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_notes)
        etvTitle2.setText(intent.getStringExtra(TITLE.toString()))
        etvNote2.setText(intent.getStringExtra(NOTE.toString()))
        var sid = intent.getStringExtra(ID.toString())
        var getID = Integer.parseInt(sid)
        val db = DatabaseHelper(this)


        img_update.setOnClickListener{
            if (etvTitle2.text.toString().equals("")&& etvNote2.text.toString().equals("")){

                Toast.makeText(this,"Bir şeyler yazmalısın", Toast.LENGTH_SHORT).show()
                var intent = Intent(this@UpdateNotes,MainActivity::class.java)
                startActivity(intent)
                /*finish()*/

            }
            else if (etvTitle2.text.toString().equals("")){
                db.updateData(Notes(getID,"Başlıksız", etvNote2.text.toString()))
                var intent = Intent(this@UpdateNotes,MainActivity::class.java)
                startActivity(intent)
                /*finish()*/
            }
            else{
                db.updateData(Notes(getID,etvTitle2.text.toString(), etvNote2.text.toString()))
                Toast.makeText(this,"Değiştirildi", Toast.LENGTH_SHORT).show()
                var intent = Intent(this@UpdateNotes,MainActivity::class.java)
                startActivity(intent)
                /*finish()*/

            }


        }
    }
    /*fun updateNote() {
        val db = DatabaseHelper(this)
        db.updateData(Notes(,etvTitle2.text.toString(), etvNote2.text.toString()))

    }*/
}
