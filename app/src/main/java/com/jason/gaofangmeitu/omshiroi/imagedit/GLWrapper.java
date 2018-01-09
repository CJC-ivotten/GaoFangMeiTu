package com.jason.gaofangmeitu.omshiroi.imagedit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.opengl.GLES20;
import android.opengl.GLException;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import com.jason.gaofangmeitu.omshiroi.filter.base.FilterGroup;
import com.jason.gaofangmeitu.omshiroi.filter.base.PassThroughFilter;
import com.jason.gaofangmeitu.omshiroi.filter.helper.FilterFactory;
import com.jason.gaofangmeitu.omshiroi.filter.helper.FilterType;
import com.jason.gaofangmeitu.omshiroi.util.BitmapUtils;
import com.jason.gaofangmeitu.omshiroi.util.FileUtils;
import com.jason.gaofangmeitu.omshiroi.util.TextureUtils;

import java.nio.IntBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by 陈家程 on 2017/12/27.
 */

public class GLWrapper implements GLSurfaceView.Renderer {

    private GLSurfaceView glImageView;
    private Context context;
    private FilterGroup filterGroup;
    private FilterGroup customizedFilters;
    private int surfaceWidth, surfaceHeight;
    private int textureId;

    private String filePath;

    private GLWrapper() {
        textureId = 0;
    }

    public static GLWrapper newInstance() {
        return new GLWrapper();
    }

    public GLWrapper init() {
        glImageView.setEGLContextClientVersion(2);
        glImageView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        glImageView.getHolder().setFormat(PixelFormat.TRANSLUCENT);

        glImageView.setRenderer(this);

        glImageView.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
        //glImageView.setClickable(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            glImageView.setPreserveEGLContextOnPause(true);
        }

        filterGroup = new FilterGroup();
        customizedFilters = new FilterGroup();

        filterGroup.addFilter(new FirstPassFilter(context));
        customizedFilters.addFilter(new PassThroughFilter(context));
        filterGroup.addFilter(customizedFilters);

        return this;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        filterGroup.init();
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        surfaceWidth = width;
        surfaceHeight = height;
        filterGroup.onFilterChanged(width, height);
        if(!MiscUtils.isNull(filePath)){
            final Bitmap bitmap = BitmapUtils.loadBitmapFromFile(filePath);
            textureId= TextureUtils.loadTextureWithOldTexId(bitmap,0);
            Log.d("GL_THREAD",textureId+" ");
        }
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(GLES20.GL_DEPTH_BUFFER_BIT | GLES20.GL_COLOR_BUFFER_BIT);
        if (textureId != 0) {
            filterGroup.onDrawFrame(textureId);
        }
        if (isTakePicture) {
            BitmapUtils.sendImage(glImageView.getMeasuredWidth(), glImageView.getMeasuredHeight(), context, new FileUtils.FileSavedCallback() {
                @Override
                public void onFileSaved(String filePath) {
                    Toast.makeText(context, "图片保存在" + filePath, Toast.LENGTH_SHORT).show();
                    isTakePicture = false;
                }
            });
            isTakePicture = false;
        }
    }

    public static boolean isTakePicture = false;

    private Bitmap createBitmapFromGLSurface(int x, int y, int w, int h, GL10 gl) {
        int bitmapBuffer[] = new int[w * h];
        int bitmapSource[] = new int[w * h];
        IntBuffer intBuffer = IntBuffer.wrap(bitmapBuffer);
        intBuffer.position(0);
        try {
            gl.glReadPixels(x, y, w, h, GL10.GL_RGBA, GL10.GL_UNSIGNED_BYTE,
                    intBuffer);
            int offset1, offset2;
            for (int i = 0; i < h; i++) {
                offset1 = i * w;
                offset2 = (h - i - 1) * w;
                for (int j = 0; j < w; j++) {
                    int texturePixel = bitmapBuffer[offset1 + j];
                    int blue = (texturePixel >> 16) & 0xff;
                    int red = (texturePixel << 16) & 0x00ff0000;
                    int pixel = (texturePixel & 0xff00ff00) | red | blue;
                    bitmapSource[offset2 + j] = pixel;
                }
            }
        } catch (GLException e) {
            return null;
        }
        return Bitmap.createBitmap(bitmapSource, w, h, Bitmap.Config.ARGB_8888);
    }

    public GLWrapper setGlImageView(GLSurfaceView glImageView) {
        this.glImageView = glImageView;
        return this;
    }

    public GLWrapper setContext(Context context) {
        this.context = context;
        return this;
    }

    public void setTextureId(int textureId) {
        this.textureId = textureId;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void switchLastFilterOfCustomizedFilters(FilterType filterType){
        if (filterType==null) return;
        //currentFilterType=filterType;
        customizedFilters.switchLastFilter(FilterFactory.createFilter(filterType,context));
    }
}
