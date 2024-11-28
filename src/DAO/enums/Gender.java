package DAO.enums;

public enum Gender {
    MALE ("М"),
    FEMALE("Ж");
    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }
}
