package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class TestUtils {

    private static final ObjectMapper mapper = new ObjectMapper()
        .setSerializationInclusion(Include.NON_NULL)
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .registerModule(new JavaTimeModule());

    public static String getUsername() {
        return "82000174";
    }

    public static Long getOrganizationId() {
        return 4L;
    }

    public static Set<String> getAuthorities() {
        HashSet<String> strings = new HashSet<>();
        strings.add("IAPI_GATEWAY-S-ORG");
        return strings;
    }

    public static <T> T convertValue(Object o, Class<T> clazz) {
        return mapper.convertValue(o, clazz);
    }

    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            return null;
        }
    }
}
