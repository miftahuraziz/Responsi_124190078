package responsi.miftahuraziz.covidjabar.model.hospital;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class HospitalResponse{
	@SerializedName("data")
	private ArrayList<HospitalItem> data;

	public void setData(ArrayList<HospitalItem> data){
		this.data = data;
	}

	public ArrayList<HospitalItem> getData(){
		return data;
	}

}