package com.smartstudy.zhike.mylibrary;

import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class ImageOption {

    public static DisplayImageOptions option = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.mipmap.building)
            .showImageForEmptyUri(R.mipmap.building)
            .showImageOnFail(R.mipmap.building)
            .resetViewBeforeLoading(true)
            .bitmapConfig(Bitmap.Config.RGB_565)
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .imageScaleType(ImageScaleType.EXACTLY)
            .displayer(new RoundedBitmapDisplayer(20))//是否设置为圆角，弧度为多少
            .considerExifParams(true)
            .build();

    public static final DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.mipmap.building) //设置图片在下载期间显示的图片
            .showImageForEmptyUri(R.mipmap.building)//设置图片Uri为空或是错误的时候显示的图片
            .showImageOnFail(R.mipmap.building)  //设置图片加载/解码过程中错误时候显示的图片
            .cacheOnDisk(true)//设置下载的图片是否缓存在SD卡中
            .considerExifParams(true)  //是否考虑JPEG图像EXIF参数（旋转，翻转）
            .resetViewBeforeLoading(true)//设置图片在下载前是否重置，复位
            .build();//构建完成


    public static final DisplayImageOptions circle = new DisplayImageOptions.Builder()
            .cacheOnDisk(true)//设置下载的图片是否缓存在SD卡中
            .considerExifParams(true)  //是否考虑JPEG图像EXIF参数（旋转，翻转）
            .resetViewBeforeLoading(true)//设置图片在下载前是否重置，复位
            .displayer(new RoundedBitmapDisplayer(200))//是否设置为圆角，弧度为多少
            .build();//构建完成


}
