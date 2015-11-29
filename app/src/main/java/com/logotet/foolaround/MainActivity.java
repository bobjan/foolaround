package com.logotet.foolaround;


import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBarActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    public static final String TAG = "MainActibity";
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    Button btnAdmob;
    Button btnElse;
    Button btnEmail;
    Button btnImgs;
    Button btnMyUI;
    Button btnProgressBar;
    Button btnButtonSizes;

    Button btnStartService;
    Button btnStopService;

    Intent akcijaAdMob;
    Intent akcijaElse;
    Intent akcijaProgres;
    Intent akcijaButtinSizes;
    Intent akcijaMyUI;
    Intent akcijaStartService;
    Intent akcijaStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        TextView tv1 = (TextView) findViewById(R.id.firstText);
//        TextView tv2 = (TextView) findViewById(R.id.secondText);
//        TextView tv3 = (TextView) findViewById(R.id.thirdText);
        btnAdmob = (Button) findViewById(R.id.testBtn);
        btnElse = (Button) findViewById(R.id.testBtnElse);
//        btnEmail = (Button) findViewById(R.id.testBtnEmail);
        btnImgs = (Button) findViewById(R.id.testImageSizes);
        btnMyUI = (Button) findViewById(R.id.testMyUI);
        btnProgressBar = (Button) findViewById(R.id.testProgressBar);
        btnButtonSizes = (Button) findViewById(R.id.testButtonSizes);

        btnStartService = (Button) findViewById(R.id.testStartService);
        btnStopService = (Button) findViewById(R.id.testStopService);

        /*
        ovo verovatmno NE VALJA!

        AssetManager assetManager = getAssets();

        try {
            InputStream is = assetManager.open("prop.prop", Context.MODE_PRIVATE);
            Properties p = new Properties();
            p.load(is);

            tv1.setText((String) p.get("mysize"));
            tv2.setText((String) p.get("mytext"));
            is.close();
            OutputStream os = assetManager.openFd("prop.prop").createOutputStream();
            p.setProperty("mytext", "promenjeno");
            p.store(os, null);
            os.flush();
            os.close();

            is = assetManager.open("prop.prop",Context.MODE_PRIVATE);
            p.load(is);
            tv3.setText((String) p.get("mytext"));


        } catch (IOException e) {
            e.printStackTrace();
        }
*/


        /*  -- ovo je doobro
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);


        String mysize = prefs.getInt("mysize", 10) + "";
        String mytext = prefs.getString("mytext", "default tekst");
//        tv1.setText(mysize);
//        tv2.setText(mytext);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("mytext", "Drugi prolaz");
        editor.putInt("mysize", 5);
        editor.commit();
*/

        akcijaAdMob = new Intent(this, TestAdMobActivity.class);
        btnAdmob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(akcijaAdMob);
            }
        });

//        btnEmail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sendEmail();
//            }
//        });

        akcijaElse = new Intent(this, SomeTestActivity.class);
        btnElse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(akcijaElse);

            }
        });

        akcijaElse = new Intent(this, ImagesActivity.class);
        btnImgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(akcijaElse);

            }
        });


        akcijaMyUI = new Intent(this, MyCustomUIActivity.class);
        btnMyUI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(akcijaMyUI);

            }
        });

        akcijaProgres = new Intent(this, ProgressBarActivity.class);
        btnProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(akcijaProgres);

            }
        });

        akcijaButtinSizes = new Intent(this, ButtonSizesActivity.class);
        btnButtonSizes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(akcijaButtinSizes);

            }
        });

        akcijaStartService = new Intent(this, MatchService.class);

        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(akcijaStopService);
//                createNotification();
                Log.w(TAG,"trying to stop servuce");
                stopService(akcijaStartService);

            }
        });
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w(TAG,"trying to start servuce");
                startService(akcijaStartService);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    protected void sendEmail() {
        String[] recipients = {"bobjan@sbb.rs"};
        Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
        // prompts email clients only
        email.setType("message/rfc822");
        email.putExtra(Intent.EXTRA_EMAIL, recipients);
        email.putExtra(Intent.EXTRA_SUBJECT, "this is a subject");
        email.putExtra(Intent.EXTRA_TEXT, "bla bla ovo je tekst poruke");
        try {
            // the user can choose the email client
            startActivity(Intent.createChooser(email, "Choose an email client from..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "No email client installed.",
                    Toast.LENGTH_LONG).show();
        }
    }


    public void createNotification(){
        NotificationCompat.Builder notificationBuilder =  new NotificationCompat.Builder(this);
        notificationBuilder.setSmallIcon(R.drawable.s32x32);
        notificationBuilder.setContentTitle("Nova utakmica");
        notificationBuilder.setContentText("U utorak ce se odigrati \nnovi mec milionera protiv\n dunavca n astadionu graficara\n pocetak u 16:00");
// Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, ProgressBarActivity.class);

// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
// Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(ProgressBarActivity.class);
// Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        notificationBuilder.setContentIntent(resultPendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        notificationManager.notify(0, notificationBuilder.build());
    }
}
