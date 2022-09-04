package com.emonics.myapplicationgroceries

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.emonics.myapplicationgroceries.fragments.FruitsFragment
import com.emonics.myapplicationgroceries.fragments.MeatFragment
import com.emonics.myapplicationgroceries.fragments.SodaFragment
import com.emonics.myapplicationgroceries.fragments.VegetablesFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager? = null








    //TabIcons
    private val tabIcons = intArrayOf(
        R.drawable.meat,
        R.drawable.fruit,
        R.drawable.veggies,
        R.drawable.soda
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        // Telling activity, using toolbar features
        //setSupportActionBar(toolbar)
        tabLayout = findViewById(R.id.tabs)
        viewPager = findViewById(R.id.viewpager)
        tabLayout?.let {
            it.setupWithViewPager(viewPager) }
//        addTabs(viewPager)
        viewPager?.let { addTabs(it) }
        setupTabIcons()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.btnCart -> {
                true
            }
            R.id.btnUser -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    // Set Icon
    private fun setupTabIcons() {
        tabLayout?.getTabAt(0)?.setIcon(tabIcons[0])
        tabLayout?.getTabAt(1)?.setIcon(tabIcons[1])
        tabLayout?.getTabAt(2)?.setIcon(tabIcons[2])
        tabLayout?.getTabAt(3)?.setIcon(tabIcons[3])
    }

    private fun addTabs(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFrag(MeatFragment(), "MEAT")
        adapter.addFrag(FruitsFragment(), "FRUITS")
        adapter.addFrag(VegetablesFragment(), "VEGETABLES")
        adapter.addFrag(SodaFragment(), "SODA")
        viewPager.adapter = adapter
    }

    internal inner class ViewPagerAdapter(manager: FragmentManager?) : FragmentPagerAdapter(
        manager!!
    ) {
        private val mFragmentList: MutableList<Fragment> = ArrayList()
        private val mFragmentTitleList: MutableList<String> = ArrayList()
        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFrag(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitleList[position]
        }

    }
}