package com.example.readquest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DetailsActivity extends AppCompatActivity {

    private ImageView bookimage;
    private TextView booktitle;
    private TextView authorname;
    private TextView genre;
    private TextView publicationYear;
    private TextView bookdesc;
    private RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        bookimage = findViewById(R.id.bookimage);
        booktitle = findViewById(R.id.booktitle);
        authorname = findViewById(R.id.authorname);
        genre = findViewById(R.id.genre);
        publicationYear = findViewById(R.id.publicationYear);
        bookdesc = findViewById(R.id.bookdesc);
        ratingBar = findViewById(R.id.ratingBar);

        List<Float> ratingRandom = new ArrayList<>();
        ratingRandom.add(3.0F);
        ratingRandom.add(3.5F);
        ratingRandom.add(4.0F);
        ratingRandom.add(4.5F);
        ratingRandom.add(5.0F);

        int randomIndex = (int) (Math.random() * ratingRandom.size());
        float randomRating = ratingRandom.get(randomIndex);

        ratingBar.setRating(randomRating);


        Intent intent = getIntent();
        String bookTitle = intent.getStringExtra("title");
        String authorName = intent.getStringExtra("author");
        String[] genres = intent.getStringArrayExtra("genre");
        String publicationYears = intent.getStringExtra("published");
        String bookDesc = intent.getStringExtra("description");
        int bookImageview = intent.getIntExtra("image", -1);

        booktitle.setText(bookTitle);
        authorname.setText(authorName);
        if (genres != null) {
            String genresString = String.join(", ", genres);
            genre.setText(genresString);
        }
        publicationYear.setText(publicationYears);
        bookdesc.setText(bookDesc);
//        bookimage.setImageResource(bookImageview);
    }


}