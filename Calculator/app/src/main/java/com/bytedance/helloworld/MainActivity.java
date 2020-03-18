package com.bytedance.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);
        final TextView tv1 = findViewById(R.id.tv1);
        final EditText et1 = findViewById(R.id.et1);
        final EditText et2 = findViewById(R.id.et2);
        final RadioGroup rg1 = findViewById(R.id.rg1);
        final TextView tv_answer = findViewById(R.id.tv_answer);

        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.d("Log_my", "点击计算");
                int a = 0;
                int b = 0;
                int error = 0;
                try{
                    a = Integer.parseInt(et1.getText().toString());
                    b = Integer.parseInt(et2.getText().toString());
                }catch (Exception e){
                    error = 1;
                }
                if (error == 0){
                    int choice = rg1.getCheckedRadioButtonId();
                    int answer = 0;
                    String op = "";
                    switch (choice){
                        case R.id.rb1:
                            answer = a + b;
                            op = "+";
                            break;
                        case R.id.rb2:
                            answer = a - b;
                            op = "-";
                            break;
                        case R.id.rb3:
                            answer = a * b;
                            op = "*";
                            break;
                        case R.id.rb4:
                            try{
                                answer = a / b;
                                op = "/";
                            }catch (Exception e){
                                op = "/";
                                error = 1;
                            }
                            break;
                    }
                    Log.d("Log_my", "输入" + et1.getText().toString() + op + et2.getText().toString());
                    if (error == 0){
                        String answer_s = Integer.toString(answer);
                        tv_answer.setText("=" + answer_s);
                        Log.d("Log_my", "结果为：" + answer_s);
                    }
                    else{
                        Log.d("Log_my", "计算结果不存在");
                        tv_answer.setText("结果不存在！");
                    }
                }
                else{
                    Log.d("Log_my", "错误输入");
                    tv_answer.setText("请输入整数！");
                }

            }
        });
    }
}
