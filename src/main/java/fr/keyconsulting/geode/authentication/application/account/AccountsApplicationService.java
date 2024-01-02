package fr.keyconsulting.geode.authentication.application.account;

import fr.keyconsulting.geode.authentication.domain.object.account.Account;
import fr.keyconsulting.geode.authentication.domain.output.AccountsRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AccountsApplicationService {

  private final AccountsRepository accounts;

  public AccountsApplicationService(AccountsRepository accounts) {
    this.accounts = accounts;
  }

  public Optional<Account> authenticatedUserAccount() {
    return accounts.authenticatedUserAccount();
  }
}
