package responsi.miftahuraziz.covidjabar.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import responsi.miftahuraziz.covidjabar.R;
import responsi.miftahuraziz.covidjabar.adapter.CovidCaseAdapter;
import responsi.miftahuraziz.covidjabar.model.covidcase.CovidCaseItem;
import responsi.miftahuraziz.covidjabar.view.viewmodel.CovidCaseViewModel;

public class CovidCaseFragment extends Fragment {
    private CovidCaseAdapter covidCaseAdapter;
    private RecyclerView recyclerView;
    private CovidCaseViewModel covidCaseViewModel;
    private Context context;
    private TextView tvName, tvNim, tvTitle;
    LinearLayout linearLayout;
    private LinearLayoutManager linearLayoutManager;

    public CovidCaseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_covid_case, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        context = view.getContext();
        linearLayout = view.findViewById(R.id.ll_fragment_covid_case);
        tvName = view.findViewById(R.id.tv_name);
        tvNim = view.findViewById(R.id.tv_nim);
        tvTitle = view.findViewById(R.id.tv_title);

        covidCaseAdapter = new CovidCaseAdapter();
        covidCaseAdapter.notifyDataSetChanged();

        recyclerView = view.findViewById(R.id.rv_fragment_covid_case);
        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        covidCaseViewModel = new ViewModelProvider(this).get(CovidCaseViewModel.class);
        covidCaseViewModel.setCovidCase();
        covidCaseViewModel.getCovidCase().observe(getViewLifecycleOwner(), getCovidCase);

        recyclerView.setAdapter(covidCaseAdapter);
    }

    private Observer<ArrayList<CovidCaseItem>> getCovidCase = new Observer<ArrayList<CovidCaseItem>>() {
        @Override
        public void onChanged(ArrayList<CovidCaseItem> covidCaseItems) {
            if (covidCaseItems != null) {
                covidCaseAdapter.setData(context, covidCaseItems);
            }
        }
    };
}