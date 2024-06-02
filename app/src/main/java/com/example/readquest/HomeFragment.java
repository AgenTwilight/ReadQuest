package com.example.readquest;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private BottomNavigationView bottomnav;
    private RecyclerView recyclerView, recyclerView2, recyclerView3, recyclerView4, recyclerView5, recyclerView6, recyclerView7, recyclerView8;
    private BookAdapter bookAdapter;
    private RecyclerView categoryView;
    private ApiService apiService;
    private List<Book> bookList;
    private CategoryAdapter categoryAdapter, categoryAdapter2, categoryAdapter3, categoryAdapter4, categoryAdapter5, categoryAdapter6, categoryAdapter7, categoryAdapter8;
    MaterialButton SeeAllBtn1, SeeAllBtn2, SeeAllBtn3, SeeAllBtn4, SeeAllBtn5, SeeAllBtn6, SeeAllBtn7, SeeAllBtn8;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        apiService = RetrofitClient.getClient().create(ApiService.class);
        SeeAllBtn1 = view.findViewById(R.id.SeeAllBtn1);
        SeeAllBtn2 = view.findViewById(R.id.SeeAllBtn2);
        SeeAllBtn3 = view.findViewById(R.id.SeeAllBtn3);
        SeeAllBtn4 = view.findViewById(R.id.SeeAllBtn4);
        SeeAllBtn5 = view.findViewById(R.id.SeeAllBtn5);
        SeeAllBtn6 = view.findViewById(R.id.SeeAllBtn6);
        SeeAllBtn7 = view.findViewById(R.id.SeeAllBtn7);
        SeeAllBtn8 = view.findViewById(R.id.SeeAllBtn8);

        categoryView = view.findViewById(R.id.rv_filterPublisher);
        categoryView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerView2 = view.findViewById(R.id.rv_filterPublisher2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerView3 = view.findViewById(R.id.rv_filterPublisher3);
        recyclerView3.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerView4 = view.findViewById(R.id.rv_filterPublisher4);
        recyclerView4.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerView5 = view.findViewById(R.id.rv_filterPublisher5);
        recyclerView5.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerView6 = view.findViewById(R.id.rv_filterPublisher6);
        recyclerView6.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerView7 = view.findViewById(R.id.rv_filterPublisher7);
        recyclerView7.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerView8 = view.findViewById(R.id.rv_filterPublisher8);
        recyclerView8.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        SeeAllBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toFiction = new Intent(getContext(), CategoryDetail.class);
                toFiction.putExtra("categori", "Fiction");
                startActivity(toFiction);

            }
        });

        SeeAllBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toFiction = new Intent(getContext(), CategoryDetail.class);
                toFiction.putExtra("categori", "Classic");
                startActivity(toFiction);

            }
        });

        SeeAllBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toFiction = new Intent(getContext(), CategoryDetail.class);
                toFiction.putExtra("categori", "Dystopian");
                startActivity(toFiction);

            }
        });

        SeeAllBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toFiction = new Intent(getContext(), CategoryDetail.class);
                toFiction.putExtra("categori", "Science Fiction");
                startActivity(toFiction);

            }
        });

        SeeAllBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toFiction = new Intent(getContext(), CategoryDetail.class);
                toFiction.putExtra("categori", "Romance");
                startActivity(toFiction);

            }
        });

        SeeAllBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toFiction = new Intent(getContext(), CategoryDetail.class);
                toFiction.putExtra("categori", "Adventure");
                startActivity(toFiction);

            }
        });

        SeeAllBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toFiction = new Intent(getContext(), CategoryDetail.class);
                toFiction.putExtra("categori", "Philosophical");
                startActivity(toFiction);

            }
        });

        SeeAllBtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toFiction = new Intent(getContext(), CategoryDetail.class);
                toFiction.putExtra("categori", "Mystery");
                startActivity(toFiction);

            }
        });


        Call<List<Book>> call = apiService.getBooks();

        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.isSuccessful()) {
                    List<Book> books = response.body();

                    List<Book> fictionBooks = new ArrayList<>();
                    for (Book book : books) {
                        String[] genres = book.getGenre();
                        if (genres != null && Arrays.asList(genres).contains("Fiction")) {
                            fictionBooks.add(book);
                        }
                    }

                    List<Book> classicBooks = new ArrayList<>();
                    for (Book book : books) {
                        String[] genres = book.getGenre();
                        if (genres != null && Arrays.asList(genres).contains("Classic")) {
                            classicBooks.add(book);
                        }
                    }

                    List<Book> Dystopian = new ArrayList<>();
                    for (Book book : books) {
                        String[] genres = book.getGenre();
                        if (genres != null && Arrays.asList(genres).contains("Dystopian")) {
                            Dystopian.add(book);
                        }
                    }

                    List<Book> ScienceFiction = new ArrayList<>();
                    for (Book book : books) {
                        String[] genres = book.getGenre();
                        if (genres != null && Arrays.asList(genres).contains("Science Fiction")) {
                            ScienceFiction.add(book);
                        }
                    }

                    List<Book> Romance = new ArrayList<>();
                    for (Book book : books) {
                        String[] genres = book.getGenre();
                        if (genres != null && Arrays.asList(genres).contains("Romance")) {
                            Romance.add(book);
                        }
                    }

                    List<Book> Adventure = new ArrayList<>();
                    for (Book book : books) {
                        String[] genres = book.getGenre();
                        if (genres != null && Arrays.asList(genres).contains("Adventure")) {
                            Adventure.add(book);
                        }
                    }

                    List<Book> Philosophical = new ArrayList<>();
                    for (Book book : books) {
                        String[] genres = book.getGenre();
                        if (genres != null && Arrays.asList(genres).contains("Philosophical")) {
                            Philosophical.add(book);
                        }
                    }

                    List<Book> Mystery = new ArrayList<>();
                    for (Book book : books) {
                        String[] genres = book.getGenre();
                        if (genres != null && Arrays.asList(genres).contains("Mystery")) {
                            Mystery.add(book);
                        }
                    }


                    bookAdapter = new BookAdapter(books);

                    categoryAdapter = new CategoryAdapter(fictionBooks);
                    categoryAdapter2 = new CategoryAdapter(classicBooks);
                    categoryAdapter3 = new CategoryAdapter(Dystopian);
                    categoryAdapter4 = new CategoryAdapter(ScienceFiction);
                    categoryAdapter5 = new CategoryAdapter(Romance);
                    categoryAdapter6 = new CategoryAdapter(Adventure);
                    categoryAdapter7 = new CategoryAdapter(Philosophical);
                    categoryAdapter8 = new CategoryAdapter(Mystery);


                    recyclerView.setAdapter(bookAdapter);

                    categoryView.setAdapter(categoryAdapter);
                    recyclerView2.setAdapter(categoryAdapter2);
                    recyclerView3.setAdapter(categoryAdapter3);
                    recyclerView4.setAdapter(categoryAdapter4);
                    recyclerView5.setAdapter(categoryAdapter5);
                    recyclerView6.setAdapter(categoryAdapter6);
                    recyclerView7.setAdapter(categoryAdapter7);
                    recyclerView8.setAdapter(categoryAdapter8);
                } else {
                    // Handle the error case
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                // Handle the failure case
            }
        });
        return view;
    }

    public void categoryBooks(String category){
        apiService = RetrofitClient.getClient().create(ApiService.class);

        Call<List<Book>> call = apiService.getBooks();

        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.isSuccessful()) {
                    List<Book> books = response.body();
                    List<Book> filteredBooks = new ArrayList<>();

                    // Filter books by genre
                    for (Book book : books) {
                        String[] genres = book.getGenre();
                        if (genres != null && genres.length > 0) {
                            for (String genre : genres) {
                                if (category.equals(genre)) {
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
