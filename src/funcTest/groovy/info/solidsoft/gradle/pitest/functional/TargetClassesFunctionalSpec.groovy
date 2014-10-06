package info.solidsoft.gradle.pitest.functional

import nebula.test.IntegrationSpec

class TargetClassesFunctionalSpec extends IntegrationSpec {

    def "report error when no project group and no targetClasses parameter are defined"() {
        given:
            buildFile << """
                apply plugin: 'java'
                apply plugin: 'info.solidsoft.pitest'
            """.stripIndent()
        and:
            writeHelloWorld('gradle.pitest.test.hello')
        when:
            def result = runTasksWithFailure('pitest')
        then:
            result.standardError.contains("No value has been specified for property 'targetClasses'")
    }
}
