package databinding.example.com.java.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ImageViewCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import databinding.example.com.R;
import databinding.example.com.java.data.Popularity;


public class BindingAdapters {
    @BindingAdapter("app:popularityIconjava")
    public static void popularityIcon(ImageView view, Popularity popularity) {

        int color = getAssociatedColor(popularity, view.getContext());

        ImageViewCompat.setImageTintList(view, ColorStateList.valueOf(color));

        view.setImageDrawable(getDrawablePopularity(popularity, view.getContext()));
    }

    @BindingAdapter("app:progressTintjava")
    public static void tintPopularity(ProgressBar view, Popularity popularity) {

        int color = getAssociatedColor(popularity, view.getContext());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.setProgressTintList(ColorStateList.valueOf(color));
        }
    }

    @BindingAdapter(value = {"app:progressScaledjava", "android:maxjava"}, requireAll = true)
    public static void setProgress(ProgressBar progressBar, int likes, int max) {
        int count = likes * max / 5;
        progressBar.setProgress((count > max) ? max : count);
        //progressBar.setProgress((likes * max / 5).coerceAtMost(max));
    }

    @BindingAdapter("app:hideIfZerojava")
    public static void hideIfZero(View view, int number) {
        view.setVisibility(number == 0 ? View.GONE : View.VISIBLE);
    }

    private static int getAssociatedColor(Popularity popularity, Context context) {
        int color = 0;
        switch(popularity) {
            case NORMAL:
                color = context.getTheme().obtainStyledAttributes(new int[]{16842800}).getColor(0, 0);
                break;
            case POPULAR:
                color = ContextCompat.getColor(context, R.color.popular);
                break;
            case STAR:
                color = ContextCompat.getColor(context, R.color.star);
                break;
            default:
                break;
        }

        return color;
    }

    private static Drawable getDrawablePopularity(Popularity popularity, Context context) {
        Drawable drawable = null;
        switch(popularity) {
            case NORMAL:
                drawable = ContextCompat.getDrawable(context, R.drawable.ic_person_black_96dp);
                break;
            case POPULAR:
                drawable = ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp);
                break;
            case STAR:
                drawable = ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp);
                break;
            default:
                break;
        }

        return drawable;
    }
}
