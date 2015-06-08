package com.sopovs.moradanen.khaleesificator;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
public class RecentPhrases implements DisposableBean {
    static final int SIZE = 10;
    private final ExecutorService offeringService = Executors.newFixedThreadPool(1);
    private final ConcurrentMap<String, Long> phrases = new ConcurrentHashMap<>();

    @Override
    public void destroy() {
        offeringService.shutdownNow();
    }

    public void offer(final String phrase) {
        offeringService.execute(() -> {
            phrases.put(phrase, System.currentTimeMillis());
            while (phrases.size() > SIZE) {
                long oldestAge = Long.MAX_VALUE;
                String oldestPhrase = null;
                for (Entry<String, Long> entry : phrases.entrySet()) {
                    if (entry.getValue() < oldestAge) {
                        oldestAge = entry.getValue();
                        oldestPhrase = entry.getKey();
                    }
                }
                phrases.remove(oldestPhrase);
            }
        });
    }

    public Collection<String> getRecent() {
        return phrases.keySet();
    }

}
