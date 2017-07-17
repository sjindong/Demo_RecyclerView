package recyclerview.com.demo_recyclerview;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
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

        //设置RecyclerView的布局管理
        LinearLayoutManager linearLaoutMnager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLaoutMnager);

        //设置RecyclerView的Item之间分割线
        RecyclerView.ItemDecoration itemDecor = new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
            }

            @Override
            public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDrawOver(c, parent, state);
            }

            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
            }
        };
        mRecyclerView.addItemDecoration( itemDecor);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_gridview:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
                break;
            case R.id.actiong_ListView:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.action_hor_gridview:
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL));
                break;
            case R.id.action_staggered:
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
