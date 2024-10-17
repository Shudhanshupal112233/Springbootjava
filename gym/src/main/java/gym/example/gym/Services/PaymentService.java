package gym.example.gym.Services;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;


@Service
@Data
@Getter
@Setter


public class PaymentService {

    private String stripeApiKey;

    public PaymentIntent createPaymentIntent(double amount, String currency) throws Exception {
        Stripe.apiKey = stripeApiKey;

        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount((long) (amount * 100)) // Convert to cents
                .setCurrency(currency)
                .build();

        return PaymentIntent.create(params);
    }
}