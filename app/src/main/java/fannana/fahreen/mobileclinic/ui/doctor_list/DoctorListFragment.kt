package fannana.fahreen.mobileclinic.ui.doctor_list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import fannana.fahreen.mobileclinic.R
import fannana.fahreen.mobileclinic.databinding.FragmentDoctorlistBinding
import fannana.fahreen.mobileclinic.repo.PrefUtils
import fannana.fahreen.mobileclinic.ui.doctor_profile.DialogFragmentDoctorProfile
import java.util.*


class DoctorListFragment: Fragment(),  DoctorListAdapter.DoctorListListener {

    private lateinit var binding: FragmentDoctorlistBinding

    private var doctorListClone: MutableList<Doctor> = mutableListOf()

    private var doctorList: MutableList<Doctor> = mutableListOf()

    private var doctorList001: MutableList<Doctor> = mutableListOf()
    private var doctorList002: MutableList<Doctor> = mutableListOf()
    private var doctorList003: MutableList<Doctor> = mutableListOf()
    private var doctorList004: MutableList<Doctor> = mutableListOf()
    private var doctorList005: MutableList<Doctor> = mutableListOf()


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDoctorlistBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val depCode = PrefUtils.init(requireContext()).getStringData(PrefUtils.PREF_DEP_CODE)
        val depName = PrefUtils.init(requireContext()).getStringData(PrefUtils.PREF_DEP_NAME)



        dummyData()


        when (depCode) {
            "D001" -> {
                setRecyclerView(doctorList001)
            }
            "D002" -> {
                setRecyclerView(doctorList002)
            }
            "D003" -> {
                setRecyclerView(doctorList003)
            }
            "D004" -> {
                setRecyclerView(doctorList004)
            }
            "D005" -> {
                setRecyclerView(doctorList005)
            }
        }

        setRecyclerView(doctorList)

        binding.apply {
            btnBack.setOnClickListener {
                findNavController().navigateUp()
            }

            tvFragmentTitle.text = "$depName Department"

            svDoc.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
                android.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    searchProduct(query)
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    searchProduct(newText)
                    return false
                }
            })
            btnDepartments.setOnClickListener {
                findNavController().navigate(R.id.nav_department)
            }
            btnHome.setOnClickListener {
                findNavController().navigate(R.id.nav_home)
            }

        }

        return root
    }

    //Adding dummy data into list
    private fun dummyData() {

        doctorList.add(Doctor("Dr. Abbas", "D001",50.0, R.mipmap.img_doctor,"MBBS","City Hospital"))
        doctorList.add(Doctor("Dr. Akash", "D001",30.0, R.mipmap.img_doctor,"MBBS,BCS","City Hospital"))
        doctorList.add(Doctor("Dr. Mizan", "D001",40.0, R.mipmap.img_doctor,"MBBS","City Hospital"))
        doctorList.add(Doctor("Dr. Sharif", "D001",80.0, R.mipmap.img_doctor,"MBBS,ApCPS","City Hospital"))
        doctorList.add(Doctor("Dr. Tamanna", "D001",30.0, R.mipmap.img_doctor,"MBBS","City Hospital"))
        doctorList.add(Doctor("Dr. Masud", "D001",70.0, R.mipmap.img_doctor,"MBBS","City Hospital"))
        doctorList.add(Doctor("Dr. Abid", "D001",150.0, R.mipmap.img_doctor,"MBBS","City Hospital"))
        doctorList.add(Doctor("Dr. Farid", "D002",50.0, R.mipmap.img_doctor,"MBBS,ApCPS","City Hospital"))
        doctorList.add(Doctor("Dr. Akash", "D002",29.0, R.mipmap.img_doctor,"MBBS","City Hospital"))
        doctorList.add(Doctor("Dr .Asif", "D002",125.0, R.mipmap.img_doctor,"MBBS","City Hospital"))
        doctorList.add(Doctor("Dr. Rafat", "D002",325.0, R.mipmap.img_doctor,"MBBS","City Hospital"))
        doctorList.add(Doctor("Dr. Mizan", "D002",25.0, R.mipmap.img_doctor,"MBBS","City Hospital"))
        doctorList.add(Doctor("Dr. Nafisha", "D002",25.0, R.mipmap.img_doctor,"MBBS","City Hospital"))
        doctorList.add(Doctor("Dr. Anis", "D003",25.0, R.mipmap.img_doctor,"MBBS","City Hospital"))
        doctorList.add(Doctor("Dr. Zayra", "D003",25.0, R.mipmap.img_doctor,"MBBS","City Hospital"))
        doctorList.add(Doctor("Dr. Tamanna", "D003",25.0, R.mipmap.img_doctor,"MBBS","City Hospital"))
        doctorList.add(Doctor("Dr. Tamjeed", "D003",25.0, R.mipmap.img_doctor,"MBBS","City Hospital"))
        doctorList.add(Doctor("Dr. Sharif", "D003",25.0, R.mipmap.img_doctor,"MBBS","City Hospital"))




    }

    private fun searchProduct(query: String?) {
        val query1 = query?.lowercase(Locale.getDefault())
        doctorListClone.clear()

        for (j in doctorList){
            val fName = j.name.lowercase(Locale.getDefault())

            if (query1?.let { fName.contains(it) } == true){
                doctorListClone.add(j)
            }
        }
        setRecyclerView(doctorListClone)
    }

    override fun onDoctorClick(doctor: Doctor, position: Int) {
        val dialog = DialogFragmentDoctorProfile()
        dialog.init(doctor)
        dialog.show(parentFragmentManager, "")
    }

    override fun onDoctorAppointmentClick(doctor: Doctor, position: Int) {
        //
    }

    override fun setRecyclerView(doctorList: MutableList<Doctor>) {
        val activity = activity
        if (activity != null) {
            val adapter = DoctorListAdapter(doctorList, activity, this)
            binding.rvDoctorList.layoutManager = LinearLayoutManager(requireActivity())
            binding.rvDoctorList.isNestedScrollingEnabled = false
            binding.rvDoctorList.adapter = adapter
        }
    }


}

