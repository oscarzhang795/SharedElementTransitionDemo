package com.example.sharedelementtransitiondemo

import android.support.v7.widget.RecyclerView
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView

class DummyDataAdapter(var onClick: (ImageView) -> Unit) : RecyclerView.Adapter<DummyDataAdapter.MyViewHolder>() {

    class MyViewHolder(var imageView: ImageView) : RecyclerView.ViewHolder(imageView)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val imageView = LayoutInflater.from(p0.context).inflate(R.layout.cardview_dummydata, p0, false) as ImageView
        return MyViewHolder(imageView)
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: MyViewHolder, p1: Int) {
        holder.imageView.transitionName = "image_scale $p1"
        holder.imageView.setOnClickListener {
            onClick(holder.imageView)
        }
    }

}
