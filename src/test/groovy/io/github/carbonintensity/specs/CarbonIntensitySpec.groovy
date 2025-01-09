package io.github.carbonintensity.specs

import io.github.carbonintensity.common.annotations.Regression
import io.github.carbonintensity.dto.Factors
import io.github.carbonintensity.dto.Stats
import io.github.carbonintensity.services.CarbonIntensityService
import spock.lang.Specification

class CarbonIntensitySpec extends Specification {

    @Regression
    def "should check Oil factor"() {
        when: 'send call for getting factors'
            Factors factors = CarbonIntensityService.getFactors()

        then: 'Oil factor is returned'
            factors.data.get(0).oil == 935
    }

    @Regression
    def "should check max intensity between 2025-01-01 and 2025-01-31"() {
        when: 'send call for getting stats between proper dates'
            Stats stats = CarbonIntensityService.getStats('2025-01-01T12:00Z','2025-01-31T12:00Z')

        then: 'max intensity is returned'
            stats.data.get(0).intensity.max == 249
    }
}
