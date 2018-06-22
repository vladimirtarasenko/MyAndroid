package vladimirtarasenko33.gmail.com.myandroid;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class FourthActivity extends Activity {
    TextView textView;
    ToggleButton toggleButton;
    WifiManager wifiManager;
    boolean onBound = false;
    MyService myService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        /*
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wifiManager.setWifiEnabled(true);
                } else wifiManager.setWifiEnabled(false);
            }
        });
*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(broadcastReceiver, intentFilter);
        Log.e("AAA", "bidService");
        bindService(new Intent(this, MyService.class), mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // startService(new Intent(this, MyService.class));
        // bindService(new Intent(this, MyService.class), serviceConnection, BIND_AUTO_CREATE);
        //Глобальный ресеивер
        // IntentFilter intentFilter = new IntentFilter();
        // intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        // registerReceiver(broadcastReceiver, intentFilter);

        //Локальный ресивер
        //  LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, intentFilter);
    }

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName classname, IBinder service) {
            Log.e("AAA", "ServiceConnection");
            MyService.LocalBinder binder = (MyService.LocalBinder) service;
            myService = binder.getService();
            onBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            onBound = false;
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(mConnection);
        // stopService(new Intent(this, MyService.class));
        unregisterReceiver(broadcastReceiver);
        //Локальный ресивер
        //   LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }


    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            textView = findViewById(R.id.textView1);
            int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);
            switch (wifiState) {
                case WifiManager.WIFI_STATE_ENABLED:
                    textView.setText("WIFI is ON");
                    break;
                case WifiManager.WIFI_STATE_DISABLED:
                    textView.setText("WIFI is OFF");
                    break;
                case WifiManager.WIFI_STATE_UNKNOWN:
                    textView.setText("WIFI is UNKNOWN");
                    break;
            }
        }
    };

    public void ToggleClick(View view) {
        if (onBound) {
            ConnectivityManager connec = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {
                myService.toggleOff();
            } else myService.toggleOn();
        }
    }
}


