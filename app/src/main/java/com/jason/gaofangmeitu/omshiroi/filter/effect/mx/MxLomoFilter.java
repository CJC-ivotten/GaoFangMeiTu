package com.jason.gaofangmeitu.omshiroi.filter.effect.mx;

import android.content.Context;
import android.opengl.GLES20;

import com.jason.gaofangmeitu.omshiroi.filter.base.SimpleFragmentShaderFilter;
import com.jason.gaofangmeitu.omshiroi.util.TextureUtils;


/**
 * Created by Ads on 2017/2/1.
 * MxLomoFilter (LOMO)
 */

public class MxLomoFilter extends SimpleFragmentShaderFilter {
    public MxLomoFilter(Context context) {
        super(context, "filter/fsh/mx/mx_lomo.glsl");
    }

    @Override
    public void onDrawFrame(int textureId) {
        onPreDrawElements();
        setUniform1f(glSimpleProgram.getProgramId(),"rOffset",1.0f);
        setUniform1f(glSimpleProgram.getProgramId(),"gOffset",1.0f);
        setUniform1f(glSimpleProgram.getProgramId(),"bOffset",1.0f);
        TextureUtils.bindTexture2D(textureId, GLES20.GL_TEXTURE0,glSimpleProgram.getTextureSamplerHandle(),0);
        GLES20.glViewport(0,0,surfaceWidth,surfaceHeight);
        plane.draw();
    }
}
