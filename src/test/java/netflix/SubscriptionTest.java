package netflix;

import org.junit.jupiter.api.Test;
import payment.IPaymentGateway;
import payment.TransactionStatus;
import service.BillingService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

class SubscriptionTest {
    @Test
    void dummyTest() {
        assertThat(1, is(equalTo(1)));
    }

    @Test
    void shouldDisplayBillDetailsBeforePayment() {
        BillingService billingService=mock(BillingService.class);
        IPaymentGateway iPaymentGateway=mock(IPaymentGateway.class);
        Subscription subscription=new Subscription(1,SubscriptionPlan.MONTHLY,billingService, iPaymentGateway);

        subscription.activate();

        verify(billingService).billDetails(SubscriptionPlan.MONTHLY.getPrice());
    }

    @Test
    void shouldBeAbleToActivateWhenTransactionIsSuccess(){
        BillingService billingService=mock(BillingService.class);
        IPaymentGateway iPaymentGateway=mock(IPaymentGateway.class);
        Subscription subscription=new Subscription(1,SubscriptionPlan.MONTHLY,billingService,iPaymentGateway);

        when(iPaymentGateway.pay(subscription.subscriptionPlan.getPrice())).thenReturn(TransactionStatus.SUCCESS);

        subscription.activate();

        assertThat(subscription.isActive(),is(equalTo(true)));
    }

    @Test
    void shouldNotBeAbleToActivateWhenTransactionIsNotSuccess(){
        BillingService billingService=mock(BillingService.class);
        IPaymentGateway iPaymentGateway=mock(IPaymentGateway.class);
        Subscription subscription=new Subscription(1,SubscriptionPlan.MONTHLY,billingService,iPaymentGateway);

        when(iPaymentGateway.pay(subscription.subscriptionPlan.getPrice())).thenReturn(TransactionStatus.FAILURE);

        subscription.activate();

        assertThat(subscription.isActive(),is(equalTo(false)));
    }
}
