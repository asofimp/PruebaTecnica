package adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.application.R
import model.Donut


class AdapterData(private var data: List<Donut>, private val context: Context) : RecyclerView.Adapter<AdapterData.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item_donuts , parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun updateData(newData: List<Donut>) {
        data = newData
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewId: TextView = itemView.findViewById(R.id.textViewId)
        private val textViewType: TextView = itemView.findViewById(R.id.textViewType)
        private val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        private val textViewPpu: TextView = itemView.findViewById(R.id.textViewPpu)
        private val textViewBatters: TextView = itemView.findViewById(R.id.textViewBatters)
        private val textViewTopping: TextView = itemView.findViewById(R.id.textViewTopping)

        fun bind(item: Donut) {
            textViewId.text = item.id
            textViewType.text = item.type
            textViewName.text = item.name
            textViewPpu.text = item.ppu.toString()

            val battersStringBuilder = StringBuilder()
            for (batter in item.batters.batter) {
                battersStringBuilder.append("${batter.id}: ${batter.type}, ")
            }
            textViewBatters.text = battersStringBuilder.toString()

            val toppingsStringBuilder = StringBuilder()
            for (topping in item.topping) {
                toppingsStringBuilder.append("${topping.id}: ${topping.type}, ")
            }
            textViewTopping.text = toppingsStringBuilder.toString()
        }
    }
}
