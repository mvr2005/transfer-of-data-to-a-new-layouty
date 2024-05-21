package com.mikhail.activityresultlesson

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mikhail.activityresultlesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass : ActivityMainBinding
    private var startActivity1 : ActivityResultLauncher<Intent>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        startActivity1 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult  ->
            if (result.resultCode == RESULT_OK){
                val text4 = result.data?.getStringExtra("key2")
                bindingClass.tx2AcM.visibility = View.VISIBLE
                bindingClass.tx2AcM.text = text4.toString()
            }
        }

    }



        fun openActivityOne (view : View) {
          val firstAc =  Intent(this, Activity1::class.java)
            val txPl1 = bindingClass.txPl1AcM.text.toString()
            firstAc.putExtra("key", "$txPl1")
              startActivity1?.launch(firstAc)


        }

}