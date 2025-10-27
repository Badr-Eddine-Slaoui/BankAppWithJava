package dao.db;

import entity.*;
import enums.DestinationEnum;
import enums.SourceEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountDAO {

    private Connection connection = null;

    public AccountDAO() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql:", "", "");
        } catch (SQLException e) {
            System.err.println("Unexpected Error : " + e.getMessage());
        }
    }

    public void addAccount(Account account) {
        try {
            String sql = "INSERT INTO accounts (code, name, balance, overdraft, intrest_rate) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getCode());
            preparedStatement.setString(2, account.getUserName());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.setDouble(4, account instanceof CurrentAccount ? ((CurrentAccount) account).getOverdraft() : 0);
            preparedStatement.setDouble(5, account instanceof SavingAccount ? ((SavingAccount) account).getInterestRate() : 0);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Unexpected Error : " + e.getMessage());
        }
    }

    public Optional<Account> getAccount(String code) {
        try {
            String sql = "SELECT * FROM accounts WHERE code = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Account account = resultSet.getDouble("overdraft") > 0 ? new CurrentAccount(resultSet.getString("name"), resultSet.getDouble("balance"))
                        : new SavingAccount(resultSet.getString("name"), resultSet.getDouble("balance"));
                account.setCode(resultSet.getString("code"));
                return Optional.of(account);
            }
        } catch (SQLException e) {
            System.err.println("Unexpected Error : " + e.getMessage());
        }
        return Optional.empty();
    }

    public void deposit(Account account, Deposit deposit) {
        try {
            String sql = "INSERT INTO deposits (account_code, amount, source) values (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getCode());
            preparedStatement.setDouble(2, deposit.getAmount());
            preparedStatement.setString(3, deposit.getSource().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Unexpected Error : " + e.getMessage());
        }
    }

    public void withdraw(Account account, Withdrawal withdrawal) {
        try {
            String sql = "INSERT INTO withdrawals (account_code, amount, destination) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getCode());
            preparedStatement.setDouble(2, withdrawal.getAmount());
            preparedStatement.setString(3, withdrawal.getDestination().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Unexpected Error : " + e.getMessage());
        }
    }

    public void transfer(Account senderAccount, Account receiverAccount, Transfer transfer) {
        try {
            String sql = "INSERT INTO transfers (sender_account_code, receiver_account_code, amount) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, senderAccount.getCode());
            preparedStatement.setString(2, receiverAccount.getCode());
            preparedStatement.setDouble(3, transfer.getAmount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Unexpected Error : " + e.getMessage());
        }
    }

    public List<Operation> getOperations(String code) {
        try {
           String sql = "SELECT * FROM deposits WHERE account_code = ?";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, code);
           ResultSet resultSet = preparedStatement.executeQuery();
           List<Operation> operations = new ArrayList<>();
           while (resultSet.next()) {
               operations.add(new Deposit(resultSet.getDouble("amount"), SourceEnum.valueOf(resultSet.getString("source"))));
           }

           sql = "SELECT * FROM withdrawals WHERE account_code = ?";
           preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, code);
           resultSet = preparedStatement.executeQuery();
           while (resultSet.next()) {
               operations.add(new Withdrawal(resultSet.getDouble("amount"), DestinationEnum.valueOf(resultSet.getString("destination"))));
           }

           sql = "SELECT * FROM transfers WHERE sender_account_code = ?";
           preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, code);
           resultSet = preparedStatement.executeQuery();
           while (resultSet.next()) {
               operations.add(new Transfer(resultSet.getDouble("amount"), resultSet.getString("sender_account_code"), resultSet.getString("receiver_account_code")));
           }

           return operations;
        } catch (SQLException e) {
            System.err.println("Unexpected Error : " + e.getMessage());
        }
        return new ArrayList<>();
    }
}
