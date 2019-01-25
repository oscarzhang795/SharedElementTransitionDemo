package com.example.sharedelementtransitiondemo

import android.support.v7.widget.RecyclerView
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView

class DummyDataAdapter : RecyclerView.Adapter<DummyDataAdapter.MyViewHolder>() {

    class MyViewHolder(var imageView: ImageView) : RecyclerView.ViewHolder(imageView)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val imageView = LayoutInflater.from(p0.context).inflate(R.layout.cardview_dummydata, p0, false) as ImageView
        return MyViewHolder(imageView)
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: MyViewHolder, p1: Int) {
        holder.imageView.setOnClickListener {
            val fragment = FragmentB()
            fragment.sharedElementEnterTransition = TransitionInflater.from(holder.itemView.context).inflateTransition(R.transition.transition_image_enlarge)
            fragment.enterTransition = TransitionInflater.from(holder.itemView.context).inflateTransition(R.transition.transition_image_enlarge)
//            fragment.sharedElementEnterTransition = TransitionInflater.from(holder.itemView.context).inflateTransition(android.R.transition.slide_bottom)
//            fragment.sharedElementReturnTransition = TransitionInflater.from(holder.itemView.context).inflateTransition(android.R.transition.explode)
            (holder.itemView.context as MainActivity).supportFragmentManager
                    .beginTransaction()
                    .addSharedElement(holder.imageView, holder.imageView.transitionName)
                    .replace(R.id.container, fragment, "Tag")
                    .addToBackStack("Tag")
                    .commit()
        }
    }

}
