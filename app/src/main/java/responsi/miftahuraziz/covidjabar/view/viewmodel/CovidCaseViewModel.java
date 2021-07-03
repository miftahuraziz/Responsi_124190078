package responsi.miftahuraziz.covidjabar.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import responsi.miftahuraziz.covidjabar.model.covidcase.CovidCaseItem;
import responsi.miftahuraziz.covidjabar.model.covidcase.CovidCaseResponse;
import responsi.miftahuraziz.covidjabar.service.ApiMain;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CovidCaseViewModel extends ViewModel {
    private ApiMain apiMain;
    private MutableLiveData<ArrayList<CovidCaseItem>> listCovidCase = new MutableLiveData<>();

    public void setCovidCase(){
        if (this.apiMain == null) {
            apiMain = new ApiMain();
        }

        apiMain.getApiCovidCase().getCovidCase().enqueue(new Callback<CovidCaseResponse>() {
            @Override
            public void onResponse(Call<CovidCaseResponse> call, Response<CovidCaseResponse> response) {
                CovidCaseResponse covidCaseResponse = response.body();
                if (covidCaseResponse != null && covidCaseResponse.getData().getContent() != null) {
                    ArrayList<CovidCaseItem> covidCaseItems = covidCaseResponse.getData().getContent();
                    listCovidCase.postValue(covidCaseItems);
                }
            }

            @Override
            public void onFailure(Call<CovidCaseResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<CovidCaseItem>> getCovidCase() {
        return listCovidCase;
    }
}
