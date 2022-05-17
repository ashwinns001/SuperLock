package com.sqt.superlock.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sqt.superlock.R;
import com.sqt.superlock.data.BleDevice;

import java.util.ArrayList;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder>{
ArrayList <BleDevice> bleDeviceArrayList =new ArrayList<>();

// RecyclerView recyclerView;
public MainListAdapter(ArrayList< BleDevice > bleDeviceArrayList) {
        this.bleDeviceArrayList = bleDeviceArrayList;
        }
@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_main, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
        }

@Override
public void onBindViewHolder(ViewHolder holder, int position) {
final BleDevice bleDevice = bleDeviceArrayList.get(position);
if (bleDeviceArrayList.get(position).getName()==null)
    holder.item_name.setText("UnNamed");
else
    holder.item_name.setText(bleDeviceArrayList.get(position).getName());
    holder.item_mac.setText(bleDeviceArrayList.get(position).getMac());

        }


@Override
public int getItemCount() {
        return bleDeviceArrayList.size();
        }

public static class ViewHolder extends RecyclerView.ViewHolder {
    public TextView item_name;
    public TextView item_mac;
    public ViewHolder(View itemView) {
        super(itemView);
       item_name=itemView.findViewById(R.id.tv_name);
        item_mac=itemView.findViewById(R.id.tv_mac);
    }
}
}
