package io.github.shoma2da.android_youtube_data_api_client;

import org.junit.Test;

import io.github.shoma2da.android_youtube_data_api_client.Sample;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void sampleMethod() {
        assertEquals("hello", new Sample().hello());
    }
}