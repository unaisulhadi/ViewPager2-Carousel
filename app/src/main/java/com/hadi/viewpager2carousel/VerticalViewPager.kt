package com.hadi.viewpager2carousel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_vertical_view_pager.*

class VerticalViewPager : AppCompatActivity() {

    var modelList = arrayListOf<ModelData>()
    lateinit var adapter: ModelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vertical_view_pager)

        loadData()

        horizontal.setOnClickListener {
            finish()
        }
    }


    private fun loadData() {
        modelList.add(ModelData("Name 1","22-05-2019","https://i.picsum.photos/id/415/500/500.jpg"))
        modelList.add(ModelData("Name 2","20-05-2019","https://i.picsum.photos/id/420/500/500.jpg"))
        modelList.add(ModelData("Name 3","15-02-2020","https://i.picsum.photos/id/425/500/500.jpg"))
        modelList.add(ModelData("Name 4","08-05-2019","https://i.picsum.photos/id/410/500/500.jpg"))
        modelList.add(ModelData("Name 5","22-05-2018","https://i.picsum.photos/id/424/500/500.jpg"))

        setupCarousel()

        adapter = ModelAdapter(this,modelList)
        viewPagervertical.adapter = adapter
    }


    fun setupCarousel(){



        viewPagervertical.offscreenPageLimit = 1

        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx = resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationY = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationY = pageTranslationY * position
//            // Next line scales the item's height. You can remove it if you don't want this effect
            page.scaleX = 1 - (0.25f * kotlin.math.abs(position))
//            // If you want a fading effect uncomment the next line:
            page.alpha = 0.25f + (1 - kotlin.math.abs(position))
        }
        viewPagervertical.setPageTransformer(pageTransformer)
//
//// The ItemDecoration gives the current (centered) item horizontal margin so that
//// it doesn't occupy the whole screen width. Without it the items overlap
        val itemDecoration = HorizontalMarginItemDecoration(
            this,
            R.dimen.viewpager_current_item_horizontal_margin
        )
        viewPagervertical.addItemDecoration(itemDecoration)


    }
}
