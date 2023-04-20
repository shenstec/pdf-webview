package com.shensl.pdfviewer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shensl.pdf_webview.PdfWebView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var webView =  findViewById<PdfWebView>(R.id.pdfView)
        webView.loadPdf("http://www.hitucao.com/123.pdf")
    }
}