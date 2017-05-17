package com.smartstudy.zhike.mylibrary.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by tnn on 17/5/17.
 * email:nanyuweiyi@126.com
 */

public class BasePageAdapter<T> extends RecyclePagerAdapter {
    protected List<T> mDatas;
    protected ViewHolderCreator holderCreator;

    public BasePageAdapter(ViewHolderCreator holderCreator, List<T> datas) {
        this.holderCreator = holderCreator;
        this.mDatas = datas;
    }

    public View getView(int position, View view, ViewGroup container) {
        Holder holder;
        if (view == null) {
            holder = (Holder) holderCreator.createHolder();
            view = holder.createView(container.getContext());
            view.setTag(holder);
        } else {
            holder = (Holder<T>) view.getTag();
        }
        if(mDatas!=null&&!mDatas.isEmpty())
        holder.UpdateUI(container.getContext(), position, mDatas.get(position));
        return view;
    }

    @Override
    public int getCount() {
        if(mDatas==null)return 0;
        return mDatas.size();
    }

    /**
     * @param <T> 任何你指定的对象
     */
    public interface Holder<T>{
        View createView(Context context);
        void UpdateUI(Context context, int position, T data);
    }
}
