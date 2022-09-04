package com.emonics.myapplicationgroceries.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emonics.myapplicationgroceries.R
import com.emonics.myapplicationgroceries.databinding.FragmentMeatBinding
import com.emonics.myapplicationgroceries.fragments.adapters.CustomAdapter
import com.emonics.myapplicationgroceries.fragments.adapters.MeatData
import com.emonics.myapplicationgroceries.interfaces.mOnclickListener

class MeatFragment : Fragment(), mOnclickListener {

    private var _binding: FragmentMeatBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.

    private val binding get() = _binding!!
    private lateinit var adapter: CustomAdapter

    // This method creates the page given to it
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMeatBinding.inflate(inflater, container, false)

//        // Inflate the layout for this fragment
//        return inflater.inflate(com.emonics.myapplicationgroceries.R.layout.fragment_meat, container, false)

        // set up the RecyclerView
        // set up the RecyclerView
        val recyclerView: RecyclerView = binding.meatRecyclerview
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)
        val dataSet = arrayOf(
        MeatData("Chicken", "chicken_one", R.drawable.turkey),
        MeatData("Chicken 2","chicken_two", R.drawable.turkey),
        MeatData("Chicken 3", "chicken_three", R.drawable.turkey),
        MeatData("Chicken 4", "chicken_four", R.drawable.turkey),
        MeatData("Chicken 5", "chicken_five", R.drawable.turkey))
//        dataSet.("Meat 1")
//        dataSet.add("Meat 2")
//        dataSet.add("Meat 3")
//        dataSet.add("Meat 4")
//        dataSet.add("Meat 5")
//        adapter = CustomAdapter(dataSet as Array<String> )
        adapter = CustomAdapter(dataSet, this)
        recyclerView.adapter = adapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(data: MeatData) {
        // TODO: navigate to product page
        Log.d("Kervens", "meat: ${data.name}")
    }
}






