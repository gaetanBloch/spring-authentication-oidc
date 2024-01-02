package fr.keyconsulting.geode.authentication.infrastructure.input.dto;

import fr.keyconsulting.geode.authentication.domain.object.account.Account;
import fr.keyconsulting.geode.authentication.domain.object.authentication.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.Collection;

@Schema(name = "user", description = "Information for an user")
public class AccountDto {

  private final String username;
  private final String name;
  private final String email;
  private final Collection<String> roles;

  private AccountDto(AccountDtoBuilder builder) {
    username = builder.username;
    name = builder.name;
    email = builder.email;
    roles = builder.roles;
  }

  public static AccountDto from(Account account) {
    return new AccountDtoBuilder()
      .username(account.username().get())
      .name(account.name().get())
      .email(account.email().get())
      .roles(account.roles().get().stream().map(Role::key).toList())
      .build();
  }

  @Schema(description = "Username of this user", requiredMode = RequiredMode.REQUIRED)
  public String getUsername() {
    return username;
  }

  @Schema(
    description = "Fullname (Firstname LASTNAME) of this user",
    requiredMode = RequiredMode.REQUIRED
  )
  public String getName() {
    return name;
  }

  @Schema(description = "Email of this user", requiredMode = RequiredMode.REQUIRED)
  public String getEmail() {
    return email;
  }

  @Schema(description = "Roles of this user")
  public Collection<String> getRoles() {
    return roles;
  }

  private static class AccountDtoBuilder {

    private String username;
    private String name;
    private String email;
    private Collection<String> roles;

    public AccountDtoBuilder username(String username) {
      this.username = username;

      return this;
    }

    public AccountDtoBuilder name(String name) {
      this.name = name;

      return this;
    }

    public AccountDtoBuilder email(String email) {
      this.email = email;

      return this;
    }

    public AccountDtoBuilder roles(Collection<String> roles) {
      this.roles = roles;

      return this;
    }

    public AccountDto build() {
      return new AccountDto(this);
    }
  }
}
