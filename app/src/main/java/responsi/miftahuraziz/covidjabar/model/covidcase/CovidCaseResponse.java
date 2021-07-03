package responsi.miftahuraziz.covidjabar.model.covidcase;

import com.google.gson.annotations.SerializedName;

public class CovidCaseResponse{

	@SerializedName("status_code")
	private Integer statusCode;

	@SerializedName("data")
	private Data data;

	public void setStatusCode(Integer statusCode){
		this.statusCode = statusCode;
	}

	public Integer getStatusCode(){
		return statusCode;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"CovidCaseResponse{" + 
			"status_code = '" + statusCode + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}