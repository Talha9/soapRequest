package com.example.soaprequest

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.ksoap2.SoapEnvelope
import org.ksoap2.serialization.SoapObject
import org.ksoap2.serialization.SoapPrimitive
import org.ksoap2.serialization.SoapSerializationEnvelope
import org.ksoap2.transport.HttpTransportSE


class MainActivity : AppCompatActivity() {
    var bt: TextView? = null
    var txt1: EditText? = null
    var txt2: EditText? = null
    var getCel: String? = null
    var resultTxt:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt = findViewById<TextView>(R.id.add)
        txt1 = findViewById<EditText>(R.id.enterInput1)
        txt2 = findViewById<EditText>(R.id.enterInput2)
        resultTxt=findViewById(R.id.resultValue)

        bt!!.setOnClickListener {
            val input1 = txt1!!.text.toString().trim()
            val input2 = txt2!!.text.toString().trim()
            when {
                input1.length == 0 || input2.length == 0 -> Toast.makeText(
                    this,
                    "fill_field",
                    Toast.LENGTH_SHORT
                ).show()

                !Utils.isConnected(this) -> Toast.makeText(
                    this,
                    "no_internet",
                    Toast.LENGTH_SHORT
                ).show()

                else -> getCitiesOfCountry().execute(input1, input2)
            }
        }
    }


    inner class getCitiesOfCountry : AsyncTask<String, String, String>() {

        override fun doInBackground(vararg params: String?): String {
            val response = CallWebService().callApi()
            Log.v("response", "response==" + response)
            return response
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            Log.v("response", "OnPostresponse==" + result)
            try {
                resultTxt!!.text = "result"+" "+result
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }
}