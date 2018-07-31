package com.priya.ola.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.priya.ola.R;

import java.util.ArrayList;
import java.util.List;

public class RideAdapter extends RecyclerView.Adapter<RideAdapter.Rideholder> {


    private Activity activity;
    private ArrayList<RideAdapter>rideAdapters;
    public RideAdapter(ArrayList<RideAdapter>rideAdapters,Activity activity) {
        this.activity = activity;
        this.rideAdapters = rideAdapters;

    }

    @NonNull
    @Override
    public RideAdapter.Rideholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.ride_adapter,parent,false);
        Rideholder rideholder=new Rideholder(view);
        return rideholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RideAdapter.Rideholder holder, int position) {
        holder.id.setText(rideAdapters.get(position).getid());
        holder.SourceAddress.setText((rideAdapters.get(position).getSourceAddress());
        holder.DestinationAdress.setText((rideAdapters.get(position).getDestinationAddress());
        holder.DriverName.setText((rideAdapters.get(position).getDriverName());
        holder.VehicleType.setText((rideAdapters.get(position).getVehicleType());
        holder.InvoiceReference.setText((rideAdapters.get(position).getInvoiceRefrerence());
        holder.Total.setText((rideAdapters.get(position).getTotal());

    }

    @Override
    public void onBindViewHolder(@NonNull RideAdapter.Rideholder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemCount() {

        return rideAdapters.size();
    }
class Rideholder extends RecyclerView.ViewHolder{

        TextView id;
        TextView SourceAddress;
        TextView DestinationAdress;
        TextView DriverName;
        TextView VehicleType;
        TextView InvoiceReference;
        TextView Total;
}

    public Rideholder(View itemView) {
        super(itemView);
        id=itemView.findViewById(R.id.IdTv);
        SourceAddress=itemView.findViewById(R.id.sourceAddress);
        DestinationAddress=itemView.findViewById(R.id.DestinationAddress);
        DriverName=itemView.findViewById(R.id.drivername);
        VehicleType=itemView.findViewById(R.id.vehicletype);
        InvoiceReference=itemView.findViewById(R.id.invoicereference);
        Total=itemView.findViewById(R.id.totalfare);

    }
}
