package io.github.carbonintensity.services

import groovy.transform.CompileStatic

@CompileStatic
class Paths {

    public static final String FACTORS = '/factors'
    public static final String STATS = '/stats'
    public static final String STATS_FROM_TO = "$STATS/{from}/{to}"
}
