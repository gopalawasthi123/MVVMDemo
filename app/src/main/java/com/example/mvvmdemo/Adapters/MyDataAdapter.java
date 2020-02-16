package com.example.mvvmdemo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmdemo.Model.Posts;
import com.example.mvvmdemo.Model.User;
import com.example.mvvmdemo.R;

import java.util.List;

public class MyDataAdapter extends RecyclerView.Adapter {

    private Context context;
//    private List<Posts> posts;
    private List<User> users;

    public MyDataAdapter(Context context,List<User> users  /*List<Posts> posts*/) {

        this.context = context;
  //      this.posts = posts;
        this.users = users;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);

        PostsViewHolder postsViewHolder = new PostsViewHolder(view);

        return postsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        final  int pos = i;

        PostsViewHolder holder =(PostsViewHolder) viewHolder;
        //holder.poststext.setText(posts.get(i).getTitle());
        holder.poststext.setText(users.get(i).getName());

        holder.poststext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Position"+ pos,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class PostsViewHolder extends RecyclerView.ViewHolder{

        View itemView;
        TextView poststext;

        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            poststext = itemView.findViewById(R.id.textpost);
        }
    }
}
