package com.example.readquest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class PostingFragment extends Fragment {

    private ImageView addimgbook;
    private EditText addBooktitle;
    private EditText addAuthor;
    private Button submitpost;
    Uri uriGambar;
    Boolean cekGambar = false;
    private PostViewModel postViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addimgbook = view.findViewById(R.id.addimgbook);
        addBooktitle = view.findViewById(R.id.addBooktitle);
        addAuthor = view.findViewById(R.id.addAuthor);
        submitpost = view.findViewById(R.id.submitpost);

        postViewModel = new ViewModelProvider(requireActivity()).get(PostViewModel.class);

        ActivityResultLauncher<Intent> intentLaunch = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        uriGambar = result.getData().getData();
                        addimgbook.setImageURI(uriGambar);
                        cekGambar = true;
                    }
                }
        );

        addimgbook.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            intentLaunch.launch(intent);
        });

        submitpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = addBooktitle.getText().toString();
                String author = addAuthor.getText().toString();

                if (title.isEmpty() || author.isEmpty()){
                    Toast.makeText(getContext(), "Isi field yang kosong", Toast.LENGTH_SHORT).show();
                } else if (!cekGambar) {
                    Toast.makeText(getContext(), "Silahkan pilih gambar", Toast.LENGTH_SHORT).show();
                } else {
                    Post post = new Post(title, author, uriGambar);
                    postViewModel.addPost(post);
                    Toast.makeText(getContext(), "Post Berhasil", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
