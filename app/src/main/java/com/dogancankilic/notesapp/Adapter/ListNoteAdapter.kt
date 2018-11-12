package com.dogancankilic.notesapp.Adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.Toast
import com.dogancankilic.notesapp.*
import kotlinx.android.synthetic.main.show_note.view.*
const val TITLE ="title"
const val NOTE ="note"
const val ID ="id"

class ListNoteAdapter(internal  var activity :Activity,
                      internal var lstNote:List<Notes>): BaseAdapter() {



    internal var inflater : LayoutInflater

    init {
        inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView : View
        rowView = inflater.inflate(R.layout.show_note,null)
        rowView.txId.text= lstNote[position].id.toString()
        rowView.txTitle.text = lstNote[position].title.toString()
        rowView.txNote.text = lstNote[position].note.toString()

        rowView.setOnClickListener{
            /*etv1.setText(rowView.txTitle.text.toString())
            etv2.setText(rowView.txNote.text.toString())*/
            var intent = Intent(activity, UpdateNotes::class.java)
            intent.putExtra(TITLE,rowView.txTitle.text.toString())
            intent.putExtra(NOTE,rowView.txNote.text.toString())
            intent.putExtra(ID,rowView.txId.text.toString())
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)


            activity.startActivity(intent)
            /*activity.finish()*/



        }

        rowView.btn_delete.setOnClickListener{

            val db = DatabaseHelper(activity)
            db.deleteData(Notes(Integer.parseInt(rowView.txId.text.toString()),rowView.txTitle.text.toString(), rowView.txNote.text.toString()))
            var intent = Intent(activity, MainActivity::class.java)
            activity.startActivity(intent)

            activity.overridePendingTransition(0,0)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)


            Toast.makeText(activity,"Silindi",Toast.LENGTH_SHORT).show()
            activity.finish()

        }

        return rowView

    }

    override fun getItem(position: Int): Any {
        return lstNote[position]
    }

    override fun getItemId(position: Int): Long {
        return lstNote[position].id.toLong()
    }

    override fun getCount(): Int {
        return lstNote.size
    }
}