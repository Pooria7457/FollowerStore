package com.ebrahimipooria.followerstore.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ebrahimipooria.followerstore.R
import com.ebrahimipooria.followerstore.models.ServicesModel

class ServicesAdapter(var context: Context, data: ArrayList<ServicesModel>) :
    RecyclerView.Adapter<ServicesAdapter.MyViewHolder>() {
    var data: List<ServicesModel>

    init {
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_services, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.btnServices.setText(data[position].name)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MyViewHolder(itemView: View) : ViewHolder(itemView),
        View.OnClickListener {

        var btnServices : Button

        init {

            btnServices = itemView.findViewById(R.id.btn_itemServices)

            itemView.setOnClickListener(this)

        }

        override fun onClick(view: View) {

        }
    }
}