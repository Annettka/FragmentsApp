package by.it.academy.fragmentsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

interface MyInterface {
    fun startQuestions()
    fun finishQuestions()
    fun answerQuestion(position: Int)
}

class MainActivity : AppCompatActivity(), MyInterface {

    lateinit var questions: Array<String>
    var questionCounter: Int = 0
    var qResult: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
    }

    private fun initFragment() {
        replaceFragment(FirstFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    override fun startQuestions() {
        questions = resources.getStringArray(R.array.questions)
        replaceFragment(QuestionFragment.newInstance(questions[questionCounter], questionCounter))
    }

    override fun finishQuestions() {
        replaceFragment(ResultFragment.newInstance(qResult.toString()))
    }

    override fun answerQuestion(position: Int) {
        when (position) {
            1 -> when (questionCounter) {
                0 -> qResult++
                1 -> qResult++
                4 -> qResult++
                5 -> qResult++
                7 -> qResult++
                8 -> qResult++
            }
            2 -> when (questionCounter) {
                2 -> qResult++
                3 -> qResult++
                6 -> qResult++
            }
        }

        if (questionCounter >= 8) {
            finishQuestions()
        } else {
            questionCounter++
            replaceFragment(QuestionFragment.newInstance(questions[questionCounter], questionCounter))
        }

    }
}