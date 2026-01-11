package org.problems.dto;

public record Penguin(
    String species
    ,String island
    ,Float culmen_length_mm
    ,Float culmen_depth_mm
    ,Float flipper_length_mm
    ,Integer body_mass_g
    ,String sex) {
}
