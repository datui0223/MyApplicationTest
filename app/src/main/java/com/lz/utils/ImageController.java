package com.lz.utils;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.lz.myapplication.MyApplication;

/**
 * Created by DELL on 2017/11/7.
 */

public class ImageController extends BaseControllerListener<ImageInfo>{
    private SimpleDraweeView simpleDraweeView;
    private Context context;
    private Uri uri;
    private DraweeController controller;

    public ImageController(SimpleDraweeView simpleDraweeView, Context context,Uri uri) {
        this.simpleDraweeView = simpleDraweeView;
        this.context = context;
        this.uri = uri;
    }

    public DraweeController getDraweeController(){
        controller = Fresco.newDraweeControllerBuilder()
                .setControllerListener(this)
                .setUri(uri)
                .build();
        return controller;
    }

    @Override
    public void onSubmit(String id, Object callerContext) {

    }

    @Override
    public void onFinalImageSet(String id, @Nullable ImageInfo imageInfo, @Nullable Animatable animatable) {
        if (imageInfo == null) {
            return;
        }
        ViewGroup.LayoutParams viewGroup = simpleDraweeView.getLayoutParams();
        viewGroup.height = imageInfo.getHeight()*MyApplication.getInstance().screenW/imageInfo.getWidth();
        viewGroup.width = MyApplication.getInstance().screenW;
        simpleDraweeView.setLayoutParams(viewGroup);
    }

    @Override
    public void onIntermediateImageSet(String id, @Nullable ImageInfo imageInfo) {

    }

    @Override
    public void onIntermediateImageFailed(String id, Throwable throwable) {

    }

    @Override
    public void onFailure(String id, Throwable throwable) {

    }

    @Override
    public void onRelease(String id) {

    }
}
