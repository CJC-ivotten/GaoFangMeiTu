package com.jason.gaofangmeitu.activity;

import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import com.jason.gaofangmeitu.GPUImageTools.GPUImageFilterTools;
import com.jason.gaofangmeitu.R;
import com.jason.gaofangmeitu.utils.Constant;
import com.zhihu.matisse.internal.entity.Item;

import jp.co.cyberagent.android.gpuimage.GPUImageFilter;
import jp.co.cyberagent.android.gpuimage.GPUImageView;

/**
 * Created by 陈家程 on 2017/9/13.
 */

public class PsPhotoActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener,
        View.OnClickListener , GPUImageView.OnPictureSavedListener {

    private GPUImageFilter mFilter;
    private GPUImageFilterTools.FilterAdjuster mFilterAdjuster;
    private GPUImageView mGPUImageView;
    private Item item; // 图片信息

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ps_photo);

        ((SeekBar) findViewById(R.id.seekBar)).setOnSeekBarChangeListener(this);
        findViewById(R.id.button_choose_filter).setOnClickListener(this);
        findViewById(R.id.button_save).setOnClickListener(this);
        mGPUImageView = (GPUImageView) findViewById(R.id.gpuimage);

        // 从图片选择库中拿到传过来的 image
        item = getIntent().getParcelableExtra("item_uri");
        if (item != null){
            handleImage(item.uri);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        if (mFilterAdjuster != null) {
            mFilterAdjuster.adjust(progress);
        }
        mGPUImageView.requestRender();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    /**
     * 设置要处理的图片
     * @param selectedImage
     */
    private void handleImage(final Uri selectedImage) {
        mGPUImageView.setImage(selectedImage);
    }

    /**
     * 选择滤镜
     * @param filter
     */
    private void switchFilterTo(final GPUImageFilter filter){
        if (mFilter == null
                || (filter != null && !mFilter.getClass().equals(filter.getClass()))) {
            mFilter = filter;
            mGPUImageView.setFilter(mFilter);
            mFilterAdjuster = new GPUImageFilterTools.FilterAdjuster(mFilter);

            findViewById(R.id.seekBar).setVisibility(
                    mFilterAdjuster.canAdjust() ? View.VISIBLE : View.GONE);
        }
    }

    /**
     * 保存图片到本地 a_Jason_meitu 文件夹
     */
    private void saveImage(){
        String fileName = System.currentTimeMillis() + ".jpg";
        mGPUImageView.saveToPictures(Constant.SAVE_PIR_FOLDER, fileName, this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_choose_filter:
                GPUImageFilterTools.showDialog(this, new GPUImageFilterTools.OnGpuImageFilterChosenListener() {

                    @Override
                    public void onGpuImageFilterChosenListener(final GPUImageFilter filter) {
                        switchFilterTo(filter);
                        mGPUImageView.requestRender();
                    }

                });
                break;
            case R.id.button_save:
                saveImage();
                break;

            default:
                break;
        }

    }

    @Override
    public void onPictureSaved(Uri uri) {
        Toast.makeText(this, "保存图片: " + uri.toString(), Toast.LENGTH_SHORT).show();

    }
}
