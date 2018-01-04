package com.jason.gaofangmeitu.omshiroi.filter.effect.instb;

import android.content.Context;

import com.jason.gaofangmeitu.omshiroi.filter.base.MultipleTextureFilter;
import com.jason.gaofangmeitu.omshiroi.util.TextureUtils;

/**
 * Created by Ads on 2017/4/7.
 */

public class InsXproIIFilter extends MultipleTextureFilter {
    public InsXproIIFilter(Context context) {
        super(context, "filter/fsh/instb/xproii.glsl");
        textureSize=2;
    }

    @Override
    public void init() {
        super.init();
        externalBitmapTextures[0].load(context, "filter/textures/inst/xpromap.png");
        externalBitmapTextures[1].load(context, "filter/textures/inst/vignettemap_new.png");
    }

    @Override
    public void onPreDrawElements() {
        super.onPreDrawElements();
        setUniform1f(glSimpleProgram.getProgramId(),"strength",1.0f);
    }
}
