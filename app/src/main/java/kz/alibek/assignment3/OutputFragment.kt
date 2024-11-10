package kz.alibek.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class OutputFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_output, container, false)
        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        val textView = view.findViewById<TextView>(R.id.textView)
        viewModel.inputText.observe(viewLifecycleOwner) { text ->
            textView.text = text
        }

        return view
    }
}
