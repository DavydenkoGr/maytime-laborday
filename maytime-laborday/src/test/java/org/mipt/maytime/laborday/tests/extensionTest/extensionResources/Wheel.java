package org.mipt.maytime.laborday.tests.extensionTest.extensionResources;

import org.mipt.maytime.annotations.Component;
import org.mipt.maytime.annotations.Inject;

@Component
public class Wheel {
    @Inject
    private Details details;

    public Details getDetails() {
        return details;
    }
}
