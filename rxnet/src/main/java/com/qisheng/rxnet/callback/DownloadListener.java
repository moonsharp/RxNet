package com.qisheng.rxnet.callback;

import okhttp3.ResponseBody;

/**
 * @author LvQiSheng
 * @date 2019/7/19
 */
public interface DownloadListener {
    void onStart(ResponseBody responseBody);
}
