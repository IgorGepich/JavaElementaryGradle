package lesson17;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;

public class MainLesson17 {
	public static void main(String[] args) {

		// First
		final  Retrofit retrofit = new Retrofit.Builder()
				.addConverterFactory(ScalarsConverterFactory.create())
				.baseUrl("https://api.github.com")
				.build();
		final GitHubService service = retrofit.create(GitHubService.class);

		Response<String> response = null;
		try {
			Call<String> request = service.listRepos("IgorGepich");
			response = request.execute(); // метод синхронного выполнения запроса
		} catch (IOException e){
			System.err.println("Failed to make request to github: " + e.getMessage());
		}

		// process the response
		if (response != null){
			if(response.isSuccessful()){
				// successful response
				String responseBody = response.body();
				System.out.println("Body: " + responseBody);
			}
			else {
				// failed response
				try {
					String errorBody = response.errorBody().string();
					System.err.println("Server responded with error: " + errorBody);
				} catch (IOException e){
					System.err.println("Failed to get error body: " + e.getMessage());
				}
			}
		}
		//END First

		// Second
		GoogleWebService googleService = new Retrofit.Builder()
				.baseUrl("https://google.com/")
				.addConverterFactory(ScalarsConverterFactory. create())
				.build()
				.create(GoogleWebService.class);
		Response<String> responseGoogle = null;
		try {
			responseGoogle = googleService.indexGoogle().execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(responseGoogle);
		// END Second

		//Third
//		final TinyUrlService service1 = new Retrofit.Builder()
//				.baseUrl( "http://tiny-url.info/api/v1/")
//				.addConverterFactory(GsonConverterFactory. create())
//				.build()
//				.create(TinyUrlService. class);
//		Response<TinyUrlResponse> response1;
//		response = service1.random( "json", "http://tiny-url.info/open_api.html").execute();
//		if (response != null && response.isSuccessful()) {
//			System. out.println(response1.body().shortUrl);
//		} else if (response != null) {
//			System. out.println(response.errorBody().string());
//		}
	}
}
