package com.kizitonwose.calendarsample.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kizitonwose.calendarsample.R
import com.kizitonwose.calendarsample.databinding.CalendarViewActivityBinding

class CalendarViewActivity : AppCompatActivity() {

    internal lateinit var binding: CalendarViewActivityBinding

    private val examplesAdapter = CalendarViewOptionsAdapter {
        val fragment = it.createView()
        val anim = it.animation
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(anim.enter, anim.exit, anim.popEnter, anim.popExit)
            .add(R.id.homeContainer, fragment, fragment.javaClass.simpleName)
            .addToBackStack(fragment.javaClass.simpleName)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CalendarViewActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.activityToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.examplesRv.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = examplesAdapter
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
        }
    }
}