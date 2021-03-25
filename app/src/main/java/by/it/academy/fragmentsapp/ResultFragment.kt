package by.it.academy.fragmentsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val RESULT = "result"

class ResultFragment : Fragment() {
    private var result: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            result = it.getString(RESULT)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_result, container, false)
        root.findViewById<TextView>(R.id.result).text = result
        return root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
                ResultFragment().apply {
                    arguments = Bundle().apply {
                        putString(RESULT, "You answered $param1/9 questions correctly")
                    }
                }
    }
}