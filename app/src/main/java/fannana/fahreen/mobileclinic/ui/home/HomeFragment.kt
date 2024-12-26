package fannana.fahreen.mobileclinic.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import fannana.fahreen.mobileclinic.R
import fannana.fahreen.mobileclinic.databinding.FragmentHomeBinding
import fannana.fahreen.mobileclinic.repo.PrefUtils
import fannana.fahreen.mobileclinic.ui.department.Department
import fannana.fahreen.mobileclinic.ui.department.DepartmentListAdapter
import fannana.fahreen.mobileclinic.ui.nav.NavDialogFragment

class HomeFragment : Fragment(), DepartmentListAdapter.DepartmentListener {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private var departmentList: MutableList<Department> = mutableListOf()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        binding.apply {

            btnDrawer.setOnClickListener {
                val dialog = NavDialogFragment()
                dialog.show(parentFragmentManager, "")
            }

            btnSeeMore.setOnClickListener {
                findNavController().navigate(R.id.nav_department)
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


            val name  = "Fannana Fahreen Aanan"
            val address  = "Bashundhara R/A, Dhaka 1212"

            //TopAppBar
            ivUserPhoto.let {
                Glide.with(requireActivity())
                    .load(R.mipmap.img_fanna)
                    .apply(RequestOptions.circleCropTransform())
                    .error(R.mipmap.ic_menu)
                    .into(it)
            }

            tvUserName.text = name
            tvUserAddress.text = address

            btnDepartments.setOnClickListener {
                findNavController().navigate(R.id.nav_department)
            }

            llSuggestions.setOnClickListener {
                findNavController().navigate(R.id.nav_gallery)
            }
        }

        dummyData()
        setRecyclerView(departmentList)

        return root
    }

    private fun dummyData() {
        departmentList.add(Department("Cardiology", "D001",  R.mipmap.ic_heart))
        departmentList.add(Department("Nephrology","D002",     R.mipmap.ic_nephrology))
        departmentList.add(Department("Gynecology","D003",     R.mipmap.ic_gyne))
        departmentList.add(Department("Orthopedic", "D004",    R.mipmap.ic_joint))
        departmentList.add(Department("Rheumatology","D005",   R.mipmap.ic_medicine))

    }

    //calling Department Adapter
    private fun setRecyclerView(departmentList: MutableList<Department>) {
        val activity = activity
        if(activity != null){
            val adapter = DepartmentListAdapter(departmentList,requireActivity(), this)
            binding.rvDepartments.layoutManager = LinearLayoutManager(requireActivity() ,LinearLayoutManager.HORIZONTAL ,false)
            binding.rvDepartments.isNestedScrollingEnabled = false
            binding.rvDepartments.adapter = adapter }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onDepartmentClick(dep: Department, pos: Int) {
        context?.let { PrefUtils.init(it).saveStringData(PrefUtils.PREF_DEP_CODE, dep.depCode) }
        context?.let { PrefUtils.init(it).saveStringData(PrefUtils.PREF_DEP_NAME, dep.depName) }
        findNavController().navigate(R.id.nav_doctor_list)
    }

}