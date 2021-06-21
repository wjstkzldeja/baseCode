package olivestonelab.com.android.basecodetest.view.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import olivestonelab.com.android.basecodetest.R
import olivestonelab.com.android.basecodetest.databinding.FragmentFirstBinding
import olivestonelab.com.android.basecodetest.view.getViewModelFactory

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
  private lateinit var viewDataBinding: FragmentFirstBinding
  /** ��� ���丮 ���� �����ߴ� �ڵ�*/
//  private val viewModel: FirstViewModel by viewModels()

  /** ��� ���丮�� ���� */
  private val viewModels by viewModels<FirstViewModel> { getViewModelFactory() }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    /** view model �� �����Ҷ� �ʱ� �ڵ�(���ͳ� ����) */
    /*mBinding = FragmentFirstBinding.inflate(inflater, container, false)
    mBinding.lifecycleOwner = this
    mBinding.viewModel = viewModel*/

    /** view model �� �����Ҷ� �ʱ� �ڵ�(���� ����) */
    val root = inflater.inflate(R.layout.fragment_first, container, false)
    viewDataBinding = FragmentFirstBinding.bind(root).apply {
      this.viewModel = viewModels
    }
    viewDataBinding.lifecycleOwner = this.viewLifecycleOwner

    initView()

    return viewDataBinding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }

  private fun initView() {
    viewModels.showNext.observe(viewLifecycleOwner, Observer { nextEvent() })
  }

  private fun nextEvent() {
    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
  }
}