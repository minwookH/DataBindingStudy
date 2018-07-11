package databinding.example.com.basic.data

import android.arch.lifecycle.ViewModel
import android.databinding.Bindable
import android.databinding.ObservableField
import android.databinding.ObservableInt
import databinding.example.com.BR
import databinding.example.com.basic.util.ObservableViewModel

class ProfileObservableViewModel : ObservableViewModel() {
    val name = ObservableField("Ada333")
    val lastName = ObservableField("Lovelace")
    val likes =  ObservableInt(0)

    fun onLike() {
        likes.increment()
        notifyPropertyChanged(BR.popularity)
    }

    @Bindable
    fun getPopularity(): Popularity {
        return likes.get().let {
            when {
                it > 9 -> Popularity.STAR
                it > 4 -> Popularity.POPULAR
                else -> Popularity.NORMAL
            }
        }
    }
}

class ProfileObservableFieldsViewModel : ViewModel() {
    val name = ObservableField("Ada22")
    val lastName = ObservableField("Lovelace")
    val likes =  ObservableInt(0)

    val popularity = ObservableField<Popularity>(Popularity.NORMAL)

    fun onLike() {
        likes.set(likes.get() + 1)

        popularity.set(likes.get().let {
            if (it > 9) Popularity.STAR
            if (it > 4) Popularity.POPULAR
            Popularity.NORMAL
        })
    }
}

enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}

private fun ObservableInt.increment() {
    set(get() + 1)
}