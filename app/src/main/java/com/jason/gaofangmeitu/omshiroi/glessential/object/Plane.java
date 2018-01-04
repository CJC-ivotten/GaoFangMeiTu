package com.jason.gaofangmeitu.omshiroi.glessential.object;

import android.opengl.GLES20;

import com.jason.gaofangmeitu.omshiroi.constant.Rotation;
import com.jason.gaofangmeitu.omshiroi.util.BufferUtils;
import com.jason.gaofangmeitu.omshiroi.util.PlaneTextureRotationUtils;
import com.jason.gaofangmeitu.omshiroi.util.ShaderUtils;

import java.nio.FloatBuffer;

/**
 * Created by 陈家程 on 2017/12/29.
 */

public class Plane {

    private FloatBuffer mVerticesBuffer;
    private FloatBuffer mTexCoordinateBuffer;
    private final float TRIANGLES_DATA[] = {
            -1.0f, -1.0f, 0f,
            1.0f, -1.0f, 0f,
            -1.0f, 1.0f, 0f,
            1.0f, 1.0f, 0f
    };

    public Plane(boolean isInGroup) {
        mVerticesBuffer = BufferUtils.getFloatBuffer(TRIANGLES_DATA,0);
        if (isInGroup)
            mTexCoordinateBuffer = BufferUtils.getFloatBuffer(PlaneTextureRotationUtils.getRotation(Rotation.NORMAL, false, true), 0);
        else mTexCoordinateBuffer = BufferUtils.getFloatBuffer(PlaneTextureRotationUtils.TEXTURE_NO_ROTATION,0);
    }

    public void uploadVerticesBuffer(int positionHandle){
        FloatBuffer vertexBuffer = getVerticesBuffer();
        if (vertexBuffer == null) return;
        vertexBuffer.position(0);

        GLES20.glVertexAttribPointer(positionHandle, 3, GLES20.GL_FLOAT, false, 0, vertexBuffer);
        ShaderUtils.checkGlError("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(positionHandle);
        ShaderUtils.checkGlError("glEnableVertexAttribArray maPositionHandle");
    }

    public void uploadTexCoordinateBuffer(int textureCoordinateHandle){
        FloatBuffer textureBuffer = getTexCoordinateBuffer();
        if (textureBuffer == null) return;
        textureBuffer.position(0);

        GLES20.glVertexAttribPointer(textureCoordinateHandle, 2, GLES20.GL_FLOAT, false, 0, textureBuffer);
        ShaderUtils.checkGlError("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(textureCoordinateHandle);
        ShaderUtils.checkGlError("glEnableVertexAttribArray maTextureHandle");
    }


    public FloatBuffer getVerticesBuffer() {
        return mVerticesBuffer;
    }

    public FloatBuffer getTexCoordinateBuffer() {
        return mTexCoordinateBuffer;
    }

    //only used to flip texture
    public void setTexCoordinateBuffer(FloatBuffer mTexCoordinateBuffer) {
        this.mTexCoordinateBuffer = mTexCoordinateBuffer;
    }

    public void setVerticesBuffer(FloatBuffer mVerticesBuffer) {
        this.mVerticesBuffer = mVerticesBuffer;
    }

    public void resetTextureCoordinateBuffer(boolean isInGroup) {
        mTexCoordinateBuffer=null;
        if (isInGroup)
            mTexCoordinateBuffer = BufferUtils.getFloatBuffer(PlaneTextureRotationUtils.getRotation(Rotation.NORMAL, false, true), 0);
        else mTexCoordinateBuffer = BufferUtils.getFloatBuffer(PlaneTextureRotationUtils.TEXTURE_NO_ROTATION,0);
    }

    public void draw() {
        GLES20.glDrawArrays(GLES20.GL_TRIANGLE_STRIP, 0, 4);
    }

    public Plane scale(float scalingFactor){
        float[] temp=new float[TRIANGLES_DATA.length];
        System.arraycopy(TRIANGLES_DATA,0,temp,0,TRIANGLES_DATA.length);
        for(int i=0;i<temp.length;i++){
            temp[i]*=scalingFactor;
        }
        mVerticesBuffer = BufferUtils.getFloatBuffer(temp,0);
        return this;
    }
}

