### Android------实现图片双击放大，缩小，左右滑动的多种方式  

  <p>项目中常常有图片浏览功能。像微信朋友圈图片浏览，QQ空间照片浏览 的功能。</p> 
<p>实现图片双击放大，缩小，左右滑动等效果。</p> 
<p>来看看我的效果图，希望能满足你的要求</p> 
<p>&nbsp;<img alt="" height="591" src="http://images2017.cnblogs.com/blog/1041439/201712/1041439-20171223113047850-1495895379.gif" width="369"></p> 
<p>&nbsp;</p> 
<p><img alt="" height="640" src="http://images2017.cnblogs.com/blog/1041439/201712/1041439-20171223113249912-257648637.jpg" width="360">&nbsp; <img alt="" height="640" src="http://images2017.cnblogs.com/blog/1041439/201712/1041439-20171223113325662-500791773.jpg" width="360"></p> 
<p>前三个button按钮是参考网上的多种实现方式，三种自定义图片控件，</p> 
<p>第4个是ViewPager实现图片左右滑动</p> 
<pre><code class="language-java">public class ViewPagerImageViewZQUI extends AppCompatActivity {


    ViewPager viewPager;


    private int[] mImgs = new int[] {
            R.mipmap.img1,
            R.mipmap.img2,
            R.mipmap.tour
    };
    ImageView[] mImageViews;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_layout);
        initView();
    }

    private void initView(){
        mImageViews= new ImageView[mImgs.length];
        viewPager= (ViewPager) findViewById(R.id.img_viewpager);
        viewPager.setAdapter(new PagerAdapter() {

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                //可以使用其他的ImageView 控件，其他自定义控件，你也可以使用自己的哦
                TounChImageView tounChImageView=new TounChImageView(ViewPagerImageViewZQUI.this);
                try {
                    Picasso.with(ViewPagerImageViewZQUI.this).load(mImgs[position])
                            .placeholder(R.mipmap.img1)//默认显示的图片
                           // .resize(500,300)//控制图片高度，不添加则自适应
                            .error(R.mipmap.ic_launcher)//加载时出现错误显示的图片
                            .into(tounChImageView);
                } catch (Exception e) {

                }
                //单击返回
                tounChImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });

                container.addView(tounChImageView,LinearLayout.LayoutParams.WRAP_CONTENT, 
                 LinearLayout.LayoutParams.WRAP_CONTENT);
                mImageViews[position] = tounChImageView;
                return tounChImageView;
            }

            @Override
            public int getCount() {
                return mImgs.length;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mImageViews[position]);
            }
            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }
        });
    }
}</code></pre> 
<p>第5个按钮主要说的是 PhotoView&nbsp; 的多种使用方式，单张，旋转，ViewPager，GridView等</p> 
<p>由于界面太多，就没上传太多图片，下载运行看效果即可。</p> 
<span id="OSC_h3_1"></span>
<h3>&nbsp;</h3> 
