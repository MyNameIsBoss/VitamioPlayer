package demo.baidu.com.vitamioplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecycleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> list = new ArrayList<String>();
        for (int i=0;i<10;i++) {
            list.add("Hello World");
        }
        List<String> list1 = new ArrayList<String>();
        for(int i=0;i<10;i++){
            list1.add("http://i.imgur.com/DvpvklR.png");
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //设置布局显示方式
        recyclerView.setLayoutManager(new GridLayoutManager(this,GridLayoutManager.chooseSize(0,3,1)));
        //设置添加删除item时候的动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new RecycleAdapter(this, list, list1);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecycleAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(int position, Object object) {
                Toast.makeText(MainActivity.this, "你好", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
