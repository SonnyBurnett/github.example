package Interface;

import Datamodel.GitHubEvent;
import Datamodel.GitHubRepos;
import Datamodel.GitHubUser;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface GitHubUserApi {

    @GET("users/{username}/repos")
    Call<List<GitHubRepos>> getReposByUser(@Path("username") String username);



    @GET("users/{username}")
    Call<GitHubUser> getUserByName(@Path("username") String username);

    @GET("users/{username}/events")
    Call<List<GitHubEvent>> getEvents(@Path("username") String username);
}
