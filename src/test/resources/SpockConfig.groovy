import io.github.carbonintensity.common.annotations.Regression
import io.github.carbonintensity.common.annotations.Smoke

Class<?>[] map(String groups) {
    Map nameToAnnotation = [
        'Regression': Regression,
        'Smoke'     : Smoke
    ]

    return Arrays.stream(groups.split(','))
                 .filter { !it.isAllWhitespace() }
                 .map(nameToAnnotation::get)
                 .toArray(size -> new Class[size])
}

runner {
    String includedGroupsCsv = System.getProperty('included.test.groups')
    String excludedGroupsCsv = System.getProperty('excluded.test.groups')

    println("Include: $includedGroupsCsv")
    println("Exclude: $excludedGroupsCsv")

    include map(includedGroupsCsv)
    exclude map(excludedGroupsCsv)
}
