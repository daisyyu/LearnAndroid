package com.example.swipetabfragment;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;

public class MainActivity extends FragmentActivity implements TabListener {
	private static final String TAG = "Daisy";
	ActionBar actionBar;
	ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		viewPager = (ViewPager) findViewById(R.id.pager);
		viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				Log.d(TAG, "onPageSeclected at position" + arg0);
				// When viewPage has been changed via scrolling, we need to
				// change the active tab
				actionBar.setSelectedNavigationItem(arg0);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				Log.d(TAG, "onPageScrolled at position " + arg0 + "from "
						+ arg1 + "with number of pixels =" + arg2);

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				switch (arg0) {
				case ViewPager.SCROLL_STATE_IDLE:
					Log.d(TAG, "Idle");
					break;
				case ViewPager.SCROLL_STATE_DRAGGING:
					Log.d(TAG, "dragging");
					break;
				case ViewPager.SCROLL_STATE_SETTLING:
					Log.d(TAG, "settling");
					break;

				default:
					break;
				}

			}
		});
		// Hey ActoinBar: There's going to be tabs coming up, get ready for that
		actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		ActionBar.Tab tab1 = actionBar.newTab();
		tab1.setText("Tab 1");
		tab1.setTabListener(this);
		ActionBar.Tab tab2 = actionBar.newTab();
		tab2.setText("Tab 2");
		tab2.setTabListener(this);
		ActionBar.Tab tab3 = actionBar.newTab();
		tab3.setText("Tab 3");
		tab3.setTabListener(this);

		actionBar.addTab(tab1);
		actionBar.addTab(tab2);
		actionBar.addTab(tab3);

	}

	class MyAdapter extends FragmentPagerAdapter {

		public MyAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int arg0) {
			switch (arg0) {
			case 0:
				return new FragmentA();
			case 1:
				return new FragmentB();
			case 2:
				return new FragmentC();

			default:
				return null;
			}
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 3;
		}

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		viewPager.setCurrentItem(tab.getPosition());
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

}
