package com.udemycourse.hrpayroll.resource;

import com.udemycourse.hrpayroll.entities.Payment;
import com.udemycourse.hrpayroll.services.PaymentService;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

//    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId,@PathVariable Integer days) throws JRException {
        Payment payment = service.getPayment(workerId, days);
        return ResponseEntity.ok(payment);
    }

//    public ResponseEntity<Payment> getPaymentAlternative(@PathVariable Long workerId,@PathVariable Integer days){
//    	Payment payment = new Payment("Brann", 400.0, days);
//        return ResponseEntity.ok(payment);
//    }
    @GetMapping(value = "/payroll")
    public void gerarFolhaDePgamento() throws JRException {
        //Obtem o valor atual do sistema
        long inicioContagem = System.currentTimeMillis();

        //Compilacao no formato jasper para o jrprint
        JasperFillManager.fillReportToFile("reports/Blank_A4.jasper", null, new JREmptyDataSource(1));
        System.err.println("Tempo de compilacao jasper -> jrprint: " + (System.currentTimeMillis() - inicioContagem));

        //Reinicia o contador
        inicioContagem = System.currentTimeMillis();

        //Geracao do PDF
        JasperExportManager.exportReportToPdfFile("reports/Blank_A4.jrprint");
        System.err.println("Tempo de geracao do PDF: " + (System.currentTimeMillis() - inicioContagem));
    }

    
}
