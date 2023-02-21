package com.example.room_database;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.room_database.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity implements UserLisetener{


  private ActivityMainBinding binding;

  User_Database user_database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        user_database= User_Database.getDatabase(getApplicationContext());






         setDataUser();




    }

    private void setDataUser() {

        List<User_Entity> userGet = user_database.getUserDAO().getAllUser();
        User_Adapter adapter = new User_Adapter(MainActivity.this,userGet,MainActivity.this);

        binding.recycler.setAdapter(adapter);

    }


    //===============================================================


    @Override
    public void editUser(User_Entity user_entity) {

        Intent intent = new Intent(MainActivity.this,User_Input.class);
        intent.putExtra("user_Entity",user_entity);
        startActivity(intent);
       // user_database.getUserDAO().updateUser(user_entity);
    }

    @Override
    public void deleteUser(User_Entity user_entity) {
       new AlertDialog.Builder(MainActivity.this)
               .setTitle("Conform  delete")
               .setIcon(R.drawable.alert_icon)
                       .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {


                               user_database.getUserDAO().deleteUser(user_entity);
                               setDataUser();
                               Toast.makeText(MainActivity.this, "Delete Done", Toast.LENGTH_SHORT).show();
                            }
                          })

               .setPositiveButton("ON", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.dismiss();

                   }
               })

                               .show();


    }

    @Override
    protected void onPostResume() {

        setDataUser();
        super.onPostResume();
    }
}