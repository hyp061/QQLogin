package com.example.wlw.qqlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button button;
    private EditText txt_name;
    private EditText txt_pwd;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button= (Button) findViewById(R.id.bt_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txt_name= (EditText) findViewById(R.id.txt_name);
                String number=txt_name.getText().toString();
                txt_pwd= (EditText) findViewById(R.id.txt_pwd);
                String pwd=txt_pwd.getText().toString();

                boolean flag=false;
                String index="";
                for (int i=0; i<ShuJu.user.length;i++){
                    if (number.equals(ShuJu.user[i][0])){
                        if (pwd.equals(ShuJu.user[i][1])){
                            index=ShuJu.user[i][2];
                            flag=true;
                            break;
                        }
                    }
                }
                if (flag){
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putInt("index",Integer.parseInt(index));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast toast=Toast.makeText(LoginActivity.this,"你输入的账号或密码错误！",Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM,0,0);
                    toast.show();
                }
            }
        });


    }
}
