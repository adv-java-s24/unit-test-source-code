package java112.project3;

import java.util.*;

/**
 * @author Eric Knapp
 * class HttpRequestData
 */
public class HttpRequestData {

    private String remoteComputer;
    private String remoteComputerAddress;
    private String httpMethod;
    private String requestUri;
    private String requestUrl;
    private String requestProtocol;
    private String serverName;
    private int serverPort;
    private Locale serverLocale;
    private String queryString;
    private String queryParameter;
    private String userAgentHeader;


    /**
     * Constructor for HttpRequestData
     */
    public HttpRequestData() {
    }


    /**
     * Returns the value of remoteComputer.
     */
    public String getRemoteComputer() {
        return remoteComputer;
    }


    /**
     * Sets the value of remoteComputer.
     * @param remoteComputer The value to assign remoteComputer.
     */
    public void setRemoteComputer(String remoteComputer) {
        this.remoteComputer = remoteComputer;
    }


    /**
     * Returns the value of remoteComputerAddress.
     */
    public String getRemoteComputerAddress() {
        return remoteComputerAddress;
    }


    /**
     * Sets the value of remoteComputerAddress.
     * @param remoteComputerAddress The value to assign remoteComputerAddress.
     */
    public void setRemoteComputerAddress(String remoteComputerAddress) {
        this.remoteComputerAddress = remoteComputerAddress;
    }


    /**
     * Returns the value of httpMethod.
     */
    public String getHttpMethod() {
        return httpMethod;
    }


    /**
     * Sets the value of httpMethod.
     * @param httpMethod The value to assign httpMethod.
     */
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }


    /**
     * Returns the value of requestUri.
     */
    public String getRequestUri() {
        return requestUri;
    }


    /**
     * Sets the value of requestUri.
     * @param requestUri The value to assign requestUri.
     */
    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }


    /**
     * Returns the value of requestUrl.
     */
    public String getRequestUrl() {
        return requestUrl;
    }


    /**
     * Sets the value of requestUrl.
     * @param requestUrl The value to assign requestUrl.
     */
    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }


    /**
     * Returns the value of requestProtocol.
     */
    public String getRequestProtocol() {
        return requestProtocol;
    }


    /**
     * Sets the value of requestProtocol.
     * @param requestProtocol The value to assign requestProtocol.
     */
    public void setRequestProtocol(String requestProtocol) {
        this.requestProtocol = requestProtocol;
    }


    /**
     * Returns the value of serverName.
     */
    public String getServerName() {
        return serverName;
    }


    /**
     * Sets the value of serverName.
     * @param serverName The value to assign serverName.
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }


    /**
     * Returns the value of serverPort.
     */
    public int getServerPort() {
        return serverPort;
    }


    /**
     * Sets the value of serverPort.
     * @param serverPort The value to assign serverPort.
     */
    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }


    /**
     * Returns the value of serverLocale.
     */
    public Locale getServerLocale() {
        return serverLocale;
    }


    /**
     * Sets the value of serverLocale.
     * @param serverLocale The value to assign serverLocale.
     */
    public void setServerLocale(Locale serverLocale) {
        this.serverLocale = serverLocale;
    }


    /**
     * Returns the value of queryString.
     */
    public String getQueryString() {
        return queryString;
    }


    /**
     * Sets the value of queryString.
     * @param queryString The value to assign queryString.
     */
    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }


    /**
     * Returns the value of queryParameter.
     */
    public String getQueryParameter() {
        return queryParameter;
    }


    /**
     * Sets the value of queryParameter.
     * @param queryParameter The value to assign queryParameter.
     */
    public void setQueryParameter(String queryParameter) {
        this.queryParameter = queryParameter;
    }


    /**
     * Returns the value of userAgentHeader.
     */
    public String getUserAgentHeader() {
        return userAgentHeader;
    }


    /**
     * Sets the value of userAgentHeader.
     * @param userAgentHeader The value to assign userAgentHeader.
     */
    public void setUserAgentHeader(String userAgentHeader) {
        this.userAgentHeader = userAgentHeader;
    }
}

