package com.lhyla.p23databinding;

/**
 * Created by dariusznowak on 14.06.2017.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public MyPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                MojTab1Fragment tab1 = new MojTab1Fragment();
                return tab1;
            case 1:
                MojTab2Fragment tab2 = new MojTab2Fragment();
                return tab2;
            case 2:
                MojTab3Fragment tab3 = new MojTab3Fragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}