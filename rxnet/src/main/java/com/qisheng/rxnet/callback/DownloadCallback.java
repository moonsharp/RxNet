package com.qisheng.rxnet.callback;

import java.io.File;

import io.reactivex.disposables.Disposable;

/**
 * @author LvQiSheng
 * @date 2019/7/15
 */
public interface DownloadCallback {
    void onStart(Disposable d);

    void onProgress(long totalByte, long currentByte, int progress);

    void onFinish(File file);

    void onError(String msg);
}
