package com.smartstudy.zhike.banner.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.smartstudy.zhike.banner.ImageOption;
import com.smartstudy.zhike.banner.R;
import com.smartstudy.zhike.banner.bean.homebanner.HomeBannerDataBean;

/**
 * Created by tnn on 2017/05/16
 * email: nanyuweiyi@126.com
 */
public class ImageHolderView implements BasePageAdapter.Holder<HomeBannerDataBean> {
    private ImageView imageView;
    private Context mContext;

    public interface ViewClickListener {
        void onclick(HomeBannerDataBean banner);
    }

    private ViewClickListener mClickListener;

    public ImageHolderView(ViewClickListener clickListener) {
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
        if (banner != null && !TextUtils.isEmpty(banner.getPicture())) {
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
}
