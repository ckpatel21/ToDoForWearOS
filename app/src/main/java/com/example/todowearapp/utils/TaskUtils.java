package com.example.todowearapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.todowearapp.model.Task;

public class TaskUtils {
    public static void saveTask(Task task, Context context){
        if(task!= null){
            SharedPreferences sharedPreferences = context.getSharedPreferences("task_details",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(task.getId(), task.getTaskDetails());
            editor.commit();
        }
    }
}
