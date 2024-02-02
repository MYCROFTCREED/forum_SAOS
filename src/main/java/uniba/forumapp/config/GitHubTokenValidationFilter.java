package uniba.forumapp.config;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

@Component
public class GitHubTokenValidationFilter extends OncePerRequestFilter {
    private static final String GITHUB_API_URL = "https://api.github.com/user";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String githubToken = authorizationHeader.substring(7); // Extract the token from the header

            // Perform GitHub token validation
            if (isValidGitHubToken(githubToken)) {
                filterChain.doFilter(request, response); // Continue with the request
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    private boolean isValidGitHubToken(String githubToken) {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(GITHUB_API_URL);

        // Set the Authorization header with the GitHub OAuth token
        request.setHeader("Authorization", "Bearer " + githubToken);

        try {
            HttpResponse response = httpClient.execute(request);

            // Check the response status code
            if (response.getStatusLine().getStatusCode() == 200) {
                // Token is valid
                System.out.println("GitHub Token is valid");
                return true;
            } else {
                // Token is invalid
                System.out.println("GitHub Token is invalid");
                return false;
            }
        } catch (IOException e) {
            // An error occurred while making the request
            e.printStackTrace();
            return false;
        }
    }
}
