package com.gucarsoft.recyclerviewwithflexbox

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayout
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent


class MainActivity : AppCompatActivity(), ItemClickListener {

    private var rcViewAdapter: RCViewAdapter? = null
    private lateinit var arrayList: ArrayList<RcViewItemModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = FlexboxLayoutManager(this, FlexDirection.ROW)
        manager.justifyContent = JustifyContent.CENTER

        arrayList = setButtonList()
        rcViewAdapter = RCViewAdapter(arrayList, this)

        val recycler = findViewById<View>(R.id.recyclerView) as RecyclerView
        recycler.layoutManager = manager
        recycler.adapter = rcViewAdapter

    }


    private fun setButtonList(): ArrayList<RcViewItemModel> {
        val arrayList: ArrayList<RcViewItemModel> = ArrayList()
        arrayList.add(RcViewItemModel("item1", "1 content"))
        arrayList.add(RcViewItemModel("item2", "2 content"))
        arrayList.add(RcViewItemModel("item3", "3 content"))
        arrayList.add(RcViewItemModel("item4", "4 content"))
        arrayList.add(RcViewItemModel("item5", "5 content"))
        arrayList.add(RcViewItemModel("item6", "6 content"))
        arrayList.add(RcViewItemModel("item7", "7 content"))
        return arrayList
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this@MainActivity, "Short Click: " + arrayList.get(position).title, Toast.LENGTH_SHORT)
            .show()
    }

    override fun onLongClick(position: Int) {
        Toast.makeText(this@MainActivity, "Long Click: " + arrayList.get(position).title, Toast.LENGTH_SHORT)
            .show()
    }


}