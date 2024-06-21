package site.ylan.sunnyweather.ui.place

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import site.ylan.sunnyweather.MainApplication.Companion.globeContext
import site.ylan.sunnyweather.databinding.FragmentPlaceBinding

/**
 * PlaceFragment
 * @author: ylan
 */
class PlaceFragment : Fragment() {

    private lateinit var binding: FragmentPlaceBinding

    private val viewModel by lazy { ViewModelProvider(this)[PlaceViewModel::class.java] }

    private lateinit var bgImageView: ImageView
    private lateinit var searchPlaceEdit: EditText
    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter: PlaceAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlaceBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView = binding.recyclerView
        searchPlaceEdit = binding.searchPlaceEdit
        bgImageView = binding.bgImageView

        layoutManager = LinearLayoutManager(globeContext)
        adapter = PlaceAdapter(this, viewModel.placeList)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        searchPlaceEdit.addTextChangedListener { editable ->
            val content = editable.toString()
            if (content.isNotEmpty()) {
                viewModel.searchPlaces(content)
            } else {
                recyclerView.visibility = View.GONE
                bgImageView.visibility = View.VISIBLE
                viewModel.placeList.clear()
                adapter.notifyDataSetChanged()
            }
        }

        viewModel.placeLiveData.observe(viewLifecycleOwner) { result ->
            val places = result.getOrNull()
            if (places != null) {
                recyclerView.visibility = View.VISIBLE
                bgImageView.visibility = View.GONE
                viewModel.placeList.clear()
                viewModel.placeList.addAll(places)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(globeContext, "未能查询到任何地点", Toast.LENGTH_SHORT).show()
                result.exceptionOrNull()?.printStackTrace()
            }
        }
    }
}