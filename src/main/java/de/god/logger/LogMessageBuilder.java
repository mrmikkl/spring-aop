package de.god.logger;

public class LogMessageBuilder {
    private String clazz;
    private String method;
    private Object[] methodsParams;

    public LogMessageBuilder() {
    }

    public LogMessageBuilder clazz(final String pClazz) {
        this.clazz = pClazz;
        return this;
    }

    public LogMessageBuilder method(final String pMethod) {
        this.method = pMethod;
        return this;
    }

    public LogMessageBuilder methodsParams(final Object[] pMethodsParams) {
        this.methodsParams = pMethodsParams;
        return this;
    }

    public String build() {
        StringBuffer logMessage = new StringBuffer();

        if (this.clazz != null) {
            logMessage.append("\n");
            logMessage.append("Class =  ");
            logMessage.append(clazz);
        }
        if (this.method != null) {
            logMessage.append("\n");
            logMessage.append("Method =  ");
            logMessage.append(method);
        }
        if (this.methodsParams != null) {
            logMessage.append("\n");
            logMessage.append("Method Params = ");
            for (int i = 0; i < this.methodsParams.length; i++) {
                logMessage.append(this.methodsParams[i]).append(",");
            }
            if (this.methodsParams.length > 0) {
                logMessage.deleteCharAt(logMessage.length() - 1);
            }
        }

        return logMessage.toString();
    }
}
