package com.xcapital.river.misc;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.reflect.Field;

/**
 * Created by kshivang on 22/03/17.
 *
 */

class FontsOverride {

    static void setDefaultFont(Context context,
                                      String staticTypefaceFieldName, String fontAssetName) {
        final Typeface regular = Typeface.createFromAsset(context.getAssets(),
                fontAssetName);
        try {
            replaceFont(staticTypefaceFieldName, regular);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void replaceFont(String staticTypefaceFieldName,
                                      final Typeface newTypeface) throws IllegalAccessException {
        try {
            final Field staticField = Typeface.class
                    .getDeclaredField(staticTypefaceFieldName);
            staticField.setAccessible(true);
            staticField.set(null, newTypeface);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
