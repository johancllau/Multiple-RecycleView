package com.example.recyclerviewmultipleview.adapter

import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewmultipleview.R
import com.example.recyclerviewmultipleview.model.DataDay
import com.example.recyclerviewmultipleview.model.DataJadwal
import kotlinx.android.synthetic.main.item_day.view.*
import kotlinx.android.synthetic.main.item_jadwal.view.*
import java.lang.IllegalArgumentException
class JadwalAdapter(private val listItem: List<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val ITEM_DAY = 0
        private const val ITEM_JADWAL = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_DAY -> ViewHolderDay(LayoutInflater.from(parent.context).inflate(
                R.layout.item_day, parent, false))
            ITEM_JADWAL -> ViewHolderJadwal(LayoutInflater.from(parent.context).inflate(
                R.layout.item_jadwal, parent, false))
            else -> throw IllegalArgumentException("undefined view type")
        }
    }

    override fun getItemCount(): Int = listItem.size

    override fun getItemViewType(position: Int): Int {
        return when (listItem[position]) {
            is DataDay -> ITEM_DAY
            is DataJadwal -> ITEM_JADWAL
            else -> throw IllegalArgumentException("undefined view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            ITEM_DAY -> {
                val itemHolderDay = holder as ViewHolderDay
                itemHolderDay.bind(listItem[position] as DataDay)
            }
            ITEM_JADWAL -> {
                val itemHolderJadwal = holder as ViewHolderJadwal
                itemHolderJadwal.bind(listItem[position] as DataJadwal)
            }
            else -> throw IllegalArgumentException("undefined view type")
        }
    }

    inner class ViewHolderDay(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: DataDay){
            with(itemView) {
                txtDay.text = item.day
            }
        }

    }
    inner class ViewHolderJadwal(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: DataJadwal) {
            with(itemView) {
                txtNameMtk.text = item.nameMtk
                txtTime.text = item.timeMtk
            }
        }

    }
}