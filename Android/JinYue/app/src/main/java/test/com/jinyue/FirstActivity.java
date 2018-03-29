package test.com.jinyue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1=(Button) findViewById(R.id.Next);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SharePreference sp=new SharePreference(FirstActivity.this);
                boolean isLogin = sp.getState();
                if(isLogin){
                    Intent intent=new Intent(FirstActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else {
                    sp.setState();  //将登陆状态设置为true;
                    Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
