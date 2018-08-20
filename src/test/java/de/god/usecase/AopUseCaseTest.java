package de.god.usecase;

import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("The AOP UseCase")
@RunWith(MockitoJUnitRunner.class)
class AopUseCaseTest
{
    //    @Mock
    AopUseCase aopUseCase;

    @BeforeEach
    void setUp()
    {
        this.aopUseCase = Mockito.mock(AopUseCase.class);
    }

    @AfterEach
    void tearDown()
    {
    }

    @DisplayName("is used to add 1 to a number")
    @Test
    void addOne()
    {
        Mockito.when(aopUseCase.addOne(1L)).thenReturn(2L);

        Long testNumber = 1L;
        final Long result = aopUseCase.addOne(testNumber);
//        assertEquals

        Mockito.verify(aopUseCase).addOne(testNumber);
    }

    @DisplayName("is used to add 1 to a number without Mock")
    @Test
    void addOneWithoutMock() {
        AopUseCase aopUseCase = new AopUseCase();
        Long testNumber = 1L;
        final Long result = aopUseCase.addOne(testNumber);
        assertEquals(2L, result.longValue());
    }

    @DisplayName("is used to return a random UUID")
    @Test
    void getRandomUUID()
    {
        final AopUseCase aopUseCase = Mockito.mock(AopUseCase.class);
        Mockito.when(aopUseCase.getRandomUUID()).thenReturn(UUID.randomUUID().toString());

        final String uuid = aopUseCase.getRandomUUID();
        Mockito.verify(aopUseCase).getRandomUUID();
    }

    @Nested
    @DisplayName("with new state")
    class NewState
    {
        private String state;

        @BeforeEach
        void setUp()
        {
            this.state = "newState";
        }

        @DisplayName("has a changed state")
        @Test
        void changeState()
        {
            final String initialState = "";
            final String stateChange1 = "1";
            final String stateChange2 = "2";
            final String stateChange3 = "3";
            Mockito.when(aopUseCase.changeTripleState(initialState, stateChange1, stateChange2, stateChange3)).thenReturn(this.state + "123");

            final String changedState = aopUseCase.changeTripleState(initialState, stateChange1, stateChange2, stateChange3);
            assertEquals(changedState, this.state + "123");
        }

        @DisplayName("can be spied on")
        @Test
        void spying(){
            final List<String> stringList = Arrays.asList("One", "Two", "Three");
            final List<String> stringListSpy = Mockito.spy(stringList);

            Mockito.when(aopUseCase.changeState("Four")).thenReturn("OneTwoThreeFour");

            
        }
    }
}
