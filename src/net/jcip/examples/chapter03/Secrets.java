package net.jcip.examples.chapter03;

import java.util.*;

/**
 * Secrets
 *
 * Publishing an object
 */
class Secrets {
    public static Set<Secret> knownSecrets;

    public void initialize() {
        knownSecrets = new HashSet<Secret>();
    }
}


class Secret {
}
