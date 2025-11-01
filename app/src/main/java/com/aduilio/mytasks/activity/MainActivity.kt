package com.aduilio.mytasks.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.aduilio.mytasks.adapter.ListAdapter
import com.aduilio.mytasks.databinding.ActivityMainBinding
import com.aduilio.mytasks.service.TaskService

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ListAdapter

    private val taskService: TaskService by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initComponents()
    }

    override fun onResume() {
        super.onResume()

        getTasks()
    }

    private fun initComponents() {
        adapter = ListAdapter()
        binding.rvMain.adapter = adapter

        binding.fabNew.setOnClickListener {
            startActivity(Intent(this, FormActivity::class.java))
        }
    }

    private fun getTasks() {
        taskService.list().observe(this) { response ->
            adapter.setData(response)
        }
    }
}