package fannana.fahreen.mobileclinic.ui.doctor_list

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import fannana.fahreen.mobileclinic.R
import fannana.fahreen.mobileclinic.databinding.ItemDoctorBinding
import fannana.fahreen.mobileclinic.repo.PrefUtils


class DoctorListAdapter (

    private val doctorList: MutableList<Doctor>,
    private val context : Context,
    private val listener : DoctorListListener,
) : RecyclerView.Adapter<DoctorListAdapter.DoctorListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_doctor, parent, false)
        return DoctorListViewHolder(view)
    }

    interface DoctorListListener{
        fun onDoctorClick(doctor:Doctor, position:Int)
        fun onDoctorAppointmentClick(doctor: Doctor, position :Int)
        abstract fun setRecyclerView(doctorList: MutableList<Doctor>)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: DoctorListViewHolder, position: Int) {

        val doctor = doctorList[position]
        val name  = doctor.name
        val visit = doctor.visit
        val image = doctor.image
        val docDep  = doctor.docDep
        val degree =doctor.degree
        val chamber=doctor.chamber

        val depCode = PrefUtils.init(context).getStringData(PrefUtils.PREF_DEP_CODE)

        Log.e("TAG", "onBindViewHolder: $depCode ", )

        holder.binding.apply {

            if (depCode == docDep) {
                itemDoc.visibility = View.VISIBLE
            } else {
                itemDoc.visibility = View.GONE
            }

            tvDoctorName.text = name
            tvDoctorVisit.text= "Visit: $visit TK"
            ivDoctorImage.let{
                Glide.with(context)
                    .load(image)
                    .apply(RequestOptions.circleCropTransform())
                    .error(R.mipmap.app_logo)
                    .into(it)
            }

            itemDoc.setOnClickListener {
                listener.onDoctorClick(doctor, position)
            }


        }
    }

    override fun getItemCount(): Int {
        return doctorList.size
    }

    inner class DoctorListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemDoctorBinding.bind(itemView)
    }

}