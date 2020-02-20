package com.hongri.nestedscrollview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hongri.nestedscrollview.adapter.MyAdapter;
import com.hongri.nestedscrollview.util.DataUtil;

/**
 * @author hongri
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView mRv;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        fillData();
    }


    private void initView() {
        mRv = findViewById(R.id.recycler_view);
        mAdapter = new MyAdapter(this);
        mRv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        mRv.setAdapter(mAdapter);
    }


    private void fillData() {
        if (mAdapter != null) {
            mAdapter.setData(DataUtil.getListData());
            mAdapter.notifyDataSetChanged();
        }
    }
}
