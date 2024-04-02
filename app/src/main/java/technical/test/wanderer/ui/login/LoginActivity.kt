package technical.test.wanderer.ui.login

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import dagger.hilt.android.AndroidEntryPoint
import technical.test.wanderer.R
import technical.test.wanderer.base.BaseActivity
import technical.test.wanderer.databinding.ActivityLoginBinding
import technical.test.wanderer.model.LoginRegisterRequestBody
import technical.test.wanderer.ui.main.MainActivity
import technical.test.wanderer.ui.register.RegisterActivity

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    companion object {
        @JvmStatic
        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity, LoginActivity::class.java))
        }
    }

    private val viewModel by viewModels<LoginViewModel>()

    override fun getViewBinding(): ActivityLoginBinding =
        ActivityLoginBinding.inflate(layoutInflater)

    override fun setupView() {
        binding.run {
            btnLogin.setOnClickListener {
                val email = tiEditTextEmail.text.toString()
                val password = tiEditTextPassword.text.toString()
                viewModel.login(
                    LoginRegisterRequestBody(email, password)
                )
            }
            btnRegister.setOnClickListener {
                RegisterActivity.startActivity(this@LoginActivity)
                finish()
            }
        }
    }

    override fun subscribeToLiveData() {
        viewModel.getIsLoading().observe(this) {
            binding.tvLogin.isVisible = !it
            binding.pbLogin.isVisible = it
        }

        viewModel.loginLiveData().observe(this) {
            Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show()
            viewModel.saveToken(it.token)
            MainActivity.startActivity(this)
            finish()
        }

        viewModel.errorLiveData().observe(this) {
            Toast.makeText(this, getString(R.string.login_failed), Toast.LENGTH_SHORT).show()
        }
    }
}