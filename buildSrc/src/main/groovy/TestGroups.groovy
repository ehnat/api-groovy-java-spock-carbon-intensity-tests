import java.util.stream.Collectors

class TestGroups {

    private final Collection<String> groupsParam

    TestGroups(String groupsString) {
        groupsParam = (groupsString ?: '')
            .split(',')
            .toList()
            .findAll { !it.isAllWhitespace() }
    }

    String excluded() {
        return resolveGroups(excludes())
    }

    String included() {
        return resolveGroups(includes())
    }

    private static String resolveGroups(Collection<String> groups) {
        groups.stream()
              .collect(Collectors.joining(','))
    }

    private Collection<String> includes() {
        groupsParam.findAll { !isExcluded(it) }
    }

    private Collection<String> excludes() {
        groupsParam
            .findAll { isExcluded(it) }
            .collect { it.replaceFirst('-', '') }
    }

    private static boolean isExcluded(String group) {
        group.startsWith('-')
    }
}
