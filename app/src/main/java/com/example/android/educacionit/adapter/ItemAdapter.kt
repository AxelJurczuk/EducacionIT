package com.example.android.educacionit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.educacionit.R
import com.example.android.educacionit.model.User

class ItemAdapter (private val context: Context, private val clickListener:OnItemClick)
    : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    var usersList: List<User> = emptyList()

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.tv_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = usersList[position]
        holder.name.text = item.name

        //click action
        holder.itemView.setOnClickListener {
            clickListener.onItemClickListener(position)
        }

    }

    override fun getItemCount()= usersList.size

    interface OnItemClick {
        fun onItemClickListener (position: Int)
    }
}

