public class Email {
    private String loginName;
    private String domainName;
    private String email;

    public Email(String loginName, String domainName, String email) {
        this.loginName = loginName;
        this.domainName = domainName;
        this.email = loginName + "@" + domainName;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getEmail() {
        return this.email;
    }
}
