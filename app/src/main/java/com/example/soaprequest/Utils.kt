package com.example.soaprequest

import android.content.Context
import android.net.ConnectivityManager

class Utils {
    companion object {

        val SOAP_URL = "https://secure.procedesoftware.com/PUBLIC/Others/WebAPI/WMService.svc?singleWsdl"
        val SOAP_NAMESPACE = "http://tempuri.org/IWebAPI/"

        fun isConnected(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting
        }
    }
}