package io.turntabl;

public class CorporateClient extends Client{
    private AccountManager accountManager;


    public CorporateClient(AccountManager accountManager, String ID, ServiceLevel serviceLevel) {
        super(ID, serviceLevel);
        this.accountManager = accountManager;
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }


    @Override
    public String getName() {
        return accountManager.getName();
    }

    @Override
    public String toString() {
        return "CorporateClient{" +
                "accountManager=" + accountManager +
                '}';
    }
}
