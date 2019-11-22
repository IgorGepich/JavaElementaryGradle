package lesson17;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface GitHubService {
	@GET("users/{IgorGepich}/repos")
	Call<String> listRepos(@Path("IgorGepich") String user);
}
