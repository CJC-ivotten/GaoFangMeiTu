package com.jason.gaofangmeitu.omshiroi.filter.effect.mx;

import android.content.Context;

import com.jason.gaofangmeitu.omshiroi.filter.base.SimpleFragmentShaderFilter;


/**
 * Created by Ads on 2017/1/31.
 * BlackWhiteFilter (黑白)
 */

public class BlackWhiteFilter extends SimpleFragmentShaderFilter {
    public BlackWhiteFilter(Context context) {
        super(context, "filter/fsh/mx/mx_black_white.glsl");
    }
}
