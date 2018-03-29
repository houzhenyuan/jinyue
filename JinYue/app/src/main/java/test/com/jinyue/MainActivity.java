//阅读器主体

package test.com.jinyue;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    /**test**/
    

    /**解析 Gson 用到的变量**/
    String text;
    String Title;
    String Auther;
    String Text;
    List<String> list;

    /**okhttp**/
    public static final String TAG = "MainActivity";
    public static final MediaType JSON= MediaType.parse("application/json; charset=utf-8");
    String jsonTags = "{\"tag\":[\"ccc\",\"ddd\" ]}";


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.MeiWen1)
    CheckBox MeiWen1;
    @BindView(R.id.ZeXue1)
    CheckBox ZeXue1;
    @BindView(R.id.KeHuan1)
    CheckBox KeHuan1;
    @BindView(R.id.TuiLi1)
    CheckBox TuiLi1;
    @BindView(R.id.JiShi1)
    CheckBox JiShi1;
    @BindView(R.id.JiTang1)
    CheckBox JiTang1;
    @BindView(R.id.GuWen1)
    CheckBox GuWen1;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.textView)
    TextView textView;
    private DrawerLayout mDrawerLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //开启一个线程，做联网操作


        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);//toolbar导入
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.tag);//把标签按钮绑定
        }
        set_checkout();
    }

    private void postJson() {
        //申明给服务端传递一个json串
        //创建一个OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        //创建一个RequestBody(参数1：数据类型 参数2传递的json串)
        RequestBody requestBody = RequestBody.create(JSON , jsonTags);
        //创建一个请求对象
        Request request = new Request.Builder()
                .url("http://192.168.155.1:8080/jianyue/getArtical.html?json={\"tag\":[\"aaa\",\"bbb\"]}")
                .post(requestBody)
                .build();

        //发送请求获取响应
        try {
            Response response=okHttpClient.newCall(request).execute();
            //判断请求是否成功
            if(response.isSuccessful()){
                //打印服务端返回结果
                Log.i(TAG,response.body().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    Toast.makeText(MainActivity.this, "hhh", Toast.LENGTH_SHORT).show();
                    System.out.println("hhh");
                    break;
                default:
                    break;
            }
        }
    };



    public boolean onCreateOptionsMenu(Menu menu) {//加载toolbar布局
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {//处理toolbar点击事件
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.flash:

                new Thread() {
                    @Override
                    public void run() {
                        if(jsonTags == null) {
                            Toast.makeText(MainActivity.this, "hhh", Toast.LENGTH_SHORT).show();
                        } else {
                            postJson();
                        }
                    }
                }.start();
                text = Util.getJson(MainActivity.this, "TestJson.json");
                GsonRead gsonRead;
                list = GsonRead.getGson(text, Title, Auther, Text);
                Title = list.get(0);
                Auther = list.get(1);
                Text = list.get(2);
                toolbar.setTitle(Title);
                textView.setText(Text);
                text = "";
                break;
            default:
        }
        return true;
    }

    //读取SharedPreference，赋值给checkbox兴趣标签,复选框按键功能，把复选框的内容记录到shareperference
    public void set_checkout() {
        //读取SharedPreference，赋值给checkbox兴趣标签
        CheckBox meiwen1 = (CheckBox) findViewById(R.id.MeiWen1);
        CheckBox zexue1 = (CheckBox) findViewById(R.id.ZeXue1);
        CheckBox tuili1 = (CheckBox) findViewById(R.id.TuiLi1);
        CheckBox kehuan1 = (CheckBox) findViewById(R.id.KeHuan1);
        CheckBox jishi1 = (CheckBox) findViewById(R.id.JiShi1);
        CheckBox jitang1 = (CheckBox) findViewById(R.id.JiTang1);
        CheckBox guwen1 = (CheckBox) findViewById(R.id.GuWen1);
        SharePreference sp = new SharePreference(MainActivity.this);
        boolean flag = sp.getMeiWen();
        meiwen1.setChecked(flag);
        flag = sp.getZeXue();
        zexue1.setChecked(flag);
        flag = sp.getTuiLi();
        tuili1.setChecked(flag);
        flag = sp.getKeHuan();
        kehuan1.setChecked(flag);
        flag = sp.getJiShi();
        jishi1.setChecked(flag);
        flag = sp.getJiTang();
        jitang1.setChecked(flag);
        flag = sp.getGuWen();
        guwen1.setChecked(flag);

        //复选框按键功能，把复选框的内容记录到shareperference
        meiwen1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                SharePreference sp = new SharePreference(MainActivity.this);
                if (isChecked) {
                    sp.setMeiWenTrue();
                } else {
                    sp.setMeiWenFalse();
                }
            }
        });
        zexue1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                SharePreference sp = new SharePreference(MainActivity.this);
                if (isChecked) {
                    sp.setZeXueTrue();
                } else {
                    sp.setZeXueFalse();
                }
            }
        });
        tuili1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                SharePreference sp = new SharePreference(MainActivity.this);
                if (isChecked) {
                    sp.setTuiLiTrue();
                } else {
                    sp.setTuiLiFalse();
                }
            }
        });
        kehuan1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                SharePreference sp = new SharePreference(MainActivity.this);
                if (isChecked) {
                    sp.setKeHuanTrue();
                } else {
                    sp.setKeHuanFalse();
                }
            }
        });
        jishi1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                SharePreference sp = new SharePreference(MainActivity.this);
                if (isChecked) {
                    sp.setJiShiTrue();
                } else {
                    sp.setJiShiFalse();
                }
            }
        });
        jitang1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                SharePreference sp = new SharePreference(MainActivity.this);
                if (isChecked) {
                    sp.setJiTangTrue();
                } else {
                    sp.setJiTangFalse();
                }
            }
        });
        guwen1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                SharePreference sp = new SharePreference(MainActivity.this);
                if (isChecked) {
                    sp.setGuWenTrue();
                } else {
                    sp.setGuWenFalse();
                }
            }
        });
    }

    @OnClick({R.id.toolbar, R.id.MeiWen1, R.id.ZeXue1, R.id.KeHuan1, R.id.TuiLi1, R.id.JiShi1, R.id.JiTang1, R.id.GuWen1, R.id.drawer_layout, R.id.scrollView, R.id.textView})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar:
                Toast.makeText(MainActivity.this, "toolbar", Toast.LENGTH_SHORT);
                break;
            case R.id.MeiWen1:
                break;
            case R.id.ZeXue1:
                break;
            case R.id.KeHuan1:
                break;
            case R.id.TuiLi1:
                break;
            case R.id.JiShi1:
                break;
            case R.id.JiTang1:
                break;
            case R.id.GuWen1:
                break;
            case R.id.drawer_layout:
                break;
            case R.id.scrollView:
                Toast.makeText(MainActivity.this, "scr", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textView:
                Toast.makeText(MainActivity.this, "papapa", Toast.LENGTH_SHORT);
                System.out.println("你点击了test");
                break;
        }
    }

    /*public String getTag() {
        Gson gson = new Gson();
        SharePreference sp = new SharePreference(MainActivity.this);
        if( sp.getGuWen() ) {
            jsonTags = gson.toJson("GuWen");
        }

        if( sp.getJiShi() ) {
            jsonTags = gson.toJson("Jishi");
        }

        if( sp.getJiTang() ) {
            jsonTags = gson.toJson("JiTang");
        }

        if( sp.getKeHuan() ) {
            jsonTags = gson.toJson("KeHuan");
        }

        if( sp.getTuiLi() ) {
            jsonTags = gson.toJson("TuiLi");
        }

        if( sp.getZeXue() ) {
            jsonTags = gson.toJson("ZeXue");
        }
    }*/



}
