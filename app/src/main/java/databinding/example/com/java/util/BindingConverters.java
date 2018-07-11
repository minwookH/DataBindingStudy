package databinding.example.com.java.util;

import android.databinding.BindingConversion;
import android.view.View;

public class BindingConverters {
    @BindingConversion
    public static int booleanToVisibility(boolean isNotVisible){
        return (isNotVisible)? View.GONE : View.VISIBLE;
    }
}
