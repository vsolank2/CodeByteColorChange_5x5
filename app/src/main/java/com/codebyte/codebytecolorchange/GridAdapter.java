package com.codebyte.codebytecolorchange;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.BtnHolder> {

    Context context;
    ClsBtnPosition[] myClsBtns;

    public interface OnClickListener {
        void onClick(ClsBtnPosition btnPosition);
    }

    OnClickListener onClickListener;

    public GridAdapter(ClsBtnPosition[] myClsBtns, Context context, OnClickListener onClickListener) {
        this.myClsBtns = myClsBtns;
        this.context = context;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public BtnHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_grid, parent, false);
        BtnHolder btnHolder = new BtnHolder(listItem);
        return btnHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BtnHolder holder, int position) {
        holder.llGrid.setBackgroundColor(context.getResources().getColor(myClsBtns[position].getColor()));

        holder.llGrid.setOnClickListener(v -> onClickListener.onClick(myClsBtns[position]));
    }

    @Override
    public int getItemCount() {
        return myClsBtns.length;
    }

    public class BtnHolder extends RecyclerView.ViewHolder {

        LinearLayout llGrid;
        public BtnHolder(@NonNull View itemView) {
            super(itemView);
            llGrid = itemView.findViewById(R.id.llGrid);
        }
    }
}
