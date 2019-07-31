# NativeTTS
Android原生TTS+讯飞语音引擎实现免费纯离线的中英TTS
Android原生TTS类——TextToSpeech步骤
1.实例化     private TextToSpeech textToSpeech = new TextToSpeech(this, this);

2.重写onInit方法，进行设置语言进行初始化   int result = textToSpeech.setLanguage(Locale.CHINA);

3.设置tts参数textToSpeech.setPitch(1.4f);// 设置音调，1.0是常规        textToSpeech.setSpeechRate(1.2f);//设定语速，1.0正常语速

4.合成并播放     textToSpeech.speak(et_input.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);

5.释放资源      textToSpeech.stop();       textToSpeech.shutdown();

  
Android原生的TTS是不支持中文合成的，需要借助其他的语音引擎（apk安装包），比如科大讯飞语音引擎3.0，度秘语音引擎3.0以及新版手机基本都内置有语音引擎，可在设置——》语言——》首选引擎进行选择。
具体可参考这篇csdn博客：https://blog.csdn.net/yingchengyou/article/details/79591954

Android的TextToSpeech类文档可参考这篇csdn博客：https://blog.csdn.net/qq_26971803/article/details/51176592

该demo缺陷：未实现暂停，恢复播放功能。TextToSpeech未提供暂停，恢复播放方法，如果想实现的话，可以用synthesizeToFile方法保存音频文件，再用MediaPlayer对音频文件进行操作。
