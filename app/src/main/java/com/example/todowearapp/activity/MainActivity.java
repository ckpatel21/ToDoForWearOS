package com.example.todowearapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.todowearapp.R;
import com.example.todowearapp.databinding.ActivityMainBinding;
import com.example.todowearapp.model.Task;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);
        init();
    }

    private  void init(){
        initTask();
    }

    private void initTask() {
        mainBinding.edtTask.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i== EditorInfo.IME_ACTION_SEND){
                    String text = textView.getText().toString();
                    if(!TextUtils.isEmpty(text)){
                        Task task = createTask(null,text);
                        updateTask(task,Constants.ACTION_ADD);
                        textView.setText("");
                        return true;
                    }
                }
                return false;
            }
        });
    }

    private Task createTask(String id, String task) {
        if(id == null){
            id = String.valueOf(System.currentTimeMillis());
        }
        return new Task(id,task);
    }
}