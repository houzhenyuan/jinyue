//第三个引导页

package test.com.jinyue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;


public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.biao_qian);
        //获取控件对象
        CheckBox meiwen=(CheckBox)findViewById(R.id.MeiWen);
        CheckBox zexue=(CheckBox)findViewById(R.id.ZeXue);
        CheckBox tuili=(CheckBox)findViewById(R.id.TuiLi);
        CheckBox kehuan=(CheckBox)findViewById(R.id.KeHuan);
        CheckBox jishi=(CheckBox)findViewById(R.id.JiShi);
        CheckBox jitang=(CheckBox)findViewById(R.id.JiTang);
        CheckBox guwen=(CheckBox)findViewById(R.id.GuWen);
        Button button2=(Button) findViewById(R.id.Next2);


        //复选框按键功能，把复选框的内容记录到shareperference
        meiwen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                SharePreference sp=new SharePreference(ThirdActivity.this);
                if(isChecked){
                    sp.setMeiWenTrue();
                }
                else{
                    sp.setMeiWenFalse();
                }
            }
        });
        zexue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                SharePreference sp=new SharePreference(ThirdActivity.this);
                if(isChecked){
                    sp.setZeXueTrue();
                }
                else{
                    sp.setZeXueFalse();
                }
            }
        });
        tuili.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                SharePreference sp=new SharePreference(ThirdActivity.this);
                if(isChecked){
                    sp.setTuiLiTrue();
                }
                else{
                    sp.setTuiLiFalse();
                }
            }
        });
        kehuan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                SharePreference sp=new SharePreference(ThirdActivity.this);
                if(isChecked){
                    sp.setKeHuanTrue();
                }
                else{
                    sp.setKeHuanFalse();
                }
            }
        });
        jishi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                SharePreference sp=new SharePreference(ThirdActivity.this);
                if(isChecked){
                    sp.setJiShiTrue();
                }
                else{
                    sp.setJiShiFalse();
                }
            }
        });
        jitang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                SharePreference sp=new SharePreference(ThirdActivity.this);
                if(isChecked){
                    sp.setJiTangTrue();
                }
                else{
                    sp.setJiTangFalse();
                }
            }
        });
        guwen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                SharePreference sp=new SharePreference(ThirdActivity.this);
                if(isChecked){
                    sp.setGuWenTrue();
                }
                else{
                    sp.setGuWenFalse();
                }
            }
        });


        //next2按钮功能，调到阅读器主体界面
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SharePreference sp=new SharePreference(ThirdActivity.this);
                sp.setState();  //将登陆状态设置为true;
                Intent intent=new Intent(ThirdActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
