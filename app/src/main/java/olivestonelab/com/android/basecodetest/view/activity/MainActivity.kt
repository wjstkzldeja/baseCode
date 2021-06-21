package olivestonelab.com.android.basecodetest.view.activity

import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import olivestonelab.com.android.basecodetest.R
import olivestonelab.com.android.basecodetest.databinding.ActivityMainBinding
import olivestonelab.com.android.basecodetest.databinding.FragmentFirstBinding
import olivestonelab.com.android.basecodetest.view.first.FirstViewModel

class MainActivity : AppCompatActivity() {
  private lateinit var mBinding: ActivityMainBinding
  private val viewModel: MainActivityViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    /** 기본 레이아웃 불러오던 코드 */
//    setContentView(R.layout.activity_main)

    /** viemodel 로 구현할때 초기 코드 */
    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    mBinding.lifecycleOwner = this
    mBinding.viewModel = viewModel

    setSupportActionBar(findViewById(R.id.toolbar))

    findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
      Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        .setAction("Action", null).show()
    }
    initView()
  }

  private fun initView() {
    viewModel.showNext.observe(this, Observer { Log.i("logTest2", "activity") })
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    // Inflate the menu; this adds items to the action bar if it is present.
    menuInflater.inflate(R.menu.menu_main, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    return when (item.itemId) {
      R.id.action_settings -> true
      else -> super.onOptionsItemSelected(item)
    }
  }
}