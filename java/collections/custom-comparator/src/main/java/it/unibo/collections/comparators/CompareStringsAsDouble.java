package it.unibo.collections.comparators;

import java.util.Comparator;

/**
 * A comparator which expects two {@link String} parsable as {@link Double}
 * using {@link Double#parseDouble(String)}.
 *
 */
public final class CompareStringsAsDouble implements Comparator<String> {

    /**
     * @param o1 the first string to compare, must be parse-able to double
     * @param o2 the second string to compare, must be parse-able to double
     *
     * @return 1 if o1 > o2, 0 if o2 == o1, -1 otherwise
     *
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    public int compare(final String o1, final String o2) { // NOPMD
        return Double.compare(Double.parseDouble(o1), Double.parseDouble(o2));
    }
}
