package com.demo.footballmvvmkoinflow_21_08_2024.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.footballmvvmkoinflow_21_08_2024.R
import com.demo.footballmvvmkoinflow_21_08_2024.databinding.ActivityMainBinding
import com.demo.footballmvvmkoinflow_21_08_2024.model.Competitions
import com.demo.footballmvvmkoinflow_21_08_2024.utils.ApiState
import com.demo.footballmvvmkoinflow_21_08_2024.viewmodel.FootballViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
  /*  private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!
*/
    private lateinit var footballAdapter: FootballAdapter
    private val footballViewModel:FootballViewModel by viewModel()
    private lateinit var recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      /*  _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)*/

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

      /*  val layoutManager :RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager*/

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                footballViewModel.footballFlow.collect{
                    when(it){
                        is ApiState.Success -> {
                            footballAdapter = FootballAdapter(it.data.competitions)
                            recyclerView.adapter = footballAdapter
                            // binding.recyclerView.adapter = footballAdapter
                        }
                        is ApiState.Failure -> {
                        Log.d("ApiState.Failure",""+it.msg)
                        }
                        is ApiState.Loading -> {
                            Log.d("ApiState.Loading","")

                        }
                        is ApiState.Empty -> {
                            Log.d("ApiState.Empty","")

                        }
                    }
                }
            }
        }
    }
}