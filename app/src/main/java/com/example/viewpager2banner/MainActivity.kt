package com.example.viewpager2banner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //viewpager2 어댑터  FragementStateAdapter 상속받는다
    //FragementStateAdapter : 프래그먼트 갯수가 일정치 않거나 많을 경우 사용 하면 좋음
    private var vpAdapter:FragmentStateAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // vpAdapter CustomPagerAdapter 초기화해서 현재액티비티 전달
        vpAdapter = CustomPagerAdapter(this)
        viewpage2.adapter =vpAdapter
        //뷰페이져 참조하기
        indicator.setViewPager(viewpage2)


    }
    
    class CustomPagerAdapter(fa:FragmentActivity):FragmentStateAdapter(fa){
        private val PAGENUMBER = 4

        override fun getItemCount(): Int {
           return PAGENUMBER
        }

        override fun createFragment(position: Int): Fragment {
            return when(position){
                 0-> TestFragment.newInstance(R.raw.bin1,"page00")
                 1-> TestFragment.newInstance(R.raw.bin2,"page01")
                 2-> TestFragment.newInstance(R.raw.bin3,"page02")
                 3-> TestFragment.newInstance(R.raw.bin4,"page03")
                 else -> TestFragment.newInstance(R.raw.bin1,"page00")
             }
        }

    }
}