package com.smartstudy.zhike.banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.smartstudy.zhike.mylibrary.widget.BasePageAdapter;

/**
 * 
 * Created by 魏军刚 on 
 * email: weijungang@innobuddy.com
 */
public class ImageHolderView implements BasePageAdapter.Holder<HomeBannerDataBean>{
    private ImageView imageView;
    private Context mContext;

    public interface ViewClickListener{
        void onclick(HomeBannerDataBean banner);
    }

    private ViewClickListener mClickListener;

    public ImageHolderView(ViewClickListener clickListener){
        this.mClickListener = clickListener;
    }

    @Override
    public View createView(Context context) {
        //不一定是Image，任何控件都可以进行翻页
        this.mContext = context;
        imageView = (ImageView) LayoutInflater.from(mContext).inflate(R.layout.layout_image_view, null);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, final int position, final HomeBannerDataBean banner) {
        ImageLoader.getInstance().displayImage(banner.getPicture(), imageView, ImageOption.option);
//        ImageLoader.getInstance().displayImage("http://img.my.csdn.net/uploads/201508/05/1438760757_3588.jpg", imageView, ImgUtil.defaultOptions);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onclick(banner);
            }
        });
    }
}
