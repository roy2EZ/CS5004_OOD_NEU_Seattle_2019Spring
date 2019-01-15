package Problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    private Account myAccount;
    private Amount myAmount;
    private Amount depositAmount;
    private Amount withdrawAmount;

    @Before
    public void setUp() throws Exception {
        myAmount = new Amount(1214, 87);
        myAccount = new Account("Roy", "Chen", myAmount);
        depositAmount = new Amount(1031,89);
        withdrawAmount = new Amount(200,15);
    }

    @Test
    public void getFirstName() {
        assertEquals(myAccount.getFirstName(), "Roy");
    }

    @Test
    public void getLastName() {
        assertEquals(myAccount.getLastName(), "Chen");
    }

    @Test
    public void getCurrentBalance() {
        assertEquals(myAccount.getCurrentBalance(), myAmount);
        assertEquals(myAccount.getCurrentBalance().getDollar(), (Integer) 1214);
        assertEquals(myAccount.getCurrentBalance().getCent(), (Integer) 87);
    }

    @Test
    public void deposit() {
        myAccount.deposit(depositAmount);
        assertEquals(myAccount.getCurrentBalance().getDollar(),(Integer)2246);
        assertEquals(myAccount.getCurrentBalance().getCent(),(Integer)76);
    }


    @Test
    public void withdraw() {
        myAccount.withdraw(withdrawAmount);
        assertEquals(myAccount.getCurrentBalance().getDollar(),(Integer)1014);
        assertEquals(myAccount.getCurrentBalance().getCent(),(Integer)72);
    }
}
