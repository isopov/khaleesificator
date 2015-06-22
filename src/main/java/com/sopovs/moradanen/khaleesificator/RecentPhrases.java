package com.sopovs.moradanen.khaleesificator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

import org.springframework.stereotype.Component;

@Component
public class RecentPhrases {
    static final int SIZE = 10;

    private final LinkedHashSet<String> phrases = new LinkedHashSet<>();

    public synchronized void offer(final String phrase) {
        if (phrases.contains(phrase)) {
            phrases.remove(phrase);
            phrases.add(phrase);
        } else {
            phrases.add(phrase);
            if (phrases.size() > SIZE) {
                Iterator<String> it = phrases.iterator();
                it.next();
                it.remove();
            }
        }
    }

    public synchronized Collection<String> getRecent() {
        return new ArrayList<String>(phrases);
    }

}
