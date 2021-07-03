package responsi.miftahuraziz.covidjabar.service;

import responsi.miftahuraziz.covidjabar.model.hospital.HospitalResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HospitalRepository {
    @GET("sebaran_v2/jabar/faskes")
    Call<HospitalResponse> getHospital();
}
