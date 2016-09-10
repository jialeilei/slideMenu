package com.example.lei.slidemenu;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    //list
    private List<String> mTitleList = new ArrayList<>();
    private List<View> viewList = new ArrayList<View>();
    //view
    private ViewPager pager;
    private TabLayout tabLayout;
    private ListViewPagerAdapter adapter;
    private View view1,view2,view3,view4;
    //others
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addData();
        initView();
    }


    private void initView(){
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabMode(TabLayout.MODE_FIXED); //set tab mode
        tabLayout.addTab(tabLayout.newTab().setText(mTitleList.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(mTitleList.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(mTitleList.get(2)));
        tabLayout.addTab(tabLayout.newTab().setText(mTitleList.get(3)));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int tabLayoutPosition = tabLayout.getSelectedTabPosition();
                pager.setCurrentItem(tabLayoutPosition);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        pager = (ViewPager) findViewById(R.id.vp);
        adapter = new ListViewPagerAdapter(viewList);
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setPagerData();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setPagerData();

    }

    private void setPagerData(){
        int position = pager.getCurrentItem();
        TextView tvShow = (TextView) viewList.get(position).findViewById(R.id.tv);
        tvShow.setText(mTitleList.get(position));
    }

    private void addData(){
        //add title
        mTitleList.add("first");
        mTitleList.add("second");
        mTitleList.add("third");
        mTitleList.add("fourth");

        //add viewpager
        layoutInflater =  LayoutInflater.from(this);
        view1 = layoutInflater.inflate(R.layout.item_listview_viewpager,null);
        view2 = layoutInflater.inflate(R.layout.item_listview_viewpager,null);
        view3 = layoutInflater.inflate(R.layout.item_listview_viewpager,null);
        view4 = layoutInflater.inflate(R.layout.item_listview_viewpager,null);
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);
    }


}
