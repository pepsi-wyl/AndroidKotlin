package site.ylan.k12_materialdesign

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import site.ylan.k12_materialdesign.databinding.ActivityFruitBinding
import kotlin.properties.Delegates

class FruitActivity : AppCompatActivity() {

    companion object {
        const val FRUIT_NAME = "fruit_name1"
        const val FRUIT_IMAGE_ID = "fruit_image_id"
        fun startFruitActivity(context: Context, bundle: Bundle) {
            val intent = Intent(context, FruitActivity::class.java)
            intent.apply {
                putExtra(FRUIT_NAME, bundle.getString(FRUIT_NAME))
                putExtra(FRUIT_IMAGE_ID, bundle.getInt(FRUIT_IMAGE_ID))
            }
            context.startActivity(intent)
        }
    }

    // ViewBinding binding
    private val binding: ActivityFruitBinding by lazy {
        ActivityFruitBinding.inflate(layoutInflater)
    }
    private var fruitName by Delegates.notNull<String>()
    private var fruitImageId by Delegates.notNull<Int>()

    private fun initIntentDate() {
        fruitName = intent.getStringExtra(FRUIT_NAME) ?: ""
        fruitImageId = intent.getIntExtra(FRUIT_IMAGE_ID, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initIntentDate()

        // Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
        }

        // CollapsingToolbarLayout的Title
        binding.collapsingToolbar.title = fruitName
        // CollapsingToolbarLayout中ImageView
        Glide.with(this).load(fruitImageId).into(binding.fruitImageView)

        // NestedScrollView中MaterialCardView的TextView
        binding.fruitContentText.text = generateFruitContent(fruitName)

    }

    /**
     * 处理toolbar按钮的点击事件
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return true
    }

    private fun generateFruitContent(fruitName: String) = fruitName.repeat(500)
}