package Interface;

import Datamodel.GitHubEvent;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class GitHubEventApi {



    static final String BASE_URL = "https://api.github.com/";
    static final String GITHUB_USER = "SonnyBurnett";

    public void start() {


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        GitHubUserApi client = retrofit.create(GitHubUserApi.class);

        Call<List<GitHubEvent>> call = client.getEvents(GITHUB_USER);

        call.enqueue(new Callback<List<GitHubEvent>>() {
            @Override
            public void onResponse(Call<List<GitHubEvent>> call, Response<List<GitHubEvent>> response) {
                List<GitHubEvent> event = response.body();

            }

            @Override
            public void onFailure(Call<List<GitHubEvent>> call, Throwable t) {
                System.out.println("ai something went terribly wrong");
            }
        });    }

}


