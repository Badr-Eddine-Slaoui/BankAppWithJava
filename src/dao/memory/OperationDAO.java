package dao.memory;

import entity.Operation;

import java.util.HashMap;
import java.util.Map;

public class OperationDAO {
    private final Map<String, Operation> operations;

    public OperationDAO() {
        this.operations = new HashMap<>();
    }

    public void addOperation(Operation operation) {
        operations.put(operation.getUuid().toString(), operation);
    }

    public Operation getOperations(String uuid) {
        return operations.get(uuid);
    }
}
