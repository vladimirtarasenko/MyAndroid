package vladimirtarasenko33.gmail.com.myandroid;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MyService extends Service {

    WifiManager wifiManager;
    private final IBinder mBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }
public void toggleOn(){
    wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
    wifiManager.setWifiEnabled(true);

}

    public void toggleOff(){
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(false);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("AAA", "onStart");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("AAA", "onBind");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("AAA", "onUnbind");
        return super.onUnbind(intent);
    }
}
