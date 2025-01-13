package io.github.carbonintensity.services

import groovy.transform.CompileStatic
import io.github.carbonintensity.dto.Factors
import io.github.carbonintensity.dto.Stats
import io.restassured.builder.RequestSpecBuilder
import io.restassured.filter.Filter
import io.restassured.filter.log.RequestLoggingFilter
import io.restassured.filter.log.ResponseLoggingFilter
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification

import static io.restassured.RestAssured.given
import static org.apache.http.HttpStatus.SC_OK

@CompileStatic
class CarbonIntensityService {

    private static final List<Filter> LOGGING_FILTERS = [new RequestLoggingFilter(), new ResponseLoggingFilter()]

    static Factors getFactors() {
        given().spec(basicSpec())
               .when()
               .get(Paths.FACTORS)
               .then()
               .statusCode(SC_OK)
               .extract().response().<Factors> as(Factors)
    }

    static Stats getStats(String fromData, String toData) {
        given().spec(basicSpec())
               .urlEncodingEnabled(false)
               .pathParam('from', fromData)
               .pathParam('to', toData)
               .when()
               .get(Paths.STATS_FROM_TO)
               .then()
               .statusCode(SC_OK)
               .extract().response().<Stats> as(Stats)
    }

    private static RequestSpecification basicSpec() {
        new RequestSpecBuilder()
            .setBaseUri(Paths.BASE_URL)
            .addFilters(LOGGING_FILTERS)
            .setAccept(ContentType.JSON)
            .build()
    }
}
