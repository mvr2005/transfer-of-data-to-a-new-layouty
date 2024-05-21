package com.mikhail.activityresultlesson

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mikhail.activityresultlesson.databinding.Activity1Binding

class Activity1 : AppCompatActivity() {
        private lateinit var bindingClass : Activity1Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        bindingClass = Activity1Binding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bindingClass.tx2Ac1.text = intent.getStringExtra("key")

    }

        fun clMainActivity (view : View) {
            val intent = Intent()
            val text = bindingClass.txPl1Ac1.text.toString()
            intent.putExtra("key2", "$text")
            setResult(RESULT_OK, intent)
            finish()
        }

}