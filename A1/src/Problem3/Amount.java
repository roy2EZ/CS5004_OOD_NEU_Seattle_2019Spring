package Problem3;

public class Amount {
    private Integer dollar;
    private Integer cent;

    public Amount(Integer dollar, Integer cent) {
        this.dollar = dollar;
        this.cent = cent;
    }

    public Integer getDollar() {
        return dollar;
    }

    public Integer getCent() {
        return cent;
    }

    public void setDollar(Integer dollar) {
        this.dollar = dollar;
    }

    public void setCent(Integer cent) {
        this.cent = cent;
    }


}
