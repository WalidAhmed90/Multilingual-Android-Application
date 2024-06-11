package com.example.multilingualapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.navigation.fragment.findNavController
import com.example.multilingualapplication.databinding.FragmentSelectLanguageBinding

class SelectLanguageFragment : Fragment() {
    private var _binding: FragmentSelectLanguageBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSelectLanguageBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.apply {
            btnUrdu.setOnClickListener{
                changeLanguage("ur")
                findNavController().navigate(SelectLanguageFragmentDirections.actionSelecLanguageFragmentToLoginFragment())
            }
            btnEnglish.setOnClickListener{
                changeLanguage("en")
                findNavController().navigate(SelectLanguageFragmentDirections.actionSelecLanguageFragmentToLoginFragment())
            }
            btnSindhi.setOnClickListener{
                changeLanguage("sd")
                findNavController().navigate(SelectLanguageFragmentDirections.actionSelecLanguageFragmentToLoginFragment())
            }
        }

        return view
    }

    private fun changeLanguage(s: String) {
        //code to change the app language.
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(s))

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}