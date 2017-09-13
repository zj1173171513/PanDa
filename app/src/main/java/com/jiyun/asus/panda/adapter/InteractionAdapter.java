package com.jiyun.asus.panda.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.asus.panda.R;
import com.jiyun.asus.panda.base.Base_Adapter;
import com.jiyun.asus.panda.bean.InfoBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ASUS on 2017/9/13.
 */

public class InteractionAdapter extends Base_Adapter {

    private List<InfoBean.InteractiveBean> mList;
    private Context context;
    private ViewHolder viewHolder;

    public InteractionAdapter(List mList, Context mContext) {
        super(mList, mContext);
        this.mList = mList;
        this.context = mContext;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(context, R.layout.interaction_item, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.interTitle.setText(mList.get(i).getTitle());
        Log.e("TAG",mList.size()+"");
        Glide.with(context).load(mList.get(i).getImage()).into(viewHolder.interImage);
        return view;
    }


    class ViewHolder {
        @Bind(R.id.inter_Title)
        TextView interTitle;
        @Bind(R.id.inter_Image)
        ImageView interImage;

        public ViewHolder(View rootView) {
            ButterKnife.bind(this,rootView);
        }

    }
}
