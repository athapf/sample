package de.thaso.demo.sample.producer.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
class GreetingResourceTest {

    @InjectMocks
    private GreetingResource underTest;

    @BeforeEach
    void setUp() {
    }

    @Test
    void check_isOk() {
        assertThat(underTest.check(), is("ok"));
    }
}
