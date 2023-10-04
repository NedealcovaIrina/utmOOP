package org.utm.labtwo.enums;

public enum StudyField {
    MECHANICAL_ENGINEERING,
    SOFTWARE_ENGINEERING,
    FOOD_TECHNOLOGY,
    URBANISM_ARCHITECTURE,
    VETERINARY_MEDICINE;

    public static boolean isValidField(String field) {
        for (StudyField studyField : StudyField.values()) {
            if (studyField.name().equals(field)) {
                return true;
            }
        }
        return false;
    }
}
