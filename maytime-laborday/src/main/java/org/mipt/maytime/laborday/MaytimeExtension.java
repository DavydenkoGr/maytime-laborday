package org.mipt.maytime.laborday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
import org.mipt.maytime.App;
import org.mipt.maytime.Context;
import org.mipt.maytime.configurators.InjectConfigurator;
import org.mipt.maytime.laborday.annotations.MaytimeTestSources;

/**
 * Extension for testing a projects written using a maytime
 * Use @ExtendsWith(MaytimeExtension.class) annotation to inject test dependencies
 *
 * @author Vronskii Alexander
 */
public class MaytimeExtension implements TestInstancePostProcessor {
    /**
     * Configure test instance fields before start testing
     * @param testInstance the instance to post-process; never {@code null}
     * @param context the current extension context; never {@code null}
     */
    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) {
        String packageName = testInstance.getClass().getPackage().getName();
        List<String> sources = new ArrayList<>();
        sources.add(packageName);
        
        if (testInstance.getClass().isAnnotationPresent(MaytimeTestSources.class)) {
            MaytimeTestSources sourcesAnnotation = testInstance.getClass().getAnnotation(MaytimeTestSources.class);
            sources.addAll(Arrays.asList(sourcesAnnotation.include()));
        }
        Context ctx = App.run(sources);
        
        InjectConfigurator configurator = new InjectConfigurator(ctx);
        configurator.configure(testInstance);
    }
}
