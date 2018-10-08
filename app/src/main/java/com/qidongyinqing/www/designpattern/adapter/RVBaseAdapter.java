package com.qidongyinqing.www.designpattern.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.qidongyinqing.www.designpattern.utils.ObjectNullUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JiaShuai on 2018/6/11.
 */

public abstract class RVBaseAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context mContext;
    public LayoutInflater inflater;
    public List<T> mDatas;



    public RVBaseAdapter(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context may not be null");
        }
        this.mContext = context;
        this.inflater = LayoutInflater.from(mContext);
        mDatas = new ArrayList<>();
    }

    /**
     * 初次加载、或下拉刷新要替换全部旧数据时刷新数据
     *
     * @param datas
     */
    public void setNewData(List<T> datas) {
        mDatas.clear();
        if (ObjectNullUtils.listIsNull(datas)) return;
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    /**
     * 刷新加载更多的数据
     *
     * @param datas
     */
    public void setLoadMoreData(List<T> datas) {
        if (ObjectNullUtils.listIsNull(datas)) return;
        int size = mDatas.size();
        mDatas.addAll(datas);
        notifyItemInserted(size);
    }

    /**
     * 根据positiond得到data
     *
     * @param position
     * @return
     */
    public T getItem(int position) {
        if (mDatas.isEmpty()) {
            return null;
        }
        return mDatas.get(position);
    }

    @Override
    public int getItemCount() {
        return ObjectNullUtils.listIsNull(mDatas) ? 0 : mDatas.size();
    }
}
