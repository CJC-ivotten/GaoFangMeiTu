package com.jason.gaofangmeitu.omshiroi.filter.effect.mx;

import android.content.Context;

import com.jason.gaofangmeitu.omshiroi.filter.base.SimpleFragmentShaderFilter;

/**
 * Created by Ads on 2017/1/31.
 * ReminiscenceFilter (回忆)
 */

public class ReminiscenceFilter extends SimpleFragmentShaderFilter {
    public ReminiscenceFilter(Context context) {
        super(context, "filter/fsh/mx/mx_reminiscence.glsl");
    }
}
