package al.polis.calculator.controller;

import al.polis.calculator.dto.Sum1ReqDto;
import al.polis.calculator.dto.Sum2RespDto1;
import al.polis.calculator.service.SumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstController {

    @Autowired
    private SumService summer;
    
    @GetMapping("/greet1")
    public void greetings1() {
        System.out.println("Hello students!");
    }

    @GetMapping("/greet2")
    public String greetings2() {
        return "Hello students!";
    }

    @PostMapping("/sum1")
    @ResponseBody
    public String sum1(@RequestBody Sum1ReqDto dto) {
        System.out.println("Entered in sum1");
        double sum = dto.getA() + dto.getB();
        return "Result is " + sum;
    }

    @PostMapping("/sum2")
    @ResponseBody
    public Sum2RespDto1 sum2(@RequestBody Sum1ReqDto dto) {
        System.out.println("Entered in sum2");
//        SumServiceImpl summer = new SumServiceImpl();
        double sum = summer.calculateSumOfTwoNumbers(
                dto.getA(), dto.getB());
        var answ = new Sum2RespDto1();
        answ.setA(dto.getA());
        answ.setB(dto.getB());
        answ.setResult(sum);
        return answ;
    }
}
