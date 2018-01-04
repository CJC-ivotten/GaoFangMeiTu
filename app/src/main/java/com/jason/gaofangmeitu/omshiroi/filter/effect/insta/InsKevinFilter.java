package com.jason.gaofangmeitu.omshiroi.filter.effect.insta;

import android.content.Context;

import com.jason.gaofangmeitu.omshiroi.filter.base.MultipleTextureFilter;
import com.jason.gaofangmeitu.omshiroi.util.TextureUtils;

/**
 * Created by Ads on 2017/4/7.
 */

public class InsKevinFilter extends MultipleTextureFilter {
    public InsKevinFilter(Context context) {
        super(context, "filter/fsh/insta/kevin.glsl");
        textureSize=1;
    }

    @Override
    public void init() {
        super.init();
        externalBitmapTextures[0].load(context, "filter/textures/inst/kevinmap.png");
    }

}
