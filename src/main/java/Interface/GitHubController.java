package Interface;

import Datamodel.GitHubRepos;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class GitHubController  {

    static final String BASE_URL = "https://api.github.com/";
    static final String GITHUB_USER = "SonnyBurnett";

    public void start() {


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        GitHubUserApi client = retrofit.create(GitHubUserApi.class);

        Call<List<GitHubRepos>> call = client.getReposByUser(GITHUB_USER);

        call.enqueue(new Callback<List<GitHubRepos>>() {
            @Override
            public void onResponse(Call<List<GitHubRepos>> call, Response<List<GitHubRepos>> response) {
                List<GitHubRepos> repos = response.body();
                for (int i=0; i<10;i++) {
                    System.out.println(repos.get(i).getName());
                }
            }

            @Override
            public void onFailure(Call<List<GitHubRepos>> call, Throwable t) {
                System.out.println("ai something went terribly wrong");
            }
        });
    }

}
