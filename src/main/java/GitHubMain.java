import Interface.GitHubClient;
import Interface.GitHubController;
import Interface.GitHubEventApi;

public class GitHubMain {
    public static void main(String[] args) {

        GitHubEventApi api = new GitHubEventApi();
        api.start();

        GitHubClient client = new GitHubClient();
        client.start();

        GitHubController controller = new GitHubController();
        controller.start();

    }
}
