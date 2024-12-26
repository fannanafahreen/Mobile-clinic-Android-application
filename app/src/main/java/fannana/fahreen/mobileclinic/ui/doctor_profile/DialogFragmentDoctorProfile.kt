package fannana.fahreen.mobileclinic.ui.doctor_profile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import fannana.fahreen.mobileclinic.R
import fannana.fahreen.mobileclinic.databinding.DialogFragmentDoctorProfileBinding
import fannana.fahreen.mobileclinic.ui.doctor_list.Doctor
//import fannana.fahreen.mobileclinicpatient.R
//import fannana.fahreen.mobileclinicpatient.databinding.DialogFragmentDoctorProfileBinding
//import fannana.fahreen.mobileclinicpatient.ui.doctor_list.Doctor

class DialogFragmentDoctorProfile : DialogFragment() {

    private lateinit var binding: DialogFragmentDoctorProfileBinding


    private var doctor : Doctor? = null


    var subPrice = 0.0f

    fun init(selectedProduct: Doctor){
        this.doctor = selectedProduct
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialog)
    }


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = DialogFragmentDoctorProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val dName = doctor?.name
        val dVisit = doctor?.visit ?: 0.0f
        val dImage = doctor?.image
     //   val dDegree = doctor?.degree
    //    val dChamber = doctor?.chamber

        binding.apply {
            btnClose.setOnClickListener {
                dialog?.dismiss()
            }

            ivDoctorPhoto.let {
                Glide.with(requireContext())
                    .load(dImage)
//                    .apply(RequestOptions.fitCenterTransform())
                    .apply(RequestOptions.circleCropTransform())
                    .error(R.mipmap.app_logo)
                    .into(it)
            }

            tvDoctorName.text = dName
            tvDoctorsVisit.text = "Visit : $dVisit TK"
          //  tvDoctorsDegree.text = dDegree
          //  tvDoctorsChamber.text = dChamber



            return root
        }

    }

}