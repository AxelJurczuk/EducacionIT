package com.example.android.educacionit.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.android.educacionit.R
import com.example.android.educacionit.UsersActivity
import com.example.android.educacionit.databinding.ActivityNotificationsBinding

class NotificationsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotificationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityNotificationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.showNotification.setOnClickListener {

            showNotification()
        }

    }

    private fun showNotification (){

        val intent = Intent (this, NotificationsActivity::class.java)
        val taskStackBuilder = TaskStackBuilder.create(this)
        taskStackBuilder.addNextIntentWithParentStack(intent)
        val pendingIntent = taskStackBuilder.getPendingIntent(11, PendingIntent.FLAG_UPDATE_CURRENT)
        //val pendingIntent= PendingIntent.getActivity(this, 11, intent,PendingIntent.FLAG_UPDATE_CURRENT)

        //aca va el codigo de notification
        val builder = NotificationCompat.Builder(this,"usuarios")
                .setContentTitle("New users")
                .setContentText("check out the new users!")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notificationChannel = NotificationChannel("usuarios", "users", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        notificationManager.notify(1, builder.build())
    }
}