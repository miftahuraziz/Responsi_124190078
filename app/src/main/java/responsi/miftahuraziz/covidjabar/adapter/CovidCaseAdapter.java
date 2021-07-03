package responsi.miftahuraziz.covidjabar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import responsi.miftahuraziz.covidjabar.R;
import responsi.miftahuraziz.covidjabar.model.covidcase.CovidCaseItem;

public class CovidCaseAdapter extends RecyclerView.Adapter<CovidCaseAdapter.ViewHolder> {

    private ArrayList<CovidCaseItem> covidCaseItems = new ArrayList<>();
    private Context context;

    public void setData(Context context, ArrayList<CovidCaseItem> items) {
        this.context = context;

        covidCaseItems.clear();
        covidCaseItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_covid_case_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidCaseAdapter.ViewHolder holder, int position) {
        holder.tvDate.setText(covidCaseItems.get(position).getTanggal());
        holder.tvNumberConfirm.setText(covidCaseItems.get(position).getConfirmationDiisolasi().toString()+" kasus");
        holder.tvNumberRecover.setText(covidCaseItems.get(position).getConfirmationSelesai().toString());
        holder.tvNumberDied.setText(covidCaseItems.get(position).getConfirmationMeninggal().toString()+" kasus");
    }

    @Override
    public int getItemCount() {
        return covidCaseItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate, tvConfirm, tvRecover, tvDied ,tvNumberConfirm, tvNumberRecover, tvNumberDied;
        LinearLayout llDate;
        RelativeLayout rlDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            llDate = itemView.findViewById(R.id.ll_date);
            rlDetail = itemView.findViewById(R.id.rl_detail);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvConfirm = itemView.findViewById(R.id.tv_confirm);
            tvRecover = itemView.findViewById(R.id.tv_recover);
            tvDied = itemView.findViewById(R.id.tv_died);
            tvNumberConfirm = itemView.findViewById(R.id.tv_number_confirm);
            tvNumberRecover = itemView.findViewById(R.id.tv_number_recover);
            tvNumberDied = itemView.findViewById(R.id.tv_number_died);
        }
    }
}
