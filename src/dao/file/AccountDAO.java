package dao.file;

import entity.*;

import java.io.*;
import java.util.*;

public class AccountDAO {
    private final String filePath = "data/accounts.text";

    @SuppressWarnings("unchecked")
    public void addAccount(Account account) {
        List<Account> accounts = new ArrayList<>();
        File file = new File(filePath);
        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(this.filePath))) {
                accounts = (List<Account>) inputStream.readObject();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                System.out.println("IO Exception");
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found");
            } catch (Exception e) {
                System.out.println("Unexpected Error : " + e.getMessage());
            }
        }
        accounts.add(account);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(this.filePath))){
            outputStream.writeObject(accounts);
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("IO Exception");
        }catch (Exception e){
            System.out.println("Unexpected Error : " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public Optional<Account> getAccount(String code) {
        List<Account> accounts = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(this.filePath))){
            accounts = (List<Account>) inputStream.readObject();
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("IO Exception");
        }catch (ClassNotFoundException e){
            System.out.println("Class not found");
        } catch (Exception e){
            System.out.println("Unexpected Error : " + e.getMessage());
        }
        return accounts.stream().filter(account -> account.getCode().equals(code)).findFirst();
    }

    @SuppressWarnings("unchecked")
    public void updateAccount(Account account) {
        List<Account> accounts = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(this.filePath))){
            accounts = (List<Account>) inputStream.readObject();
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("IO Exception");
        }catch (ClassNotFoundException e){
            System.out.println("Class not found");
        } catch (Exception e){
            System.out.println("Unexpected Error : " + e.getMessage());
        }
        accounts.removeIf(account1 -> account1.getCode().equals(account.getCode()));
        accounts.add(account);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(this.filePath))){
            outputStream.writeObject(accounts);
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("IO Exception");
        }catch (Exception e){
            System.out.println("Unexpected Error : " + e.getMessage());
        }
    }

    public void deposit(Account account, Deposit deposit) {
        account.deposit(deposit.getAmount());
        account.setOperationsList(deposit);
        updateAccount(account);
    }

    public void withdraw(Account account, Withdrawal withdrawal) {
        account.withdraw(withdrawal.getAmount());
        account.setOperationsList(withdrawal);
        updateAccount(account);
    }

    public void transfer(Account senderAccount, Account receiverAccount, Transfer transfer) {
        senderAccount.withdraw(transfer.getAmount());
        receiverAccount.deposit(transfer.getAmount());

        senderAccount.setOperationsList(transfer);
        receiverAccount.setOperationsList(transfer);

        updateAccount(senderAccount);
        updateAccount(receiverAccount);
    }

    public List<Operation> getOperations(String code) {
        Optional<Account> accountOptional = getAccount(code);
        if (accountOptional.isPresent()) {
            return accountOptional.get().getOperationsList();
        }
        return new ArrayList<>();
    }
}
