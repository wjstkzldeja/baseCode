package olivestonelab.com.android.basecodetest.view

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import olivestonelab.com.android.basecodetest.view.activity.MainActivityViewModel
import olivestonelab.com.android.basecodetest.view.first.FirstViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
  owner: SavedStateRegistryOwner,
  defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
  override fun <T : ViewModel?> create(
    key: String,
    modelClass: Class<T>,
    handle: SavedStateHandle
  )= with(modelClass) {
    when{
      isAssignableFrom(MainActivityViewModel::class.java) -> MainActivityViewModel()
      isAssignableFrom(FirstViewModel::class.java) -> FirstViewModel()

      else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
  } as T
}