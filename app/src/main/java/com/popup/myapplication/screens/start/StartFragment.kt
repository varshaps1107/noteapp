package com.example.mynote.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.mynote.utilits.*
import com.popup.myapplication.R
import com.popup.myapplication.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: StartFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()

        mViewModel = ViewModelProvider(this).get(StartFragmentViewModel::class.java)

        if (AppPreference.getInitUser()) {
            mViewModel.initDatabase(AppPreference.getTypeDB()) {
                APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment)
            }
        } else initialization()
    }

    private fun initialization() {
        mBinding.btnRoom.setOnClickListener {
            mViewModel.initDatabase(TYPE_ROOM) {
                AppPreference.setInitUser(true)
                AppPreference.setTypeDB(TYPE_ROOM)
                APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}