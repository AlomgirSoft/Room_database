package com.example.room_database;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class User_ViewHolder extends RecyclerView.ViewHolder {

    TextView id, userName,userEmail,userCountry,userPassword;
    ImageView editbtn,deletebtn;


    public User_ViewHolder(@NonNull View itemView) {
        super(itemView);


        id = itemView.findViewById(R.id.idtext);

        userName = itemView.findViewById(R.id.userName);
        userEmail= itemView.findViewById(R.id.userEmail);
        userCountry= itemView.findViewById(R.id.userCountry);
        userPassword= itemView.findViewById(R.id.userpassword);

        editbtn= itemView.findViewById(R.id.editbtn);
        deletebtn= itemView.findViewById(R.id.deletebtn);







    }
}
