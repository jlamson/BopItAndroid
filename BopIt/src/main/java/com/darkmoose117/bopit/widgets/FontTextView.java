package com.darkmoose117.bopit.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.darkmoose117.bopit.R;

/**
 * Created by Joshua Lamson on 10/7/13.
 */
public class FontTextView extends TextView {

    private String mFontFile;

    public FontTextView(Context context) {
        this(context, null);
    }

    public FontTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        initFontFile(context, attrs);
    }

    private void initFontFile(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.FontTextView);
        String fontFile = a.getString(R.styleable.FontTextView_fontFile);
        a.recycle();

        setFontFile(fontFile);
    }

    /**
     * Sets the ttf font to use on this {@link android.widget.TextView}. The .ttf name given must
     * be in the assets/fonts folder. For the assets/fonts/Ariel.ttf file, the parameter would be
     * "Ariel".
     *
     * @param fontFile the name of the font file (must be a .ttf)
     */
    public void setFontFile(String fontFile) {
        mFontFile = fontFile;
        Typeface typeface = Typeface.createFromAsset(
                getContext().getAssets(),
                String.format("fonts/%s.ttf", mFontFile)
        );
        setTypeface(typeface);
    }

    public String getFontFile() {
        return mFontFile;
    }
}
