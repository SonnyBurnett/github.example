package Interface;

import Datamodel.GitHubUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHubClient {

    static final String BASE_URL = "https://api.github.com/";
    static final String GITHUB_USER = "SonnyBurnett";

    public void start() {


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        GitHubUserApi client = retrofit.create(GitHubUserApi.class);

        Call<GitHubUser> call = client.getUserByName(GITHUB_USER);

        call.enqueue(new Callback<GitHubUser>() {
            @Override
            public void onResponse(Call<GitHubUser> call, Response<GitHubUser> response) {
                GitHubUser gitHubUser = response.body();
                System.out.println(gitHubUser.getName());
                System.out.println(gitHubUser.getId());
                System.out.println(gitHubUser.getAvatarUrl());
                System.out.println(gitHubUser.getFollowers());
            }

            @Override
            public void onFailure(Call<GitHubUser> call, Throwable t) {
                System.out.println("ai something went terribly wrong");
            }
        });    }

}

