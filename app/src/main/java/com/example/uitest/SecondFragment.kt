package com.example.uitest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = view.findViewById<TextView>(R.id.show_text)
        textView.text = arguments?.getString(KEY_EXTRA_MESSAGE)
    }

    companion object {
        private const val KEY_EXTRA_MESSAGE = "extra_message"

        fun newInstance(message: String): SecondFragment {
            return SecondFragment().apply {
                arguments = bundleOf(KEY_EXTRA_MESSAGE to message)
            }
        }
    }
}