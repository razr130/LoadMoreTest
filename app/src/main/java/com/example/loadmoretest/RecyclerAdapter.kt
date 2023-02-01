package com.example.loadmoretest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val items: List<Item>, val onClickLitener: OnClickListener) :
    RecyclerView.Adapter<RecyclerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder {
        return RecyclerHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        holder.bindApp(items[position])
        holder.itemView.setOnClickListener {
            onClickLitener.onClick(items[position])
        }
    }

    override fun getItemCount(): Int = items.size

    class OnClickListener(val clickListener: (item: Item) -> Unit) {
        fun onClick(item: Item) = clickListener(item)
    }
}

class RecyclerHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val imgApp = view.findViewById<ImageView>(R.id.ImgMenuIcon)
    private val nameApp = view.findViewById<TextView>(R.id.TxtNamaMenu)

    fun bindApp(item: Item) {
        imgApp.setImageResource(item.img)
        nameApp.text = item.name
    }
}