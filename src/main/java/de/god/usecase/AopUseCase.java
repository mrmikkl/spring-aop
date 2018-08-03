package de.god.usecase;

import java.util.Arrays;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

@Service
public class AopUseCase
{
    private String innerState = "";

    public AopUseCase()
    {
    }

    public String getRandomUUID()
    {
        return UUID.randomUUID().toString();
    }

    public Long addOne(@NotNull Long number)
    {
        number += 1;
        return number;
    }

    public String changeState(@NotNull String... values)
    {
        final StateBuilder stateBuilder = new StateBuilder(this.innerState);
        Arrays.stream(values).forEach(value -> stateBuilder.addValue(value));
        return stateBuilder.build();
    }

    public String changeTripleState(@NotNull String value1, @NotNull String value2, @NotNull String value3)
    {
        final StateBuilder stateBuilder = new StateBuilder(this.innerState);
        return stateBuilder
                .addValue(value1)
                .addValue(value2)
                .addValue(value3)
                .build();
    }

    public String getInnerState()
    {
        return innerState;
    }

    public class StateBuilder
    {
        private String state;
        private String value;

        public StateBuilder(final String state)
        {
            this.state = state;
        }

        public StateBuilder addValue(final String value)
        {
            this.value += value;
            return this;
        }

        public String build()
        {
            this.state += this.value;
            return this.state;
        }
    }
}
