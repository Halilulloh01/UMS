package com.example.ums.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.ums.Models.listClass
import com.example.ums.R
import kotlinx.android.synthetic.main.rv_item.view.*

class MyAdapter(var contet: Context, var myInterFace: MyInterFace, private val list:List<listClass>): RecyclerView.Adapter<MyAdapter.Vh>() {
    inner class Vh(var itemRv: View) : RecyclerView.ViewHolder(itemRv) {
        fun onBind(user: listClass) {
            itemRv.imageTarif.text = user.name
            itemRv.codeTarif.text = user.code
            itemRv.aboutTarif.text = user.description
            itemRv.startAnimation(AnimationUtils.loadAnimation(contet,R.anim.enter_from_left))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
        holder.itemRv.backGround.setOnClickListener {
            myInterFace.clicking(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    interface MyInterFace{
        fun clicking(pos:Int)
    }
}