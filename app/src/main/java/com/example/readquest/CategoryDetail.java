package com.example.readquest;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryDetail extends AppCompatActivity {
    private BottomNavigationView bottomnav;
    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;
    private ApiService apiService;
    private List<Book> bookList;
    MaterialButton btn_fiction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerViewDetail);

        apiService = RetrofitClient.getClient().create(ApiService.class);

        Call<List<Book>> call = apiService.getBooks();

        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.isSuccessful()) {
                    String genreDetail = getIntent().getStringExtra("categori");
                    List<Book> books = response.body();
                    List<Book> filteredBooks = new ArrayList<>();

                    // Filter books by genre
                    for (Book book : books) {
                        String[] genres = book.getGenre();
                        if (genres != null && genres.length > 0) {
                            for (String genre : genres) {
                                if (genreDetail.equals(genre)) {
                                    filteredBooks.add(book);
                                    break;
                                }
                            }
                        }
                    }

                    // Set the adapter with filtered books
                    bookAdapter = new BookAdapter(filteredBooks);
                    recyclerView.setAdapter(bookAdapter);
                } else {
                    // Handle the error case
                    Log.e("Books API", "Response not successful: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                // Handle the failure case
                Log.e("Books API", "Request failed: ", t);
            }
        });

    }
}