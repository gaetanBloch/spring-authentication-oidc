package fr.keyconsulting.geode.authentication.domain.object.account;

import fr.keyconsulting.geode.authentication.shared.error.domain.Assert;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

public record Email(String email) {
  public Email {
    Assert.field("email", email).notBlank().maxLength(255);
  }

  public static Optional<Email> of(String email) {
    return Optional.ofNullable(email).filter(StringUtils::isNotBlank).map(Email::new);
  }

  public String get() {
    return email();
  }
}
