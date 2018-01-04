package com.jason.gaofangmeitu.omshiroi.filter.effect.mx;

import android.content.Context;

import com.jason.gaofangmeitu.omshiroi.filter.base.SimpleFragmentShaderFilter;

/**
 * Created by Ads on 2017/1/31.
 * ShiftColorFilter (提取红色)
 */

public class ShiftColorFilter extends SimpleFragmentShaderFilter {
    public ShiftColorFilter(Context context) {
        super(context, "filter/fsh/mx/mx_shift_color.glsl");
    }
}
