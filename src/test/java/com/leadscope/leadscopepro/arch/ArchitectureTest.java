package com.leadscope.leadscopepro.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.leadscope.leadscopepro")
class ArchitectureTest {

    static final ArchRule domain_should_not_depend_on_infra =
            noClasses().that().resideInAPackage("..core..")
                    .should().dependOnClassesThat()
                    .resideInAnyPackage("..infra..", "..shared.logging..");
}
