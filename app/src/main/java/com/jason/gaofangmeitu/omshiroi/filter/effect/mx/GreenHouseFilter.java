package com.jason.gaofangmeitu.omshiroi.filter.effect.mx;

import android.content.Context;

import com.jason.gaofangmeitu.omshiroi.filter.base.SimpleFragmentShaderFilter;

/**
 * Created by Ads on 2017/1/31.
 * GreenHouseFilter (温室)
 */

public class GreenHouseFilter extends SimpleFragmentShaderFilter{
    public GreenHouseFilter(Context context) {
        super(context, "filter/fsh/mx/mx_green_house.glsl");
    }
}
