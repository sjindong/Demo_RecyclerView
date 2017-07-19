package recyclerview.com.demo_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjd on 2017/7/17.
 */

public class StaggeredAdapter extends MySimpleAdapter{
    private LayoutInflater mInflater;
    private Context mContext;
    private List<String> mDatas;

    private List<Integer> mHeight;

    public StaggeredAdapter(Context context, List<String> datas) {
        super(context,datas);
        mContext = context;
        mDatas = datas;
        mInflater = LayoutInflater.from(context);
        mHeight= new ArrayList<Integer>();
        for (int i = 0; i <mDatas.size() ; i++) {
            mHeight.add((int) (100+Math.random()*300));
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ViewGroup.LayoutParams lp=  holder.itemView.getLayoutParams();
        lp.height = mHeight.get(position);
        holder.itemView.setLayoutParams(lp);
        holder.textView.setText(mDatas.get(position));
        setUpItemEvent(holder);
    }
}
