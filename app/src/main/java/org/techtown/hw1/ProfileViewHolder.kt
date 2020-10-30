package org.techtown.hw1

import android.content.Context
import android.content.Intent
import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class ProfileViewHolder (itemView: View, itemClick:(ProfileData)->Unit): RecyclerView.ViewHolder(itemView){
   private val title: TextView=itemView.findViewById(R.id.textView9)
    private var subtitle: TextView=itemView.findViewById(R.id.textView10)


    fun onBind(data: ProfileData,itemClick:(ProfileData)->Unit){
        title.text=data.title
        subtitle.text=data.subtitle
        itemView.setOnClickListener { itemClick(data) }
    }

}