package com.bw.day02s;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.xbanner)
    XBanner xbanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MyOkhttp.getInstance().GetRequest(new MyOkhttp.MyCallback() {
            @Override
            public void success(String json) {

                Gson gson=new Gson();
                UserBean userBean = gson.fromJson(json, UserBean.class);
                final List<UserBean.ResultBean> result = userBean.getResult();

                xbanner.setData(result,null);
                xbanner.setmAutoPalyTime(2000);
                xbanner.setPageTransformer(Transformer.Default);
                xbanner.setmAdapter(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        Glide.with(MainActivity.this).load(result.get(position).getImageUrl()).into((ImageView) view);
                    }
                });
            }

            @Override
            public void error(String error) {

            }
        });



    }
}
