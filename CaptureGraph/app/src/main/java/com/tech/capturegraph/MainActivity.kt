package com.tech.capturegraph

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val btnCapture = view.findViewById<Button>(R.id.btnCapture)
        //btnCapture.setOnClickListener {
            val it = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(it, 100)
        //}
        //val btnReturn = view.findViewById<Button>(R.id.btnReturn)
        //btnReturn.setOnClickListener() {
        //    findNavController().navigate(R.id.action_captureFragment_to_menuFragment)
        //}
    }
    override fun onActivityResult(requestCode :Int, resultCode:Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 100 )
        {

        }
        else
        {
            //Toast.makeText(this, "沒有拍到照片", Toast.LENGTH_SHORT).show()
        }
    }
}