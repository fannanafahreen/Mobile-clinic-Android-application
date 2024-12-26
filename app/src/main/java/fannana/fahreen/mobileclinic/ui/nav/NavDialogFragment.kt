package fannana.fahreen.mobileclinic.ui.nav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import fannana.fahreen.mobileclinic.R
import fannana.fahreen.mobileclinic.databinding.NavDialogFragmentBinding


class NavDialogFragment() : DialogFragment() {

    private var _binding: NavDialogFragmentBinding? = null


    private val binding get() = _binding!!

   /* override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = NavDialogFragmentBinding.inflate(inflater, container, false)

        /*_binding?.btnClose?.setOnClickListener {
            dialog?.dismiss()
        }*/



        _binding?.apply {
            //emptySpace.setBackgroundColor(resources.getColor(android.R.color.transparent))
            btnHome.setOnClickListener {
                //
                findNavController().navigate(R.id.nav_home)
            }
            btnDepartments.setOnClickListener {
                //
                findNavController().navigate(R.id.nav_gallery)

            }
        }



        return binding.root
    }

}