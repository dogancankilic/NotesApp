package com.dogancankilic.notesapp

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alarm.*
import java.util.*

class AlarmActivity : AppCompatActivity() {
    var notificationId =2
    var random = Random()
    var m = random.nextInt(9999 - 1000) + 1000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)


        checker(false)








        setBtn.setOnClickListener {

            val intent = Intent(this@AlarmActivity, AlarmReceiver::class.java)
            intent.putExtra("notificationId", m)
            intent.putExtra("todo", editText.getText().toString())
            val alarmIntent = PendingIntent.getBroadcast(this@AlarmActivity, 0,
                    intent, PendingIntent.FLAG_CANCEL_CURRENT)
            val alarm = getSystemService(ALARM_SERVICE) as AlarmManager

            val hour = timePicker.getCurrentHour()
            val minute = timePicker.getCurrentMinute()
            val startTime = Calendar.getInstance()
            startTime.set(Calendar.HOUR_OF_DAY, hour)
            startTime.set(Calendar.MINUTE, minute)
            startTime.set(Calendar.SECOND, 0)
            val alarmStartTime = startTime.getTimeInMillis()
            alarm.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent)
            Toast.makeText(this, "Hatırlatıcı kuruldu.", Toast.LENGTH_SHORT).show()



        }






            }


        fun checker(check : Boolean){
            if (check)
            {cancelBtn.setOnClickListener {
                val intent = Intent(this@AlarmActivity, AlarmReceiver::class.java)
                /*intent.putExtra("notificationId", notificationId)*/
                intent.putExtra("todo", editText.getText().toString())
                val alarmIntent = PendingIntent.getBroadcast(this@AlarmActivity, 0,
                        intent, PendingIntent.FLAG_CANCEL_CURRENT)
                val alarm = getSystemService(ALARM_SERVICE) as AlarmManager
                alarm.cancel(alarmIntent);

                var iptal : EditText = findViewById(R.id.editText)

                checker(false)

                Toast.makeText(this,  "Hatırlatıcı iptal edildi : "+iptal.text.toString(), Toast.LENGTH_SHORT).show()
            }




        }













    }





}
