package com.jason.gaofangmeitu.omshiroi.filter.effect.insta;

import android.content.Context;

import com.jason.gaofangmeitu.omshiroi.filter.base.MultipleTextureFilter;
import com.jason.gaofangmeitu.omshiroi.util.TextureUtils;

/**
 * Created by Ads on 2017/4/7.
 */

public class InsFairyTaleFilter extends MultipleTextureFilter {
    public InsFairyTaleFilter(Context context) {
        super(context, "filter/fsh/insta/look_up.glsl");
        textureSize=1;
    }

    @Override
    public void init() {
        super.init();
        externalBitmapTextures[0].load(context, "filter/textures/inst/fairy_tale.png");
    }

}
