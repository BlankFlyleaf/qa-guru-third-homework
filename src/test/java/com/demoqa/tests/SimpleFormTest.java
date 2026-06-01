package com.demoqa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.demoqa.utils.RandomUtils.*;

public class SimpleFormTest extends TestBase {

    String firstNameFaker;
    String lastNameFaker;
    String emailFaker;
    String corruptedEmailRandom;
    String currAddressFaker;
    String permAddressFaker;

    @BeforeEach
    void randomVariableGeneration () {
        firstNameFaker = fakerRu.name().firstName();
        lastNameFaker = fakerRu.name().lastName();
        emailFaker = fakerEn.internet().emailAddress();
        corruptedEmailRandom = getRandomIntToString(1111, 9999);
        currAddressFaker = fakerRu.address().fullAddress();
        permAddressFaker = fakerRu.address().fullAddress();
    }

    @Test
    void simpleFillFormTest() {
        simpleFormTestPages
                .openPage()

                //Fill String value
                .typeUserName(firstNameFaker + " " + lastNameFaker)
                .typeUserEmail(emailFaker)
                .typeUserCurrentAddress(currAddressFaker)
                .typeUserPermanentAddress(permAddressFaker)

                //Submit
                .submitForm()

                //Output Check
                .outputCheckValue(firstNameFaker + " " + lastNameFaker)
                .outputCheckValue(emailFaker)
                .outputCheckValue(currAddressFaker)
                .outputCheckValue(permAddressFaker);
    }

    @Test
    void withWrongEmailSimpleTest() {
        simpleFormTestPages
                .openPage()

                //Fill String value
                .typeUserName(firstNameFaker + " " + lastNameFaker)
                .typeUserEmail(corruptedEmailRandom)
                .typeUserCurrentAddress(currAddressFaker)
                .typeUserPermanentAddress(permAddressFaker)

                //Submit
                .submitForm()

                //Output Check
                .outputCheckEmailError("class", "mr-sm-2 field-error form-control");
    }
}
