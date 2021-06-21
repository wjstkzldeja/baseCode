package olivestonelab.com.android.basecodetest.view

import androidx.fragment.app.Fragment

fun Fragment.getViewModelFactory(): ViewModelFactory {
  return ViewModelFactory(this)
}