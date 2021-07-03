package responsi.miftahuraziz.covidjabar.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import responsi.miftahuraziz.covidjabar.R;
import responsi.miftahuraziz.covidjabar.model.hospital.HospitalItem;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.ViewHolder> {
    private ArrayList<HospitalItem> hospitalItems = new ArrayList<>();
    private Context context;

    public void setData(Context context, ArrayList<HospitalItem> items) {
        this.context = context;

        hospitalItems.clear();
        hospitalItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hospital_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HospitalAdapter.ViewHolder holder, int position) {
        holder.tvHospitalName.setText(hospitalItems.get(position).getNama());
        holder.tvDetailAddress.setText(hospitalItems.get(position).getAlamat());
        holder.btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+ Uri.encode(hospitalItems.get(position).getNama()));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                context.startActivity(mapIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hospitalItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvHospitalName, tvAddress, tvDetailAddress;
        Button btnMaps;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvHospitalName = itemView.findViewById(R.id.tv_hospital_name);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvDetailAddress = itemView.findViewById(R.id.tv_detail_address);
            btnMaps = itemView.findViewById(R.id.btn_maps);
        }
    }
}
