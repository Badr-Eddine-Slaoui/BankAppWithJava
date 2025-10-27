package dao.file;

import entity.Account;
import entity.Operation;

import java.io.*;
import java.util.*;

public class AccountDAO {
    private final String filePath = "../../../data/accounts.text";

    @SuppressWarnings("unchecked")
    public void addAccount(Account account) {
        List<Account> accounts = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(this.filePath))){
            accounts = (List<Account>) inputStream.readObject();
            accounts.add(account);
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("IO Exception");
        }catch (ClassNotFoundException e){
            System.out.println("Class not found");
        } catch (Exception e){
            System.out.println("Unexpected Error : " + e.getMessage());
        }
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

    public List<Operation> getOperations(String code) {
        Optional<Account> accountOptional = getAccount(code);
        if (accountOptional.isPresent()) {
            return accountOptional.get().getOperationsList();
        }
        return new ArrayList<>();
    }
}
