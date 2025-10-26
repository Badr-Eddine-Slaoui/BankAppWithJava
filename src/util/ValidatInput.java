package util;

import enums.DestinationEnum;
import enums.SourceEnum;
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
    public static DestinationEnum validateDestination(int choice) throws InvalidDestinationException {
        switch (choice) {
            case 1: return DestinationEnum.ATM;
            case 2: return DestinationEnum.CHECK;
            case 3: return DestinationEnum.OUTGOING_TRANSFER;
            default: throw new InvalidDestinationException("Invalid Destination!");
        }

    }

    public static SourceEnum validateSource(int choice) throws InvalidSourceException {
        switch (choice) {
            case 1: return SourceEnum.CASH_DEPOSIT;
            case 2: return SourceEnum.EXTERNAL_TRANSFER;
            case 3: return SourceEnum.SALARY;
            default: throw new InvalidSourceException("Invalid Source!");
        }
    }
}
