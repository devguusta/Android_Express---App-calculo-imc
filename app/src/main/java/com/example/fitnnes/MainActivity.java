package com.example.fitnnes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        View btnImc = findViewById(R.id.btn_imc);

        rvMain = findViewById(R.id.main_rv);

        List<MainItem> mainItens = new ArrayList<MainItem>();
        mainItens.add(new MainItem(1, R.drawable.ic_baseline_wb_sunny_24, R.string.imc, Color.GREEN));
        mainItens.add(new MainItem(2, R.drawable.ic_baseline_visibility_24, R.string.tmb, Color.RED));


        rvMain.setLayoutManager(new LinearLayoutManager(this));

        MainAdapter adapter = new MainAdapter(mainItens);
        rvMain.setAdapter(adapter);
//        btnImc.setOnClickListener(view -> {
//            Intent intent = new Intent(MainActivity.this, ImcActivity.class);
//            startActivity(intent);
//
//        });


    }

    private class MainAdapter extends RecyclerView.Adapter<MainViewHolder>{

        private List<MainItem> mainItems;

        public MainAdapter(List<MainItem> mainItems){
            this.mainItems = mainItems;
        }


        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainViewHolder(getLayoutInflater().inflate(R.layout.main_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
       MainItem currentMainItem =    mainItems.get(position);
            holder.bind(currentMainItem);
        }

        @Override
        public int getItemCount() {
            return mainItems.size();
        }
    }


    private class MainViewHolder extends RecyclerView.ViewHolder{
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

        }

        public void bind(MainItem item){
            TextView textView =    itemView.findViewById(R.id.item_txt_name);
            ImageView imageView =    itemView.findViewById(R.id.item_img_icon);
            LinearLayout container  = (LinearLayout)  itemView;
            textView.setText(item.getTextStringId());
            imageView.setImageResource(item.getDrawableId());
            container.setBackgroundColor(item.getColor());
        }

    }
}