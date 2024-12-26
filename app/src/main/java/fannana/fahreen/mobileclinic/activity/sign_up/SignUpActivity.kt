package fannana.fahreen.mobileclinic.activity.sign_up

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import fannana.fahreen.mobileclinic.databinding.SignUpBinding


class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: SignUpBinding
    //private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            val name = binding.etUserName.text.toString()
            val phone = binding.etUserPhone.text.toString()
            val address = binding.etUserAddress.text.toString()

            val email = binding.etUserMail.text.toString()
            val pass = binding.etPassword.text.toString()
            val confirmPass = binding.etPasswordConfirm.text.toString()

//            val dialog = DialogFragmentOrder()
//            dialog.show(supportFragmentManager, "")


        }
    }
}