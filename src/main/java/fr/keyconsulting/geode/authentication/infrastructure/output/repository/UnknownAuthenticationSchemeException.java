package fr.keyconsulting.geode.authentication.infrastructure.output.repository;

import java.io.Serial;

class UnknownAuthenticationSchemeException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = -3259391057037839022L;

  public UnknownAuthenticationSchemeException() {
    super("Tried to read authentication from an unknown scheme");
  }
}
