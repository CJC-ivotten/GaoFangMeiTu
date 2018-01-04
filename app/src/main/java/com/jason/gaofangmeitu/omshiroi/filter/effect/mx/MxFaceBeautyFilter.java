package com.jason.gaofangmeitu.omshiroi.filter.effect.mx;

import android.content.Context;
import android.opengl.GLES20;
import com.jason.gaofangmeitu.omshiroi.filter.base.SimpleFragmentShaderFilter;
import com.jason.gaofangmeitu.omshiroi.util.TextureUtils;


/**
 * Created by Ads on 2017/2/1.
 * MxFaceBeautyFilter (Mx美颜)
 */

public class MxFaceBeautyFilter extends SimpleFragmentShaderFilter {
    public MxFaceBeautyFilter(Context context) {
        super(context, "filter/fsh/mx/mx_face_beauty.glsl");
    }

    @Override
    public void onDrawFrame(int textureId) {
        onPreDrawElements();
        setUniform1f(glSimpleProgram.getProgramId(),"stepSizeX",1.0f/surfaceWidth);
        setUniform1f(glSimpleProgram.getProgramId(),"stepSizeY",1.0f/surfaceHeight);
        TextureUtils.bindTexture2D(textureId, GLES20.GL_TEXTURE0,glSimpleProgram.getTextureSamplerHandle(),0);
        GLES20.glViewport(0,0,surfaceWidth,surfaceHeight);
        plane.draw();
    }
}
