package com.example.readquest;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    public List<Book> categoryList;

    public CategoryAdapter(List<Book> categoryList) {
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {
        Book category = categoryList.get(position);
        holder.bookName.setText(category.getTitle());
        holder.bookAuthor.setText(category.getAuthor());
        setBookImage(category, holder.BookImage);

        holder.BookImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.BookImage.getContext(), DetailsActivity.class);
                intent.putExtra("image", category.getCover_image());
                intent.putExtra("title", category.getTitle());
                intent.putExtra("author", category.getAuthor());
                intent.putExtra("description", category.getDescription());
                intent.putExtra("genre", category.getGenre());
                intent.putExtra("published", category.getPublication_year());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        private ImageView BookImage;
        private TextView bookName;
        private TextView bookAuthor;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            BookImage = itemView.findViewById(R.id.bookImage);
            bookName = itemView.findViewById(R.id.bookTitle);
            bookAuthor = itemView.findViewById(R.id.bookAuthor);
        }
    }

    private void setBookImage(Book book, ImageView imageView) {
        if (book.getId() == 1) {
            Picasso.get().load(R.drawable.satu).resize(200, 300).into(imageView);
        } else if (book.getId() == 2) {
            Picasso.get().load(R.drawable.dua).resize(200, 300).into(imageView);
        } else if (book.getId() == 3) {
            Picasso.get().load(R.drawable.tiga).resize(200, 300).into(imageView);
        } else if (book.getId() == 4) {
            Picasso.get().load(R.drawable.empat).resize(200, 300).into(imageView);
        } else if (book.getId() == 5) {
            Picasso.get().load(R.drawable.lima).resize(200, 300).into(imageView);
        } else if (book.getId() == 6) {
            Picasso.get().load(R.drawable.enam).resize(200, 300).into(imageView);
        } else if (book.getId() == 7) {
            Picasso.get().load(R.drawable.tuju).resize(200, 300).into(imageView);
        } else if (book.getId() == 8) {
            Picasso.get().load(R.drawable.delapa).resize(200, 300).into(imageView);
        } else if (book.getId() == 9) {
            Picasso.get().load(R.drawable.sembilan).resize(200, 300).into(imageView);
        } else if (book.getId() == 10) {
            Picasso.get().load(R.drawable.sepuluh).resize(200, 300).into(imageView);
        } else if (book.getId() == 11) {
            Picasso.get().load(R.drawable.sebelas).resize(200, 300).into(imageView);
        } else if (book.getId() == 12) {
            Picasso.get().load(R.drawable.duabelas).resize(200, 300).into(imageView);
        } else if (book.getId() == 13) {
            Picasso.get().load(R.drawable.tigabelas).resize(200, 300).into(imageView);
        } else if (book.getId() == 14) {
            Picasso.get().load(R.drawable.empatbelas).resize(200, 300).into(imageView);
        } else if (book.getId() == 15) {
            Picasso.get().load(R.drawable.limabelas).resize(200, 300).into(imageView);
        } else if (book.getId() == 16) {
            Picasso.get().load(R.drawable.enambelas).resize(200, 300).into(imageView);
        } else if (book.getId() == 17) {
            Picasso.get().load(R.drawable.tujuhbelas).resize(200, 300).into(imageView);
        } else if (book.getId() == 18) {
            Picasso.get().load(R.drawable.delapanbelas).resize(200, 300).into(imageView);
        } else if (book.getId() == 19) {
            Picasso.get().load(R.drawable.sembilanbelas).resize(200, 300).into(imageView);
        } else if (book.getId() == 20) {
            Picasso.get().load(R.drawable.duapuluh).resize(200, 300).into(imageView);
        } else if (book.getId() == 21) {
            Picasso.get().load(R.drawable.duasatu).resize(200, 300).into(imageView);
        } else if (book.getId() == 22) {
            Picasso.get().load(R.drawable.duadua).resize(200, 300).into(imageView);
        } else if (book.getId() == 23) {
            Picasso.get().load(R.drawable.duatiga).resize(200, 300).into(imageView);
        } else if (book.getId() == 24) {
            Picasso.get().load(R.drawable.duaempat).resize(200, 300).into(imageView);
        } else if (book.getId() == 25) {
            Picasso.get().load(R.drawable.dualima).resize(200, 300).into(imageView);
        } else if (book.getId() == 26) {
            Picasso.get().load(R.drawable.duaenam).resize(200, 300).into(imageView);
        } else if (book.getId() == 27) {
            Picasso.get().load(R.drawable.duatujuh).resize(200, 300).into(imageView);
        } else if (book.getId() == 28) {
            Picasso.get().load(R.drawable.duadelapan).resize(200, 300).into(imageView);
        } else if (book.getId() == 29) {
            Picasso.get().load(R.drawable.duasembilan).resize(200, 300).into(imageView);
        } else if (book.getId() == 30) {
            Picasso.get().load(R.drawable.tigapuluh).resize(200, 300).into(imageView);
        } else if (book.getId() == 31) {
            Picasso.get().load(R.drawable.tigasatu).resize(200, 300).into(imageView);
        } else if (book.getId() == 32) {
            Picasso.get().load(R.drawable.tiga).resize(200, 300).into(imageView);
        } else if (book.getId() == 33) {
            Picasso.get().load(R.drawable.tigatiga).resize(200, 300).into(imageView);
        } else if (book.getId() == 34) {
            Picasso.get().load(R.drawable.tigaempat).resize(200, 300).into(imageView);
        } else if (book.getId() == 35) {
            Picasso.get().load(R.drawable.tigalima).resize(200, 300).into(imageView);
        } else if (book.getId() == 36) {
            Picasso.get().load(R.drawable.tigaenam).resize(200, 300).into(imageView);
        } else if (book.getId() == 37) {
            Picasso.get().load(R.drawable.tigatujuh).resize(200, 300).into(imageView);
        } else if (book.getId() == 38) {
            Picasso.get().load(R.drawable.tigadelapan).resize(200, 300).into(imageView);
        } else if (book.getId() == 39) {
            Picasso.get().load(R.drawable.tigasembilan).resize(200, 300).into(imageView);
        } else if (book.getId() == 40) {
            Picasso.get().load(R.drawable.empatpuluh).resize(200, 300).into(imageView);
        } else if (book.getId() == 41) {
            Picasso.get().load(R.drawable.empatsatu).resize(200, 300).into(imageView);
        } else if (book.getId() == 42) {
            Picasso.get().load(R.drawable.empatdua).resize(200, 300).into(imageView);
        } else if (book.getId() == 43) {
            Picasso.get().load(R.drawable.empattiga).resize(200, 300).into(imageView);
        } else if (book.getId() == 44) {
            Picasso.get().load(R.drawable.empatempat).resize(200, 300).into(imageView);
        } else if (book.getId() == 45) {
            Picasso.get().load(R.drawable.empatlima).resize(200, 300).into(imageView);
        } else if (book.getId() == 46) {
            Picasso.get().load(R.drawable.empatenam).resize(200, 300).into(imageView);
        } else if (book.getId() == 47) {
            Picasso.get().load(R.drawable.empattujuh).resize(200, 300).into(imageView);
        } else if (book.getId() == 48) {
            Picasso.get().load(R.drawable.empatenam).resize(200, 300).into(imageView);
        } else if (book.getId() == 49) {
            Picasso.get().load(R.drawable.empatsembilan).resize(200, 300).into(imageView);
        } else if (book.getId() == 50) {
            Picasso.get().load(R.drawable.limapuluh).resize(200, 300).into(imageView);
        }
    }
}