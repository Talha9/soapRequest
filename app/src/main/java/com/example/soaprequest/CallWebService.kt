package com.example.soaprequest

import org.ksoap2.SoapEnvelope
import org.ksoap2.serialization.SoapObject
import org.ksoap2.serialization.SoapSerializationEnvelope
import org.ksoap2.transport.HttpTransportSE

class CallWebService {

    fun callApi(): String {
        var result = ""
        val SOAP_ACTION = Utils.SOAP_NAMESPACE + "IsLoginValid"
        val soapObject = SoapObject(Utils.SOAP_NAMESPACE, "IsLoginValid")

        val envelope = SoapSerializationEnvelope(SoapEnvelope.VER11)
        envelope.setOutputSoapObject(soapObject)
        envelope.dotNet = true

        val httpTransportSE = HttpTransportSE(Utils.SOAP_URL)

        try {
            httpTransportSE.call(SOAP_ACTION, envelope)
            val soapPrimitive = envelope.response
            result = soapPrimitive.toString()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return result
    }
}