package site.ylan.k12_materialdesign

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import site.ylan.k12_materialdesign.adapter.FruitAdapter
import site.ylan.k12_materialdesign.databinding.ActivityMainBinding
import site.ylan.k12_materialdesign.model.Fruit
import site.ylan.k12_materialdesign.model.FruitDate
import site.ylan.k12_materialdesign.utils.SnackbarUtils
import site.ylan.k12_materialdesign.utils.SnackbarUtils.Companion.showSnackbar
import site.ylan.k12_materialdesign.utils.showToastShort
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    // ViewBinding binding
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var adapter: FruitAdapter
    private lateinit var layoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)           // 显示导航按钮
            it.setHomeAsUpIndicator(R.drawable.ic_menu)  // 设置导航按钮图标
            it.setTitle(R.string.tool_bar_title)
        }

        // NavigationView
        binding.navView.let {
            // 默认选中的菜单项
            it.setCheckedItem(R.id.navCall)
            it.setNavigationItemSelectedListener {
                // 调用DrawerLayout的closeDrawers()方法将滑动菜单关闭，并返回true表示此事件已被处理
                binding.drawerLayout.closeDrawers()
                true
            }
        }

        // FloatingActionButton FloatingActionButton是CoordinatorLayout中的子控件,事件就能被监听到
        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Data deleted", Snackbar.LENGTH_SHORT)
//                .setAction("Undo") {
//                    Toast.makeText(this, "Data restored", Toast.LENGTH_SHORT).show()
//                }
//                .show()
            view.showSnackbar("Data deleted", "Undo") {
                "Data restored".showToastShort(this)
            }
        }

        // RecyclerView
        binding.recyclerView.let {
            layoutManager = GridLayoutManager(this, 2)
            adapter = FruitAdapter(this)
            adapter.setFruitList(FruitDate.getFruitList())
            it.layoutManager = layoutManager
            it.adapter = adapter
        }

        // 下拉刷新
        binding.swipeRefresh.let {
            it.setColorSchemeResources(R.color.violet)
            it.setOnRefreshListener {
                refreshFruits()
            }
        }

    }

    /**
     * 加载toolbar菜单文件
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    /**
     * 处理toolbar按钮的点击事件
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            // 处理导航按钮的点击事件
            android.R.id.home -> {
                // gravity GravityCompat.START
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }

            R.id.backup -> "You clicked Backup".showToastShort(this)
            R.id.delete -> "You clicked Delete".showToastShort(this)
            R.id.settings -> "You clicked Settings".showToastShort(this)

        }
        return true
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun refreshFruits() {
        thread {
            Thread.sleep(2000)
            // runOnUiThread()方法将线程切换回主线程
            runOnUiThread {
                // 刷新数据
                adapter.setFruitList(FruitDate.getFruitList())
                // 刷新结束
                binding.swipeRefresh.isRefreshing = false
            }
        }
    }
}