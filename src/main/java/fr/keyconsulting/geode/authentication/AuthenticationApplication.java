package fr.keyconsulting.geode.authentication;

import java.util.Arrays;
import java.util.stream.StreamSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.EnumerablePropertySource;

//@EnableDiscoveryClient
@SpringBootApplication
public class AuthenticationApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(AuthenticationApplication.class, args);
  }

  @EventListener
  public void handleContextRefresh(ContextRefreshedEvent event) {
    final var env = event.getApplicationContext().getEnvironment();

    LOGGER.info("Active profiles: {}", Arrays.toString(env.getActiveProfiles()));

    final var sources = ((AbstractEnvironment) env).getPropertySources();

    StreamSupport
      .stream(sources.spliterator(), false)
      .filter(ps -> ps instanceof EnumerablePropertySource)
      .map(ps -> ((EnumerablePropertySource) ps).getPropertyNames())
      .flatMap(Arrays::stream)
      .distinct()
      .filter(prop -> !(prop.contains("credentials") || prop.contains("password")))
      .forEach(prop -> LOGGER.info("{}: {}", prop, env.getProperty(prop)));
  }
}
