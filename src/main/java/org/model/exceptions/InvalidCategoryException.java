package org.model.exceptions;

public class InvalidCategoryException extends DomainException {
    public InvalidCategoryException(String message) {
        super(message);
    }

    private static final String MESSAGE_CATEGORY_NULL = "Category is invalid. Category is Null";
    private static final String MESSAGE_CATEGORY_INVALID = "Category is invalid, it does not exist";

    public static InvalidCategoryException becauseCategoryIsNull() {
        return new InvalidCategoryException(MESSAGE_CATEGORY_NULL);
    }

    public static InvalidCategoryException becauseCategoryIsInvalid() {
        return new InvalidCategoryException(MESSAGE_CATEGORY_INVALID);
    }
}