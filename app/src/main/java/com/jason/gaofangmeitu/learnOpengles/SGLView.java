package com.jason.gaofangmeitu.learnOpengles;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

import com.jason.gaofangmeitu.learnOpengles.filter.AFilter;

import java.io.IOException;

/**
 * Created by 陈家程 on 2017/11/20.
 */

public class SGLView extends GLSurfaceView {

    private SGLRender render;

    public SGLView(Context context) {
        this(context,null);
    }

    public SGLView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        setEGLContextClientVersion(2);
        render=new SGLRender(this);
        setRenderer(render);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

        try {
            render.setImage(BitmapFactory.decodeStream(getResources().getAssets().open("texture/fengj.png")));
            requestRender();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SGLRender getRender(){
        return render;
    }

    public void setFilter(AFilter filter){
        render.setFilter(filter);
    }

}
