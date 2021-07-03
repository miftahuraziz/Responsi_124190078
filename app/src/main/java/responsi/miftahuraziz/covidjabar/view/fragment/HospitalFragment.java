package responsi.miftahuraziz.covidjabar.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import responsi.miftahuraziz.covidjabar.R;
import responsi.miftahuraziz.covidjabar.adapter.HospitalAdapter;
import responsi.miftahuraziz.covidjabar.model.hospital.HospitalItem;
import responsi.miftahuraziz.covidjabar.view.viewmodel.HospitalViewModel;

public class HospitalFragment extends Fragment {
    private HospitalAdapter hospitalAdapter;
    private RecyclerView recyclerView;
    private HospitalViewModel hospitalViewModel;
    private Context context;

    public HospitalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hospital, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        context = view.getContext();

        hospitalAdapter = new HospitalAdapter();
        hospitalAdapter.notifyDataSetChanged();

        recyclerView = view.findViewById(R.id.rv_fragment_hospital);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        hospitalViewModel = new ViewModelProvider(this).get(HospitalViewModel.class);
        hospitalViewModel.setHospital();
        hospitalViewModel.getHospital().observe(getViewLifecycleOwner(), getHospital);

        recyclerView.setAdapter(hospitalAdapter);
    }

    private Observer<ArrayList<HospitalItem>> getHospital = new Observer<ArrayList<HospitalItem>>() {
        @Override
        public void onChanged(ArrayList<HospitalItem> hospitalItems) {
            if (hospitalItems != null) {
                hospitalAdapter.setData(context, hospitalItems);
            }
        }
    };
}