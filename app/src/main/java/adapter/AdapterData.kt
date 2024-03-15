package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.application.R
import model.Donut



class AdapterData(private val data: List<Donut> ): RecyclerView.Adapter<AdapterData.ViewHolder>(){

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val id : TextView
        val name : TextView
        val ppu : TextView
        val type : TextView
         init {
             id = view.findViewById(R.id.tv_id)
             name = view.findViewById(R.id.tv_nombre)
             ppu = view.findViewById(R.id.tv_ppu)
             type = view.findViewById(R.id.tv_tipo)
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item_donuts, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val donut = data[position]
        holder.name.text = donut.name
        holder.id.text = donut.id
        holder.type.text = donut.type
        holder.ppu.text = donut.ppu.toString()
    }


}