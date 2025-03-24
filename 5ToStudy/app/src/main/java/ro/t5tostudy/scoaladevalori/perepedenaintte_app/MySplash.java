package ro.t5tostudy.scoaladevalori.perepedenainte_app;

import android.app.Application;
import android.os.SystemClock;

public class MySplash extends Application {

    @Override
    public void onCreate (){
        super.onCreate();
        SystemClock.sleep(2000);

    }
}
