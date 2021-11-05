package com.dvillage.taxreturnbd.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dvillage.taxreturnbd.R;
import com.dvillage.taxreturnbd.model.A24Model;
import com.dvillage.taxreturnbd.model.Methods;

import java.util.List;

public class A24Adapter extends RecyclerView.Adapter<A24Adapter.VH> {
    private Context context;
    private List<A24Model> modelList;

    public A24Adapter(Context context, List<A24Model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public A24Adapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_a24_cv, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull A24Adapter.VH holder, int position) {
        A24Model a24Model = modelList.get(position);
        String particular = a24Model.getParticular();
        long amount = a24Model.getAmount();
        long exempted = a24Model.getExempted();
        long taxable = a24Model.getTaxable();
        
        holder.setData(particular,amount, exempted, taxable);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        private TextView tv_particular, tv_amount, tv_exempted, tv_taxable;
        public VH(@NonNull View itemView) {
            super(itemView);
            tv_particular = itemView.findViewById(R.id.tv_particular);
            tv_amount = itemView.findViewById(R.id.tv_amount);
            tv_exempted = itemView.findViewById(R.id.tv_exempted);
            tv_taxable = itemView.findViewById(R.id.tv_taxable);
        }

        public void setData(String particular, long amount, long exempted, long taxable) {
            tv_particular.setText(particular);
            tv_amount.setText(Methods.indianCurrencyFormat(amount));
            tv_exempted.setText(Methods.indianCurrencyFormat(exempted));
            tv_taxable.setText(Methods.indianCurrencyFormat(taxable));
        }
    }
}
