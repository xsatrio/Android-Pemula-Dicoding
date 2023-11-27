package com.xsat.hitoribocchi

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListCharAdapter(private val listChar: List<Char>) : RecyclerView.Adapter<ListCharAdapter.ListViewHolder>() {
    private var lastClickTime: Long = 0
    private val clickDelay = 1000

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_char, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listChar.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, gender, age, photo) = listChar[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            val clickTime = System.currentTimeMillis()

            if (clickTime - lastClickTime > clickDelay) {
                lastClickTime = clickTime

                val intentDetail = Intent(holder.itemView.context, DetailCharActivity::class.java)
                intentDetail.putExtra("key_char", listChar[position])
                holder.itemView.context.startActivity(intentDetail)
            }
        }
    }
}