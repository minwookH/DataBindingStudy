package databinding.example.com.java.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableInt;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import databinding.example.com.R;
import databinding.example.com.databinding.JavaObservableFieldProfileBinding;
import databinding.example.com.java.data.ObservableFieldProfile;

public class ObservableFieldActivity extends AppCompatActivity {
    private ObservableFieldProfile observableFieldProfile = new ObservableFieldProfile("java over", "hi", new ObservableInt(0));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        JavaObservableFieldProfileBinding binding =
                DataBindingUtil.setContentView(this, R.layout.java_observable_field_profile);
        binding.setUser(observableFieldProfile);


    }

    public void onLike(View view) {
        observableFieldProfile.likes.set(observableFieldProfile.likes.get() + 1);
    }
}
