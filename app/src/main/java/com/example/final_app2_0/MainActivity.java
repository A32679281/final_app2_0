package com.example.final_app2_0;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.Toast;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton add_btn;
    private ViewPager2 viewPager;
    private TabLayout tab;
    private FragmentViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_btn=findViewById(R.id.add_btn);
        add_btn.setOnClickListener(this);


        viewPager = findViewById(R.id.viewpager);
        tab = findViewById(R.id.tab);
        adapter = new FragmentViewPagerAdapter(this);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);


        new TabLayoutMediator(tab, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0) tab.setText("限定活動");
                if (position == 1) tab.setText("版本更新");
                if (position == 2) tab.setText("突發事件");
                if (position == 3) tab.setText("消消業障");
            }
        }).attach();//點擊後會發生的事件


        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //選中Tab時
                Toast.makeText(MainActivity.this, tab.getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //未選中Tab時
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //再次選中Tab時
            }

        });
    }

    @Override
    public void onClick(View view) {//點擊add_btn後出現的動畫
        Animation animation = new RotateAnimation(0,90,Animation.RELATIVE_TO_SELF,
                0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation.setDuration(300);
        add_btn.startAnimation(animation);
        animation.startNow();
        Intent intent =new Intent(MainActivity.this,Post_NEWS.class);
        startActivity(intent);

    }
}
