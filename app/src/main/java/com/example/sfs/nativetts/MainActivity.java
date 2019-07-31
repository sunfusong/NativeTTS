package com.example.sfs.nativetts;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {
    private EditText et_input;
    private Button bt_start;
    private Button bt_pause;
    private Button bt_resume;

    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (textToSpeech==null){
            textToSpeech = new TextToSpeech(this, this);
        }

        initView();

    }


    private void ttsParam() {
        textToSpeech.setPitch(1.4f);// 设置音调，,1.0是常规
        textToSpeech.setSpeechRate(1.2f);//设定语速，1.0正常语速
    }


    private void initView() {
        et_input = findViewById(R.id.et_input);
        bt_start = findViewById(R.id.bt_start);
        bt_pause = findViewById(R.id.bt_pause);
        bt_resume = findViewById(R.id.bt_resume);

        bt_start.setOnClickListener(this);
        bt_pause.setOnClickListener(this);
        bt_resume.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_start:

                textToSpeech.speak(et_input.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);

                break;
            case R.id.bt_pause:
                Toast.makeText(this, "未实现", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_resume:
                Toast.makeText(this, "未实现", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            //初始化tts引擎
            int result = textToSpeech.setLanguage(Locale.CHINA);
            //设置参数
            ttsParam();
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(this, "语音包丢失或语音不支持", Toast.LENGTH_SHORT).show();

            }
        }
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech!=null){
            //释放资源
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}