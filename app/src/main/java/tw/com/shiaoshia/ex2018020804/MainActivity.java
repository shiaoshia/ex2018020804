package tw.com.shiaoshia.ex2018020804;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //動態
    MyReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiver = new MyReceiver();
    }

    //註冊receiver
    public void click01(View v) {
        IntentFilter filter = new IntentFilter();
        filter.addAction("myaction");
        filter.setPriority(500);
        registerReceiver(receiver,filter);
        Log.d("MainActivity:","註冊recivier");
    }

    //取消receiver
    public void click02(View v) {
        unregisterReceiver(receiver);
        Log.d("MainActivity:","取消recivier");
    }

    //寄出訊號
    public void click03(View v) {
        Intent intent = new Intent("myaction");
        sendBroadcast(intent);
        Log.d("MainActivity:","寄出訊號");
    }

    //監聽螢幕是否打開
    public void click04(View v) {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.setPriority(500);
        registerReceiver(receiver,filter);
        Log.d("MainActivity:","註冊recivier");
    }
}
