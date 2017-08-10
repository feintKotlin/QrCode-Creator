package com.feint.fx.utils

import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.MultiFormatWriter
import com.google.zxing.client.j2se.MatrixToImageConfig
import com.google.zxing.client.j2se.MatrixToImageWriter
import java.awt.image.BufferedImage
import java.util.*

object QrUtil {
    val qrWidth=256;
    val qrHeight=256;
    fun createQR(info:String): BufferedImage? {
        val hints=Hashtable<EncodeHintType,String>()
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8")
        val bitMatrix=MultiFormatWriter().encode(info,BarcodeFormat.QR_CODE, qrWidth, qrHeight,hints)
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}