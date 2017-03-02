package com.example.pwdapp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText et;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.button);
        et= (EditText) findViewById(R.id.edit);
        tv= (TextView) findViewById(R.id.textView);
        button.setOnClickListener(clickListener);

    }
    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String edits=et.getText().toString();
           // StringBuilder edit=new StringBuilder(edits);
            List<Integer> listA=new ArrayList<>();
            List<Integer> listB=new ArrayList<>();
            List<Integer> listG=new ArrayList<>();
            String pwd="^[0-9a-zA-Z]+$";
            if(edits.matches(pwd)){
                edits=edits.trim();
                char[] arr=edits.toCharArray();
                for(int i=0;i<arr.length;i++){
                    if ('A'==arr[i]){
                        listA.add(i);
                    }
                    if ('B'==arr[i]){
                        listB.add(i);
                    }
                    if ('G'==arr[i]){
                        listG.add(i);
                    }
                }
                StringBuilder builder=new StringBuilder(edits);
                for(int i=0;i<listA.size();i++){
                    int j=listA.get(i);
                    builder.replace(j,j+1,"G");
                }
                for(int i=0;i<listB.size();i++){
                    int j=listB.get(i);
                    builder.replace(j,j+1,"A");
                }
                for(int i=0;i<listG.size();i++){
                    int j=listG.get(i);
                    builder.replace(j,j+1,"B");
                }
                edits=builder.toString();

            }else {
                Toast.makeText(MainActivity.this, "输入格式不正确!", Toast.LENGTH_SHORT).show();
            }

            tv.setText(edits);
        }
    };
}
