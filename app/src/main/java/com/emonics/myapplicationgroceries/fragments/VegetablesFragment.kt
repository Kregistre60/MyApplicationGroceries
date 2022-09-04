package com.emonics.myapplicationgroceries.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emonics.myapplicationgroceries.R
import com.emonics.myapplicationgroceries.databinding.FragmentVegetablesBinding
import com.emonics.myapplicationgroceries.fragments.adapters.CustomAdapter
import com.emonics.myapplicationgroceries.fragments.adapters.MeatData
import com.emonics.myapplicationgroceries.interfaces.mOnclickListener

class VegetablesFragment : Fragment(), mOnclickListener {

    private var _binding: FragmentVegetablesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.

    private val binding get() = _binding!!
    private lateinit var adapter: CustomAdapter

    // This method creates the page given to it
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentVegetablesBinding.inflate(inflater, container, false)

//        // Inflate the layout for this fragment
//        return inflater.inflate(com.emonics.myapplicationgroceries.R.layout.fragment_meat, container, false)

        // set up the RecyclerView
        // set up the RecyclerView
        val recyclerView: RecyclerView = binding.vegetablesRecyclerview
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val dataSet = arrayOf(MeatData("Chicken", "chic", R.drawable.turkey),
            MeatData("Chicken 2", "chic", R.drawable.turkey),
            MeatData("Chicken 3", "chic", R.drawable.turkey),
            MeatData("Chicken 4", "chic", R.drawable.turkey),
            MeatData("Chicken 5", "chic", R.drawable.turkey))

//        dataSet.add("Meat 1")
//        dataSet.add("Meat 2")
//        dataSet.add("Meat 3")
//        dataSet.add("Meat 4")
//        dataSet.add("Meat 5")
//        adapter = CustomAdapter(dataSet as Array<String> )
        adapter = CustomAdapter(dataSet,this)
        recyclerView.adapter = adapter

        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
////        binding.buttonFirst.setOnClickListener {
////            findNavController().navigate(com.emonics.myapplicationgroceries.R.id.action_FirstFragment_to_SecondFragment)
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(data: MeatData) {
        // TODO: navigate to product page
        Log.d("Kervens", "vegetables: ${data.name}")
    }
}

