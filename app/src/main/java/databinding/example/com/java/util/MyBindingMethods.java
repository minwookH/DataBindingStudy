package databinding.example.com.java.util;

import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.widget.ImageView;

@BindingMethods(value = {
        @BindingMethod(
                type = ImageView.class, attribute = "app:srcCompat", method = "setImageResource"),
})
public class MyBindingMethods {
}
