package com.projects.dogbreeds.exception.messages;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BreedControllerExceptionMessages {
    ENTITY_FOR_PROVIDED_ID_NOT_EXIST("Entity for provided id does not exist."),
    ENTITY_FOR_PROVIDED_NAME_NOT_EXIST("Entity for provided name does not exist."),
    ENTITY_FOR_PROVIDED_SIZE_NOT_EXIST("Entity for provided size does not exist."),
    ENTITY_FOR_PROVIDED_ORIGIN_NOT_EXIST("Entity for provided origin does not exist.");


    private final String message;

}
