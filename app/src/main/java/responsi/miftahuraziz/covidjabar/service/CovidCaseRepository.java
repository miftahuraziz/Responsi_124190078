package responsi.miftahuraziz.covidjabar.service;

import responsi.miftahuraziz.covidjabar.model.covidcase.CovidCaseResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidCaseRepository {
    @GET("rekapitulasi_v2/jabar/harian")
    Call<CovidCaseResponse> getCovidCase();
}
