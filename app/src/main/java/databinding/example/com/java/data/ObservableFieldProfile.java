package databinding.example.com.java.data;

import android.databinding.ObservableInt;

public class ObservableFieldProfile {
    public String name;
    public String lastName;
    public ObservableInt likes;

    public ObservableFieldProfile(String name, String lastName, ObservableInt likes){
        this.name = name;
        this.lastName = lastName;
        this.likes = likes;
    }
}
