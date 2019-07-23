# RxNet
对Retrofit+RxJava+OKHttp的进一步封装，该网络框架目前实现了下载功能。

![show](/show-download.gif)

## 下载特性
1. 进度回调
2. 断点续传

## 如何使用

### log开关

```
RxNet.enableLog = true;
```

### 下载调用

```
    String path = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + File.separator + "weather.apk";
    RxNet.download(url, path, new DownloadCallback() {
        @Override
        public void onStart(Disposable d) {
            LogUtils.d("onStart");
        }

        @Override
        public void onProgress(long totalByte, long currentByte, int progress) {
            LogUtils.d("onProgress " + progress);
        }

        @Override
        public void onFinish(File file) {
            LogUtils.d("onFinish " + file.getAbsolutePath());
        }

        @Override
        public void onError(String msg) {
            LogUtils.d("onError " + msg);
        }
```
