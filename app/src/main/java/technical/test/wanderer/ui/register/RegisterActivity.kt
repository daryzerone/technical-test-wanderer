package technical.test.wanderer.ui.register

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import dagger.hilt.android.AndroidEntryPoint
import technical.test.wanderer.R
import technical.test.wanderer.base.BaseActivity
import technical.test.wanderer.databinding.ActivityLoginBinding
import technical.test.wanderer.databinding.ActivityRegisterBinding
import technical.test.wanderer.model.LoginRegisterRequestBody
import technical.test.wanderer.ui.login.LoginActivity
import technical.test.wanderer.ui.main.MainActivity

@AndroidEntryPoint
class RegisterActivity : BaseActivity<ActivityRegisterBinding>() {

    companion object {
        @JvmStatic
        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity, RegisterActivity::class.java))
        }
    }

    private val viewModel by viewModels<RegisterViewModel>()

    override fun getViewBinding(): ActivityRegisterBinding =
        ActivityRegisterBinding.inflate(layoutInflater)

    override fun setupView() {
        binding.run {
            btnRegister.setOnClickListener {
                val email = tiEditTextEmail.text.toString()
                val password = tiEditTextPassword.text.toString()
                viewModel.register(
                    LoginRegisterRequestBody(email, password)
                )
            }
            btnLogin.setOnClickListener {
                LoginActivity.startActivity(this@RegisterActivity)
                finish()
            }
        }
    }

    override fun subscribeToLiveData() {
        viewModel.getIsLoading().observe(this) {
            binding.tvRegister.isVisible = !it
            binding.pbRegister.isVisible = it
        }

        viewModel.registerLiveData().observe(this) {
            Toast.makeText(this, getString(R.string.register_success), Toast.LENGTH_SHORT).show()
            viewModel.saveToken(it.token)
            MainActivity.startActivity(this)
            finish()
        }

        viewModel.errorLiveData().observe(this) {
            Toast.makeText(this, getString(R.string.register_failed), Toast.LENGTH_SHORT).show()
        }
    }
}