package org.mipt.maytime.laborday.tests.extensionTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mipt.maytime.annotations.Inject;
import org.mipt.maytime.laborday.MaytimeExtension;
import org.mipt.maytime.laborday.annotations.MaytimeTestSources;
import org.mipt.maytime.laborday.tests.additionalResources.SupplementaryResource;
import org.mipt.maytime.laborday.tests.extensionTest.extensionResources.Details;
import org.mipt.maytime.laborday.tests.extensionTest.extensionResources.Vehicle;
import org.mipt.maytime.laborday.tests.extensionTest.extensionResources.Wheel;

@ExtendWith(MaytimeExtension.class)
@MaytimeTestSources(include = {"org.mipt.maytime.laborday.tests.additionalResources"})
public class ExtensionTest {
    @Inject
    private Vehicle vehicle;
    @Inject
    private Wheel wheel;
    @Inject
    private Details details;
    @Inject
    private SupplementaryResource resource;

    @Test
    public void basicTest() {
        Assertions.assertSame(wheel.getDetails(), details);
        Assertions.assertSame(vehicle.getWheel().getDetails(), wheel.getDetails());
        Assertions.assertEquals("Ivan", resource.sayMyName());
    }
}
