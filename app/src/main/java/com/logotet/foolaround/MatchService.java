package com.logotet.foolaround;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by boban on 10/1/15.
 */
public class MatchService extends Service {
    private static final String TAG = "MatchService";
    private static int brojac;

    private final int INTERVAL = 60 * 1000;
    private Timer timer;
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public MatchService() {
//        super("com.logotet.foolarounr.MatchService");
        brojac = 0;
        timer  = new Timer();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.w(TAG, "service started");

        // Execute an action after period time
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Print a log
                createNotification();
            }
        }, 0, INTERVAL);

        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        if (timer != null) {
            timer.cancel();
        }
        super.onDestroy();
        Log.w(TAG, "service  destroyed");
    }

//    @Override
//    protected void onHandleIntent(Intent intent) {    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.w(TAG, "service  bound");
        return null;
//        return super.onBind(intent);
    }

    public void createNotification(){
        NotificationCompat.Builder notificationBuilder =  new NotificationCompat.Builder(this);
        notificationBuilder.setSmallIcon(R.drawable.s32x32);
        notificationBuilder.setContentTitle("Nova utakmica(servis)" + brojac++);
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
