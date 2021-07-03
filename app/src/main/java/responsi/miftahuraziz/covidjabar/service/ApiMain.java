package responsi.miftahuraziz.covidjabar.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMain {
    private Retrofit retrofit;
    String BASE_URL = "https://covid19-public.digitalservice.id/api/v1/";

    public CovidCaseRepository getApiCovidCase() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(CovidCaseRepository.class);
    }

    public HospitalRepository getApiHospital() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(HospitalRepository.class);
    }
}
