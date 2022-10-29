package com.ndkapp.www.mediconsult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class activity_contact_us extends AppCompatActivity {

    TextView text1;
    TextView text2;
    TextView text3;
    ImageView image1;
    ImageView image2;
    ImageView image3;
    private static final int REQUEST_CALL = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        text1 = findViewById(R.id.call_cs);
        text2 = findViewById(R.id.mail_cs);
        text3 = findViewById(R.id.map_cs);
        image1 = findViewById(R.id.final_call);
        image2 = findViewById(R.id.final_mail);
        image3 = findViewById(R.id.final_map);

        final String num = "8980688666";
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall(num);
            }
        });

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall(num);
            }
        });

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setType("message/rfc822");
                i.setData(Uri.parse("mailto:" + "rudra.barad@gmail.com"));
                i.putExtra(Intent.EXTRA_SUBJECT, "Query or Feedback");
                try {
                    startActivity(Intent.createChooser(i, "Choose an Email client :"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(activity_contact_us.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setType("message/rfc822");
                i.setData(Uri.parse("mailto:" + "rudra.barad@gmail.com"));
                i.putExtra(Intent.EXTRA_SUBJECT, "Query or Feedback");
                try {
                    startActivity(Intent.createChooser(i, "Choose an Email client :"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(activity_contact_us.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bIntent = new Intent(Intent.ACTION_VIEW);
                bIntent.setData(Uri.parse("https://www.google.com/maps/place/Royal+Care+Boys+Hostel/@22.597658,72.8216473,17z/data=!3m1!4b1!4m5!3m4!1s0x395e50c30bd44029:0xa7ccb7b99f760e6e!8m2!3d22.597658!4d72.823836"));
                startActivity(bIntent);
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bIntent = new Intent(Intent.ACTION_VIEW);
                bIntent.setData(Uri.parse("https://www.google.com/maps/place/Royal+Care+Boys+Hostel/@22.597658,72.8216473,17z/data=!3m1!4b1!4m5!3m4!1s0x395e50c30bd44029:0xa7ccb7b99f760e6e!8m2!3d22.597658!4d72.823836"));
                startActivity(bIntent);
            }
        });


    }

    private void makePhoneCall(String num)
    {
        if(ContextCompat.checkSelfPermission(activity_contact_us.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(activity_contact_us.this, new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL );
        }
        else
        {
            String dial = "tel:" +num;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
    }

}
