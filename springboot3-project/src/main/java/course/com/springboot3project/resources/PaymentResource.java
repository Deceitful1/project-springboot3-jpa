package course.com.springboot3project.resources;

import course.com.springboot3project.entities.Payment;
import course.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentResource
{
    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments()
    {
        List<Payment> payments = paymentService.findAll();
        return ResponseEntity.ok(payments);
    }

}
