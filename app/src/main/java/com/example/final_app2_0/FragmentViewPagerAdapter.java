package com.example.final_app2_0;

import  androidx.annotation.NonNull;
import  androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
public class FragmentViewPagerAdapter extends FragmentStateAdapter{
    //Adapter初始化
    public  FragmentViewPagerAdapter(@NonNull FragmentActivity fragmentActivity){
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position){
        if (position == 0){
            return new actives();
        } else if (position==1) {
            return new update();
        } else if (position==2) {
            return new events();
        }else {
            return new sub_error();
        }
        //切換頁面
    }
    @Override
    public int getItemCount(){
        return 4;
    }
}
