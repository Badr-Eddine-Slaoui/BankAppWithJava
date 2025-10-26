package util;

import exeption.*;

public class ValidatInput {
    public static void isValidCode(String code) throws InvalidCodeException {
        if (!code.matches("^CPT-\\d{5}$") || code.isEmpty())
            throw new InvalidCodeException("Invalid Code. Code Format Should be: CPT-00001");
    }

    public static void isValidAmount(double amount) throws InvalidAmountException {
        if (amount <= 0 ) throw new InvalidAmountException("Amount must be positive");
    }

    public static void isValidName(String name) throws InvalidNameException {
        if (name == null || name.trim().isEmpty()) throw new InvalidNameException("Name cannot be empty");
        if (!name.matches("^[A-Za-z]{3,15}(\\s[A-Za-z]{3,15})?$")) throw new InvalidNameException("Invalid Name");
    }
}
