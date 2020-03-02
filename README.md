# ViewPager2-Carousel
A simple Carousel for ViewPager2


## Horizontal Carousel VP2

- Layout 

```
    <androidx.viewpager2.widget.ViewPager2
        android:id="@+id/viewPagervertical"
        android:layout_width="match_parent"
        android:layout_height="300dp"
        android:orientation="horizontal"/>
   ```     
       
       
       
- Code 
```
private fun setupCarousel(){

        viewPager.offscreenPageLimit = 1

        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx = resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
            page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
             page.alpha = 0.25f + (1 - kotlin.math.abs(position))
        }
        viewPager.setPageTransformer(pageTransformer)
        val itemDecoration = HorizontalMarginItemDecoration(
            this,
            R.dimen.viewpager_current_item_horizontal_margin
        )
        viewPager.addItemDecoration(itemDecoration)
    }
    
```
    
## Vertical Carousel VP2


- Layout 

```
    <androidx.viewpager2.widget.ViewPager2
        android:id="@+id/viewPagervertical"
        android:layout_width="match_parent"
        android:layout_height="300dp"
        android:padding="10dp"
        android:orientation="vertical" />
   ```     
       
       
       
- Code 
```
private fun setupCarousel(){

        viewPagervertical.offscreenPageLimit = 1

        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx = resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationY = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationY = pageTranslationY * position
            page.scaleX = 1 - (0.25f * kotlin.math.abs(position))
            page.alpha = 0.25f + (1 - kotlin.math.abs(position))
        }
        viewPagervertical.setPageTransformer(pageTransformer)
        val itemDecoration = HorizontalMarginItemDecoration(
            this,
            R.dimen.viewpager_current_item_horizontal_margin
        )
        viewPagervertical.addItemDecoration(itemDecoration)
    }
    
```
