package com.example.ums

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.ums.Adapter.MyAdapter
import com.example.ums.Models.listClass
import com.example.ums.Utils.Data.list0
import com.example.ums.Utils.Data.list1
import com.example.ums.Utils.Data.list2
import com.example.ums.Utils.Data.list3
import com.example.ums.Utils.Data.list4
import com.example.ums.Utils.Data.list5
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {

    private lateinit var root: View
    lateinit var list : ArrayList<listClass>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        root =  inflater.inflate(R.layout.fragment_list, container, false)

        when(arguments?.getInt("key")){
            0-> list = list3
            1-> list = list0
            2-> list = list1
            3-> list = list4
            4-> list = list2
            5-> list = list5
        }

        root.recycleRV.adapter = MyAdapter(requireContext(),object : MyAdapter.MyInterFace{
            override fun clicking(pos: Int) {
                val navOption = NavOptions.Builder()
                navOption.setEnterAnim(R.anim.enter_from_left)
                navOption.setPopExitAnim(R.anim.exit_from_left)
                findNavController().navigate(R.id.aboutFragment, bundleOf("listPos" to arguments?.getInt("key"),"itemPos" to pos),navOption.build())
            }
        },list)

        return root

    }
}