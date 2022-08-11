package com.geektech.hw2_m6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geektech.hw2_m6.PromptUtils.negativeButton
import com.geektech.hw2_m6.PromptUtils.positiveButton
import com.geektech.hw2_m6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var adapter: NameAdapter
    private var namesList = mutableListOf<NamesModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initNames()
        initAdapter()
    }

    private fun initAdapter() {
        adapter = NameAdapter { pos ->
            initAlert(pos)
        }
        adapter.addNames(namesList)
        binding.rcItem.adapter = adapter
    }

    private fun initAlert(pos : Int){
        PromptUtils.alertDialog(this) {
            setTitle("Delete?")
            positiveButton {
                adapter.deleteNames(pos)
                showToast("Deleted!")
            }
            negativeButton {
                showToast("Not Deleted!")
            }
            show()
        }
    }

    private fun initNames() {
        namesList.add(NamesModel("Chika"))
        namesList.add(NamesModel("Chika1"))
        namesList.add(NamesModel("Chika2"))
        namesList.add(NamesModel("Chika3"))
        namesList.add(NamesModel("Chika4"))
        namesList.add(NamesModel("Chika5"))
        namesList.add(NamesModel("Chika6"))
        namesList.add(NamesModel("Chika7"))
        namesList.add(NamesModel("Chika8"))
        namesList.add(NamesModel("Chika8"))
        namesList.add(NamesModel("Chika10"))
        namesList.add(NamesModel("Chika11"))
        namesList.add(NamesModel("Chika12"))
        namesList.add(NamesModel("Chika13"))
    }
}