package fannana.fahreen.mobileclinic.activity.log_in

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fannana.fahreen.mobileclinic.activity.main.MainActivity
import fannana.fahreen.mobileclinic.activity.sign_up.SignUpActivity
import fannana.fahreen.mobileclinic.databinding.LogInBinding

class LogInActivity : AppCompatActivity() {

    private lateinit var binding: LogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.etUserName.text.toString()
            val pass = binding.etPassword.text.toString()


            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

       binding.tvCreateAccount.setOnClickListener {
           val intent = Intent(this, SignUpActivity::class.java)
           startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()

    }
}