package com.logotet.foolaround.model;

import android.graphics.Bitmap;

/**
 * Created by boban on 9/28/15.
 */
public class ImageData {
    private int broj;
    Bitmap bitmap;
    boolean loaded;

    public ImageData(int broj) {
        this.broj = broj;
    }
    public String getFileName(){
        return "img" + broj + ".png";
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }
}
