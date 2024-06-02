package com.example.readquest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class PostViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<Post>> posts = new MutableLiveData<>(new ArrayList<>());

    public LiveData<ArrayList<Post>> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        ArrayList<Post> currentPosts = posts.getValue();
        if (currentPosts != null) {
            currentPosts.add(post);
            posts.setValue(currentPosts);
        }
    }
}
