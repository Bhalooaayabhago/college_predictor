package com.example.cp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class cp extends AppCompatActivity {
   private WebView w;
    String jsonfp(String file) {
        String json = "";
        try {
            InputStream fat = this.getAssets().open(file);
            int size = fat.available();
            byte[] buffer = new byte[size];
            fat.read(buffer);
            fat.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp);
        Intent ini=getIntent();
        String clg=ini.getStringExtra("tpackage");
        String pass=jsonfp("pr.json");
        Gson g=new Gson();
        ctop lim[]=g.fromJson(pass,ctop[].class);
        String url="https://www.google.com/";
        int flag=0;
        for(int i=0;i<lim.length;i++)
        {
            if(lim[i].college.equalsIgnoreCase(clg)) {
                url = lim[i].link;
                flag = 1;
            }
        }
        if(flag==0)
        {
            Toast.makeText(this,"Data not found",Toast.LENGTH_SHORT);
        }
        w=(WebView)findViewById(R.id.webView);
        w.setWebViewClient(new WebViewClient());
        WebSettings ws=w.getSettings();
        ws.setJavaScriptEnabled(true);
        w.loadUrl(url);


    }


}