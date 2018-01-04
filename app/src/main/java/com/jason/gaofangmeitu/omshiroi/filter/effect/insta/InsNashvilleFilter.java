package com.jason.gaofangmeitu.omshiroi.filter.effect.insta;

import android.content.Context;

import com.jason.gaofangmeitu.omshiroi.filter.base.MultipleTextureFilter;
import com.jason.gaofangmeitu.omshiroi.util.TextureUtils;

/**
 * Created by Ads on 2017/4/7.
 */

public class InsNashvilleFilter extends MultipleTextureFilter {
    public InsNashvilleFilter(Context context) {
        super(context, "filter/fsh/insta/nashville.glsl");
        textureSize=2;
    }

    @Override
    public void init() {
        super.init();
        externalBitmapTextures[0].load(context, "filter/textures/inst/nashvillemap.png");
    }

    @Override
    public void onPreDrawElements() {
        super.onPreDrawElements();
        setUniform1f(glSimpleProgram.getProgramId(),"strength",1.0f);
    }
}
