package com.cesoc.apps.android.dotaapp.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cesoc.apps.android.dotaapp.Fragments.HeroesListFragment;
import com.cesoc.apps.android.dotaapp.Models.Heroe;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> list =new ArrayList<>();
    private List<String> titles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    public void AddFragment(Fragment myFragment, List<Heroe> heroes, String title){
        HeroesListFragment heroeFragment=(HeroesListFragment)myFragment;
        heroeFragment.SetListHeroes(heroes);
        list.add(myFragment);
        titles.add(title);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
