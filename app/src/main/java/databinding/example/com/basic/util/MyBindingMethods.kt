package databinding.example.com.basic.util

import android.databinding.BindingMethod
import android.databinding.BindingMethods
import android.widget.ImageView

@BindingMethods(
        BindingMethod(type = ImageView::class,
                attribute = "app:srcCompat",
                method = "setImageResource"))
class MyBindingMethods
