package fannana.fahreen.mobileclinic.ui.department

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fannana.fahreen.mobileclinic.R
import fannana.fahreen.mobileclinic.databinding.ItemDepartmentCardBinding


class DepartmentListAdapter(
    private val departmentList: MutableList<Department>,
    private val context : Context,
    private val listener: DepartmentListener,
) : RecyclerView.Adapter<DepartmentListAdapter.HomeUpComViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeUpComViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_department_card, parent, false)
        return HomeUpComViewHolder(view)
    }
    interface DepartmentListener{
        fun onDepartmentClick(dep: Department, pos :Int)

    }


    override fun onBindViewHolder(holder: HomeUpComViewHolder, position: Int) {

        val department = departmentList[position]

        val title = department.depName
        val image = department.imageResId

        holder.binding.apply {
            tvDepName.text = title
            ivCardImage.let{
                Glide.with(context)
                    .load(image)
                    .into(it)
            }
            itemDepartment.setOnClickListener {
                listener.onDepartmentClick(department, position)
            }
        }



    }

    override fun getItemCount(): Int {
        return departmentList.size
    }

    inner class HomeUpComViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemDepartmentCardBinding.bind(itemView)
    }



    inner class FlowerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemDepartmentCardBinding.bind(itemView)
    }

}