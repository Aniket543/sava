package com.wohlig.sava;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private RecyclerView mRecyclerView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        mRecyclerView2 = (RecyclerView)findViewById(R.id.my_recycler_view2);
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        List<String> data = new ArrayList<>();
        for(int i = 0;i<10;i++){
            data.add("Demo " + i);
        }

        List<String> data2 = new ArrayList<>();
        for(int i = 0;i<10;i++){
            data2.add("Demo " + i);
        }

        MyAdapter myAdapter = new MyAdapter(data,this);
        mRecyclerView.setAdapter(myAdapter);
        mRecyclerView.addItemDecoration(new VerticalSpaceItemDecoration(10));

        MyAdapter2 myAdapter2 = new MyAdapter2(data2,this);
        mRecyclerView2.setAdapter(myAdapter2);
        mRecyclerView2.addItemDecoration(new HorizontalSpaceItemDecoration(2));
    }


    public class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {

        private final int mVerticalSpaceHeight;

        public VerticalSpaceItemDecoration(int mVerticalSpaceHeight) {
            this.mVerticalSpaceHeight = mVerticalSpaceHeight;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            outRect.right = mVerticalSpaceHeight;
        }
    }

    public class HorizontalSpaceItemDecoration extends RecyclerView.ItemDecoration {

        private final int mHorizontalSpaceHeight;

        public HorizontalSpaceItemDecoration(int mHorizontalSpaceHeight) {
            this.mHorizontalSpaceHeight = mHorizontalSpaceHeight;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            outRect.bottom = mHorizontalSpaceHeight;
        }
    }
}
