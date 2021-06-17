package olivestonelab.com.android.basecodetest.view.first

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel : ViewModel() {
  private val _showNext = MutableLiveData<Unit>()
  val showNext: LiveData<Unit> get() = _showNext

  fun next() {
    Log.i("logTest", "logTest")
    _showNext.value = Unit
  }
}