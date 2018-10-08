package com.qidongyinqing.www.designpattern.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qidongyinqing.www.designpattern.R;


/**
 * Created by xzqb on 2017/3/20.
 */

public class QuestionRVAdapter extends RVBaseAdapter {

    private String[] dataList;
    private OnItemClickListener onItemClickListener;


    public QuestionRVAdapter(Context context) {
        super(context);
    }

    @Override
    public int getItemCount() {
        return dataList.length;
    }
    public void setData(String[] dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new EventPlanningOneHolder(inflater.inflate(R.layout.item_more_quetion, parent, false));

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
                EventPlanningOneHolder oneHolder = ( EventPlanningOneHolder) holder;
                oneHolder.tv_question.setText(dataList[position]);

        oneHolder.ll_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.click(dataList[position]);
                }
            }
        });

    }



    public class EventPlanningOneHolder extends RecyclerView.ViewHolder {

        public TextView tv_question;
        public LinearLayout ll_container;

        public EventPlanningOneHolder(View itemView) {
            super(itemView);
            tv_question = itemView.findViewById(R.id.tv_question);
            ll_container = itemView.findViewById(R.id.ll_container);
        }
    }
public interface OnItemClickListener{
        public void click(String names);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }



}
