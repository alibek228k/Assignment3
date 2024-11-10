package kz.alibek.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class InputFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_input, container, false)
        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        val editText = view.findViewById<EditText>(R.id.editText)
        editText.addTextChangedListener {
            viewModel.inputText.value = it.toString()
        }

        return view
    }
}