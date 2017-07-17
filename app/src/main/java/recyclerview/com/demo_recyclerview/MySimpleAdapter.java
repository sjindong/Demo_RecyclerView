package recyclerview.com.demo_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sjd on 2017/7/17.
 */

public class MySimpleAdapter  extends RecyclerView.Adapter<MyViewHolder>{
    private LayoutInflater mInflater;
    private Context mContext;
    private List<String> mDatas;
    public MySimpleAdapter(Context context, List<String> datas) {
        mContext = context;
        mDatas = datas;
        mInflater = LayoutInflater.from(context);
    }

    @Override //创建
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_singale,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mDatas.get(position));
        Log.e("SJD","textView Width = "+position+"  "+holder.textView.getWidth());
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{
    TextView textView;
    public MyViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.single_textView);

    }
}