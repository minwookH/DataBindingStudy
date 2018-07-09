package databinding.example.com.basic.ui

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import databinding.example.com.R
import databinding.example.com.basic.data.ProfileObservableViewModel
import databinding.example.com.databinding.ViewmodelProfileBinding

class ViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProviders.of(this).get(ProfileObservableViewModel::class.java)

        val binding: ViewmodelProfileBinding =
                DataBindingUtil.setContentView(this, R.layout.viewmodel_profile)

        binding.viewmodel = viewModel
    }
}
