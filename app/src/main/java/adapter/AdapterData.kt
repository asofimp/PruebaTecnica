import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import model.data
import com.application.R

class AdapterData(private val data: List<data>, private val context: Context) : RecyclerView.Adapter<AdapterData.ViewHolder>() {

    private lateinit var datos: List<data>
    private lateinit var contextDat: Context

    fun init(datos:List<data>, contextDat: Context){
        this.datos = datos
        this.contextDat=contextDat

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate( R.layout.activity_main, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewId: TextView = itemView.findViewById(R.id.rV_Data)
        private val textViewType: TextView = itemView.findViewById(R.id.rV_Data)
        private val textViewName: TextView = itemView.findViewById(R.id.rV_Data)
        private val textViewPpu: TextView = itemView.findViewById(R.id.rV_Data)
        private val textViewBatters: TextView = itemView.findViewById(R.id.rV_Data)
        private val textViewTopping: TextView = itemView.findViewById(R.id.rV_Data)

        fun bind(item: data) {
            textViewId.text = item.getId().toString()
            textViewType.text = item.getType()
            textViewName.text = item.getName()
            textViewPpu.text = item.getPpu()
            textViewBatters.text = item.getBatters()
            textViewTopping.text = item.getTopping()
        }
    }
}
