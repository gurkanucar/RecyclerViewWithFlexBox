package com.gucarsoft.recyclerviewwithflexbox

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RCViewAdapter(
    var arrayList: ArrayList<RcViewItemModel>,
    val itemClickListener: ItemClickListener
) :
    RecyclerView.Adapter<RCViewAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val content: TextView

        init {
            title = view.findViewById(R.id.title)
            content = view.findViewById(R.id.content)
            itemView.setOnClickListener {
                itemClickListener.onItemClick(adapterPosition)
            }
            view.setOnLongClickListener {
                itemClickListener.onLongClick(adapterPosition)
                return@setOnLongClickListener true
            }
        }
        fun bindItems(item: RcViewItemModel) {
            title.text = item.title
            content.text = item.content

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.rc_view_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindItems(arrayList.get(position))
    }

    override fun getItemCount() = arrayList.size

}
