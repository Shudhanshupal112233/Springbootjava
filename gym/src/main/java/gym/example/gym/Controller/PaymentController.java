package gym.example.gym.Controller;


import com.stripe.model.PaymentIntent;
import gym.example.gym.Services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public PaymentIntent createPayment(@RequestParam double amount, @RequestParam String currency) throws Exception {
        return paymentService.createPaymentIntent(amount, currency);
    }
}