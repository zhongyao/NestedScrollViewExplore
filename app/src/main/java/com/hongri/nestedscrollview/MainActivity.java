package com.hongri.nestedscrollview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author hongri
 */
public class MainActivity extends AppCompatActivity {

    //private RecycleListView
    private RecyclerView mRV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
