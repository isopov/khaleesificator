package com.sopovs.moradanen.khaleesificator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RecentPhrasesTest {

    private RecentPhrases recentPhrases;

    @Before
    public void setUp() {
        recentPhrases = new RecentPhrases();
    }

    @Test
    public void testDifferentPhrases() throws InterruptedException {
        for (int i = 0; i < RecentPhrases.SIZE * 2; i++) {
            recentPhrases.offer("testPhrase" + i);
        }
        assertEquals(RecentPhrases.SIZE, recentPhrases.getRecent().size());
    }

    @Test
    public void testSamePhrases() throws InterruptedException {
        for (int i = 0; i < RecentPhrases.SIZE * 2; i++) {
            recentPhrases.offer("testPhrase");
        }
        assertEquals(1, recentPhrases.getRecent().size());
    }

}
