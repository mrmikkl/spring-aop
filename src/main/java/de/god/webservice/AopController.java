package de.god.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.god.usecase.AopUseCase;

@RestController
@RequestMapping("/api/aop")
public class AopController
{
    private AopUseCase aopUseCase;

    @Autowired
    public AopController(final AopUseCase pAopUseCase)
    {
        aopUseCase = pAopUseCase;
    }

    @PostMapping
    public ResponseEntity triggerAop(@RequestParam("value") Long value)
    {

        return ResponseEntity
                .ok()
                .build();
    }
}
