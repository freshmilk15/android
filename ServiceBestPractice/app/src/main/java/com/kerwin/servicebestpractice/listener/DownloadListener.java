package com.kerwin.servicebestpractice.listener;

/**
 * Created by Administrator on 2019/4/13.
 */

public interface DownloadListener {

    void onProgress(int progress);
    void onSuccess();
    void onFailed();
    void onPaused();
    void onCanceled();

}
