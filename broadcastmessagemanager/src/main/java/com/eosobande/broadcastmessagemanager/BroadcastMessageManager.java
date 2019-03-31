package com.eosobande.broadcastmessagemanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;

import java.io.Serializable;

public class BroadcastMessageManager extends BroadcastReceiver {

    private static LocalBroadcastManager mLocalBroadcastManager;

    private BroadcastListener mListener;
    private String[] mBroadcastIds;
    private boolean registered = false;

    public static void init(Context context) {
        if (mLocalBroadcastManager == null) {
            mLocalBroadcastManager = LocalBroadcastManager.getInstance(context);
        }
    }

    public BroadcastMessageManager(@NonNull BroadcastListener listener, @NonNull String... broadcastIds) {
        super();
        mListener = listener;
        mBroadcastIds = broadcastIds;
    }

    @Override
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        for (String broadcastId : mBroadcastIds) {
            if (broadcastId.equals(action)) {
                mListener.onReceiveBroadcast(context, action, intent.getExtras());
                break;
            }
        }
    }

    public void register() {
        // This registers mMessageReceiver to receive messages.
        if (!registered) {

            IntentFilter filter = new IntentFilter();

            for (String broadcastId : mBroadcastIds) {
                filter.addAction(broadcastId);
            }

            mLocalBroadcastManager.registerReceiver(this, filter);

            registered = true;

        }
    }

    public void unregister() {
        // Unregister since the activity is not visible
        if (registered) {
            mLocalBroadcastManager.unregisterReceiver(this);
            registered = false;
        }
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, int message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, @NonNull int[] message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, byte message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, @NonNull byte[] message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, char message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, @NonNull char[] message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, long message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, @NonNull long[] message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, float message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, @NonNull float[] message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, short message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, @NonNull short[] message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull Bundle message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtras(message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull Intent message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtras(message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, double message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, @NonNull double[] message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, @NonNull String message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }
    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, @NonNull String[] message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, boolean message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, @NonNull boolean[] message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, @NonNull Parcelable message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, @NonNull Parcelable[] message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, @NonNull CharSequence message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, @NonNull CharSequence[] message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId, @NonNull String key, @NonNull Serializable message) {
        Intent intent = new Intent(broadcastId);
        intent.putExtra(key, message);
        send(intent);
    }

    public static void sendBroadcast(@NonNull String broadcastId) {
        send(new Intent(broadcastId));
    }

    private static void send(Intent intent) {
        mLocalBroadcastManager.sendBroadcast(intent);
    }

    public static interface BroadcastListener {
        void onReceiveBroadcast(Context context, String action, Bundle data);
    }

}
