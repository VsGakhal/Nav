package com.example.nav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.nav.databinding.FragmentNavHostFragOneBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NavHostFragOne.newInstance] factory method to
 * create an instance of this fragment.
 */
class NavHostFragOne : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentNavHostFragOneBinding
    lateinit var nav: Nav


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nav = activity as Nav
        Toast.makeText(nav, resources.getString(R.string.oncreate_view_fragment), Toast.LENGTH_LONG).show()
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        Toast.makeText(nav, resources.getString(R.string.oncreate_view_fragment), Toast.LENGTH_LONG).show()
        binding = FragmentNavHostFragOneBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(nav, resources.getString(R.string.on_view_create_fragment),Toast.LENGTH_LONG).show()

        binding.tvNav.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("Test", "testing")
            findNavController().navigate(R.id.action_navHostFragOne_to_navHostFragSec2, bundle)
        }


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NavHostFragOne.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NavHostFragOne().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}