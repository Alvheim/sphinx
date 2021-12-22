package org.alvheim.sphinx.services.util;

import java.lang.reflect.Field;
import java.util.Map;
import org.alvheim.sphinx.exception.ResourceHasNoSuchPropertyException;
import org.springframework.util.ReflectionUtils;

public class ServiceUtils {

  public static <T> T applyPatches(T entityToPatch, Map<String, Object> partialUpdates, Class<?> clazz) {
    partialUpdates.forEach(
        (k, v) -> {
          Field field = ReflectionUtils.findField(clazz, k);
          if (field == null) {
            throw new ResourceHasNoSuchPropertyException(clazz.getName() + " has no field: " + k);
          }
          field.setAccessible(true);
          ReflectionUtils.setField(field, entityToPatch, v);
        });
    return entityToPatch;
  }

}
