package android.my.com.myrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<String> titles = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        initData();
        mRecyclerView.setAdapter(new RecyclerViewAdapter(this,titles));
        //添加分割线
        mRecyclerView.addItemDecoration(new SimplePaddingDecoration(this));

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //在此处做点击之后的逻辑处理
//                Toast.makeText(MainActivity.this, "点击 ---- " + position, Toast.LENGTH_SHORT).show();
//                TextView textView = view.findViewById(R.id.id_num);
//                textView.setText("点击 ---- " + position);
//                titles.set(position,"点击 ---- " + position);
            }


            @Override
            public void onLongClick(View view, int position) {
                //在此处做长按之后的逻辑处理
                Toast.makeText(MainActivity.this, "长按 ---- " + position, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    protected void initData() {
        for (int i = 0; i < 20; i++) {
            titles.add("标题"+i);
        }
    }

}
