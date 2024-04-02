package technical.test.wanderer.helper

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

abstract class EndlessRecyclerViewScrollListener : RecyclerView.OnScrollListener {
    private var visibleThreshold = 6
    private var currentPage = 1
    private var previousTotalItemCount = 0
    private var loading = true
    private val startingPageIndex = 1

    private var mLayoutManager: LinearLayoutManager

    constructor(layoutManager: LinearLayoutManager) {
        this.mLayoutManager = layoutManager
    }

    override fun onScrolled(view: RecyclerView, dx: Int, dy: Int) {
        var lastVisibleItemPosition = 0
        val totalItemCount = mLayoutManager.itemCount

        lastVisibleItemPosition = mLayoutManager.findLastVisibleItemPosition()

        if (totalItemCount < previousTotalItemCount) {
            this.currentPage = this.startingPageIndex
            this.previousTotalItemCount = totalItemCount
            if (totalItemCount == 0) {
                this.loading = true
            }
        }

        if (loading && totalItemCount > previousTotalItemCount) {
            loading = false
            previousTotalItemCount = totalItemCount
        }

        if (!loading && lastVisibleItemPosition != RecyclerView.NO_POSITION &&
            lastVisibleItemPosition + visibleThreshold > totalItemCount
        ) {
            currentPage++
            onLoadMore(currentPage, totalItemCount, view)
            loading = true
        }
    }
    abstract fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView)
}