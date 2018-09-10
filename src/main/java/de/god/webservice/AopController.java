package de.god.webservice;

import de.god.special.SpecialUseCase;
import de.god.usecase.AopUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aop")
public class AopController {
    private AopUseCase aopUseCase;
    private SpecialUseCase specialUseCase;

    @Autowired
    public AopController(
            final AopUseCase pAopUseCase,
            final SpecialUseCase pSpecialUseCase) {
        aopUseCase = pAopUseCase;
        specialUseCase = pSpecialUseCase;
    }

    @GetMapping(value = "test")
    public String testMethod() {
        return "Works";
    }

    @PostMapping(value = "addOneWithAnnotation")
    public ResponseEntity triggerAddOneWithAnnotation(@RequestParam("value") Long value) {
        aopUseCase.addOne(value);
        return ResponseEntity
                .ok()
                .build();
    }

    @PostMapping(value = "addOneWithpackage")
    public ResponseEntity triggerAddOneWithPackage(@RequestParam("value") Long value) {
        specialUseCase.addOne(value);
        return ResponseEntity
                .ok()
                .build();
    }
}
