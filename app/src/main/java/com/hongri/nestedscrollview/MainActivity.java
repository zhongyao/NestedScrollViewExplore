package com.hongri.nestedscrollview;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.NestedScrollView.OnScrollChangeListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hongri.nestedscrollview.adapter.MyAdapter;
import com.hongri.nestedscrollview.util.DataUtil;
import com.hongri.nestedscrollview.util.Logger;

/**
 * @author hongri
 */
public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    private NestedScrollView mNestedScrollView;
    private RecyclerView mRv;
    private MyAdapter mAdapter;
    private Button mToTop, mToEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        fillData();

        initListener();
    }

    private void initView() {
        mNestedScrollView = findViewById(R.id.nested_scroll_view);
        mRv = findViewById(R.id.recycler_view);
        mToTop = findViewById(R.id.to_top);
        mToEnd = findViewById(R.id.to_end);
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

    private void initListener() {
        if (mNestedScrollView != null) {
            mNestedScrollView.setOnScrollChangeListener(new OnScrollChangeListener() {
                @Override
                public void onScrollChange(NestedScrollView v, int scrollX, int scrollY,
                                           int oldScrollX, int oldScrollY) {

                    //当前展示出来的一屏的高度(不包含未展示出来的)
                    final int hasShowHeight = mNestedScrollView.getMeasuredHeight();
                    //总高度
                    final int totalHeight = mNestedScrollView.getChildAt(0).getMeasuredHeight();

                    Logger.d(TAG,
                        "hasShowHeight: " + hasShowHeight + "\ntotalHeight:" + totalHeight);

                    if (scrollY > oldScrollY) {
                        Logger.d(TAG, "下滑");
                    }

                    if (scrollY < oldScrollY) {
                        Logger.d(TAG, "上滑");
                    }

                    if (scrollY == totalHeight - hasShowHeight) {
                        Logger.d(TAG, "已滑动到底部");
                    }

                    if (scrollY == 0) {
                        Logger.d(TAG, "已滑动到顶部");
                    }

                }
            });
        }

        if (mToTop != null) {
            mToTop.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mNestedScrollView != null) {
                        //方法1
                        //mNestedScrollView.scrollTo(0,0);
                        //方法2
                        mNestedScrollView.fullScroll(NestedScrollView.FOCUS_UP);
                    }

                }
            });
        }

        if (mToEnd != null) {
            mToEnd.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mNestedScrollView != null) {
                        //总高度
                        final int totalHeight = mNestedScrollView.getChildAt(0).getMeasuredHeight();
                        //方法1
                        //mNestedScrollView.scrollTo(0, totalHeight);
                        //方法2
                        mNestedScrollView.fullScroll(NestedScrollView.FOCUS_DOWN);
                    }
                }
            });
        }
    }

}
