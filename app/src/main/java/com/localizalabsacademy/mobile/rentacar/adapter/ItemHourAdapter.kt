package com.localizalabsacademy.mobile.rentacar.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.localizalabsacademy.mobile.rentacar.R
import com.localizalabsacademy.mobile.rentacar.model.RentViewModel
import com.localizalabsacademy.mobile.rentacar.ui.SelectHourFragment
import java.util.*

class ItemHourAdapter(
    private val dataSet: List<Date>,
    private val context: Context,
    private val viewModel: RentViewModel,
    private val view: SelectHourFragment,
) :
    RecyclerView.Adapter<ItemHourAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayoutInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_hour, parent, false)
        return ItemViewHolder(adapterLayoutInflater)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataSet[position]
        holder.textView.text = item.toString()
        holder.textView.setOnClickListener {
            viewModel.setHourForPickupOrReturn(position)
            view.pickHour()
        }
    }
    override fun getItemCount(): Int = dataSet.size

}