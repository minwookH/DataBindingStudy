package databinding.example.com.java.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import databinding.example.com.R;
import databinding.example.com.databinding.JavaViewmodelProfileBinding;
import databinding.example.com.java.data.ProfileObservableViewModel;

public class ViewModelActivity extends AppCompatActivity {
    private ProfileObservableViewModel viewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(ProfileObservableViewModel.class);
        JavaViewmodelProfileBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.java_viewmodel_profile);

        viewDataBinding.setViewmodel(viewModel);
    }
}
