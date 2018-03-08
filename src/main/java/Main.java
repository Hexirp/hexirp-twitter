import twitter4j.*;
import twitter4j.auth.AccessToken;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        Twitter twitter = new TwitterFactory().getInstance(new AccessToken("token", "tokenSecret"));

        try (PrintStream out = new PrintStream("C:\\Users\\hexirp\\Documents\\twitter\\timeline.txt")) {
            ResponseList<Status> statuses = twitter.getHomeTimeline(new Paging(1, 200));

            out.print(statuses);
        } catch (FileNotFoundException | TwitterException e) {
            e.printStackTrace();
        }
    }
}
