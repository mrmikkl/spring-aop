package de.god.usecase;

import de.god.aspect.LogReturnValue;
import de.god.domain.Adder;
import de.god.domain.StateBuilder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.UUID;

@Service
public class AopUseCase {
    public AopUseCase() {
    }

    public String getRandomUUID() {
        return UUID.randomUUID().toString();
    }

    @LogReturnValue
    public Long addOne(@NotNull Long number) {
        Adder adder = new Adder(number);
        return adder.addOne();
    }

    public String changeState(
            @NotNull final String initialState,
            @NotNull String... values) {
        final StateBuilder stateBuilder = new StateBuilder(initialState);
        Arrays.stream(values).forEach(value -> stateBuilder.addValue(value));
        return stateBuilder.build();
    }

    // Only for testing purposes, should normally just call changeState with String...
    public String changeTripleState(
            @NotNull final String initialState,
            @NotNull String value1,
            @NotNull String value2,
            @NotNull String value3) {
        final StateBuilder stateBuilder = new StateBuilder();
        return stateBuilder
                .addValue(value1)
                .addValue(value2)
                .addValue(value3)
                .build();
    }
}
