package technical.test.wanderer.ui.main

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import technical.test.wanderer.adapter.UserAdapter
import technical.test.wanderer.base.BaseActivity
import technical.test.wanderer.databinding.ActivityMainBinding
import technical.test.wanderer.helper.EndlessRecyclerViewScrollListener

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    companion object {
        @JvmStatic
        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity, MainActivity::class.java))
        }
    }

    private val userAdapter = UserAdapter()
    private val viewModel by viewModels<MainViewModel>()

    private var page = 1
    private var totalPage = 0

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun setupView() {
        binding.run {
            rvListUser.adapter = userAdapter
            val linearLayoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            rvListUser.layoutManager = linearLayoutManager
            rvListUser.addOnScrollListener(object :
                EndlessRecyclerViewScrollListener(linearLayoutManager) {
                override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                    if (page <= totalPage) {
                        this@MainActivity.page = page
                        viewModel.getUserList(this@MainActivity.page)
                    }
                }

            })
        }
        viewModel.getUserList(page)
    }

    override fun subscribeToLiveData() {
        viewModel.getIsLoading().observe(this) {
            binding.progressBar.isVisible = page == 1 && it
        }
        viewModel.userListLiveData().observe(this) {
            totalPage = it.totalPage
            userAdapter.addUserList(it.data)
        }

        viewModel.errorLiveData().observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onBackPressed() {
        viewModel.clearSessionData()
        super.onBackPressed()
    }
}