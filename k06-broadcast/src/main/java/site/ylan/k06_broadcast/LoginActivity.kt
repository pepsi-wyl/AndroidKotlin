package site.ylan.k06_broadcast

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import site.ylan.k06_broadcast.base.BaseActivity
import site.ylan.k06_broadcast.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    override fun onCreated(savedInstanceState: Bundle?) {

        val account = binding.accountEdit
        val password = binding.passwordEdit
        val login = binding.login

        login.setOnClickListener {
            if ("admin" == account.text.toString() && "123456" == password.text.toString()) {
                val intent = Intent(this, ForceOfflineActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "account or password is invalid", Toast.LENGTH_SHORT).show()
            }
        }
    }
}