package com.example.room_database;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.room_database.databinding.ActivityUserInputBinding;

public class User_Input extends AppCompatActivity {

    private ActivityUserInputBinding binding;
    User_Entity uaserentity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserInputBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

          if (getIntent().hasExtra("user_Entity")){
              uaserentity    = (User_Entity) getIntent().getSerializableExtra("user_Entity");
              Log.i("TAG","data: " +uaserentity.toString());

              binding.edusername.setText(uaserentity.getUserName());
              binding.edemail.setText(uaserentity.getUserEmail());
              binding.edcountry.setText(uaserentity.getUserCountry());
              binding.edpassword.setText(uaserentity.getUserPassword());

              binding.submitbtn.setText("Update");
          }else {
              binding.submitbtn.setText("submit");


          }







        binding.submitbtn.setOnClickListener(v ->{
            userInputEd();
            Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(User_Input.this,MainActivity.class);

           startActivity(intent);



        });





    }
    //====================================================
    private void userInputEd() {
        String userName,userEmail,userCountry ,userPassword;
        int id = 0;

        userName = binding.edusername.getText().toString();
        userEmail = binding.edemail.getText().toString();
        userCountry = binding.edcountry.getText().toString();
        userPassword = binding.edpassword.getText().toString();
                   if (binding.submitbtn.getText().equals("submit")){

                       saveData(userName,userEmail,userCountry,userPassword);
                   }else {
                       saveUserData(id,userName,userEmail,userCountry,userPassword);
                   }










    }

    private void saveUserData(int id, String userName, String userEmail, String userCountry, String userPassword) {

        uaserentity.setUserName(userName);
        uaserentity.setUserEmail(userEmail);
        uaserentity.setUserCountry(userCountry);
        uaserentity.setUserPassword(userPassword);

        User_Database.getDatabase(getApplicationContext()).getUserDAO().updateUser(uaserentity);
        fileList();
    }


    //====================================================

    private void saveData(String userName, String userEmail, String userCountry, String userPassword) {


        User_Entity user_entity= new User_Entity();
        user_entity.setUserName(userName);
        user_entity.setUserEmail(userEmail);
        user_entity.setUserCountry(userCountry);
        user_entity.setUserPassword(userPassword);

        User_Database.getDatabase(getApplicationContext()).getUserDAO().insertUser(user_entity);
        fileList();



    }

    @Override
    public void onBackPressed() {
       // super.onBackPressed();

        new AlertDialog.Builder(User_Input.this)
                .setTitle("Conform Exit!!")
                .setMessage(" Do you really want to Exit ?")
                .setIcon(R.drawable.alert_icon)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                })

                .setPositiveButton("Yes,Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finishAndRemoveTask();
                    }
                })

                .show();
    }

    //====================================================
}