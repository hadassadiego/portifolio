public class Machine <T>{
    // excluo o T


    //acao a ser feita, valor
     T action(MonoOperation<T> operation, T operand){ //insiro <T> antes do T
        return operation.doThis(operand);
    }

    //acao a ser feita, valores
     T action(BiOperation<T> biOperation, T operand, T operand2) {
        return biOperation.doThisAgain(operand, operand2);
    }
}
