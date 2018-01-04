package com.jason.gaofangmeitu.omshiroi.filter.imgproc;

import android.content.Context;

import com.jason.gaofangmeitu.omshiroi.filter.base.SimpleFragmentShaderFilter;


/**
 * Created by Ads on 2016/11/19.
 * InvertColorFilter (反色)
 */

public class InvertColorFilter extends SimpleFragmentShaderFilter {
    public InvertColorFilter(Context context) {
        super(context, "filter/fsh/imgproc/invert_color.glsl");
    }
}
