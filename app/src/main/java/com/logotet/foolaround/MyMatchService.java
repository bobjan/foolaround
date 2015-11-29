package com.logotet.foolaround;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyMatchService extends IntentService {
    private static final String ACTION_MATCH = "com.logotet.foolaround.action.MATCH";
    private static final String ACTION_GOAL = "com.logotet.foolaround.action.GOAL";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.logotet.foolaround.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.logotet.foolaround.extra.PARAM2";



    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionMatch(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyMatchService.class);
        intent.setAction(ACTION_MATCH);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionGoal(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyMatchService.class);
        intent.setAction(ACTION_GOAL);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    public MyMatchService() {
        super("MyMatchService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_MATCH.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionMatch(param1, param2);
            } else if (ACTION_GOAL.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionGoal(param1, param2);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionMatch(String param1, String param2) {
        // TODO: Handle action Match
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionGoal(String param1, String param2) {
        // TODO: Handle action Goal
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
