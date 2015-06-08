package com.sopovs.moradanen.khaleesificator;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RecentPhrasesTest {

    private RecentPhrases recentPhrases;

    @Before
    public void setUp() {
        recentPhrases = new RecentPhrases();
    }

    @After
    public void tearDown() {
        recentPhrases.destroy();
    }

    @Test
    public void testDifferentPhrases() throws InterruptedException {
        for (int i = 0; i < RecentPhrases.SIZE * 2; i++) {
            recentPhrases.offer("testPhrase" + i);
        }
        Thread.sleep(100);
        assertEquals(RecentPhrases.SIZE, recentPhrases.getRecent().size());
    }

    @Test
    public void testSamePhrases() throws InterruptedException {
        for (int i = 0; i < RecentPhrases.SIZE * 2; i++) {
            recentPhrases.offer("testPhrase");
        }
        Thread.sleep(100);
        assertEquals(1, recentPhrases.getRecent().size());
    }

}
