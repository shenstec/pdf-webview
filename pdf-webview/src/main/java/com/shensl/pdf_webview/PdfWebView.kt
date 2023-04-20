package com.shensl.pdf_webview

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.webkit.WebSettings
import android.webkit.WebView
import java.lang.reflect.InvocationTargetException

class PdfWebView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : WebView(context, attrs) {

    init {
        val settings: WebSettings? = settings
        settings?.javaScriptEnabled = true
        settings?.allowFileAccess = true

        settings?.builtInZoomControls = true
        settings?.setSupportZoom(true)
        settings?.displayZoomControls = false //不显示缩放按钮

        try {
            if (Build.VERSION.SDK_INT >= 16) {
                val clazz: Class<*> = getSettings().javaClass
                val method = clazz.getMethod(
                    "setAllowUniversalAccessFromFileURLs", Boolean::class.javaPrimitiveType
                ) //利用反射机制去修改设置对象
                if (method != null) {
                    method.invoke(getSettings(), true) //修改设置
                }
            }
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }
    }

    fun loadPdf(pdfUrl:String){
        loadUrl("file:///android_asset/index.html?$pdfUrl")
    }
}