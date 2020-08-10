package com.bksx.mvvmforjetpack.bindingadapter;

import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bksx.mvvmforjetpack.R;
import com.squareup.picasso.Picasso;

/**
 * @Author JoneChen
 * @Date 2020\8\6 0006-13:34
 */
public class ImageViewBindingAdapter {

    @BindingAdapter(value = {"image","defaultImageResource"},requireAll = false)
    public static void setImage(ImageView imageView,String imageUrl,int resource){
        if (!TextUtils.isEmpty(imageUrl)){
            Picasso.get()
                    .load(imageUrl)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(imageView);
        }else {
            imageView.setImageResource(R.drawable.ic_launcher_foreground);
        }
    }
}
