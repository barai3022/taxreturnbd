package com.dvillage.taxreturnbd.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dvillage.taxreturnbd.R;
import com.dvillage.taxreturnbd.model.FormModel;
import com.dvillage.taxreturnbd.view.A24Activity;
import com.dvillage.taxreturnbd.view.B10Activity;
import com.dvillage.taxreturnbd.view.B24Activity;
import com.dvillage.taxreturnbd.view.Bb10Activity;
import com.dvillage.taxreturnbd.view.C24Activity;
import com.dvillage.taxreturnbd.view.D24Activity;
import com.dvillage.taxreturnbd.view.Ga11Activity;

import java.util.List;

public class FormAdapter extends RecyclerView.Adapter<FormAdapter.VH> {
    private Context context;
    private List<FormModel> modelList;

    public FormAdapter(Context context, List<FormModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public FormAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_form_cv, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FormAdapter.VH holder, @SuppressLint("RecyclerView") int position) {
        FormModel formModel = modelList.get(position);
        String tin = formModel.getTin();
        String taxYear = formModel.getTax_year();
        String title = formModel.getTitle();
        String name = formModel.getName();
        String description = formModel.getDescription();

        holder.setData(title, description);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position) {
                    case 0:
                        customIntent (A24Activity.class);
                        break;
                    case 1:
                        customIntent (B24Activity.class);
                        break;
                    case 2:
                        customIntent (C24Activity.class);
                        break;
                    case 3:
                        customIntent (D24Activity.class);
                        break;
                    case 4:
                        customIntent (Ga11Activity.class);
                        break;
                    case 5:
                        customIntent (Bb10Activity.class);
                        break;
                    case 6:
                        customIntent (B10Activity.class);
                        break;
                }





            }

            private void customIntent(Class custom) {
                Intent intent = new Intent(holder.itemView.getContext(), custom);
                intent.putExtra("tin", tin);
                intent.putExtra("tax_year", taxYear);
                intent.putExtra("name", name);
                intent.putExtra("title", title);
                intent.putExtra("desc", description);
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class VH extends RecyclerView.ViewHolder {

        private TextView title_tv;
        private TextView description_tv;
        private ImageView next_iv;

        public VH(@NonNull View itemView) {
            super(itemView);

            title_tv = itemView.findViewById(R.id.tv_title);
            description_tv = itemView.findViewById(R.id.tv_description);
            next_iv = itemView.findViewById(R.id.iv_next);
        }

        public void setData(String title, String description) {
            title_tv.setText(title);
            title_tv.setTextColor(Color.rgb(0,0, 255));
            description_tv.setText(description);
            next_iv.setColorFilter(Color.rgb(0,0, 255));
        }
    }
}
