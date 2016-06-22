package net.jcip.examples.chapter04;

import java.util.*;

import net.jcip.annotations.*;

/**
 * PersonSet
 * <p/>
 * Using confinement to ensure thread safety
 */

@ThreadSafe
public class PersonSet {
    @GuardedBy("this") private final Set<Person> mySet = new HashSet<Person>();

    public synchronized void addPerson(Person p) {
        mySet.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return mySet.contains(p);
    }

    interface Person {
    }
}
