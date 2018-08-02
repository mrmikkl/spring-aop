package de.god.usecase;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

@Service
public class AopUseCase
{
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
}
