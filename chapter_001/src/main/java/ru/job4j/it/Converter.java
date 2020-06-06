package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> innerIt = it.next();

            @Override
            public boolean hasNext() {
                boolean result = false;
                while (!result && (it.hasNext() || innerIt.hasNext())) {
                    if (innerIt.hasNext()) {
                        result = true;
                    } else {
                        innerIt = it.next();
                    }
                }
                return result;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                return innerIt.next();
            }
        };
    }
}
