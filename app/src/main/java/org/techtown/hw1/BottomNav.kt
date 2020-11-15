package org.techtown.hw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_bottom_nav.*
import kotlin.properties.Delegates

class BottomNav : AppCompatActivity() {
    private lateinit var viewpagerAdapter: ViewpageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)



        viewpagerAdapter= ViewpageAdapter(supportFragmentManager)
        viewpagerAdapter.fragments= listOf(
            FirstFragment(),
            SecondFragment(),
            ThirdFragment()
        )
        sample_viewpager.adapter=viewpagerAdapter

        sample_viewpager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                sample_bottom_navi.menu.getItem(position).isChecked=true
            }


        })
        sample_bottom_navi.setOnNavigationItemReselectedListener {
            var index by Delegates.notNull<Int>()
            when(it.itemId){
                R.id.menu_add->index=0
                R.id.menu_alarm->index=1
                R.id.menu_photo->index=2
            }
            sample_viewpager.currentItem=index
            true
        }

    }
}