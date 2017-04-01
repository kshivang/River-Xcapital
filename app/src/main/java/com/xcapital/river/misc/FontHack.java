package com.xcapital.river.misc;

import android.app.Application;

/**
 * Created by kshivang on 22/03/17.
 */

public class FontHack extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/Calibre-R-Regular.otf");
    }
}
