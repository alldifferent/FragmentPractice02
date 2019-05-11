package com.alldi.fragmentpractice02;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alldi.fragmentpractice02.adapters.PagerAdapter;
import com.alldi.fragmentpractice02.databinding.ActivityMainBinding;
import com.alldi.fragmentpractice02.fragment.FragmentTwo;

public class MainActivity extends BaseActivity {

    ActivityMainBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView();
        setValues();
        setupEvents();

    }

    @Override
    public void setupEvents() {

        act.twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Fragment fg = new Fragment();
//                FragmentManager fragmentManager = fg.getFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.oneFragment, fg);
//                fragmentTransaction.commit();

                act.viewPager.setCurrentItem(1);

            }
        });
        act.oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                act.viewPager.setCurrentItem(0);
            }
        });

        act.threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                act.viewPager.setCurrentItem(2);
            }
        });

        act.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                if (i == 0){
                    act.oneBtn.setText("현재 선택됨");
                    act.twoBtn.setText("2번 프래그먼트");
                    act.threeBtn.setText("3번 프래그먼트");
                }else if (i == 1){
                    act.oneBtn.setText("1번 프래그먼트");
                    act.twoBtn.setText("현재 선택됨");
                    act.threeBtn.setText("3번 프래그먼트");
                }else if (i == 2){
                    act.oneBtn.setText("1번 프래그먼트");
                    act.twoBtn.setText("2번 프래그먼트");
                    act.threeBtn.setText("현재 선택됨");
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    @Override
    public void setValues() {
        act.viewPager.setOffscreenPageLimit(4);// 프래그먼트의 갯수와 맞춰주자
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 3);
        act.viewPager.setAdapter(pagerAdapter);

    }

    @Override
    public void bindView() {

        act = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }
}
