package ru.cocktails.errors.model;

import io.swagger.annotations.ApiModel;

@ApiModel
public enum ErrorType {
    APP,
    DATA_BASE,
    OUT_SYSTEM
}

