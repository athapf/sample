package de.thaso.demo.sample.template.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
class GreetingResourceTest {

    @InjectMocks
    private GreetingResource underTest;

    @Mock
    private ProducerRestClient producerRestClient;

    @BeforeEach
    void setUp() {
        Mockito.when(producerRestClient.callCheck()).thenReturn("ok");
    }

    @Test
    void check_isOk() {
        assertThat(underTest.check(), is("ok / ok"));
    }
}
