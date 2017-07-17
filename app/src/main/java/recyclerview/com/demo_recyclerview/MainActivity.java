package recyclerview.com.demo_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //不关心item是否显示正确的位置     LayoutMnager
//    不关心item如何分割               ItemDecoration
//    不关注item增加和删除动画效果      ItemAnimator
//    仅仅关注如何回收和复用View

    //RecyclerView  实现：listView（横向和竖向） GridView（横向和竖向）  瀑布流， 定制item增加和删除动画
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private MySimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();
        initViews();
        mAdapter = new MySimpleAdapter(this,mDatas);
        mRecyclerView.setAdapter(mAdapter);

        LinearLayoutManager linearLaoutMnager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLaoutMnager);
    }

    private void initDatas() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i <= 'Z'; i++) {
            mDatas.add(""+(char)i);
        }
    }

    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

}
