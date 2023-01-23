package com.example.counterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.counterapp.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: StateViewModel by viewModels() // object creted by ktx library

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.addButton.setOnClickListener {
            viewModel.incrementFunc()
        }

        binding.minusButton.setOnClickListener {
            viewModel.decrementFunc()
        }

       lifecycleScope.launchWhenStarted {
           viewModel.cnt.collect{
               binding.countText.text = it.toString()
           }
       }
    }
}