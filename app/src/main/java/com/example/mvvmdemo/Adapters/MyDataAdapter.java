package com.example.mvvmdemo.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvvmdemo.Model.Posts;
import com.example.mvvmdemo.R;

import java.util.List;

public class MyDataAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Posts> posts;

    public MyDataAdapter(Context context, List<Posts> posts) {

        this.context = context;
        this.posts = posts;
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

        PostsViewHolder holder =(PostsViewHolder) viewHolder;
        holder.poststext.setText(posts.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return posts.size();
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
