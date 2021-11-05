package com.dvillage.taxreturnbd.adapter;

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
import com.dvillage.taxreturnbd.model.TaxYearModel;
import com.dvillage.taxreturnbd.view.FormActivity;

import java.util.List;

public class TaxYearAdapter extends RecyclerView.Adapter<TaxYearAdapter.VH> {
    private Context context;
    private List<TaxYearModel> modelList;

    public TaxYearAdapter(Context context, List<TaxYearModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public TaxYearAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_tax_year_cv, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaxYearAdapter.VH holder, int position) {
        TaxYearModel taxYearModel = modelList.get(position);
        String taxYear = taxYearModel.getTax_year();
        String taxYearText = taxYearModel.getTax_year_text();

        holder.setData(taxYear, taxYearText);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), FormActivity.class);
                intent.putExtra("tax_year", taxYear);
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class VH extends RecyclerView.ViewHolder{
        private TextView taxYear_tv;
        private TextView taxYearText_tv;
        private ImageView next_iv;

        public VH(@NonNull View itemView) {
            super(itemView);
            taxYear_tv = itemView.findViewById(R.id.tax_year);
            taxYearText_tv = itemView.findViewById(R.id.tax_year_text);
            next_iv = itemView.findViewById(R.id.iv_next);
        }

        public void setData(String taxYear, String taxYearText) {
            taxYear_tv.setText(taxYear);
            taxYear_tv.setTextColor(Color.rgb(17,161, 12));
            taxYearText_tv.setText(taxYearText);
            next_iv.setColorFilter(Color.rgb(17,161, 12));
        }
    }
}
