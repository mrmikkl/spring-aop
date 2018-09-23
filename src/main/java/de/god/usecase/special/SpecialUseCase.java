package de.god.usecase.special;

import de.god.domain.Adder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class SpecialUseCase {
    public SpecialUseCase() {
    }

    public Long addOne(@NotNull Long number) {
        Adder adder = new Adder(number);
        return adder.addOne();
    }
}
