package com.jason.gaofangmeitu.omshiroi.ui;

import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.jason.gaofangmeitu.R;
import com.jason.gaofangmeitu.omshiroi.debug.GlobalConfig;
import com.jason.gaofangmeitu.omshiroi.filter.helper.FilterType;
import com.jason.gaofangmeitu.omshiroi.flyu.DemoConstants;
import com.jason.gaofangmeitu.omshiroi.glessential.GLRootView;
import com.jason.gaofangmeitu.omshiroi.imagedit.GLWrapper;
import com.jason.gaofangmeitu.omshiroi.util.BitmapUtils;
import com.jason.gaofangmeitu.omshiroi.util.FileUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈家程 on 2017/12/27.
 */

public class EditActivity extends AppCompatActivity {

    private RecyclerView filterListView;
    private GLRootView glRootView;
    private GLWrapper glWrapper;
    private Button savePhotoBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_edit);
        GlobalConfig.context = this;

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.flags |= WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
        getWindow().setAttributes(params);

        setFilterList();

        setUpImage();


        savePhotoBtn = (Button) findViewById(R.id.id_save_edit_photo);
        savePhotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int width;
                final int height;
                width = glRootView.getMeasuredWidth();
                height = glRootView.getMeasuredHeight();
                GLWrapper.isTakePicture = true;
//                BitmapUtils.sendImage(width, height, EditActivity.this, new FileUtils.FileSavedCallback() {
//                    @Override
//                    public void onFileSaved(String filePath) {
//                        Toast.makeText(EditActivity.this, "图片保存在" + filePath, Toast.LENGTH_SHORT).show();
//                    }
//                });

            }
        });
    }

    private void setUpImage(){
        String path = getIntent().getStringExtra(DemoConstants.IMAGE_PATH);

        final Bitmap bitmap = BitmapUtils.loadBitmapFromFile(path);
        glRootView.setAspectRatio(bitmap.getWidth(), bitmap.getHeight());
        bitmap.recycle();

        glWrapper.setFilePath(path);
    }

    private void setFilterList(){
        glRootView = (GLRootView) findViewById(R.id.camera_view);
        glWrapper = GLWrapper.newInstance()
                .setGlImageView(glRootView)
                .setContext(this)
                .init();

        FileUtils.upZipFile(this, "filter/thumbs/thumbs.zip", getFilesDir().getAbsolutePath());

        filterListView = (RecyclerView) findViewById(R.id.filter_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        filterListView.setLayoutManager(linearLayoutManager);

        List<FilterType> filterTypeList = new ArrayList<>();
        for (int i = 0; i < FilterType.values().length; i++){
            filterTypeList.add(FilterType.values()[i]);
            if (i == 0){
                filterTypeList.add(FilterType.NONE);
            }
        }

        FilterAdapter filterAdapter = new FilterAdapter(this, filterTypeList);
        filterListView.setAdapter(filterAdapter);
        filterAdapter.setOnFilterChangeListener(new FilterAdapter.OnFilterChangeListener() {
            @Override
            public void onFilterChanged(FilterType filterType) {
                glWrapper.switchLastFilterOfCustomizedFilters(filterType);
            }
        });
    }
}
