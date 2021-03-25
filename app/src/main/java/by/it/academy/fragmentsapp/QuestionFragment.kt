package by.it.academy.fragmentsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val TEXT1 = "param1"
private const val COUNT = "0"

class QuestionFragment : Fragment() {
    private var text: String? = null
    private var questionCounter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            text = it.getString(TEXT1)
            questionCounter = it.getInt(COUNT)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_question, container, false)
        root.findViewById<TextView>(R.id.question).text = text
        return root
    }

    override fun onStart() {
        super.onStart()
        var buttonIndex: Int

        view?.findViewById<Button>(R.id.button_yes)?.setOnClickListener {
            buttonIndex = setButtonIndex(R.id.button_yes)
            (requireActivity() as MyInterface).answerQuestion(buttonIndex)
        }
        view?.findViewById<Button>(R.id.button_no)?.setOnClickListener {
            buttonIndex = setButtonIndex(R.id.button_no)
            (requireActivity() as MyInterface).answerQuestion(buttonIndex)
        }
    }


    fun setButtonIndex(id: Int): Int {
        var index = 0
        when (id) {
            R.id.button_yes -> index = 1
            R.id.button_no -> index = 2
        }
        return index
    }

    companion object {
        @JvmStatic
        fun newInstance(text: String, counter: Int) =
                QuestionFragment().apply {
                    arguments = Bundle().apply {
                        putString(TEXT1, text)
                        putInt(COUNT, counter)
                    }
                }
    }
}
