package uas2019.develops.stud11417025.testing_jetpack

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by test on 5/18/2020.
 */
class MainAdapter (private val contex:Context,private val datas : MutableList<DataModel>): RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        Picasso.with(contex).load(datas[position].thumbnail).into(holder!!.image)
        holder.image!!.setOnClickListener{
            val intent = Intent(contex, Detail_Data::class.java)
            intent.putExtra("caption",datas[position].caption)
            intent.putExtra("image",datas[position].image)
            contex.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) : DataViewHolder{
        var  itemView = LayoutInflater.from(contex).inflate(R.layout.image_item, parent, false)
        return DataViewHolder(itemView)
    }

    class DataViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        var image:ImageView?=null
        init {
            image = itemView.findViewById(R.id.image)
        }
    }

    fun addData(list:List<DataModel>){
        datas.addAll(list)
    }
}