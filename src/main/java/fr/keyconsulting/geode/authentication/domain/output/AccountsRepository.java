package fr.keyconsulting.geode.authentication.domain.output;

import fr.keyconsulting.geode.authentication.domain.object.account.Account;
import java.util.Optional;

public interface AccountsRepository {
  Optional<Account> authenticatedUserAccount();
}
