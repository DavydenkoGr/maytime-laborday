package org.mipt.maytime.laborday.tests.extensionTest.extensionResources;

import org.mipt.maytime.annotations.Component;
import org.mipt.maytime.annotations.Inject;

@Component
public class Vehicle {
    @Inject
    private Wheel wheel;

    public Wheel getWheel() {
        return wheel;
    }
}
