package io.github.carbonintensity.services

import groovy.transform.CompileStatic
import io.github.carbonintensity.dto.Factors
import io.github.carbonintensity.dto.Stats

import static io.restassured.RestAssured.given
import static org.apache.http.HttpStatus.SC_OK

@CompileStatic
class CarbonIntensityService {

    static Factors getFactors() {
        given().spec(RequestSpecs.basicSpec())
               .when()
               .get(Paths.FACTORS)
               .then()
               .statusCode(SC_OK)
               .extract().response().<Factors> as(Factors)
    }

    static Stats getStats(String fromData, String toData) {
        given().spec(RequestSpecs.basicSpec())
               .urlEncodingEnabled(false)
               .pathParam('from', fromData)
               .pathParam('to', toData)
               .when()
               .get(Paths.STATS_FROM_TO)
               .then()
               .statusCode(SC_OK)
               .extract().response().<Stats> as(Stats)
    }
}
