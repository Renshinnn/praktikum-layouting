package www.smktelkommlg.sch.id

import androidx.appcompat.app.AppCompatActivity
import www.smktelkommlg.sch.id.R
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import www.smktelkommlg.sch.id.Intro.MyViewPagerAdapter
import android.content.Intent
import www.smktelkommlg.sch.id.MainActivity1
import android.widget.LinearLayout
import www.smktelkommlg.sch.id.Intro
import android.view.ViewGroup
import android.graphics.PorterDuff
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import androidx.viewpager.widget.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Intro : AppCompatActivity() {
    private var btn_got_it: Button? = null
    private val title_array = arrayOf(
        "Intro One", "Intro Two",
        "Intro Three", "Intro Four"
    )
    private val description_array = arrayOf(
        "ninuninuninuninuninu",
        "pengen beli trek",
        "sebelah sini bang...",
        "pupuk lengkap mantap"
    )
    private val about_images_array = intArrayOf(
        R.drawable.ic_android, R.drawable.ic_notifications,
        R.drawable.ic_help, R.drawable.ic_favorite
    )
    private val color_array = intArrayOf(
        R.color.colorBlackDoff, R.color.colorBlackDoff,
        R.color.colorBlackDoff, R.color.colorBlackDoff
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        initComponent()
    }

    private fun initComponent() {
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        btn_got_it = findViewById(R.id.btn_got_it)
        bottomProgressDots(0)
        val myViewPagerAdapter = MyViewPagerAdapter()
        viewPager.adapter = myViewPagerAdapter
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener)
        btn_got_it?.setVisibility(View.GONE)
        btn_got_it?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Intro, MainActivity1::class.java)
            startActivity(intent)
        })
        findViewById<View>(R.id.btn_skip).setOnClickListener {
            val intent = Intent(this@Intro, MainActivity1::class.java)
            startActivity(intent)
        }
    }

    private fun bottomProgressDots(index: Int) {
        val dotsLayout = findViewById<LinearLayout>(R.id.layoutDots)
        val dots = arrayOfNulls<ImageView>(MAX_STEP)
        dotsLayout.removeAllViews()
        for (i in dots.indices) {
            dots[i] = ImageView(this)
            val width_height = 15
            val params =
                LinearLayout.LayoutParams(ViewGroup.LayoutParams(width_height, width_height))
            params.setMargins(10, 10, 10, 10)
            dots[i]!!.layoutParams = params
            dots[i]!!.setImageResource(R.drawable.dot)
            dots[i]!!.setColorFilter(resources.getColor(R.color.colorWhite), PorterDuff.Mode.SRC_IN)
            dotsLayout.addView(dots[i])
        }
        dots[index]!!.setImageResource(R.drawable.dot)
        dots[index]!!.setColorFilter(resources.getColor(R.color.colorGold), PorterDuff.Mode.SRC_IN)
    }

    var viewPagerPageChangeListener: OnPageChangeListener = object : OnPageChangeListener {
        override fun onPageSelected(position: Int) {
            bottomProgressDots(position)
            if (position == title_array.size - 1) {
                btn_got_it!!.visibility = View.VISIBLE
            } else {
                btn_got_it!!.visibility = View.GONE
            }
        }

        override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
        override fun onPageScrollStateChanged(arg0: Int) {}
    }

    inner class MyViewPagerAdapter internal constructor() : PagerAdapter() {
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val layoutInflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = layoutInflater.inflate(R.layout.item_intro, container, false)
            (view.findViewById<View>(R.id.title) as TextView).text = title_array[position]
            (view.findViewById<View>(R.id.description) as TextView).text =
                description_array[position]
            (view.findViewById<View>(R.id.image) as ImageView).setImageResource(
                about_images_array[position]
            )
            view.findViewById<View>(R.id.lyt_parent).setBackgroundColor(
                resources.getColor(
                    color_array[position]
                )
            )
            container.addView(view)
            return view
        }

        override fun getCount(): Int {
            return title_array.size
        }

        override fun isViewFromObject(view: View, obj: Any): Boolean {
            return view === obj
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            val view = `object` as View
            container.removeView(view)
        }
    }

    companion object {
        private const val MAX_STEP = 4
    }
}