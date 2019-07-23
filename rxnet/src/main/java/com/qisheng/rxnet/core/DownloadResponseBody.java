package com.qisheng.rxnet.core;

import android.support.annotation.NonNull;

import com.qisheng.rxnet.callback.DownloadListener;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/**
 * @author LvQiSheng
 * @date 2019/7/16
 */
public class DownloadResponseBody extends ResponseBody {
    private final ResponseBody responseBody;
    private BufferedSource bufferedSource;

    public DownloadResponseBody(ResponseBody responseBody, DownloadListener listener) {
        this.responseBody = responseBody;
        if (null != listener) {
            listener.onStart(responseBody);
        }
    }

    @Override
    public MediaType contentType() {
        return responseBody.contentType();
    }


    @Override
    public long contentLength() {
        return responseBody.contentLength();
    }

    @Override
    public BufferedSource source() {
        if (bufferedSource == null) {
            bufferedSource = Okio.buffer(getSource(responseBody.source()));
        }
        return bufferedSource;
    }

    private Source getSource(Source source) {
        return new ForwardingSource(source) {
            long downloadBytes = 0L;

            @Override
            public long read(@NonNull Buffer buffer, long byteCount) throws IOException {
                long singleRead = super.read(buffer, byteCount);
                if (-1 != singleRead) {
                    downloadBytes += singleRead;
                }
                return singleRead;
            }
        };
    }
}
