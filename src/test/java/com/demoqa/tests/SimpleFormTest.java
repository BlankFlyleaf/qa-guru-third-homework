package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.demoqa.testdata.TestData.*;

public class SimpleFormTest extends TestBase {

    @Test
    void simpleFillFormTest() {
        simpleFormTestPages
                .openPage()

                //Fill String value
                .typeUserName(firstName + " " + lastName)
                .typeUserEmail(email)
                .typeUserCurrentAddress(currAddress)
                .typeUserPermanentAddress(permAddress)

                //Submit
                .submitForm()

                //Output Check
                .outputCheckValue(firstName + " " + lastName)
                .outputCheckValue(email)
                .outputCheckValue(currAddress)
                .outputCheckValue(permAddress);
    }

    @Test
    void withWrongEmailSimpleTest() {
        simpleFormTestPages
                .openPage()

                //Fill String value
                .typeUserName(firstName + " " + lastName)
                .typeUserEmail(corruptedEmail)
                .typeUserCurrentAddress(currAddress)
                .typeUserPermanentAddress(permAddress)

                //Submit
                .submitForm()

                //Output Check
                .outputCheckEmailError("class", "mr-sm-2 field-error form-control");
    }
}
