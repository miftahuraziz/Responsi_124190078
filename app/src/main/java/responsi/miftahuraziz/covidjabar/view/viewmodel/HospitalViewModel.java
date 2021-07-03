package responsi.miftahuraziz.covidjabar.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import responsi.miftahuraziz.covidjabar.model.hospital.HospitalItem;
import responsi.miftahuraziz.covidjabar.model.hospital.HospitalResponse;
import responsi.miftahuraziz.covidjabar.service.ApiMain;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HospitalViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<HospitalItem>> listHospital = new MutableLiveData<>();

    public void setHospital(){
        if (this.apiMain == null) {
            apiMain = new ApiMain();
        }

        apiMain.getApiHospital().getHospital().enqueue(new Callback<HospitalResponse>() {
            @Override
            public void onResponse(Call<HospitalResponse> call, Response<HospitalResponse> response) {
                HospitalResponse hospitalResponse = response.body();
                if (hospitalResponse != null && hospitalResponse.getData() != null) {
                    ArrayList<HospitalItem> hospitalItems = hospitalResponse.getData();
                    listHospital.postValue(hospitalItems);
                }
            }

            @Override
            public void onFailure(Call<HospitalResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<HospitalItem>> getHospital() {
        return listHospital;
    }
}
