package com.sergioventura.wxllpaper.viewer;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.sergioventura.wxllpaper.util.WallpaperUtils;


/**
 * @author Aidan Follestad (afollestad)
 */
public class ViewerPageAdapter extends FragmentStatePagerAdapter {

    public int mCurrentPage;
    private final WallpaperUtils.WallpapersHolder mWallpapers;

    public ViewerPageAdapter(AppCompatActivity context, int initialOffset, WallpaperUtils.WallpapersHolder wallpapers) {
        super(context.getFragmentManager());
        mCurrentPage = initialOffset;
        mWallpapers = wallpapers;
    }

    @Override
    public Fragment getItem(int position) {
        return ViewerPageFragment.create(mWallpapers.get(position), position)
                .setIsActive(mCurrentPage == position);
    }

    @Override
    public int getCount() {
        return mWallpapers.length();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}