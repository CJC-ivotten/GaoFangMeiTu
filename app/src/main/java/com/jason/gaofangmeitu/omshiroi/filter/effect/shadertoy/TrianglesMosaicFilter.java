package com.jason.gaofangmeitu.omshiroi.filter.effect.shadertoy;

import android.content.Context;

/**
 * Created by Ads on 2017/4/6.
 */

public class TrianglesMosaicFilter extends ShaderToyAbsFilter{
    public TrianglesMosaicFilter(Context context) {
        super(context, "filter/fsh/shadertoy/triangles_mosaic.glsl");
    }
}
