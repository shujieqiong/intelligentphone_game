package com.example.funnymath;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class SettingActivity extends Activity {

    private Button  up, down;

    private AudioManager aManger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        aManger = (AudioManager) getSystemService(Service.AUDIO_SERVICE);
        up = (Button) findViewById(R.id.button);
        down = (Button) findViewById(R.id.button2);

        up.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // 指定调节音乐的音频，增大音量，而且显示音量的图形示意
                aManger.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                        AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);

            }
        });
        down.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // 指定调节音乐的音频，增大音量，而且音量的图形示意
                aManger.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                        AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);

            }
        });
    }
    private void dialog() {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(SettingActivity.this);

        mBuilder.setMessage("完成设置了吗？");
        mBuilder.setTitle("提示ʾ");

        mBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });
        mBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });
        mBuilder.create().show();
    }

}
