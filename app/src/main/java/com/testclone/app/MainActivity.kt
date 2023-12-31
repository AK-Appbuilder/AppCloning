package com.testclone.app

import android.app.ActivityManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notepad = findViewById<TextView>(R.id.notepad)

        val context = this.baseContext

        val path = context.filesDir.path

//          context.checkse

        notepad.append("\npath: $path")

        notepad.append("\n abc : ${Build.VERSION.SDK_INT}")

        notepad.append("\npackage name: ${context.packageName}")

        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        activityManager.appTasks.get(0).taskInfo

        val sdkVersion = Build.VERSION.SDK_INT

        if (sdkVersion >= Build.VERSION_CODES.O) {
            val services = activityManager.getRunningServices(Int.MAX_VALUE)

            notepad.append("\n 1 Services ${services}")

            for (service in services) {
                notepad.append("\n servicePackageName ${service.service.packageName}")
//                process.pkgList.forEach {
//                    notepad.append("\n pkglist $it")
//                }
            }

            val apptasks = activityManager.appTasks


//            notepad.append("\n services ${apptasks}")

            apptasks.forEach {
//                notepad.append("\n taskInfo ${it.taskInfo}")
//                notepad.append("\n serviceClassName ${it.service.className}")
//                notepad.append("\n serviceClientPackage ${it.clientPackage}")
            }
        }
    }
}
