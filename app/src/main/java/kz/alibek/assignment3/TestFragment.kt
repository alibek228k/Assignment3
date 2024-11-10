package kz.alibek.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class TestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("onLifecycleEvent() -> onCreateView()")
        return inflater.inflate(R.layout.test_fragment, container, false)
    }

    override fun onStart() {
        println("onLifecycleEvent() -> onStart()")
        super.onStart()
    }

    override fun onResume() {
        println("onLifecycleEvent() -> onResume()")
        super.onResume()
    }


    override fun onPause() {
        println("onLifecycleEvent() -> onPause()")
        super.onPause()
    }

    override fun onStop() {
        println("onLifecycleEvent() -> onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        println("onLifecycleEvent() -> onDestroy()")
        super.onDestroy()
    }
}