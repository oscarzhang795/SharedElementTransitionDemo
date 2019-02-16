package com.example.sharedelementtransitiondemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_a.*

class FragmentA: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_dummy.adapter = DummyDataAdapter { imageView ->
            val fragment = FragmentB()
            fragment.sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
            fragment.sharedElementReturnTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
//            fragment.enterTransition = TransitionInflater.from(holder.itemView.context).inflateTransition(R.transition.transition_image_enlarge)
//            fragment.sharedElementEnterTransition = TransitionInflater.from(holder.itemView.context).inflateTransition(android.R.transition.slide_bottom)
//            fragment.sharedElementReturnTransition = TransitionInflater.from(holder.itemView.context).inflateTransition(android.R.transition.explode)
            (context as MainActivity).supportFragmentManager
                .beginTransaction()
                .add(R.id.container, fragment, "Tag")
                .addToBackStack("Tag")
                .addSharedElement(imageView, imageView.transitionName)
                .commit()
        }
        rv_dummy.layoutManager = LinearLayoutManager(view.context)
        rv_dummy.setHasFixedSize(true)


//        val fragment = FragmentB()
//        fragment.sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.explode)
//
//        testImageView.setOnClickListener {
//            activity!!.supportFragmentManager
//                .beginTransaction()
//                .addSharedElement(testImageView, testImageView.transitionName)
//                .replace(R.id.container, fragment, "Tag")
//                .addToBackStack("Tag")
//                .commit()
//        }
    }
}