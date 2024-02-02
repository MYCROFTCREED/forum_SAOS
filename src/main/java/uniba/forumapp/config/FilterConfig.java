package uniba.forumapp.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<GitHubTokenValidationFilter> tokenValidationFilter() {
        FilterRegistrationBean<GitHubTokenValidationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new GitHubTokenValidationFilter());
        registrationBean.addUrlPatterns("/secured/*");
        return registrationBean;
    }
}
