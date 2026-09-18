package org.model.vo;

import org.model.enums.Category;
import org.model.exceptions.InvalidCategoryException;

public record ComputerCategory(Category value) {

    private static void validateNull(Category value) {
        if (value == null) {
            throw InvalidCategoryException.becauseCategoryIsNull();
        }
    }

    public ComputerCategory {
        validateNull(value);
    }
}