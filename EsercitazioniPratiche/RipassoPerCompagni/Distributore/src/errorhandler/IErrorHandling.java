package errorhandler;


public interface IErrorHandling {

    public static void errorMessage() {
        StackTraceElement staElement = Thread.currentThread().getStackTrace()[2];
        
        System.out.println("Errore nella classe: " + staElement.getClassName() + "\nLinea: "
                + staElement.getLineNumber() + "\nMetodo: " + staElement.getMethodName());
    }
}
