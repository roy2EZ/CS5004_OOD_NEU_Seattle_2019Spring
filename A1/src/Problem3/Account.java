package Problem3;

public class Account {
    private String firstName;
    private String lastName;
    private Amount currentBalance;

    public Account(String firstName, String lastName, Amount currentBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.currentBalance = currentBalance;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Amount getCurrentBalance() {
        return currentBalance;
    }

    public Amount deposit(Amount depositAmount){
        Integer totalCent= (currentBalance.getDollar() * 100) + currentBalance.getCent() +
                (depositAmount.getDollar() * 100) + depositAmount.getCent();
        return getAmount(totalCent);
    }


    public Amount withdraw(Amount withdrawAmount){
        Integer totalCent= (currentBalance.getDollar() * 100) + currentBalance.getCent() -
                (withdrawAmount.getDollar() * 100) - withdrawAmount.getCent();
        return getAmount(totalCent);
    }

    private Amount getAmount(Integer totalCent) {
        Integer newDollar = (int)(Math.floor(totalCent / 100));
        Integer newCent = totalCent-newDollar*100;
        currentBalance.setDollar(newDollar);
        currentBalance.setCent(newCent);

        return currentBalance;
    }

}
