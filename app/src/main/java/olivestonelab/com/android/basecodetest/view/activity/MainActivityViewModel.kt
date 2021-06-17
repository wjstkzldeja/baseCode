package olivestonelab.com.android.basecodetest.view.activity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
  private val _showNext = MutableLiveData<Unit>()
  val showNext: LiveData<Unit> get() = _showNext

  fun next() {
    Log.i("logTest", "activity")
    _showNext.value = Unit
  }
}