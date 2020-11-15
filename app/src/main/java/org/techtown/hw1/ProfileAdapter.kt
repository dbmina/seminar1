package org.techtown.hw1

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter(private val context: Context): RecyclerView.Adapter<ProfileViewHolder>(){
    var data= mutableListOf<ProfileData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.activity_data, parent, false)
        return ProfileViewHolder(view)
    }

    override fun getItemCount(): Int=data.size
    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.onBind(data[position])


    }

}