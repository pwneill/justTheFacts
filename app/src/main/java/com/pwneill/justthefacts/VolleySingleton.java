package com.pwneill.justthefacts;

import android.graphics.Bitmap;

import androidx.collection.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {
    private static com.pwneill.justthefacts.VolleySingleton mInstance = null;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private VolleySingleton(){
        mRequestQueue = Volley.newRequestQueue(com.pwneill.justthefacts.MyApplication.getAppContext());
        mImageLoader = new ImageLoader(this.mRequestQueue, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(10);
            public void putBitmap(String url, Bitmap bitmap) {
                mCache.put(url, bitmap);
            }
            public Bitmap getBitmap(String url) {
                return mCache.get(url);
            }
        });
    }

    public static com.pwneill.justthefacts.VolleySingleton getInstance(){
        if(mInstance == null){
            mInstance = new com.pwneill.justthefacts.VolleySingleton();
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue(){
        return this.mRequestQueue;
    }
    
    public ImageLoader getImageLoader(){
        return this.mImageLoader;
    }

}
