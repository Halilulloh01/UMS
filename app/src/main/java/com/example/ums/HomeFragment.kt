package com.example.ums

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment(){

    private lateinit var root: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_home, container, false)

        my(0,root.tariflar_linear)
        my(1,root.daqiqalar_linear)
        my(2,root.internet_linear)
        my(3,root.setting_linear)
        my(4,root.sms_linear)
        my(5,root.news_linear)

        return root
    }
    private fun my(s:Int, v:View){
        v.setOnClickListener {
            val navOption = NavOptions.Builder()
            navOption.setEnterAnim(R.anim.enter_from_left)
            navOption.setPopExitAnim(R.anim.exit_from_left)
            findNavController().navigate(R.id.listFragment, bundleOf("key" to s),navOption.build())
        }
    }
}