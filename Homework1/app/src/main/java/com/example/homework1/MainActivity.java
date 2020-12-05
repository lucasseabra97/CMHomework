package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView phNumber;
    ImageButton rmNumber;
    ImageView call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);

        phNumber = (TextView) findViewById(R.id.textView);
        rmNumber = (ImageButton) findViewById(R.id.imageButton);
        call = (ImageView) findViewById(R.id.imageView);
    }


    public void addNumber(View view){
        Button btn = (Button) findViewById(view.getId());
        String phText = (String) phNumber.getText();

        String str = (String) btn.getText();
        String [] aux = str.split("\n");
        String btnTxt = aux[0];
        //System.out.println("button " + btnTxt);
        //System.out.print("all buttons " + aux);
        if(phText.length()==0){
            rmNumber.setVisibility(View.VISIBLE);
            rmNumber.setEnabled(true);
            rmNumber.setEnabled(true);
        }
        phNumber.setText((phText + btnTxt));
    }

    public void removeNumber(View view){
         String str = (String) phNumber.getText();
         if(str.length() == 1){
             rmNumber.setVisibility(View.INVISIBLE);
             rmNumber.setEnabled(false);
             call.setEnabled(false);
         }
         //delete char
         str = str.substring(0,str.length()-1);
         phNumber.setText(str);
    }

    public void makeCall(View view){
        String phNumberText = (String) phNumber.getText();
        dialPhoneNumber(phNumberText);
    }

    public void dialPhoneNumber(String phNumberText) {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
        }
        else
        {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + phNumberText));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }
}