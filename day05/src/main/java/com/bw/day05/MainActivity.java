package com.bw.day05;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bw.day05.adapter.PzshAdapter;
import com.bw.day05.adapter.RxxpAdapter;
import com.bw.day05.bean.UserBean;
import com.bw.day05.util.MyOkHttp;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.recycles)
    RecyclerView recycles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        MyOkHttp.getInstance().GetRequest(new MyOkHttp.MyCallback() {
            @Override
            public void success(String json) {
                Gson gson=new Gson();
                UserBean userBean = gson.fromJson(json, UserBean.class);
                List<UserBean.ResultBean.RxxpBean.CommodityListBean> commodityList = userBean.getResult().getRxxp().getCommodityList();
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
                recycle.setLayoutManager(linearLayoutManager);
                RxxpAdapter adapter=new RxxpAdapter(commodityList,MainActivity.this);
                recycle.setAdapter(adapter);


                List<UserBean.ResultBean.PzshBean.CommodityListBeanX> commodityList1 = userBean.getResult().getPzsh().getCommodityList();
                LinearLayoutManager linearLayoutManagers=new LinearLayoutManager(MainActivity.this);
                recycles.setLayoutManager(linearLayoutManagers);
                PzshAdapter adapter1=new PzshAdapter(commodityList1,MainActivity.this);
                recycles.setAdapter(adapter1);

            }

            @Override
            public void error(String error) {

            }
        });

    }
}
