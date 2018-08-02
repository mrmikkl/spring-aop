package de.god.usecase;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class AopUseCaseTest
{
//    @Mock
//    private AopUseCase aopUseCase;

    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }

    @DisplayName("Tests to add 1 to 1.")
    @Test
    public void addOne()
    {
        final AopUseCase aopUseCase = Mockito.mock(AopUseCase.class);
        Mockito.when(aopUseCase.addOne(1L)).thenReturn(2L);

        Long testNumber = 1L;
        final Long result = aopUseCase.addOne(testNumber);
//        assertEquals

        Mockito.verify(aopUseCase).addOne(testNumber);
    }

    @DisplayName("Tests to return a random generated UUID.")
    @Test
    public void getRandomUUID()
    {
        final AopUseCase aopUseCase = Mockito.mock(AopUseCase.class);
        Mockito.when(aopUseCase.getRandomUUID()).thenReturn(UUID.randomUUID().toString());

        final String uuid = aopUseCase.getRandomUUID();
        Mockito.verify(aopUseCase).getRandomUUID();
    }
}
