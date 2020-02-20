package com.hongri.nestedscrollview.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.hongri.nestedscrollview.R;
import com.hongri.nestedscrollview.util.CollectionUtil;

/**
 * @author zhongyao
 * @date 2020-02-20
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private ArrayList<String> mListData;
    private LayoutInflater mInflater;

    public MyAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<String> listData) {
        mListData = listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycler_view_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ((ItemViewHolder)holder).tv.setText(mListData.get(position));
    }

    @Override
    public int getItemCount() {
        return CollectionUtil.isEmpty(mListData) ? 0 : mListData.size();
    }

    private class ItemViewHolder extends ViewHolder {

        private TextView tv;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
