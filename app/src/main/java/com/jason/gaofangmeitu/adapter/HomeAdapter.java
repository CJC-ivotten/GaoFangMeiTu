package com.jason.gaofangmeitu.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jason.gaofangmeitu.R;
import com.jason.gaofangmeitu.item.HomeItem;

import java.util.List;

/**
 * Created by 陈家程 on 2017/9/12.
 */

public class HomeAdapter extends BaseQuickAdapter<HomeItem, BaseViewHolder>{

    public HomeAdapter(@LayoutRes int layoutResId, @Nullable List<HomeItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeItem item) {
        helper.setText(R.id.id_home_item_tv, item.getTitle());
        helper.setImageResource(R.id.id_home_item_iv, item.getImageResource());
    }
}
