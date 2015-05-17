package com.example.scrollabletagfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.PagerTitleStrip;

public class MainActivity extends FragmentActivity {
	// This seems like the only situation where we need to extends
	// FragmentActivity other than Activity
	// Maybe only FagmentActivity can inflate a viewPager as contentView (?)

	ViewPager viewPager = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// this view now contains viewPager
		setContentView(R.layout.activity_main);

		viewPager = (ViewPager) findViewById(R.id.pager);
		// we are using the support library here to make sure that this is
		// compatable with lower versions of android
		FragmentManager manager = getSupportFragmentManager();
		viewPager.setAdapter(new MyAdapter(manager));

	}

	// For small number of pages, onSaveinstanceState not called, object not
	// dettached
	class MyAdapter extends FragmentPagerAdapter {
		// For large number of pages, onSaveinstanceState will be called,
		// objects are destoyed
//		 class MyAdapter extends FragmentStatePagerAdapter {

		public MyAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		// FragmentPagerAdapter will only call getItem once, once all the
		// fragment objects are created, it is saved into memery. On tab
		// switching, we are only destryong the UI not the object. That is part
		// of the reason why we cannot have a lot of tabs here.
		public Fragment getItem(int arg0) {
			// return the fragment object
			Fragment fragment = null;
			switch (arg0) {
			case 0:
				fragment = new FragmentA();
				break;
			case 1:
				fragment = new FragmentB();
				break;
			case 2:
				fragment = new FragmentC();
				break;

			default:
				break;
			}
			return fragment;
		}

		@Override
		public int getCount() {
			// we have 3 fragments
			return 3;
		}

		// This override along with the item
		// android.support.v4.view.PagerTitleStrip in layout file contributes to
		// the title.Depending on where we are, tab title will be set to the
		// corresponding text
		@Override
		public CharSequence getPageTitle(int position) {

			switch (position) {
			case 0:

				return "Tab1";
			case 1:
				return "Tab2";
			case 2:
				return "Tab3";
			default:
				return "";
			}
		}

	}
}
