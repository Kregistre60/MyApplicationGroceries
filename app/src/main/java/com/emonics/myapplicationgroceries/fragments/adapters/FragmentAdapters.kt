package com.emonics.myapplicationgroceries.fragments.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.emonics.myapplicationgroceries.fragments.FruitsFragment
import com.emonics.myapplicationgroceries.fragments.MeatFragment
import com.emonics.myapplicationgroceries.fragments.SodaFragment
import com.emonics.myapplicationgroceries.fragments.VegetablesFragment

class MeatAdapter(fragmentManager : FragmentManager,lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MeatFragment()
            1 -> FruitsFragment()
            2 -> VegetablesFragment()
            3 -> SodaFragment()
            else -> {
                MeatFragment()
            }
        }
    }
}

