# banner
Banner轮播图

1、在项目build.gradle里添加：maven { url 'https://www.jitpack.io' }

2、在工程build.gradeli里直接引用：compile 'com.github.nanyuweiyi:banner:v1.0.8'

   别忘了引用图片加载库：compile 'com.nostra13.universalimageloader:universal-image-loader:1.9.5'

3、添加该类

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
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onclick(banner);
            }
        });
    }
}

4、代码引用：

    public void initImageLoaderCache() {
        File cacheDir = StorageUtils.getOwnCacheDirectory(
                getApplicationContext(), "ImageLoader/Cache");

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .memoryCacheExtraOptions(720, 1280)
                .diskCacheExtraOptions(720, 1280, null)
                .memoryCache(new WeakMemoryCache())
                .diskCache(new UnlimitedDiskCache(cacheDir))
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
                .imageDownloader(new BaseImageDownloader(getApplicationContext())) 
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                .build();
        ImageLoader.getInstance().init(config);
    }

    void processBanner(List<HomeBannerDataBean> banners) {
        bannerView.setPages(viewHolderCreator, banners);
        int[] inditcators = new int[]{R.mipmap.circle_indicator_stroke, R.mipmap.circle_indicator_solid};
        if (banners.size() != 1) {
            bannerView.setPageIndicator(inditcators).startTurning(5000);
        }
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
            if (TextUtils.isEmpty(url)) {
                return;
            }
            Toast.makeText(MainActivity.this, url, Toast.LENGTH_SHORT).show();
        }
    };
    
    5、注意添加网络权限
    
    
