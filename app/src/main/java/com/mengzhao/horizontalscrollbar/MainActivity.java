package com.mengzhao.horizontalscrollbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;

import com.mengzhao.horizontalscrollbar.fragment.FifthFragment;
import com.mengzhao.horizontalscrollbar.fragment.FirstFragment;
import com.mengzhao.horizontalscrollbar.fragment.FourthFragment;
import com.mengzhao.horizontalscrollbar.fragment.SecondFragment;
import com.mengzhao.horizontalscrollbar.fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tableLayout;
    private ViewPager mViewPager;
    private List<String> titleList;
    private List<Fragment> fragmentList;
    private viewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        tableLayout= (TabLayout) findViewById(R.id.tableLayout);
        mViewPager= (ViewPager) findViewById(R.id.viewPager);
        titleList=new ArrayList<>();
        titleList.add("第一");
        titleList.add("第二");
        titleList.add("第三");
        titleList.add("第四");
        titleList.add("第五");
        fragmentList =new ArrayList<>();
        FirstFragment firstFragment=new FirstFragment();
        fragmentList.add(firstFragment);
        SecondFragment secondFragment=new SecondFragment();
        fragmentList.add(secondFragment);
        ThirdFragment thirdFragment=new ThirdFragment();
        fragmentList.add(thirdFragment);
        FourthFragment fourthFragment=new FourthFragment();
        fragmentList.add(fourthFragment);
        FifthFragment fifthFragment=new FifthFragment();
        fragmentList.add(fifthFragment);
        adapter=new viewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        tableLayout.setupWithViewPager(mViewPager);
        mViewPager.setOffscreenPageLimit(5);
        tableLayout.setTabsFromPagerAdapter(adapter);
    }
    class viewPagerAdapter extends FragmentPagerAdapter{
        public viewPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}
