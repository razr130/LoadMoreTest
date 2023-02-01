package com.example.loadmoretest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.loadmoretest.databinding.FragmentItemListBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.gson.Gson


class ItemListBottomFragment : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentItemListBottomBinding.inflate(layoutInflater)

        binding.RecyclerBottom.layoutManager = GridLayoutManager(requireActivity(), 3)
        val data = arguments?.getString("listItem")
        val gson = Gson()
        val listItem = gson.fromJson(data, Array<Item>::class.java).toList()

        binding.RecyclerBottom.adapter = RecyclerBottomAdapter(listItem, RecyclerBottomAdapter.OnClickListener{

        })

        return binding.root
    }


}