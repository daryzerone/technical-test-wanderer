package technical.test.wanderer.ui.splash

import android.os.Handler
import android.os.Looper
import technical.test.wanderer.base.BaseActivity
import technical.test.wanderer.databinding.ActivitySplashBinding
import technical.test.wanderer.ui.login.LoginActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    companion object {
        private const val DELAY_IN_MILLIS = 2000L
    }

    override fun getViewBinding(): ActivitySplashBinding =
        ActivitySplashBinding.inflate(layoutInflater)

    override fun setupView() {
        Handler(Looper.getMainLooper()).postDelayed({
            LoginActivity.startActivity(this)
            finish()
        }, DELAY_IN_MILLIS)
    }
}