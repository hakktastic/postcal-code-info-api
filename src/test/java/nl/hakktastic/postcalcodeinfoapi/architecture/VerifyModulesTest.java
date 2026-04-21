package nl.hakktastic.architecture;

import lombok.extern.slf4j.Slf4j;
import nl.hakktastic.pensioenpotapi.PensioenpotApiApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class VerifyModulesTest {

    private ApplicationModules modules;

    @BeforeEach
    void beforeEach() {
        modules = ApplicationModules.of(PensioenpotApiApplication.class);
    }

    @Test
    void verifyModules() {

        modules.forEach(applicationModule -> log.info("Module: '{}', package: '{}'", applicationModule.getIdentifier(),
                applicationModule.getBasePackage()));

        modules.verify();
    }

    @Test
//    @Disabled("run only if you want to generate documentation")
    void writeDocumentation() {

        final var documenter = new Documenter(modules).writeDocumentation()
                .writeModuleCanvases()
                .writeIndividualModulesAsPlantUml()
                .writeModulesAsPlantUml();

        assertThat(documenter).isNotNull();
    }
}