package com.raywenderlich.pertemuan_6_1918049;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public TextView status;
    public ImageView success;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(MyWorker.class).build();
        status = (TextView) findViewById(R.id.textView);
        success = (ImageView) findViewById(R.id.imageView);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 WorkManager.getInstance().enqueueUniqueWork("Notifikasi",ExistingWorkPolicy.REPLACE,request);
                 status.setText("status : Succeded");
                 success.setImageResource(R.drawable.darkmagician);
             }
         });
    }
}