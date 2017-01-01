package com.example.ndkOpencvAndroidstudio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.ndk_opencv_androidstudio.R;

import org.opencv.android.CameraBridgeViewBase;
public class MainActivity extends ActionBarActivity {
    private static final String TAG         = "MainActivity";
    private Button buttonOpenCV             = null;

    static {
        System.loadLibrary("detection_based_tracker");
        System.loadLibrary("opencv_java3");
    }
    CameraBridgeViewBase camera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView tv = (TextView) findViewById(R.id.testTextView);
//        tv.setText(NativeClass.getStringFromNative());

        buttonOpenCV = (Button) findViewById(R.id.buttonOpenCV);
        buttonOpenCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FdActivity.class);
                startActivity(intent);
                Log.i(TAG, "ClickEVENT Listener");
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
}
