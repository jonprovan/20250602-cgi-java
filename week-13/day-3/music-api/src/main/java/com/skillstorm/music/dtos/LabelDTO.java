package com.skillstorm.music.dtos;

/*
 * DTO = Data Transfer Object
 * we don't always need all the fields from an entity when we're sending data back/forth with the user
 * sometimes we need a partial object, like when a user is posting a new Label, and we don't want/need them to submit an ID, since it's auto-incremented
 * 
 * Records are new to Java 17
 * They are immutable classes, meaning once values are assigned at instantiation, they are final
 * We DO NOT have to implement ANYTHING in this class!
 * 
 * It is auto-populated with constructor, getters, toString, hashCode, equals
 * You ONLY need to insert the fields you want into the parameters list, and everything else is handled!
 */

public record LabelDTO(String labelName) {}