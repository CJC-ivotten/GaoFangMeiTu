package com.jason.gaofangmeitu;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jason.gaofangmeitu.adapter.HomeAdapter;
import com.jason.gaofangmeitu.decoration.GridItemDecoration;
import com.jason.gaofangmeitu.item.HomeItem;
import com.jason.gaofangmeitu.learnOpengles.SGLViewActivity;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.engine.impl.PicassoEngine;
import com.zhihu.matisse.filter.Filter;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
   // private static final Class<?>[] ACTIVITY = {AnimationUseActivity.class, MultipleItemUseActivity.class, HeaderAndFooterUseActivity.class, PullToRefreshUseActivity.class, SectionUseActivity.class, EmptyViewUseActivity.class, ItemDragAndSwipeUseActivity.class, ItemClickActivity.class, ExpandableUseActivity.class, DataBindingUseActivity.class,UpFetchUseActivity.class};
    private static final String[] TITLE = {"美化图片", "手绘自拍", "人像美容", "拼图", "素材中心", "广告1", "广告2", "广告3"};
    private static final int[] IMG = {R.drawable.ac4,R.drawable.ac4,R.drawable.ac4,R.drawable.ac4,R.drawable.ac4,R.drawable.ac4,R.drawable.ac4,R.drawable.ac4,};
    private ArrayList<HomeItem> mDataList;
    private RecyclerView mRecyclerView;

    private static final int REQUEST_CODE_CHOOSE = 23;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initAdapter();
    }

    private void initView(){
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerView);
        GridLayoutManager gms = new GridLayoutManager(this,2);
        gms.setOrientation(LinearLayoutManager.HORIZONTAL);// 设置 recyclerview 布局方式为横向布局
        mRecyclerView.setLayoutManager(gms);
    }

    @SuppressWarnings("unchecked")
    private void initAdapter() {
        BaseQuickAdapter homeAdapter = new HomeAdapter(R.layout.item_home_recyclerview, mDataList);
        homeAdapter.openLoadAnimation();
        homeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                selectItem(position);
            }
        });

        mRecyclerView.setAdapter(homeAdapter);
    }



    private void initData() {
        mDataList = new ArrayList<>();
        for (int i = 0; i < TITLE.length; i++) {
            HomeItem item = new HomeItem();
            item.setTitle(TITLE[i]);
            //item.setActivity(ACTIVITY[i]);
            item.setImageResource(IMG[i]);
            mDataList.add(item);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            Toast.makeText(this, Matisse.obtainPathResult(data).toString(), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 主界面，选则所需的图片出功能或者美颜相机
     * @param position
     */
    private void selectItem(int position) {
        switch (position){
            // 图片处理界面，最终是通过使用 GPUImage 来做处理
            case 0:
                Toast.makeText(MainActivity.this, "美拍", Toast.LENGTH_SHORT).show();
                RxPermissions rxPermissions = new RxPermissions(MainActivity.this);
                rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .subscribe(new Observer<Boolean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Boolean aBoolean) {
                                if (aBoolean) {
                                    Matisse.from(MainActivity.this)
                                            .choose(MimeType.ofAll(), false)
                                            .countable(false)
                                            // 是否在图片右上角显示选中的数目
                                            //.capture(true)
                                            .theme(R.style.Matisse_Dracula)
                                            //是否开启照相功能
                                            // .captureStrategy(
                                            //         new CaptureStrategy(true, "com.jason.gaofangmeitu.fileprovider"))
                                            .maxSelectable(9)
                                            //设置最大可选数量
                                            //.addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
                                            //添加过滤器,可自定义
                                            .gridExpectedSize(
                                                    getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                                            //设置期待的尺寸
                                            .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                                            //设置布局的水平或垂直属性
                                            .thumbnailScale(0.85f)
                                            //缩略图的缩放尺寸，默认为0.5
                                            .imageEngine(new GlideEngine())
                                            //设置图片加载库
                                            .forResult(REQUEST_CODE_CHOOSE);
                                    //启动选择图片的Activity


                                } else {
                                    Toast.makeText(MainActivity.this, R.string.permission_request_denied, Toast.LENGTH_LONG)
                                            .show();
                                }
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
                break;
            // 学习opengl es 的demo
            case 1:
                startActivity(new Intent(MainActivity.this, SGLViewActivity.class));
                break;
            default:
                break;
        }

    }

}
