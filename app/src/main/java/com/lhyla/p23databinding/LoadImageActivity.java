package com.lhyla.p23databinding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoadImageActivity extends AppCompatActivity {
    @BindView(R.id.img_load_act_loaded_image_view)
    ImageView loadedImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image);
        ButterKnife.bind(this);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
    }

    @OnClick(R.id.img_load_act_load_img_fab_btn)
    public void loadImageView() {
        ImageLoader imageLoader = ImageLoader.getInstance();

        imageLoader.displayImage(
                returnRandomImageUri(),
                loadedImageView);
    }



    public String returnRandomImageUri() {
        Random random = new Random();

        List<String> imageUriList = Arrays.asList(
                "http://ichef.bbci.co.uk/naturelibrary/images/ic/credit/640x395/m/mo/mountain/mountain_1.jpg",
                "http://ichef.bbci.co.uk/naturelibrary/images/ic/credit/640x395/m/mo/mountain/mountain_1.jpg",
                "https://cdn.pixabay.com/photo/2017/03/14/17/43/mountain-2143877_960_720.jpg",
                "http://www.telegraph.co.uk/content/dam/Travel/galleries/travel/activityandadventure/" +
                        "The-worlds-most-beautiful-mountains/mountains-Kirkjufe_3374110a-large.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgiiH9kJU5ff38IzfvIdFR_N9KkilGWA8SfbWTFsi1RmOw8_9w"
        );
        return imageUriList.get(random.nextInt(imageUriList.size()));
    }
}