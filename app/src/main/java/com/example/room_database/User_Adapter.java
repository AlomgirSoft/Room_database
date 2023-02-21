package com.example.room_database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class User_Adapter extends RecyclerView.Adapter<User_ViewHolder> {

   private Context context;
   private List<User_Entity>getUserList;
   private  UserLisetener userLisetener;

    public User_Adapter(Context context, List<User_Entity> getUserList, UserLisetener userLisetener) {
        this.context = context;
        this.getUserList = getUserList;
        this.userLisetener = userLisetener;
    }

    @NonNull
    @Override
    public User_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_user_data,parent,false);
        User_ViewHolder user_viewHolder= new User_ViewHolder(view);



        return user_viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull User_ViewHolder holder, int position) {

    String userNameget,userEmailGet,userCountry;

        User_Entity user_entity = getUserList.get(position);

        Integer   id  = user_entity.getId();

       userNameget= user_entity.getUserName();
        userEmailGet= user_entity.getUserEmail();
        userCountry= user_entity.getUserCountry();



        holder.userName.setText(userNameget);
        holder.userEmail.setText(userEmailGet);
        holder.userCountry.setText(userCountry);
        holder.id.setText(id.toString());

   //=================button ClickListener==================================

        holder.editbtn.setOnClickListener(v->{
           userLisetener.editUser(user_entity );


        });

        holder.deletebtn.setOnClickListener(v->{
            userLisetener.deleteUser(user_entity);

        });

    }

    //===============button ClickListener End ======================

    @Override
    public int getItemCount() {
        return getUserList.size();
    }
}
