package com.fatihuynk.progressbarsliderratingbarkullanimi

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fatihuynk.progressbarsliderratingbarkullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Butona tıklandığında gerçekleşecek olaylar tanımlanır
        binding.buttonStart.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
        }
        //binding.progressBar.visibility ile ProgressBar'a erişiyoruz.
        //View.VISIBLE ile ProgressBar'ı görünür hale getiriyoruz.
        binding.buttonStop.setOnClickListener {
            binding.progressBar.visibility = View.INVISIBLE
        }
        //View.INVISIBLE ile ProgressBar'ı görünmez hale getiriyoruz.

        binding.Slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.textViewConclusion.text = "Conclusion : $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        binding.buttonShow.setOnClickListener{

            val progress = binding.Slider.progress
            val vote = binding.ratingBar.rating

            Log.e("Progress",vote.toString())
            Log.e("Vote",progress.toString())
        }
    }
}