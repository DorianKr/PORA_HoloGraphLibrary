package krizaj.dorian.pora_holographlibrary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import krizaj.dorian.pora_holographlibrary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLineGraph.setOnClickListener {
            findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.lineGraphFragment)
        }

        binding.btnBarGraph.setOnClickListener {
            findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.barGraphFragment)
        }

        binding.btnPieGraph.setOnClickListener {
            findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.pieGraphFragment)
        }
    }
}