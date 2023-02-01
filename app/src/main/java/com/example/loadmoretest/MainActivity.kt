package com.example.loadmoretest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loadmoretest.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    val listItem = listOf(
        Item(1, "Monday", R.drawable.engineer),
        Item(2, "Tuesday", R.drawable.engineer),
        Item(3, "Wednesday", R.drawable.engineer),
        Item(4, "Thursday", R.drawable.engineer),
        Item(5, "Friday", R.drawable.engineer),
        Item(6, "Saturday", R.drawable.engineer),
        Item(7, "Sunday", R.drawable.engineer),
        Item(8, "UnknownDay", R.drawable.engineer),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newList: ArrayList<Item> = arrayListOf()

        for (i in 0..2) {
            newList.add(listItem[i])
        }
        newList.add(Item(9, "Lainnya", R.drawable.other, true))

        val gson = Gson()
        val listString = gson.toJson(listItem)

        val bottomList = ItemListBottomFragment()
        val bundle = Bundle()
        bundle.putString("listItem", listString)
        bottomList.arguments = bundle

        binding.RecyclerMain.adapter = RecyclerAdapter(newList, RecyclerAdapter.OnClickListener {
            if(it.lainnya) {
                bottomList.show(supportFragmentManager, "itemList")
            }
        })
    }
}