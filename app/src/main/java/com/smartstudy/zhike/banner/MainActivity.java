package com.smartstudy.zhike.banner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.smartstudy.zhike.mylibrary.widget.BannerView;
import com.smartstudy.zhike.mylibrary.widget.ViewHolderCreator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BannerView bannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bannerView = (BannerView) findViewById(R.id.bannerview);

        HomeBannerDataBean bean = new HomeBannerDataBean();
        bean.setPicture("http://img.my.csdn.net/uploads/201508/05/1438760757_3588.jpg");
        bean.setLink("1");

        HomeBannerDataBean bean1 = new HomeBannerDataBean();
        bean1.setPicture("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488801109414&di=b3ea62058e9ba4afb0d75a10a8917d89&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F15%2F52%2F01300001017421128637528950010.jpg");
        bean1.setLink("2");

        List<HomeBannerDataBean> banners = new ArrayList<>();
        banners.add(bean);
        banners.add(bean1);

        initBannerView(banners);
    }

    private void initBannerView(List<HomeBannerDataBean> banners) {
        bannerView.setPages(viewHolderCreator, banners);
        bannerView.setPageIndicator(new int[]{R.drawable.indicator_normal_icon, R.drawable.indicator_selected_icon});
        bannerView.startTurning(5000);
    }

    ViewHolderCreator viewHolderCreator = new ViewHolderCreator<ImageHolderView>() {
        @Override
        public ImageHolderView createHolder() {
            return new ImageHolderView(bannerClick);
        }
    };

    ImageHolderView.ViewClickListener bannerClick = new ImageHolderView.ViewClickListener() {
        @Override
        public void onclick(HomeBannerDataBean banner) {
            String url = banner.getLink();
            Toast.makeText(MainActivity.this, url, Toast.LENGTH_LONG).show();
        }
    };

}
