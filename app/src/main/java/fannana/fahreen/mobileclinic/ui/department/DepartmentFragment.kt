package fannana.fahreen.mobileclinic.ui.department

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import fannana.fahreen.mobileclinic.R
import fannana.fahreen.mobileclinic.databinding.FragmentDepartmentBinding
import fannana.fahreen.mobileclinic.repo.PrefUtils
import fannana.fahreen.mobileclinic.ui.doctor_list.Doctor


import java.util.*


class DepartmentFragment: Fragment() {

    private lateinit var binding: FragmentDepartmentBinding


    private var doctorList: MutableList<Doctor> = mutableListOf()




    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDepartmentBinding.inflate(inflater, container, false)
        val root: View = binding.root


        binding.apply {
            btnBack.setOnClickListener {
                findNavController().navigateUp()
            }
            btnGeneralMed.setOnClickListener {
                PrefUtils.init(requireActivity()).saveStringData(PrefUtils.PREF_DEP_NAME, "General Medicine")
                PrefUtils.init(requireActivity()).saveStringData(PrefUtils.PREF_DEP_CODE, "D000")
                findNavController().navigate(R.id.nav_doctor_list)
            }
            btnCardiology.setOnClickListener {
                PrefUtils.init(requireActivity()).saveStringData(PrefUtils.PREF_DEP_NAME, "Cardiology")
                PrefUtils.init(requireActivity()).saveStringData(PrefUtils.PREF_DEP_CODE, "D001")
                findNavController().navigate(R.id.nav_doctor_list)
            }
            btnGynecology.setOnClickListener {
                PrefUtils.init(requireActivity()).saveStringData(PrefUtils.PREF_DEP_NAME, "Gynecology")
                PrefUtils.init(requireActivity()).saveStringData(PrefUtils.PREF_DEP_CODE, "D003")
                findNavController().navigate(R.id.nav_doctor_list)
            }

            btnNephrology.setOnClickListener {
                PrefUtils.init(requireActivity()).saveStringData(PrefUtils.PREF_DEP_NAME, "Nephrology")
                PrefUtils.init(requireActivity()).saveStringData(PrefUtils.PREF_DEP_CODE, "D002")
                findNavController().navigate(R.id.nav_doctor_list)
            }
            btnOrthopedic.setOnClickListener {
                PrefUtils.init(requireActivity()).saveStringData(PrefUtils.PREF_DEP_NAME, "O go")
                PrefUtils.init(requireActivity()).saveStringData(PrefUtils.PREF_DEP_CODE, "D004")
                findNavController().navigate(R.id.nav_doctor_list)
            }
            btnRheumatology.setOnClickListener {
                PrefUtils.init(requireActivity()).saveStringData(PrefUtils.PREF_DEP_NAME, "y")
                PrefUtils.init(requireActivity()).saveStringData(PrefUtils.PREF_DEP_CODE, "D005")
                findNavController().navigate(R.id.nav_doctor_list)
            }
            btnDepartments.setOnClickListener {
                findNavController().navigate(R.id.nav_department)
            }
            btnHome.setOnClickListener {
                findNavController().navigate(R.id.nav_home)
            }

        }

        return root
    }





}