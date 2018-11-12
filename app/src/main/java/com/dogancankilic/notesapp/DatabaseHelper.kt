package com.dogancankilic.notesapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.dogancankilic.notesapp.R.attr.title
import junit.runner.Version

class DatabaseHelper( var context: Context?) : SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION){



    companion object {
        const val DATABASE_NAME = "note.db"
        const val DATABASE_VERSION= 1

        private const val TABLE_NAME = "note_table"
        private const val TITLE ="title"
        private const val NOTE ="note"
        private const val ID ="ID"


    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table if not exists $TABLE_NAME( $ID integer primary key autoincrement,$TITLE text,$NOTE text )")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
    }

    fun addData(notes : Notes){
        var db : SQLiteDatabase? = this.writableDatabase
        var cv  = ContentValues()
        /*cv.put(ID,notes.id)*/
        cv.put(TITLE,notes.title)
        cv.put(NOTE,notes.note)
        db?.insert(TABLE_NAME,null,cv)

         Toast.makeText(context,"Eklendi", Toast.LENGTH_SHORT).show()
        db?.close()
    }
    fun updateData(notes : Notes) : Int? {
        var db : SQLiteDatabase? = this.writableDatabase
        var cv  = ContentValues()
        cv.put(ID,notes.id)
        cv.put(TITLE,notes.title)
        cv.put(NOTE,notes.note)
        /*return db?.update(TABLE_NAME,cv,"$ID ="+ ID,null)*/
        return db?.update(TABLE_NAME,cv,"$ID=?", arrayOf(notes.id.toString()))

        /*Toast.makeText(context,"Değiştirildi", Toast.LENGTH_SHORT).show()
        db?.close()*/
    }
    fun deleteData(notes: Notes){
        val db : SQLiteDatabase? = this.writableDatabase
        db?.delete(TABLE_NAME,"$ID=?", arrayOf(notes.id.toString()))
        db?.close()
    }

    fun showNote (): ArrayList<Notes>{
        var list = ArrayList<Notes>()
        val query= "SELECT * FROM $TABLE_NAME"
        val db = this.writableDatabase
        val cursor = db.rawQuery(query,null)
        if(cursor.moveToFirst()){
            do{
                val  notes = Notes()
                notes.id = cursor.getInt(cursor.getColumnIndex(ID))
                notes.title = cursor.getString(cursor.getColumnIndex(TITLE))
                notes.note = cursor.getString(cursor.getColumnIndex(NOTE))

                list.add(notes)


            }while (cursor.moveToNext())

        }
        db.close()

        return list


    }


}