package com.application.coin_ranking.features.home

import android.app.Activity
import android.content.Context
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.annotation.ArrayRes
import com.application.coin_ranking.R

object Spinner : Activity() {
    fun setupSpinner(
        context: Context,
        spinner: Spinner,
        @ArrayRes res: Int,
        onSelected: AdapterView.OnItemSelectedListener
    ) {
        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
            context,
            res,
            R.layout.support_simple_spinner_dropdown_item
        )
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = onSelected
    }
}