package com.example.recyclerviewmultipleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    
    companion object {
        val data: List<Any>
            get() = mutableListOf(
                DataDay("Monday"),
                DataJadwal("Proyek Pengembangan Aplikasi Mobile", "08.00 - 09.40"),
                DataJadwal("Proyek Pengembangan Aplikasi Web", "10.00 - 11.40"),
                DataDay("Tuesday"),
                DataJadwal("Pemrograman Berorientasi Object", "13.00 - 14.40"),
                DataJadwal("Algoritma dan Pemrograman", "15.00 - 17.00"),
                DataDay("Wednesday"),
                DataJadwal("Sistem Digital", "10.00 - 12.00"),
                DataJadwal("Data Mining", "08.00 - 09.40"),
                DataDay("Thursday"),
                DataJadwal("Matematika Informatika", "08.30 - 10.00"),
                DataJadwal("Algoritma dan Pemrograman Lanjut", "10.00 - 11.40"),
                DataDay("Friday"),
                DataJadwal("Sistem Pendukung Keputusan", "13.00 - 15.00"),
                DataJadwal("Otomata dan Bahasa Formal", "19.00 - 20.40")
            )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportActionBar == null) {
            supportActionBar?.title = getString(R.string.app_name)
        }
        
        recyclerJadwal.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = JadwalAdapter(data)
        }
    }
}
