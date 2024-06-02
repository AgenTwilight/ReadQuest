package com.example.readquest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Post implements Parcelable {

    private String title;
    private String author;
    private Uri imageUri;

    public Post(String title, String author, Uri imageUri) {
        this.title = title;
        this.author = author;
        this.imageUri = imageUri;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    protected Post(Parcel in) {
        title = in.readString();
        author = in.readString();
        imageUri = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(author);
        dest.writeParcelable(imageUri, flags);
    }
}
