package com.bw.day05.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.day05.R;
import com.bw.day05.bean.UserBean;

import java.util.List;

public class PzshAdapter extends RecyclerView.Adapter<PzshAdapter.Hander> {

    private List<UserBean.ResultBean.PzshBean.CommodityListBeanX> list;
    private Context context;

    public PzshAdapter(List<UserBean.ResultBean.PzshBean.CommodityListBeanX> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Hander onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.recycle_item, null);
        Hander hander=new Hander(inflate);
        return hander;
    }

    @Override
    public void onBindViewHolder(@NonNull Hander hander, int i) {
        Glide.with(context).load(list.get(i).getMasterPic()).into(hander.imageView);
           hander.textView.setText(list.get(i).getCommodityName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Hander extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        public Hander(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img);
            textView=itemView.findViewById(R.id.name);
        }
    }
}
