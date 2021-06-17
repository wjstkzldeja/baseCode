package olivestonelab.com.android.basecodetest.view.first

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import olivestonelab.com.android.basecodetest.R
import olivestonelab.com.android.basecodetest.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
  private lateinit var mBinding: FragmentFirstBinding
  private val viewModel: FirstViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    mBinding = FragmentFirstBinding.inflate(inflater, container, false)
    mBinding.lifecycleOwner = this
    mBinding.viewModel = viewModel

    initView()

    return mBinding.root
  }

  private fun initView() {
    viewModel.showNext.observe(viewLifecycleOwner, Observer { nextEvent() })
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }

  private fun nextEvent() {
    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
  }
}