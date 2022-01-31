package com.example.ums

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ums.Models.listClass
import com.example.ums.Utils.Data.list0
import com.example.ums.Utils.Data.list1
import com.example.ums.Utils.Data.list2
import com.example.ums.Utils.Data.list3
import com.example.ums.Utils.Data.list4
import com.example.ums.Utils.Data.list5
import kotlinx.android.synthetic.main.fragment_about.view.*

class AboutFragment : Fragment() {

    private lateinit var root: View
    private lateinit var list:List<listClass>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_about, container, false)

        val itemPos = arguments?.getInt("itemPos")!!

        when(arguments?.getInt("listPos")!!){
            0-> list = list3
            1-> list = list0
            2-> list = list1
            3-> list = list4
            4-> list = list2
            5-> list = list5
        }

        root.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        root.title_text.text = list[itemPos].name
        root.msg_text.text = list[itemPos].fullDescription
        root.phone_text.text = list[itemPos].code

        return root
    }
}